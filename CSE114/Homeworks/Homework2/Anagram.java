//Edward Buckler
//111628438
//L05
/*
Two strings are anagrams if they are written using the same exact letters. Write a method to
check if given two strings are anagrams or not. You have to ignore the case and space
characters. Write a test program for that prompts the user to input two strings and invokes this
method.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String wordOne = input.nextLine();
        System.out.print("Enter the second string: ");
        String wordTwo = input.nextLine();
        System.out.println((testIfAnagram2(wordOne, wordTwo) ? wordOne + " and " + wordTwo + " are anagrams" : wordOne +
                " and " + wordTwo + " are NOT anagrams"));
    }

    private static boolean testIfAnagram(String wordOne, String wordTwo) {
        wordOne = wordOne.toLowerCase();
        wordTwo = wordTwo.toLowerCase();
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }
        for (int i = 0; i < wordOne.length(); i++) {
            if (wordOne.charAt(i) != wordTwo.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean testIfAnagram2(String wordOne, String wordTwo) {
        //chars() starts an intStream of the characters, it is sorted, and then converted to int array
        int[] val1=wordOne.toLowerCase().chars().sorted().toArray();
        int[] val2=wordTwo.toLowerCase().chars().sorted().toArray();
        return Arrays.equals(val1,val2);
    }

}
