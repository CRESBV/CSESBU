/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design an interface named Colorable with a void method named howToColor(). Every class
 * of a colorable object must implement the Colorable interface. Design a class named Square
 * that extends GeometricObject and implements Colorable. Implement howToColor to display
 * the message “Color all four sides”. The Square class contains a data field named side with its
 * getter and setter methods, and constructor for constructing Square with specific side. It has noarg
 * constructor to create a Square with side 0, and another constructor that creates a Square
 * with specified side.
 * Write a test program that creates an array of four GeometricObjects. For each object in the
 * array, display its area and invoke its howToColor method if it is colorable.
 */
public interface Colorable {
    public void howToColor();
}

class SquareLab extends GeometricObjectLab implements Colorable {
    private double sideLength;

    public SquareLab() {
        sideLength = 0;
    }

    public SquareLab(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }
}

class TriangleLab extends GeometricObjectLab implements Colorable {

    private double side1, side2, side3;

    public TriangleLab() {
        side1 = side2 = side3 = 1;
    }

    public TriangleLab(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all three sides");
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

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
}

class DriverColorable {
    public static void main(String[] args) {
        GeometricObjectLab[] testArr = new GeometricObjectLab[4];
        testArr[0] = new RectangleLab(1, 2);
        testArr[1] = new CircleLab(1);
        testArr[2] = new TriangleLab(1, 1, 1);
        testArr[3] = new SquareLab(1);

        System.out.println("Rec Area: " + testArr[0].getArea()  + " How To Color:");
        ((RectangleLab) testArr[0]).howToColor();
        System.out.println("Circle Area: " + testArr[1].getArea());
        System.out.println("Triangle Area: " + testArr[2].getArea() + " How To Color:");
        ((TriangleLab) testArr[2]).howToColor();
        System.out.println("Square Area: " + testArr[3].getArea() + " How To Color:");
        ((SquareLab) testArr[3]).howToColor();

    }
}