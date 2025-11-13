package clashofserres.ui.controller;

import clashofserres.Main;
import clashofserres.calc.CalculatorFactory;
import clashofserres.ui.model.CalculatorModel;
import clashofserres.ui.view.CalculatorView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CalculatorController {
    private static final String ERROR_PREFIX = "ERROR";
    private static final String CLEAR_BUTTON = "C";
    private static final String EQUALS_BUTTON = "=";
    
    private final CalculatorModel model;
    private final CalculatorView view;
    private boolean start = true;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        attachEventHandlers();
    }

    private void attachEventHandlers() {
        view.getButtonGrid().getChildren().forEach(node -> {
            if (node instanceof Button btn) {
                btn.setOnAction(e -> handleButton(btn.getText()));
            }
        });

        view.getSwitchToConsoleButton().setOnAction(e -> {
            System.out.println("\n--- Switched to Console Mode ---");
            Stage stage = (Stage) view.getRoot().getScene().getWindow();
            stage.close();
            Main.main(new String[]{"-NoUI"});
        });
    }

    private void handleButton(String text) {
        var display = view.getDisplay();

        if (display.getText().startsWith(ERROR_PREFIX)) {
            clearDisplay();
            return;
        }

        try {
            switch (text) {
                case CLEAR_BUTTON -> handleClear();
                case EQUALS_BUTTON -> handleEquals();
                default -> {
                    if (CalculatorFactory.isSupportedOperation(text)) {
                        handleOperator(text);
                    } else {
                        handleInput(text);
                    }
                }
            }
        } catch (NumberFormatException e) {
            showError("Invalid number");
        } catch (ArithmeticException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Unexpected error");
            e.printStackTrace();
        }
    }

    private void handleClear() {
        var display = view.getDisplay();
        display.clear();
        model.setValue(0);
        model.setOperator("");
        start = true;
    }

    private void handleOperator(String operator) {
        var display = view.getDisplay();
        if (display.getText().isEmpty()) {
            return;
        }
        model.setValue(Double.parseDouble(display.getText()));
        model.setOperator(operator);
        start = true;
    }

    private void handleEquals() {
        var display = view.getDisplay();
        double input = Double.parseDouble(display.getText());
        double result = model.calculate(input);
        display.setText(formatResult(result));
        model.setOperator("");
        start = true;
    }

    private void handleInput(String text) {
        var display = view.getDisplay();
        if (start) {
            display.clear();
            start = false;
        }
        display.appendText(text);
    }

    private void clearDisplay() {
        view.getDisplay().clear();
        start = true;
    }

    private void showError(String message) {
        view.getDisplay().setText(ERROR_PREFIX + ": " + message);
        start = true;
    }

    private String formatResult(double result) {
        return (result == (long) result)
                ? String.valueOf((long) result)
                : String.valueOf(result);
    }
}