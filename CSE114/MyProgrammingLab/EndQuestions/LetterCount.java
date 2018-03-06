import java.util.Scanner;

/*
6-20) (Count the letters in a string) Write a method that counts the number of letters in a string using the following
header:

public static int countLetters(String s)
Write a test program that prompts the user to enter a string and displays the number of letters in the string, not
counting numbers, spaces, or symbols.
 */
public class LetterCount {
    public static void main(String[] args) {
        System.out.print("Enter a string of letter, numbers, spaces, and symbols:");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        System.out.println("The number of letters in the string is: "+ countLetters(line));
    }

    public static int countLetters(String line) {
        int out = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isAlphabetic(line.charAt(i))) {
                out++;
            }
        }
        return out;
    }
}
