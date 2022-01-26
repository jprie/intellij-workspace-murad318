package at.appdevs.basics;

public class Square {

    private Stone stone = null;

    // Erstelle Square mit Stein
    public Square(Stone stone) {
        this.stone = stone;
    }

    // Erstelle Square ohne Stein
    public Square() {}

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public Stone getStone() {
        return stone;
    }

    @Override
    public String toString() {
        // gibt es einen Stein, gib Stein aus, ist das Square leer, gib "." aus
        return stone == null ? "." : stone.toString();
    }
}
