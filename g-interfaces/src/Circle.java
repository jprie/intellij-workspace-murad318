public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        super(ShapeType.CIRCLE);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle: with radius " + radius);
    }
}
