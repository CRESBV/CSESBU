//Edward Buckler
//111628438
//L05
import java.util.Scanner;

public class ShippingCost {
    public static void main(String[] args) {
        System.out.println("input weight of package");
        Scanner input = new Scanner(System.in);
        double weight = input.nextDouble();
        if (weight <= 0) {
            System.out.println("Invalid input");
        } else if (weight <= 1) {
            System.out.println("cost = $" + 3.5);
        } else if (weight <= 3) {
            System.out.println("cost = $" + 5.5);
        } else if (weight <= 10) {
            System.out.println("cost = $" + 8.5);
        } else if (weight <= 20) {
            System.out.println("cost = $" + 10.5);
        } else {
            System.out.println("The package cannot be shipped.");
        }
    }
}
