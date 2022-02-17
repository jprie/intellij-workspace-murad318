// Abstrakte Klasse nicht instantiierbar, da nicht fertig implementiert
public abstract class TaxedDog {

    public static final int baseTax = 120;
    private String taxID;

    public TaxedDog(String taxID) {
        this.taxID = taxID;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    // Abstrakte Methode ohne Implementierung
    public abstract int getTaxes();

}
