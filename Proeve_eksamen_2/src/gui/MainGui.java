package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Pizza;
import storage.Storage;

public class MainGui extends Application {

	private Stage stage;
	@Override
	public void start(Stage stage) {
		stage.setTitle("Pizzaer");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		this.stage = stage;
	}

	// -------------------------------------------------------------------------

	//listviews
	private final ListView<Pizza> lvwPizza = new ListView<>();
	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblComp = new Label("Liste over pizzaer");
		pane.add(lblComp, 0, 0);

		pane.add(lvwPizza, 0, 1, 1, 3);
		lvwPizza.setPrefHeight(200);
		lvwPizza.getItems().setAll(Storage.getPizzas());

		HBox hbxButtons = new HBox(40);
		pane.add(hbxButtons, 0, 4);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);
		
		Button btnCreate = new Button("Lav ny pizza");
		btnCreate.setOnAction(event -> createNewPizzaAction());
		hbxButtons.getChildren().add(btnCreate);
	}

	private void createNewPizzaAction(){
		PizzaInputWindow dialog = new PizzaInputWindow("Opret pizza", stage);
		dialog.showAndWait();
		lvwPizza.getItems().clear();
		lvwPizza.getItems().setAll(Storage.getPizzas());
	}
}
