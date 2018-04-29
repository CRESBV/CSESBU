import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named Triangle that extends GeometricObject class (attached with this Lab).
 * The class contains
 *  Three double data fields named 𝑠𝑖𝑑𝑒1, 𝑠𝑖𝑑𝑒2, 𝑎𝑛𝑑 𝑠𝑖𝑑𝑒3 with default values 1.0 to
 * denote three sides of a triangle.
 *  A no-arg constructor that creates a default triangle.
 *  A constructor that creates a triangle with specified 𝑠𝑖𝑑𝑒1, 𝑠𝑖𝑑𝑒2, 𝑎𝑛𝑑 𝑠𝑖𝑑𝑒3.
 *  The accessor methods for all three data fields.
 *  A method named getArea() that returns the area of this triangle.
 *  A method named getPerimeter() that returns the area of this triangle.
 *  A method named toString() that returns a string description for the triangle.
 * The formula for computing the area of a triangle is:
 * 𝑠 =
 * 𝑠𝑖𝑑𝑒1 + 𝑠𝑖𝑑𝑒2 + 𝑠𝑖𝑑𝑒3
 * 2
 * , area = √𝑠(𝑠 − 𝑠𝑖𝑑𝑒1)(𝑠 − 𝑠𝑖𝑑𝑒2)(𝑠 − 𝑠𝑖𝑑𝑒3)
 * The toString() method is implemented as follows:
 * 𝑟𝑒𝑡𝑢𝑟𝑛 “𝑇𝑟𝑖𝑎𝑛𝑔𝑙𝑒: 𝑠𝑖𝑑𝑒1 = ” + 𝑠𝑖𝑑𝑒1 + “ 𝑠𝑖𝑑𝑒2 = ” + 𝑠𝑖𝑑𝑒2 + “ 𝑠𝑖𝑑𝑒3 = ” + 𝑠𝑖𝑑𝑒3 ;
 * Write a test program that prompts the user to enter three sides of the triangle, a color, and a Boolean
 * value to indicate whether the triangle is filled. The program should creates a Triangle object with
 * these sides and set the color and filled properties using the input. The program should display the
 * area, perimeter, color and true or false to indicate whether it is filled or not.
 */
public class Triangle extends GeometricObject {
    private double side1, side2, side3;

    public Triangle() {
        side1 = side2 = side3 = 1;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input sides of triangle: ");
        double side1 = input.nextDouble(), side2 = input.nextDouble(), side3 = input.nextDouble();
        input.nextLine();
        System.out.print("input color of triangle: ");
        String color = input.nextLine();
        System.out.print("input filled of triangle (bool): ");
        Boolean filled = input.nextBoolean();
        Triangle testing = new Triangle(color, filled, side1, side2, side3);
        System.out.println("area = " + testing.getArea() + ", perimeter = " + testing.getPerimeter() + ", color = " +
                testing.getColor() + ", filled = " + testing.isFilled());

    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return (Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5));
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    @Override
    public String toString() {

        return "Triangle: " + "side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}
