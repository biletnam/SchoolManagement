package ru.romanlebedev;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Component
public class StageAndScenesManager {
    private Stage stage;
    private Scene mainScene;
    private Scene journalScene;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Scene getJournalScene() {
        return journalScene;
    }

    public void setJournalScene(Scene journalScene) {
        this.journalScene = journalScene;
    }
}
