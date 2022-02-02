package at.muradundmurad.app.coding318.ecalculator;

import java.util.function.BinaryOperator;

public class CalculatorBrain {

    private static final BinaryOperator<Double> add = Double::sum;
    private static final BinaryOperator<Double> sub = (op1, op2) -> op1 - op2;
    private static final BinaryOperator<Double> mul = (op1, op2) -> op1 * op2;
    private static final BinaryOperator<Double> div = (op1, op2) -> op1 / op2;

    private BinaryOperator<Double> operator;
    private double operand1;
    private double operand2;
    private double result;

    public CalculatorBrain() {
    }

    public BinaryOperator<Double> getOperator() {
        return operator;
    }

    public void setOperatorString(String operatorString) {

        this.operator = switch(operatorString) {
            case "+" -> add;
            case "-" -> sub;
            case "*" -> mul;
            case "/" -> div;
            default -> throw new RuntimeException("Unknown operator");
        };
    }

    public void calculateResult() {

        this.result = operator.apply(operand1, operand2);
        operator = null;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
