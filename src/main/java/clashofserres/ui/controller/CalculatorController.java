package clashofserres.ui.controller;

import clashofserres.Main;
import clashofserres.ui.model.CalculatorModel;
import clashofserres.ui.view.CalculatorView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CalculatorController {
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
            Main.main(new String[]{"-NoUI"}); // Relaunch CLI version
        });
    }

    private void handleButton(String text) {
        var display = view.getDisplay();

        if (display.getText().startsWith("ERROR")) {
            display.clear();
            start = true;
        }

        try {
            switch (text) {
                case "C" -> {
                    display.clear();
                    model.setValue(0);
                    start = true;
                }

                // TODO add logic for
                case "+", "-", "*", "/", "√", "^", "%" -> {
                    if (display.getText().isEmpty()) return;
                    model.setValue(Double.parseDouble(display.getText()));
                    model.setOperator(text);
                    start = true;
                }

                case "=" -> {
                    double input = Double.parseDouble(display.getText());
                    double result = model.calculate(input);

                    String formatted = (result == (long) result)
                            ? String.valueOf((long) result)
                            : String.valueOf(result);

                    display.setText(formatted);
                    model.setOperator("");
                    start = true;
                }

                default -> {
                    if (start) {
                        display.clear();
                        start = false;
                    }
                    display.appendText(text);
                }
            }
        }
        catch (NumberFormatException nfe) {
            display.setText("ERROR: Invalid number");
            start = true;
        }
        catch (ArithmeticException ae) {
            display.setText("ERROR: " + ae.getMessage());
            start = true;
        }
        catch (Exception e) {
            display.setText("ERROR: Unexpected");
            e.printStackTrace();
            start = true;
        }
    }
}