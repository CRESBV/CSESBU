import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Using recursion, write a program that takes a word as an input and outputs that word
 * backward (reverse). As an example if the input is the string “recursion” then the output of the
 * program should be “noisrucer” .
 */
public class Q3 {
    public static String stringReverser(String input) {
        if (input.length() <= 1) {
            return input;
        } else {
            return stringReverser(input.substring(1)) + input.charAt(0);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input String:");
        String testString = input.nextLine();
        System.out.println("Reversed String: " + stringReverser(testString));
        input.close();
    }
}
