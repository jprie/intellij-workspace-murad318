public class Rectangle implements Printable, Drawable {

    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void print() {
        System.out.println("Print Rectangle: length=" + length + " width="
                           + width);
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase Rectangle");
    }
}
