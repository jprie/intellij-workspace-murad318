

public class Main {

    public static void main(String[] args) {

        Text text = new Text("hello", true, false);

        Circle circle = new Circle(5.0);

        Drawable dText = text;

//        Eraseable eCircle = circle;

        Eraseable eText = text;
    }
}
