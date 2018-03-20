import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named QuadraticEquation for a quadratic equation 𝑎𝑥
 * 2 + 𝑏𝑥 + 𝑐 = 0. The
 * class contains
 *  Private data fields a, b, and c that represents three coefficients.
 *  A constructor with the arguments for a, b, and c.
 *  Three getter methods for a, b, c. [getter are the methods which help access the private
 * data fields].
 *  A method named getDiscriminant() that returns the discriminant, which is 𝑏
 * 2 − 4𝑎𝑐.
 *  The method named getRoot1() and getRoot2() for returning two roots of the equation
 * 𝑟1 =
 * −𝑏 + √𝑏
 * 2−4𝑎𝑐
 * 2𝑎
 * and 𝑟2 =
 * −𝑏 − √𝑏
 * 2−4𝑎𝑐
 * 2𝑎
 * These methods are useful only if the discriminant is nonnegative. Let these methods
 * return 0 if the discriminant is negative.
 * Write a test program that prompts the user to enter values for a, b, and c and display the
 * result based on the discriminant. If the discriminant is positive display the two roots, if the
 * discriminant is 0, display the one root. Otherwise, display “The equation has no roots.”
 */
public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int discriminantTester() {
        if (((Math.pow(b, 2) - 4 * a * c) > 0)) {
            return 1;
        } else if (((Math.pow(b, 2) - 4 * a * c) == 0)) {
            return 0;
        } else {
            return -1;
        }
    }

    public double getDiscriminant() {
        return ((discriminantTester() >= 0) ? (Math.pow(b, 2) - 4 * a * c) : 0);
    }

    public double getRoot1() {
        return ((discriminantTester() >= 0) ? ((-1 * b + Math.pow(getDiscriminant(), 0.5)) / 2 * a) : 0);
    }

    public double getRoot2() {
        return ((discriminantTester() >= 0) ? ((-1 * b - Math.pow(getDiscriminant(), 0.5)) / 2 * a) : 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        QuadraticEquation testing = new QuadraticEquation(a, b, c);
        if (testing.discriminantTester() > 0) {
            System.out.println("root 1 = " + testing.getRoot1() + " root 2 = " + testing.getRoot2());
        } else if (testing.discriminantTester() == 0) {
            System.out.println("root = " + testing.getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }

    }

}
