package ru.romanlebedev.JavaFXcontrollers;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TabPaneManager {

    private final ConsoleTabController consoleTabController;
    private final LoggerTabController loggerTabController;

    @Autowired
    public TabPaneManager(ConsoleTabController consoleTabController, LoggerTabController loggerTabController) {
        this.consoleTabController = consoleTabController;
        this.loggerTabController = loggerTabController;
    }

    public TextArea getVisualLog() {
        return loggerTabController.getLoggerTxtArea();
    }

}
