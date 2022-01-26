package at.appdevs.basics;

public class Main {

    public static void main(String[] args) {

        Fox f1 = new Fox("Reineke",3);

        Fox f2 = f1;

        // Identitätsvergleich
        // Überprüfung ob f1 und f2 auf das selbe Objekt zeigen
        if (f1 == f2) {
            System.out.println("f1 == f2");
        }

        f2.setName("Billy");
        System.out.println("f1 heisst jetzt: " + f1.getName());

        changeFoxName(f2, "Luki");

        System.out.println("f2 nach changeFoxName: " + f2.getName());
        System.out.println("f1 nach changeFoxName: " + f1.getName());

        // ---------------- ein 2. Fox wird erstellt

        Fox newFoxRef = new Fox("Hans-Dieter", 5);

        if (newFoxRef == f2) {
            System.out.println("Gleiches Objekt");
        } else {
            System.out.println("Unterschiedliches Objekt");
        }

        // damit beide Objekte sicher den gleichen Inhalt haben
        newFoxRef.setName(f2.getName());
        newFoxRef.setAge(f2.getAge());

        // Inhaltlicher Vergleich (der Werte der Attribute)
        // Überprüft, sind die Namen gleich. Vergleicht also den Inhalt!
        if (f2.equals(newFoxRef)) {
            System.out.println("f2 equals foxRef");
        } else {
            System.out.println("!equals");
        }


    }

    // Diese Methode verändert das Objekt auf das foxRef zeigt
    private static void changeFoxName(Fox foxRef, String name) {

        foxRef.setName(name);
    }
}
