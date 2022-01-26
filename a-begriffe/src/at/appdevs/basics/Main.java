package at.appdevs.basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Suffixe: f
        // Mit dem Suffix f sage ich dem Compiler: Mach aus dem 1.22222222 eine 32 bit Wert!
        // 2. Schritt: Zuweisung von 1.22222222f an die Variable
        float f = 1.222222222222f; // 32bit

        // Default in Java ist double
        double d = 1.3333333333333333333; // 64bit

        // Fehler: 64 bit in eine 32 bit Variable geht nicht!
        // float fromDouble = d;

        // FUNKTIONIERT: da 32 bit in 64 bit Variable PlaTZ HAT
        double d2 = 1.2f;


        // Suffix: L für long (64bit)
        long l = 4_000_000_000L; // 4_000_000_000 hat in 32-bit int nicht Platz.

        // Default in Java ist int mit 32 bit, deswegen braucht es kein Suffix!
        int i = 400_000_000;

        /*
        ACHTUNG: byte hat 8 bit, also -128 bis 127. Das sind 2^8-1 = 255 Werte!
         */
        short s = 32000; // wird zu 16 bit gemacht
        byte b = -128; // wird zu 8 bit gemacht

        // ----------- String

        // Strings sind Objekte

        // 3 Strings erzeugt
        String str = "Hello" + " " + "world"; // hier gehts weiter.

        String str2 = "Hello World"; // hier entsteht nur 1 String



        // -------- Referenzdatentyp

        // scannerReferenz 'zeigt' auf das Objekt new Scanner (mit Konstruktor erzeugt)

        // Scanner ist der Referenzdatentyp und 'new Scanner' erzeugt aus Datentyp (Klasse) Scanner ein Objekt!!
        Scanner scannerReferenz = new Scanner(System.in);

        Scanner scannerReferenz2 = scannerReferenz;

        Student studentRef = new Student("Johannes", "Priebsch");

        Student studentRef2 = studentRef;

        // beide Referenzen zeigen auf dasselbe Objekt

        studentRef.setFirstName("Johann");

        System.out.println(studentRef2.getFirstName());

    }
}
