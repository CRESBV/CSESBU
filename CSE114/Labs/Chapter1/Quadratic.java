//Edward Buckler
//111628438
//L05
import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[3];
        System.out.println("Please enter number doubles a, b, and c clicking enter after each:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }
        double discriminant = (Math.pow(numbers[1], 2) - (4 * numbers[0] * numbers[2]));
        double r1 = (-numbers[1] + Math.pow(discriminant, 0.5)) / (2 * numbers[0]);
        double r2 = (-numbers[1] - Math.pow(discriminant, 0.5)) / (2 * numbers[0]);
        if (discriminant > 0) {
            System.out.println("The roots are: " + r1 + " and " + r2);
        } else if (discriminant == 0) {
            System.out.println("The root is: " + r1);
        } else {
            System.out.println("There are no roots");
        }
    input.close();
    }
}

