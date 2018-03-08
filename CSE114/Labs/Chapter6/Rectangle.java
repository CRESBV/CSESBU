//Edward Buckler
//111628438
//L05
/*
Design a class named Rectangle to represent a rectangle. The class contains:
 Two double data fields named width and height that specify the width and height of
the rectangle. The default values are 1 for both width and height.
 A no-argument constructor (default-constructor) that creates a default constructor.
 A constructor that creates a rectangle with the specified width and height.
 A method named getArea() that returns the area of this rectangle.
 A method named getPerimeter() that returns the perimeter.
Write a test program that creates two Rectangle objects -- one with width 4 and height 40,
and the other with width 3.5 and height 35.9. Display the width, height, area, and perimeter
of each rectangle in this order.
*/
public class Rectangle {
    private double width, height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }

    public String viewAllRecData() {
        return Double.toString(width) + ", " + Double.toString(height) + ", " + getArea() + ", " + getPerimeter();
    }
}
