package ru.romanlebedev.JavaFXcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.romanlebedev.dataManaging.entity.Teacher;
import ru.romanlebedev.dataManaging.service.interfaces.TeacherService;

/**
 * Created by RomanLebedev on 04.06.2017.
 */
@Component
public class TeacherInformationTabController {

    @FXML
    private ListView<Teacher> teacherList;

    @FXML
    private Label subjectNameLabel;

    @FXML
    private Label classLabel;

    @Autowired
    private TeacherService teacherService;

    public void initialize() {
        ObservableList<Teacher> allTeachers = FXCollections.observableArrayList(teacherService.getAllTeachers());
        teacherList.setItems(allTeachers);
    }

    public void teacherListMouseClicked(MouseEvent mouseEvent) {
        final Teacher selectedTeacher = teacherList.getSelectionModel().getSelectedItem();
        subjectNameLabel.setText(selectedTeacher.getSubject().getSubjectName());
        if(selectedTeacher.getTeacherClass() == null){
            classLabel.setText("нет класса под руководством");
        }else classLabel.setText(selectedTeacher.getTeacherClass().getClassName());

    }
}
