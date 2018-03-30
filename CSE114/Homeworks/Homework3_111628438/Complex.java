import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * <p>
 * Create a class called Complex for performing arithmetic with complex numbers. Complex
 * numbers have the form
 * 𝑟𝑒𝑎𝑙𝑃𝑎𝑟𝑡 + 𝑖𝑚𝑎𝑔𝑖𝑛𝑎𝑟𝑦𝑃𝑎𝑟𝑡 ∗ 𝑖
 * where 𝑖 is √−1
 * Write a program to test your class. Use double variable to represent the private data of the
 * class. Provide a constructor that enables an object of this class to be initialized when it’s
 * declared. Provide a no-argument constructor with default values in case no initializers are
 * provided. Provide public methods that perform the following operations:
 * a) Add two Complex numbers: The real parts are added together and the imaginary parts
 * are added together.
 * b) Subtract two Complex numbers: The real part of the right operand is subtracted from
 * the real part of the left operand, and the imaginary part of the right operand is
 * subtracted from the imaginary part of the left operand.
 * c) Print Complex numbers in the form (𝑎, 𝑏) where 𝑎 the real part and 𝑏 is the imaginary part.
 * Here is a sample run:
 * Enter real part of the first complex number: 3
 * Enter imaginary part of the first complex number: 6
 * Enter real part of the second complex number: 2
 * Enter imaginary part of the second complex number: 7
 * First complex number is: (3.0, 6.0)
 * Second complex number is: (2.0, 7.0)
 * Addition of the complex numbers is: (5.0, 13.0)
 * Subtraction of the complex numbers is: (1.0, -1.0)
 */
public class Complex {
    double real, com;

    public Complex(double real, double com) {
        this.real = real;
        this.com = com;
    }

    public Complex() {
        real = 0;
        com = 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Complex num1 = new Complex(), num2 = new Complex();
        System.out.print("Enter real part of the first complex number: ");
        num1.setReal(input.nextDouble());
        System.out.print("Enter imaginary part of the first complex number: ");
        num2.setCom(input.nextDouble());
        System.out.print("Enter real part of the second complex number: ");
        num2.setReal(input.nextDouble());
        System.out.print("Enter imaginary part of the second complex number: ");
        num1.setCom(input.nextDouble());
        System.out.println("First complex number is: " + printer(num1));
        System.out.println("Second complex number is: " + printer(num2));
        System.out.println("Addition of the complex numbers is: " + printer(add(num1, num2)));
        System.out.println("Subtraction of the complex numbers is: " + printer(subtract(num1, num2)));
    }

    public static String printer(Complex num) {
        return "(" + num.getReal() + ", " + num.getCom() + ")";
    }

    public static Complex add(Complex num1, Complex num2) {
        return new Complex((num1.getReal() + num2.getReal()), (num1.getCom() + num2.getCom()));
    }

    public static Complex subtract(Complex num1, Complex num2) {
        return new Complex((num1.getReal() - num2.getReal()), (num1.getCom() - num2.getCom()));
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getCom() {
        return com;
    }

    public void setCom(double com) {
        this.com = com;
    }
}