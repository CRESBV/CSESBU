import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Create a class called Rational for performing arithmetic with fractions. Write a program to
 * test your class. Use integer variables to represent the private instance variables of the class -
 * the numerator and the denominator. Provide a constructor that enables an object of this class
 * to be initialized when it’s declared. The constructor should store the fraction in reduced form.
 * The fraction
 * 2/4
 * is equivalent to 1/2 and would be stored in the object as 1 in the numerator and 2 in the
 * denominator. Provide a no-argument constructor with default values in case no initializers
 * are provided. Provide public methods that perform each of the following operations:
 * a) Add two Rational numbers: The result of the addition should be stored in reduced
 * form.
 * b) Subtract two Rational numbers: The result of subtraction should be stored in reduced
 * form.
 * c) Multiply two Rational numbers: The result of the multiplication should be stored in
 * reduced form.
 * d) Divide two Rational numbers: The result of the division should be stored in reduced
 * form.
 * e) Return a String representation of Rational number in the form 𝑎/𝑏, where 𝑎 is the
 * numerator and 𝑏 is the denominator.
 * Here is a sample run:
 * Enter numerator for the first rational number: 4
 * Enter a non-zero denominator for the first rational number: 6
 * Enter numerator for the second rational number: 1
 * Enter a non-zero denominator for the second rational number: 4
 * First rational number is: 2/3
 * Second rational number is: 1/4
 * Addition of the rational numbers is: 11/12
 * Subtraction of the rational numbers is: 5/12
 * Multiplication of the rational numbers is: 1/6
 * Division of the rational numbers is: 8/3
 */
public class Rational {
    private int numerator, denominator;

    public Rational() {
        numerator = 1;
        denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rational testing1 = new Rational(), testing2 = new Rational();
        System.out.print("Enter numerator for the first rational number: ");
        testing1.setNumerator(input.nextInt());
        System.out.print("Enter a non-zero denominator for the first rational number: ");
        testing1.setDenominator(input.nextInt());
        System.out.print("Enter numerator for the first rational number: ");
        testing2.setNumerator(input.nextInt());
        System.out.print("Enter a non-zero denominator for the first rational number: ");
        testing2.setDenominator(input.nextInt());
        System.out.println("First rational number is: " + testing1);
        System.out.println("Second rational number is: " + testing2);
        System.out.println("Addition of the rational numbers is: " + add(testing1, testing2));
        System.out.println("Subtraction of the rational numbers is: " + subtract(testing1, testing2));
        System.out.println("Multiplication of the rational numbers is: " + multiply(testing1, testing2));
        System.out.println("Division of the rational numbers is: " + divide(testing1, testing2));
    }

    public static Rational add(Rational num1, Rational num2) {
        return new Rational(num1.getNumerator() * num2.getDenominator() + num2.getNumerator() *
                num1.getDenominator(), num1.getDenominator() * num2.getDenominator());
    }

    public static Rational subtract(Rational num1, Rational num2) {
        return new Rational(num1.getNumerator() * num2.getDenominator() - num2.getNumerator() *
                num1.getDenominator(), num1.getDenominator() * num2.getDenominator());
    }

    public static Rational multiply(Rational num1, Rational num2) {
        return new Rational(num1.getNumerator() * num2.getNumerator(), num1.getDenominator() * num2.getDenominator());
    }

    public static Rational divide(Rational num1, Rational num2) {
        return new Rational(num1.getNumerator() * num2.getDenominator(), num1.getDenominator() * num2.getNumerator());
    }

    private void reduce() {
        for (int i = ((numerator > denominator) ? denominator : numerator); i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        reduce();
    }
}
