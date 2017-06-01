package ru.romanlebedev.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.romanlebedev.StageAndScenesManager;
import ru.romanlebedev.dataManaging.entity.Teacher;
import ru.romanlebedev.dataManaging.service.interfaces.TeacherService;


import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class ClassInformationViewController {

    private Logger logger = LoggerFactory.getLogger(ClassInformationViewController.class);

    @Autowired
    private StageAndScenesManager stageAndScenesManager;

    // Инъекции Spring
    @Autowired
    private TeacherService teacherService;

    // Инъекции JavaFX
    @FXML private TableView<Teacher> table = new TableView<>();
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;

    // Variables
    private ObservableList<Teacher> data;

    /**
     * Инициализация контроллера от JavaFX.
     * Метод вызывается после того как FXML загрузчик произвел инъекции полей.
     *
     * Обратите внимание, что имя метода <b>обязательно</b> должно быть "initialize",
     * в противном случае, метод не вызовется.
     *
     * Также на этом этапе еще отсутствуют бины спринга
     * и для инициализации лучше использовать метод,
     * описанный аннотацией @PostConstruct,
     * который вызовется спрингом, после того, как им будут произведены все инъекции.
     * {@link ClassInformationViewController#init()}
     */
    @FXML
    public void initialize() {
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        List<Teacher> contacts = teacherService.getAllTeachers();
        data = FXCollections.observableArrayList(contacts);

        // Столбцы таблицы
        TableColumn<Teacher, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Teacher, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Teacher, String> phoneColumn = new TableColumn<>("Фамилия");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        table.getColumns().setAll(idColumn, nameColumn, phoneColumn);

        // Данные таблицы
        table.setItems(data);
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Привязан к кнопке в FXML файле представления.
     */
    @FXML
    public void addContact() {
        Teacher teacher = new Teacher(txtName.getText(), txtPhone.getText(), null);
        teacherService.addTeacher(teacher);
        data.add(teacher);

        // чистим поля
        txtName.setText("");
        txtPhone.setText("");
    }

    @FXML
    public void changeView(){
        stageAndScenesManager.getStage().setScene(stageAndScenesManager.getJournalScene());
        //Application.getStage().setScene(Application.getJournalScene());
    }
}
