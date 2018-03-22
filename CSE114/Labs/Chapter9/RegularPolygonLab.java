/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * In an n-sided regular polygon, all sides have same length and all angles have the same degree
 * (i.e., the polygon is both equilateral and equiangular). Design a class named RegularPolygon
 * that contains:
 *  A private int data field named 𝑛 that defines the number of sides in the polygon with
 * default value 3.
 *  A private double data field named 𝑠𝑖𝑑𝑒 that stores the length of the side with default
 * value 1.
 *  A private double data field named 𝑥 that defines the x-coordinate of the polygon’s
 * center with default value 0.
 *  A private double data field named 𝑦 that defines the y-coordinate of the polygon’s
 * center with default value 0.
 *  A no-arg constructor that creates a regular polygon with default values.
 *  A constructor that creates a regular polygon with the specified number of sides and
 * length of side, centered at (0, 0).
 *  A constructor that creates a regular polygon with the specified number of sides,
 * length of side, and x-coordinate and y-coordinate.
 *  The accessor and mutator for all data fields. [accessors are the getters and mutators
 * are the setters]
 * <p>
 * NERD
 * <p>
 *  The method getPerimeter() that returns the perimeter of the polygon.
 *  The method getArea() that returns the area of the polygon. The formula for
 * computing the area for a regular polygon is
 * Write a test program that creates three RegularPolygon objects, created using the no-arg
 * constructor, using RegularPolygon(6, 4), and using RegularPolygon(10, 4, 5.6, 7.8). For each
 * object, display its perimeter and area
 */
public class RegularPolygonLab {
    int n;
    double side, x, y;

    public RegularPolygonLab() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    public RegularPolygonLab(int n, double side) {
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }

    public RegularPolygonLab(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        RegularPolygonLab testing1 = new RegularPolygonLab();
        System.out.println("perimeter = " + testing1.getPerimeter() + ", area = " + testing1.getArea());

        RegularPolygonLab testing2 = new RegularPolygonLab(6, 4);
        System.out.println("perimeter = " + testing2.getPerimeter() + ", area = " + testing2.getArea());

        RegularPolygonLab testing3 = new RegularPolygonLab(10, 4, 5.6, 7.8);
        System.out.println("perimeter = " + testing3.getPerimeter() + ", area = " + testing3.getArea());
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return ((n * Math.pow(side, 2)) / (4 * Math.tan((Math.PI / n))));
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
