package ru.romanlebedev.JavaFXcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;
import ru.romanlebedev.dataManaging.service.interfaces.*;

import java.util.List;

/**
 * Created by RomanLebedev on 02.06.2017.
 */
@Component
public class ClassInformationTabController {

    @FXML
    private ListView<SchoolClass> classList;

    @FXML
    private ListView<Student> studentList;

    @FXML
    private Label teacherLabel;

    @FXML
    private Label studentCountLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label averageMark;

    @FXML
    private VBox VBoxOfSubjects;

    @FXML
    private VBox VBoxOfMarkOfSubject;

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @Autowired
    private SubjectService subjectService;

    public void initialize() {
        ObservableList<SchoolClass> allClasses = FXCollections.observableArrayList(schoolClassService.getAllSchoolClasses());
        classList.setItems(allClasses);
    }

    @FXML
    private void classListMouseClicked(MouseEvent event) {
        if(classList.getSelectionModel().getSelectedItem() != null) {
            clearView();
            final SchoolClass selectedClass = classList.getSelectionModel().getSelectedItem();
            teacherLabel.setText(selectedClass.getClassTeacher().getFirstname() + " " + selectedClass.getClassTeacher().getLastname());
            List<Student> studentsOfSelectedClass = studentService.getBySchoolClass(selectedClass);
            studentCountLabel.setText(Integer.toString(studentsOfSelectedClass.size()));
            ObservableList<Student> studentsOfClass = FXCollections.observableArrayList(studentsOfSelectedClass);
            studentList.setItems(null);
            studentList.setItems(studentsOfClass);
        }
    }

    @FXML
    private void studentListMouseClicked(MouseEvent event) {
        if(studentList.getSelectionModel().getSelectedItem() != null) {
            clearView();
            final Student selectedStudent = studentList.getSelectionModel().getSelectedItem();
            setupListOfStudents(selectedStudent);
            setupAverageMark(selectedStudent);
            setupAverageMarksBySubject(selectedStudent);
        }
    }

    private void setupListOfStudents(Student selectedStudent){
        nameLabel.setText(selectedStudent.getFirstname());
        lastnameLabel.setText(selectedStudent.getLastname());
    }

    private void setupAverageMark(Student selectedStudent){
        Double averageMarkValue = markService.getAverageMarkByStudent(selectedStudent.getId().toString());
        if(averageMarkValue!=null){
            averageMark.setText(Double.toString((Math.round(averageMarkValue * 100D)/100D)));
        }
    }

    private void setupAverageMarksBySubject(Student selectedStudent){
        List<Subject> subjects = subjectService.getAllSubjects();
        for (Subject subject:subjects) {
            VBoxOfSubjects.getChildren().add(new Label(subject.getSubjectName()));
            Double averageMarkBySubject = markService.getAverageMarkByStudentAndSubject
                    (selectedStudent.getId().toString() , subject.getId().toString());
            if(averageMarkBySubject!=null) {
                Label label = new Label(Double.toString((Math.round(averageMarkBySubject * 100D) / 100D)));
                label.setTextFill(Color.RED);
                VBoxOfMarkOfSubject.getChildren().add(label);
            }
        }
    }

    private void clearView(){
        nameLabel.setText("");
        lastnameLabel.setText("");
        averageMark.setText("");
        VBoxOfSubjects.getChildren().clear();
        VBoxOfMarkOfSubject.getChildren().clear();
    }
}
