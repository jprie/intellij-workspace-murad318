public class JuniorDeveloper extends Developer {


    public JuniorDeveloper(String name) {
        super(name);
    }

    @Override
    public void askForRaise() {
        System.out.println("I'm earning 2800 and I would like to get more!!");
    }

    @Override
    public int getSalary() {
        return 2800;
    }
}
