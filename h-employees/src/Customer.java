public class Customer implements Greetable, Honorable {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void greet(String name) {
        System.out.println("Merry Christmas dear Customer: " + name);
    }

    @Override
    public void honor() {
        System.out.println("Best customer award");
    }
}
