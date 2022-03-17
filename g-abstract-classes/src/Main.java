public class Main {

    public static void main(String[] args) {

        GuideDog guideDog = new GuideDog("asd123");
        WatchDog watchDog = new WatchDog("yui843");

        System.out.println("Guide dog: " + guideDog.getTaxes());
        System.out.println("Watch dog: " + watchDog.getTaxes());

        // Beide sind abgeleitet von TaxedDog, deswegen gehen beide in ein
        // TaxedDog[]
        TaxedDog[] taxedDogs = new TaxedDog[] {guideDog, watchDog};
        taxedDogs[0].getTaxes();

        for (TaxedDog t : taxedDogs) {
            // Laufzeitumgebung sucht sich automatisch die richtige Implementierung
            // je nach Objekt. Weil Methoden überschrieben wurden.
            System.out.println(t.getTaxes());

            // Kann man WatchDog-Methode hier aufrufen?? - geht nicht
            // t.barkForAlarm();

            // Überprüfung: ist TaxedDog tatsächlich ein WatchDog?
//            if (t instanceof WatchDog) {
//                WatchDog w = (WatchDog) t; // Caste (=Typumwandlung) TaxedDog auf WatchDog
//                w.barkForAlarm();
//            }

            // Kurzschreibweise: Überprüfung + Cast (nur wenn tatsächlich ein Watchdog!)
            if (t instanceof WatchDog w) {
                w.barkForAlarm();
            }


            // w ist out of scope
//            w.barkForAlarm();

            // t ist nach wie vor ein TaxedDog
            t.getTaxes();
        } // t out of scope
    }
}
