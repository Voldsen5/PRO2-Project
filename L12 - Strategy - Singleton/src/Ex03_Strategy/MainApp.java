package Ex03_Strategy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        assert stage != null;
        stage.setTitle("Field Evaluator");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // ------------------------------------------------------------------------

    private final TextField txfNumber = new TextField(), txfEmail = new TextField();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNumber = new Label("Number");
        pane.add(lblNumber, 0, 0);

        pane.add(this.txfNumber, 1, 0);
        this.txfNumber.setOnAction(event -> this.numberAction());

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 0, 1);

        pane.add(this.txfEmail, 1, 1);
        this.txfEmail.setOnAction(event -> this.emailAction());
    }

    // ------------------------------------------------------------------------

    private final FieldEvaluator fieldEvaluator = new FieldEvaluator();

    private void numberAction() {
        this.fieldEvaluator.setEvaluator(new NumberEvaluator());
        if (this.fieldEvaluator.evaluate(this.txfNumber.getText())) {
            this.txfNumber.setStyle("-fx-background-color: lightgreen");
        } else {
            this.txfNumber.setStyle("-fx-background-color: pink");
        }

    }

    private void emailAction() {
        this.fieldEvaluator.setEvaluator(new EmailEvaluator());
        if (this.fieldEvaluator.evaluate(this.txfEmail.getText())) {
            this.txfEmail.setStyle("-fx-background-color: lightgreen");
        } else {
            this.txfEmail.setStyle("-fx-background-color: pink");
        }
    }

}
