package ru.romanlebedev.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.romanlebedev.StageAndScenesManager;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class JournalViewControler {

    @Autowired
    private StageAndScenesManager stageAndScenesManager;

    @FXML
    private Button secondViewButton;

    @FXML
    public void goBack(){
        //Application.getStage().setScene(Application.getMainScene());
        stageAndScenesManager.getStage().setScene(stageAndScenesManager.getMainScene());
    }
}
