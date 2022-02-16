public abstract class Shape implements Drawable {

    enum ShapeType {
        SQUARE, RECT, CIRCLE
    }

    private ShapeType type;

    public Shape(ShapeType type) {
        this.type = type;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }
}
