//Edward Buckler
//111628438
//L05
import java.util.Scanner;

public class FactorialInput {
    public static void main(String[] args) {
        System.out.print("Enter a positive integer: ");
        Scanner input = new Scanner(System.in);
        /*Factorials should be done with longs, and sometimes need to be done with ln and addition*/
        int factor = input.nextInt();
        int out = 1;
        for (int i = 2; i <= factor; i++) {
            out *= i;
        }
        System.out.println("Testing is : " + out);
    }
}
