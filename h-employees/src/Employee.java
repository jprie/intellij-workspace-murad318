public abstract class Employee implements Greetable, Honorable {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void honor() {
        System.out.println("Best employee award");
    }

    public abstract int getSalary();
}
