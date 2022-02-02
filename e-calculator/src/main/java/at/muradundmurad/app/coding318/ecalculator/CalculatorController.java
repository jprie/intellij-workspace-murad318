package at.muradundmurad.app.coding318.ecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {


    @FXML
    private Label displayLabel;

    private boolean enteringANumber;
    private CalculatorBrain brain = new CalculatorBrain();

    public void onNumberClick(ActionEvent actionEvent) {

        Button clickedButton = (Button)actionEvent.getSource();
        String numberOfButton = clickedButton.getText();
        String fromDisplay = displayLabel.getText();

        // comma-handling
        boolean containsComma = fromDisplay.contains(".");
        boolean isComma = numberOfButton.equals(".");

        if (enteringANumber) {
            if (containsComma && isComma) {
                numberOfButton = "";
            }
            displayLabel.setText(fromDisplay + numberOfButton);
        } else {
            enteringANumber = true;
            if (fromDisplay.equals(".")) {
                numberOfButton = "0" + fromDisplay;
            }
            displayLabel.setText(numberOfButton);
        }

    }

    public void onOperatorClick(ActionEvent actionEvent) {

        Button operatorButton = (Button) actionEvent.getSource();
        String operatorString = operatorButton.getText();

        if (operatorString.equals("=")) {

            if (brain.getOperator() != null) {
                brain.setOperand2(Double.parseDouble(displayLabel.getText()));
                brain.calculateResult();
                displayLabel.setText(String.valueOf(brain.getResult()));
            }

        } else {

            enteringANumber = false;
            brain.setOperand1(Double.parseDouble(displayLabel.getText()));
            brain.setOperatorString(operatorString);


        }

    }

    @FXML
    void initialize() {

        displayLabel.setText("0.0");
    }
}