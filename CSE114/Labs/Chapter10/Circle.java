import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a superclass encapsulating a circle; this class has one attribute representing the radius of
 * the circle. It has methods returning the perimeter and the area of the circle. This class has a
 * subclass, encapsulating a cylinder. A cylinder has a circle as its base, and another attribute, its
 * length; it has two methods, calculating and returning its area and volume. You also need to
 * include a client class (test program) to test these two classes.
 * Use the following formula:
 *  area of the cylinder = 2 ∗ 𝜋 ∗ 𝑟𝑎𝑑𝑖𝑢𝑠 ∗ 𝑟𝑎𝑑𝑖𝑢𝑠 + 2 ∗ 𝜋 ∗ 𝑟𝑎𝑑𝑖𝑢𝑠 ∗ 𝑙𝑒𝑛𝑔𝑡ℎ
 *  volume of the cylinder = 𝜋 ∗ 𝑟𝑎𝑑𝑖𝑢𝑠 ∗ 𝑟𝑎𝑑𝑖𝑢𝑠 ∗ 𝑙𝑒𝑛𝑔𝑡ℎ
 */
public class Circle {
    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        return (Math.PI * 2 * radius);
    }

    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    }
}

class Cylinder extends Circle {
    private double length;
    private Circle base;

    public Cylinder() {
        length = 1;
        base = new Circle();
    }

    public Cylinder(double length, double radius) {
        super(radius);
        this.length = length;
    }

    public double getArea() {
        return (2 * super.getArea() + length * super.getPerimeter());
    }

    public double getVolume() {
        return (super.getArea() * length);
    }
}

class TestingCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Testing Circle:");
        System.out.print("Input radius: ");
        Circle testing1 = new Circle(input.nextDouble());
        input.nextLine();
        System.out.println("Radius = " + testing1.getRadius() + ", Area = " + testing1.getArea() + ", Perimeter = " +
                "" + testing1.getPerimeter() + "\n");
        System.out.println("Testing Cylinder");
        System.out.print("Input length: ");
        double length = input.nextDouble();
        System.out.print("Input Radius: ");
        Cylinder testing2 = new Cylinder(length, input.nextDouble());
        System.out.println("Radius = " + testing2.getRadius() + ", Area = " + testing2.getArea() + ", Perimeter = " +
                "" + testing2.getVolume() + "\n");
    }
}
