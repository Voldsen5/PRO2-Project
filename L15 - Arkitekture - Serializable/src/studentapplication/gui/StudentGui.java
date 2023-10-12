package studentapplication.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentapplication.controller.Controller;
import studentapplication.model.Student;
import studentapplication.storage.ListStorage;

public class StudentGui extends Application implements Observer {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administrer studerende");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        Controller.addObserver(this);
    }

    @Override
    public void stop() {
        ListStorage.saveStorage(Controller.getStorage());
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfAge = new TextField();
    private final CheckBox chkActive = new CheckBox();
    private final ListView<Student> lvwStudents = new ListView<>();

    private final Button btnAdd = new Button("Opret");
    private final Button btnDelete = new Button("Slet");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Navn");
        pane.add(lblName, 1, 1);

        Label lblAge = new Label("Alder");
        pane.add(lblAge, 1, 2);

        Label lblActive = new Label("Aktiv");
        pane.add(lblActive, 1, 3);

        pane.add(txfName, 2, 1, 2, 1);

        pane.add(txfAge, 2, 2, 2, 1);

        pane.add(chkActive, 2, 3);

        pane.add(btnAdd, 1, 5);
        btnAdd.setOnAction(event -> this.addAction());

        pane.add(btnDelete, 3, 5);
        btnDelete.setDisable(true);
        btnDelete.setOnAction(event -> this.deleteAction());

        pane.add(lvwStudents, 0, 1, 1, 4);
        lvwStudents.setPrefWidth(250);
        lvwStudents.setPrefHeight(200);
        lvwStudents.getItems().setAll(Controller.getStudents());

        ChangeListener<Student> listener = (ov, o, n) -> this.selectedStudentChanged();
        lvwStudents.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void addAction() {
        String name = txfName.getText().trim();
        int age = Integer.parseInt(txfAge.getText());
        if (name.isEmpty()) return;

        Controller.createStudent(name, age, chkActive.isSelected());

        this.clearFields();
        btnDelete.setDisable(true);
    }

    private void deleteAction() {
        Student studerende = lvwStudents.getSelectionModel().getSelectedItem();
        if (studerende == null) return;

        Controller.deleteStudent(studerende);

        this.clearFields();
        btnDelete.setDisable(true);
    }

    private void clearFields() {
        txfName.clear();
        txfAge.clear();
        chkActive.setSelected(false);
    }

    private void selectedStudentChanged() {
        Student studerende = lvwStudents.getSelectionModel().getSelectedItem();
        if (studerende == null) return;

        txfName.setText(studerende.getName());
        txfAge.setText("" + studerende.getAge());
        chkActive.setSelected(studerende.isActive());
        btnDelete.setDisable(false);
    }

    @Override
    public void update() {
        lvwStudents.getItems().setAll(Controller.getStudents());
    }
}
