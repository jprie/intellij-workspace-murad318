import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // alle Calculator operations zentral definiert
    private static final BinaryOperator<Double> addJDK = (op1, op2) -> op1 + op2;

    private static final CalculatorOperation add = ((op1, op2) -> op1 + op2);
    private static final CalculatorOperation sub = ((op1, op2) -> op1 - op2);
    private static final CalculatorOperation mul = ((op1, op2) -> op1 * op2);
    private static final CalculatorOperation div = ((op1, op2) -> op1 / op2);

    public static void main(String[] args) {

        Calculation calculation = null;
        try {
            calculation = handleInput();

            CalculatorOperation operator = null;

            operator = selectOperator(calculation.getOperatorString());
            double result = executeOperation(operator, calculation.getOp1(), calculation.getOp2());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static double executeOperation(CalculatorOperation operator, double op1, double op2) {
        return operator.execute(op1, op2);
    }

    private static CalculatorOperation selectOperator(String operatorString) throws Exception {

        // In der Switch-Expression ist das break implizit
        return switch (operatorString) {
            case "+" -> add;
            case "-" -> sub;
            case "*" -> mul;
            case "/" -> div;
            default -> throw new Exception("Unknown operator");
        };

    }

    private static Calculation handleInput() throws Exception {

        System.out.println("Geben Sie eine Berechnung ein (1 + 2, 3.4 - 7.2, 0.9 * 1.2, 3.2 / 8.9)");
        double op1;
        double op2;
        if (scanner.hasNextDouble()) {
            op1 = scanner.nextDouble();
            String operatorString = scanner.next();
            if (scanner.hasNextDouble()) {
                op2 = scanner.nextDouble();
                return new Calculation(op1, op2, operatorString);
            }

        }
        throw new Exception("Syntax-Error in Calculation");

    }


}
