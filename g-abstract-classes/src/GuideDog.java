public class GuideDog extends TaxedDog {

    public GuideDog(String taxID) {
        super(taxID);
    }

    @Override
    public int getTaxes() {
        // GuideDog zahlt keine Steuer
        return 0;
    }


}
