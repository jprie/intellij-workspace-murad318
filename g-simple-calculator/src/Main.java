public class Main {

    public static void main(String[] args) {

        PlusOperation plusOperation = new PlusOperation();
        MinusOperation minusOperation = new MinusOperation();

        double sum = plusOperation.execute(2.3, 4.5);
        double minusResult = minusOperation.execute(4.5, 9.3);

        CalculatorOperation calculatorPlus = plusOperation;
        calculatorPlus.execute(2.3, 7.9);


        // Kurzschreibweise: Anonyme Klasse, Einweg-Klassen
        // erstellt Klasse, implements CalculatorOperation, liefert die Implementierung
        // UND erstellt Objekt
        // Kann auch mehrere Methoden implementieren
        CalculatorOperation calculatorMultiply = new CalculatorOperation() {
            @Override
            public double execute(double op1, double op2) {
                return op1 * op2;
            }

            public void anotherMethod() {
                System.out.println("Another method");
            }
        };

        double product = calculatorMultiply.execute(2.1, 4.2);

        // Lambda-Ausdruck
        // Auf funktionale Interfaces beschränkt!!
        CalculatorOperation calculatorDivide = (double operand1, double operand2) -> {

            if (operand2 != 0) {
                // benötigt return sobald Block-Syntax
                return operand1 / operand2;
            }

            throw new ArithmeticException("/ by 0");
        };

        // MethodenReferenz
        // Eingeschränkt auf Functional Interfaces
        // MethodenSignatur von subtract und execute muss übereinstimmen.
        CalculatorOperation calculatorSubtract = Main::subtract;
        System.out.println(calculatorSubtract.execute(2,3));

        //
        CalculatorOperation calculatorSubtract2 = Calculator::subtract;


        CalculatorOperation[] calculatorOperations =
                {calculatorDivide, calculatorMultiply, calculatorSubtract, calculatorPlus};
    }

    private static double subtract(double op1, double op2) {

        return op1 - op2;
    }

}
