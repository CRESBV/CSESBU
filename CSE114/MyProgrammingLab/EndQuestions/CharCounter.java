/*
(Occurrences of a specified character) Write a method that finds the number of
occurrences of a specified character in a string using the following header:
public static int count(String str, char a)

Add a main method to the class that tests the method by prompting for a string and a character,
invoking the method and printing the returned count.
 */

import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.print("Enter a character: ");
        char a = input.next().charAt(0);
        System.out.println(a+" occurs "+count(str, a)+" times in the string");
    }

    public static int count(String str, char a) {
        int out = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                out++;
            }
        }
        return out;
    }
}
