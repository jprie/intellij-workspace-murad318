public class Manager extends Employee {

    protected Manager(String name) {
        super(name);
    }

    @Override
    public int getSalary() {
        return 5000;
    }

    @Override
    public void greet(String name) {
        System.out.println("Dear Manager, " + name + ": Merry Christmas");
    }
}
