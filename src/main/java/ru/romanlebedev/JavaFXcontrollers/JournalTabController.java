package ru.romanlebedev.JavaFXcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.romanlebedev.dataManaging.entity.*;
import ru.romanlebedev.dataManaging.service.interfaces.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by RomanLebedev on 04.06.2017.
 */
@Component
public class JournalTabController {

    @FXML
    private ListView<SchoolClass> classList;

    @FXML
    private ListView<Student> studentList;

    @FXML
    private ListView<Subject> subjectList;

    @FXML
    private TableView<Mark> journalTable;

    @FXML
    private TableColumn<Mark,Integer> markColumn;

    @FXML
    private TableColumn<Mark,Date> dateColumn;

    @FXML
    private Button createMarkButton;

    @FXML
    private Button editMarkButton;

    @FXML
    private Button deleteMarkButton;

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private JournalService journalService;

    public void initialize() {
        ObservableList<SchoolClass> allClasses = FXCollections.observableArrayList(schoolClassService.getAllSchoolClasses());
        classList.setItems(allClasses);
        markColumn.setCellValueFactory(new PropertyValueFactory<Mark, Integer>("value"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Mark, Date>("date"));
    }

    public void classListMouseClicked(MouseEvent mouseEvent) {
        final SchoolClass selectedClass = classList.getSelectionModel().getSelectedItem();
        List<Student> studentsOfSelectedClass = studentService.getBySchoolClass(selectedClass);
        ObservableList<Student> studentsOfClass = FXCollections.observableArrayList(studentsOfSelectedClass);
        subjectList.setItems(null);
        studentList.setItems(null);
        studentList.setItems(studentsOfClass);
    }

    public void studentListMouseClicked(MouseEvent mouseEvent) {
        final Student selectedStudent = studentList.getSelectionModel().getSelectedItem();
        List<Subject> subjects = subjectService.getAllSubjects();
        ObservableList<Subject> observableSubjectList = FXCollections.observableArrayList(subjects);
        subjectList.setItems(null);
        subjectList.setItems(observableSubjectList);
    }

    public void subjectListMouseClicked(MouseEvent mouseEvent) {
        updateJournal();
    }

    public void createButtonClicked(MouseEvent mouseEvent) {
        if(checkForSelection()) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Поставьте новую оценку");
            VBox dialogVbox = new VBox(20);
            dialogVbox.setPadding(new Insets(10,10,10,10));
            dialogVbox.getChildren().add(new Label("Выберите оценку"));
            ObservableList<Integer> optionsMarks =
                    FXCollections.observableArrayList(
                            2, 3, 4, 5
                    );
            ComboBox<Integer> comboBox = new ComboBox(optionsMarks);
            dialogVbox.getChildren().add(comboBox);
            dialogVbox.getChildren().add(new Label("Выберите дату оценки"));
            DatePicker datePicker = new DatePicker();
            dialogVbox.getChildren().add(datePicker);
            HBox buttons = new HBox();
            buttons.setSpacing(10);
            Button buttonAccept = new Button("Принять");
            buttonAccept.setOnMouseClicked(event -> saveMark(comboBox, datePicker, dialog));
            buttons.getChildren().add(buttonAccept);
            Button cancelButton = new Button("Отмена");
            cancelButton.setOnMouseClicked(event -> dialog.close());
            buttons.getChildren().add(cancelButton);
            dialogVbox.getChildren().add(buttons);
            Scene dialogScene = new Scene(dialogVbox, 350, 250);
            dialog.setScene(dialogScene);
            dialog.show();
        }
    }

    public void editButtonClicked(MouseEvent mouseEvent) {
        if(checkForSelection() && checkSelectedMarkForEdit()) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Измените оценку");
            VBox dialogVbox = new VBox(20);
            dialogVbox.setPadding(new Insets(10,10,10,10));
            dialogVbox.getChildren().add(new Label("Выберите оценку"));
            ObservableList<Integer> optionsMarks =
                    FXCollections.observableArrayList(
                            2, 3, 4, 5
                    );
            ComboBox<Integer> comboBox = new ComboBox(optionsMarks);
            comboBox.setValue(journalTable.getSelectionModel().getSelectedItem().getValue());
            dialogVbox.getChildren().add(comboBox);
            dialogVbox.getChildren().add(new Label("Выберите дату оценки"));
            DatePicker datePicker = new DatePicker();
            datePicker.setValue(journalTable.getSelectionModel().getSelectedItem().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dialogVbox.getChildren().add(datePicker);
            HBox buttons = new HBox();
            buttons.setSpacing(10);
            Button buttonAccept = new Button("Принять");
            buttonAccept.setOnMouseClicked(event -> editMark(comboBox, datePicker, dialog));
            buttons.getChildren().add(buttonAccept);
            Button cancelButton = new Button("Отмена");
            cancelButton.setOnMouseClicked(event -> dialog.close());
            buttons.getChildren().add(cancelButton);
            dialogVbox.getChildren().add(buttons);
            Scene dialogScene = new Scene(dialogVbox, 350, 250);
            dialog.setScene(dialogScene);
            dialog.show();
        }
    }

    public void deleteButtonClicked(MouseEvent mouseEvent) {
        if(checkForSelection() && checkSelectedMarkForEdit()) {
            markService.deleteMark(journalTable.getSelectionModel().getSelectedItem().getId());
            updateJournal();
            Notifications notification = Notifications.create()
                    .title("Оценка удалена")
                    .text("Вы удалили оценку")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
        }
    }

    private void saveMark(ComboBox<Integer> comboBox , DatePicker datePicker , Stage dialog){
        if(comboBox.getValue() == null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать оценку")
                    .text("Выберите оценку от 2 до 5")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
        } else if(datePicker.getValue() == null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать дату")
                    .text("Выберите дату для оценки")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
        } else {
            if (comboBox.getSelectionModel().getSelectedItem() != null && datePicker.getValue() != null) {
                Mark newMark = new Mark();
                Journal journal = classList.getSelectionModel().getSelectedItem().getJournal();
                newMark.setJournal(journal);
                newMark.setStudent(studentList.getSelectionModel().getSelectedItem());
                newMark.setSubject(subjectList.getSelectionModel().getSelectedItem());
                newMark.setValue(comboBox.getValue());
                newMark.setDate(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                markService.addMark(newMark);
                updateJournal();
                dialog.close();
            }
        }
    }

    private void editMark(ComboBox<Integer> comboBox , DatePicker datePicker , Stage dialog){
        if(comboBox.getSelectionModel().getSelectedItem() != null && datePicker.getValue()!= null) {
            Mark newMark = journalTable.getSelectionModel().getSelectedItem();
            newMark.setValue(comboBox.getValue());
            newMark.setDate(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            markService.editMark(newMark);
            updateJournal();
            dialog.close();
        }
    }

    private void updateJournal(){
        final Student selectedStudent = studentList.getSelectionModel().getSelectedItem();
        final Subject selectedSubject = subjectList.getSelectionModel().getSelectedItem();
        List<Mark> marks = markService.getByStudentAndSubject(selectedStudent , selectedSubject);
        ObservableList<Mark> observableMarksList = FXCollections.observableArrayList(marks);
        journalTable.setItems(null);
        journalTable.setItems(observableMarksList);
    }

    private boolean checkForSelection(){
        if(classList.getSelectionModel().getSelectedItem()==null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать все данные")
                    .text("Выберите класс из списка классов")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
            return false;
        } else if(studentList.getSelectionModel().getSelectedItem()==null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать все данные")
                    .text("Выберите ученика из списка учеников")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
            return false;
        } else if(subjectList.getSelectionModel().getSelectedItem()==null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать все данные")
                    .text("Выберите предмет из списка предметов")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
            return false;
        } else return true;
    }

    private boolean checkSelectedMarkForEdit(){
        if(journalTable.getSelectionModel().getSelectedItem()==null){
            Notifications notification = Notifications.create()
                    .title("Необходимо указать все данные")
                    .text("Выберите оценку из списка оценок")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notification.show();
            return false;
        } else return true;
    }

}
