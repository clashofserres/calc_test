package clashofserres;

import clashofserres.ui.controller.CalculatorController;
import clashofserres.ui.model.CalculatorModel;
import clashofserres.ui.view.CalculatorView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;
    private double memory = 0;

    public static void launchUI(String[] args) {
        Application.launch(CalculatorUI.class, args);
    }

    @Override
    public void start(Stage stage) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(stage);
        new CalculatorController(model, view);
    }
}
