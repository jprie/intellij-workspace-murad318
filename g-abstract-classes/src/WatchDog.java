public class WatchDog extends TaxedDog {

    public WatchDog(String taxID) {
        super(taxID);
    }

    @Override
    public int getTaxes() {
        return TaxedDog.baseTax/2;
    }

    public void barkForAlarm() {
        System.out.println("Wauwau");
    }


}
