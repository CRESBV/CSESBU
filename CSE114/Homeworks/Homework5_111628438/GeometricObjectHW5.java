public abstract class GeometricObjectHW5 implements Comparable {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObjectHW5() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObjectHW5(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    static int max(GeometricObjectHW5 geoObj1, GeometricObjectHW5 geoObj2) {
        return (geoObj1.getArea() >= geoObj2.getArea()) ? ((geoObj1.getArea() == geoObj2.getArea()) ? 0 : 1) : -1;
    }

    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}

class CircleHW5 extends GeometricObjectHW5 {
    private double radius;

    public CircleHW5() {
        radius = 1;
    }

    public CircleHW5(double radius) {
        this.radius = radius;
    }

    public CircleHW5(String color, boolean filled, int radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double getPerimeter() {
        return (2 * radius * Math.PI);
    }

    public int compareTo(Object c1) {
        return (((CircleHW5) c1).getArea() >= getArea()) ? ((((CircleHW5) c1).getArea() == getArea()) ? 0 : 1) : -1;
    }
}

class RectangleHW5 extends GeometricObjectHW5 {
    private double length, width;

    public RectangleHW5() {
        length = 1;
        width = 1;
    }

    public RectangleHW5(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public RectangleHW5(String color, boolean filled, double length, double width) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return (length * width);
    }

    @Override
    public double getPerimeter() {
        return (length * 2 + width * 2);
    }

    public int compareTo(Object c1) {
        return (((CircleHW5) c1).getArea() >= getArea()) ? ((((CircleHW5) c1).getArea() == getArea()) ? 0 : 1) : -1;
    }
}

class driver {
    public static void main(String[] args) {
        RectangleHW5 rec1 = new RectangleHW5();
        RectangleHW5 rec2 = new RectangleHW5(1, 0.5);
        CircleHW5 cir1 = new CircleHW5();
        CircleHW5 cir2 = new CircleHW5(2);
        System.out.println("rec1.getArea() = " + rec1.getArea());
        System.out.println("rec2.getArea() = " + rec2.getArea());
        System.out.println("cir1.getArea() = " + cir1.getArea());
        System.out.println("cir2.getArea() = " + cir2.getArea());
        int recComp = GeometricObjectHW5.max(rec1, rec2);
        int cirComp = GeometricObjectHW5.max(cir1, cir2);
        System.out.println("Largest rectangle: " + ((0 <= recComp) ? ((recComp == 0) ? "Rectangles Equal Size" : "rec1") : "rec2"));
        System.out.println("Largest circle: " + ((0 <= cirComp) ? ((cirComp == 0) ? "Circles Equal Size" : "cir1") : "cir2"));
    }
}