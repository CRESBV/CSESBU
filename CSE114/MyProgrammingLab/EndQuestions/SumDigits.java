import java.util.Arrays;
import java.util.Scanner;

/*
6.2) (Sum the digits in an integer) Write a method that computes the sum of the digits in an integer. Use the
following method header:

public static int sumDigits(long n)

For example, sumDigits(234) returns 9 (2 + 3 + 4). (Hint: Use the % opera- tor to extract digits, and the / operator to
remove the extracted digit. For instance, to extract 4 from 234, use 234 % 10 (= 4). To remove 4 from 234,
use 234 / 10 (= 23). Use a loop to repeatedly extract and remove the digit until all the digits are extracted. Write a
test program that prompts the user to enter an integer and displays the sum of all its digits.
*/
public class SumDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer:");
        String num = input.nextLine();
        System.out.println("The sum of the digits in " + num + " is " + sumDigits(num));
    }

    public static int sumDigits(String string) {
        int[] list = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            list[i] = Character.getNumericValue(string.charAt(i));
        }
        int out = 0;
        for (int i = 0; i < list.length; i++) {
            out += list[i];
        }
        return out;
    }
}
