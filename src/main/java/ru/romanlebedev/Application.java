package ru.romanlebedev;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;


/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Lazy
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title}")
    private String windowTitle;

    @Qualifier("mainView")
    @Autowired
    private ConfigurationControllers.View mainView;

    @Qualifier("journalView")
    @Autowired
    private ConfigurationControllers.View journalView;

    @Autowired
    private StageAndScenesManager stageAndScenesManager;

    @Override
    public void start(Stage stage) throws Exception {
        stageAndScenesManager.setStage(stage);
        stageAndScenesManager.setMainScene(new Scene(mainView.getView()));
        stageAndScenesManager.setJournalScene(new Scene(journalView.getView()));
        stageAndScenesManager.getStage().setTitle(windowTitle);
        stageAndScenesManager.getStage().setScene(stageAndScenesManager.getMainScene());
        stageAndScenesManager.getStage().setResizable(true);
        stageAndScenesManager.getStage().centerOnScreen();
        stageAndScenesManager.getStage().show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

}
