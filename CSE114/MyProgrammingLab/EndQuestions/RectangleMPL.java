/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * (The Rectangle class) Following the example of the Circle class in Section 8.2,
 * design a class named Rectangle to represent a rectangle. The class contains:
 * <p>
 * ■ Two double data fields named width and height that specify the width and
 * height of the rectangle. The default values are 1 for both width and height.
 * ■ A no-arg constructor that creates a default rectangle.
 * ■ A constructor that creates a rectangle with the specified width and height.
 * ■ A method named getArea() that returns the area of this rectangle.
 * ■ A method named getPerimeter() that returns the perimeter.
 * <p>
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates two Rectangle objects—one with width 4 and height 40
 * and the other with width 3.5 and height 35.9. Display the width, height, area,
 * and perimeter of each rectangle in this order.
 */
public class RectangleMPL {
    private double width, height;

    public RectangleMPL() {
        width = 1;
        height = 1;
    }

    public RectangleMPL(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4, 40);
        System.out.println("The area of a 4.0 x 40.0 Rectangle is " + rec1.getArea());
        System.out.println("The perimeter of a 4.0 x 40.0 Rectangle is " + rec1.getPerimeter());

        Rectangle rec2 = new Rectangle(3.5, 35.9);
        System.out.println("The area of a 3.5 x 35.9 Rectangle is " + rec2.getArea());
        System.out.println("The perimeter of a 3.5 x 35.9 Rectangle is " + rec2.getPerimeter());
    }
}
