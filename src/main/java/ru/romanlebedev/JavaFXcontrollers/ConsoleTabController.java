package ru.romanlebedev.JavaFXcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConsoleTabController {

    @FXML private TextArea missionOverviewText;
    @FXML private ListView<String> missionsList;

//    @Autowired
//    MissionsService service;
    private TabPaneManager tabManager;

    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Apollo", "Shuttle", "Skylab");
        missionsList.setItems(missions);
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        missionOverviewText.clear();
        final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
        missionOverviewText.positionCaret(0);
        missionOverviewText.appendText(getInfo(selectedItem));
    }
    
    @Autowired
    private void setTabManager(TabPaneManager tabManager){
        this.tabManager = tabManager;
    }
 
    public String getInfo(String selectedItem) {
        String missionInfo = null;
        
        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return missionOverviewText;
    }

    public ListView<String> getMissionsList() {
        return missionsList;
    }
    
    private TextArea getLog(){
        return tabManager.getVisualLog();
    }

}
