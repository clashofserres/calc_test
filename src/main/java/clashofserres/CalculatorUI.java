package clashofserres;

import clashofserres.ui.controller.CalculatorController;
import clashofserres.ui.view.CalculatorView;
import clashofserres.ui.model.CalculatorModel; // Missing import
import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

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
