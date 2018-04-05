import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a method that returns an array list of Character from a string using the following header:
 * public static ArrayList<Character> toCharacterArray(String s)
 * For example toCharacterArray(“abc”) returns an array list that contains characters ‘a’, ‘b’ and ‘c’.
 * Write a test method that prompts the user to enter a String. Call the method toCharacterArray() on the
 * input string. Print the elements of the Character array list separated by exactly one space.
 * Here is a sample run:
 * Enter the input string: Stony Brook
 * Elements of the Character array list: S t o n y B r o o k
 */
public class ToCharArray {
    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> out = new ArrayList<>();
        for (char c : s.toCharArray()) {
            out.add(c);
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        ArrayList<Character> testing = toCharacterArray(input.nextLine());
        System.out.println("Elements of the Character array list: " + printArrayChar(testing));
    }

    public static String printArrayChar(ArrayList<Character> array) {
        String out = "";
        for (Character charElement : array) {
            out += charElement + " ";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }

}
