package ru.romanlebedev.JavaFXcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.service.interfaces.MarkService;
import ru.romanlebedev.dataManaging.service.interfaces.SubjectService;


/**
 * Created by RomanLebedev on 04.06.2017.
 */
@Component
public class SubjectInformationTabController {

    @FXML
    private ListView<Subject> subjectList;

    @FXML
    private Label subjectNameLabel;

    @FXML
    private Label teacherLabel;

    @FXML
    private Label averageMark;

    @Autowired
    private MarkService markService;

    @Autowired
    private SubjectService subjectService;

    public void initialize() {
        ObservableList<Subject> allSubjects = FXCollections.observableArrayList(subjectService.getAllSubjects());
        subjectList.setItems(allSubjects);
    }

    public void subjectListMouseClicked(MouseEvent mouseEvent) {
        final Subject selectedSubject = subjectList.getSelectionModel().getSelectedItem();
        subjectNameLabel.setText(selectedSubject.getSubjectName());
        teacherLabel.setText(selectedSubject.getTeacher().getFirstname() + " " + selectedSubject.getTeacher().getLastname() );
        Double averageMarkValue = markService.getAverageMarkBySubject(selectedSubject.getId().toString());
        if(averageMarkValue!=null){
            averageMark.setText(Double.toString((Math.round(averageMarkValue * 100D)/100D)));
        }
    }
}
