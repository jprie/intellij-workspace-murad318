public class Main {

    public static void main(String[] args) {


        SeniorDeveloper johannes = new SeniorDeveloper("Johannes");
        JuniorDeveloper franz = new JuniorDeveloper("Franz");
        Manager hansPeter = new Manager("Hans-Peter");
        Customer karl = new Customer("Karl");

        Employee[] employees = {johannes, hansPeter, franz};

        for (Employee employee : employees) {

            System.out.println(employee.getSalary());

            if (employee instanceof Developer developer) {
                developer.askForRaise();
            }
        }

        Greetable[] greetables = {johannes, karl, hansPeter, franz};



    }
}
