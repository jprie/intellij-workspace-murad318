package at.appdevs.basics.app;

public class Stone {

    // definiere 2 Farben
    public static final String YELLOW = "y";
    public static final String RED = "r";

    private Color color;

    public Stone(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {

        return color.toString();
    }
}
