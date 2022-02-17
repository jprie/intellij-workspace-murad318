public abstract class AnyDog extends TaxedDog {

    public AnyDog(String taxID) {
        super(taxID); // das Gleiche wie: TaxedDog(taxID)
    }

    // Ich implementiere getTaxes() bewusst nicht
}
