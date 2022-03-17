@FunctionalInterface
public interface CalculatorOperation {

    // Binäre mathematische Operation (z.B. +, -, *, /)
    double execute(double op1, double op2);

    // Functional Interface erlaubt nur eine zu implementierende Methode
//    void secondMethod();








    // Beides möglich
//    static void method() {
//
//    }
//
    // Möglich, da ja keine zu implementierende Methode
//    default void bla() {
//
//    }
}
