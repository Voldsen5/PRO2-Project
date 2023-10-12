package gui;

import controller.Controller;
import javafx.application.Application;

public class MainApp {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(MainGui.class);
    }
}
