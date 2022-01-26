package at.appdevs.basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final  boolean INPUT = false;
    private static final  boolean GUESS = true;

    public static void main(String[] args) {

        // ArrayList von Objekten vom Typ Integer
        ArrayList<Integer> numbers = new ArrayList<>();

        // Referenzdatentypen sind Klassen!
        String str = "Johannes";
        Integer iObj = 1;

        // 2 String-Objekte erzeugen
        String s1 = "lalala";
        String s2 = new String("lalala");

        //


        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean doExit = false;
        int randomIndex = 0;
        boolean mode = INPUT;

        do {
            if (mode == INPUT) {
                System.out.println("[INPUT] Geben Sie eine Ganzzahl ein");
            } else { // mode == GUESS
                System.out.println("[GUESS] Raten Sie eine Ganzzahl");
            }

            // ueberprüft ob nächster Input eine Ganzzahl ist
            // Input-Handling
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

            } else {
                // command
                String command = scanner.next();
                if (command.equals("start")) {
                    // starte raten
                    mode = GUESS;
                    System.out.println();
                    // zufalls  index berechnet
                    randomIndex = (int)(Math.random() * numbers.size());

                } else if (command.equals("quit")) {
                    doExit = true;
                }
            }

            // Programm-Logik
            if (mode == INPUT) {
                // Füge Zahlen ins ArrayList ein
                numbers.add(number);

            } else { // mode == GUESS
                // Vergleiche Zahl in ArrayList an randomIndex

                /*
                number
                 Der Bug war hier: if(number == numbers.get(randomIndex))
                 Wrapper-Klassen
                 */
                if (numbers.get(randomIndex).equals(number)) {
                    System.out.println("Gewonnen");
                    doExit = true;
                }
            }

        }while (!doExit);

        System.out.println("Program quit");
    }
}
