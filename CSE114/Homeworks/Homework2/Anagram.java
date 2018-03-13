//Edward Buckler
//111628438
//L05
/*
Two strings are anagrams if they are written using the same exact letters. Write a method to
check if given two strings are anagrams or not. You have to ignore the case and space
characters. Write a test program for that prompts the user to input two strings and invokes this
method.
*/

/*
adlt - com added live templates abbreviations + descriptions
arrst - array to string method
bbsa - bubble sort array method
inpt - makes a Scanner with var name input
name - Puts in name, id, and lab
pis - Private Static
pus - Public Static
sou - prints a string to System out w/o ln
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
        System.out.println((testIfAnagram(wordOne, wordTwo) ? wordOne + " and " + wordTwo + " are anagrams" : wordOne +
                " and " + wordTwo + " are NOT anagrams"));
    }

    private static boolean testIfAnagram(String wordOne, String wordTwo) {
        wordOne = wordOne.toLowerCase();
        wordTwo = wordTwo.toLowerCase();
        char[] w1 = wordOne.toCharArray();
        char[] w2 = wordTwo.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1, w2);
    }



}
