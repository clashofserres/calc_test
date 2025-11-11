package clashofserres.ui.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorView {
    private final TextField display = new TextField();
    private final GridPane buttonGrid = new GridPane();
    private final Button switchToConsoleBtn = new Button("Switch to Console");
    private final VBox root = new VBox(10);

    public CalculatorView(Stage stage) {
        setupDisplay();
        setupButtons();
        setupSwitchButton();
        setupLayout();

        Scene scene = new Scene(root, 400, 550);
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void setupDisplay() {
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setEditable(false);
        display.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        display.setPrefHeight(60);
    }

    private void setupButtons() {
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(20));

        String[][] layout = {
                {"1", "2", "3", "+", "C"},
                {"4", "5", "6", "-", "="},
                {"7", "8", "9", "*", "^"},
                {"0", ".", "%", "/", "√"}
        };

        for (int r = 0; r < layout.length; r++) {
            for (int c = 0; c < layout[r].length; c++) {
                String text = layout[r][c];
                if (text.isEmpty()) continue;
                Button btn = new Button(text);
                btn.setPrefSize(70, 60);
                btn.setStyle("-fx-font-size: 18px;");
                buttonGrid.add(btn, c, r);
            }
        }
    }

    private void setupSwitchButton() {
        switchToConsoleBtn.setPrefWidth(300);
        switchToConsoleBtn.setStyle(
                "-fx-font-size: 16px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;"
        );
    }

    private void setupLayout() {
        VBox.setMargin(buttonGrid, new Insets(10, 0, 0, 0));
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(display, buttonGrid, switchToConsoleBtn);
    }

    // Accessors
    public TextField getDisplay() { return display; }
    public GridPane getButtonGrid() { return buttonGrid; }
    public Button getSwitchToConsoleButton() { return switchToConsoleBtn; }
    public VBox getRoot() { return root; }
}
