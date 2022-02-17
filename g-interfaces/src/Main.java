public class Main {

    public static void main(String[] args) {

        Text text = new Text("Hello", true, false);
        Rectangle rectangle = new Rectangle(15, 30);

        text.print();
        rectangle.print();

        Printable[] printables = new Printable[] {text, rectangle};

        for (Printable p : printables) {

            p.print();

            // Auch hier bei Rectangle-Methode Überprüfung und Cast benötigt
        }

        Drawable[] drawables = new Drawable[] {text, rectangle};

        for (Drawable d : drawables) {
            d.draw();
            // Da jedes Drawable auch Erasable sein muss!!! (extends-Beziehung)
            d.erase();
        }

        Erasable erasable = text;
        // ABER: nicht jedes Erasable ist auch Drawable!!!
//        erasable.draw();
    }
}
