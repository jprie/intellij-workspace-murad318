public class SeniorDeveloper extends Developer {

    public SeniorDeveloper(String name) {
        super(name);
    }

    @Override
    public void askForRaise() {
        System.out.println("I'm earning 4000 and I would like to earn more");
    }

    @Override
    public int getSalary() {
        return 4000;
    }
}
