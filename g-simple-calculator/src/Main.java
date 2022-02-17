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
        };

        double product = calculatorMultiply.execute(2.1, 4.2);

        // Lambda-Ausdruck
        // Auf funktionale Interfaces beschränkt!!
        CalculatorOperation calculatorDivide = (double operator1, double operator2) -> operator1 / operator2;

        // TODO: Methoden-Referenzen nächste Woche!!

    }

}
