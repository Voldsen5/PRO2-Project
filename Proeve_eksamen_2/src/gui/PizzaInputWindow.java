package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PizzaInputWindow extends Stage {

    public PizzaInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    //textfields
    TextField txfName = new TextField();
    TextField txfPrice = new TextField();
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        // first column
        Label lblName = new Label("Navn:");
        pane.add(lblName,0,0);

        Label lblprice = new Label("Pris:");
        pane.add(lblprice, 0,1);

        Button btnMakePizza = new Button("Lav Pizza");
        btnMakePizza.setOnAction(Event -> makePizzaAction());
        pane.add(btnMakePizza,0,2);

        //second column
        pane.add(txfName,1,0);

        pane.add(txfPrice,1,1);
    }

    private void makePizzaAction(){
        if(!txfName.getText().trim().equals("")){
            try{
                double price = Double.parseDouble(txfPrice.getText().trim());
                String name = txfName.getText().trim();
                Controller.createNewPizza(name, price);
                this.hide();
            } catch (NumberFormatException e){
                Alert priceNaN = new Alert(Alert.AlertType.ERROR);
                priceNaN.setTitle("Ikke gyldig pris");
                priceNaN.setHeaderText("Ikke gyldig pris");
                priceNaN.setContentText("Prisen kan ikke valideres, indtast en ny pris.");
                priceNaN.showAndWait();
            }

        } else {
            Alert nameEmpty = new Alert(Alert.AlertType.ERROR);
            nameEmpty.setTitle("Ikke gyldigt navn");
            nameEmpty.setHeaderText("Ikke gyldigt navn");
            nameEmpty.setContentText("Indtast et navn på pizza.");
            nameEmpty.showAndWait();
        }
    }
}
