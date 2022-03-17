public abstract class Developer extends Employee {

    public Developer(String name) {
        super(name);
    }

    public abstract void askForRaise();
    // Selbst abstrakt, weil es gibt Junior und Senior-Developer
//    @Override
//    public int getSalary() {
//        return 2800;
//    }


    @Override
    public void greet(String name) {
        System.out.println("Dear developer: Merry Christmas");
    }
}
