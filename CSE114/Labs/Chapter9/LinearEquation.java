import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named LinearEquation for a 2 × 2 system of linear equations:
 * 𝑎𝑥 + 𝑏𝑦 = 𝑒
 * 𝑐𝑥 + 𝑑𝑦 = 𝑓
 * Where: 𝑥 = 𝑒𝑑−𝑏𝑓 / 𝑎𝑑−𝑏𝑐
 * and 𝑦 = 𝑎𝑓−𝑒𝑐 / 𝑎𝑑−𝑏𝑐
 * The class contains:
 *  Private data fields 𝑎, 𝑏, 𝑐, 𝑑,𝑒, and 𝑓.
 *  A constructor with the arguments for 𝑎, 𝑏, 𝑐, 𝑑,𝑒, and 𝑓.
 *  Six getter methods for 𝑎, 𝑏, 𝑐, 𝑑,𝑒, and 𝑓.
 *  A method 𝑖𝑠𝑆𝑜𝑙𝑣𝑎𝑏𝑙𝑒() that returns true if 𝑎𝑑 – 𝑏𝑐 is not 0.
 *  Method 𝑔𝑒𝑡𝑋() and 𝑔𝑒𝑡𝑌() that returns the solution for the equation.
 * Write a test program that prompts the user to enter a, b, c, d, e, and f and display the result. If
 * 𝑎𝑑 – 𝑏𝑐 is 0, report that “The equation has no solution.”
 * Here is a sample run:
 * Enter a, b, c, d, e, f: 9.0 4.0 3.0 -5.0 -6.0 -21.0
 * X is -2.0 and y is 3.0
 * Enter a, b, c, d, e, f: 1.0 2.0 2.0 4.0 4.0 5.0
 * The equation has no solutions.
 */
public class LinearEquation {
    private double a, b, c, d, e, f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, f: ");
        double[] vars = new double[6];
        for (int i = 0; i < vars.length; i++) {
            vars[i] = input.nextDouble();
        }
        LinearEquation testing = new LinearEquation(vars[0], vars[1], vars[2], vars[3], vars[4], vars[5]);
        System.out.println(((testing.isSolvable()) ? "X is " + testing.getX() + " and y is " + testing.getY() : "The " +
                "equation" + " has no " + "solutions"));
    }

    public boolean isSolvable() {
        return ((a * d - b * c) != 0 ? true : false);
    }

    public double getX() {
        return ((e * d - b * f) / (a * d - b * c));
    }

    public double getY() {
        return ((a * f - e * c) / (a * d - b * c));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }
}
