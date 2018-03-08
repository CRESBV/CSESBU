//Edward Buckler
//111628438
//L05
/*
Write a method that checks whether the input string or a sentence (a string with spaces) is a
palindrome or not. The method should be case insensitive and should ignore spaces. Write a
test program that prompts the user to input a string and invokes this method
 */
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String inputString = input.nextLine();
        System.out.println((testIfPalindrome(inputString)) ? "Input string " + inputString + " is a palindrome" : "Input string " +
                inputString + " is NOT a palindrome");
    }

    public static boolean testIfPalindrome(String inputString) {
        boolean out = true;
        inputString = inputString.toLowerCase();
        String reversedInputString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversedInputString += inputString.charAt(i);
        }
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != reversedInputString.charAt(i)) {
                out = false;
                break;
            }
        }
        return out;
    }
}
