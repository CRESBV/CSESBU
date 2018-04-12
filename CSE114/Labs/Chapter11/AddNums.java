import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a program that prompts the user to read two integers and displays their sum. Your
 * program should prompt the user to read the number again if the input is incorrect. (Hint: Use
 * InputMismatchException).
 */
public class AddNums {
    public static void main(String[] args) {
        boolean done = false, doneInt = false;
        int num1 = 0, num2 = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            doneInt = false;
            while (!doneInt) {
                try {
                    System.out.print("Enter int num1 to be added:");
                    num1 = input.nextInt();
                    System.out.print("Enter int num2 to be added:");
                    num2 = input.nextInt();
                    doneInt = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Incorrect input!");
                    input.nextLine();
                }
            }
                System.out.println("num1 + num2 = " + (num1 + num2));
        }
    }

}
