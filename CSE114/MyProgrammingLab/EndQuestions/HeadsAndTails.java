//Edward Buckler
//111628438
//L05
/*
Nine coins are placed in a 3x3 matrix with some face up and some face down. You can represent the state of the coins
using a 3x3 matrix with values 0 (heads) and 1 (tails). Here are some examples:

0 0 0 1 0 1 1 1 0
0 1 0 0 0 1 1 0 0
0 0 0 1 0 0 0 0 1

Each state can also be represented using a binary number. For example, the preceding matrices correspond to the numbers:

000010000 101001100 110100001

There are a total of 512 possibilities, so you can use decimal numbers 0, 1, 2, 3,...,511 to represent all the states
of the matrix.

Write a program that prompts the user to enter a number between 0 and 511 and displays the corresponding matrix with
the characters H and T.
*/

import java.util.Scanner;

public class HeadsAndTails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer representing the state of the coins:");
        int num = input.nextInt();
        String binary = Integer.toBinaryString(num);
        binary = ("000000000" + binary).substring(binary.length());
        for (int i = 0, count = 1; i < binary.length(); i++, count++) {
            if (binary.charAt(i) == '0' && count != 3) {
                System.out.print("H ");
            } else if (binary.charAt(i) == '0') {
                System.out.print("H");
            } else if (count != 3) {
                System.out.print("T ");
            } else {
                System.out.print("T");
            }
            if (count == 3) {
                count = 0;
                System.out.print("\n");
            }
        }
    }
}
