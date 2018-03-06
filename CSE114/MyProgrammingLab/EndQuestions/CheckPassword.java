

/*
6-18) (Check password) Some websites impose certain rules for passwords. Write a method that checks whether a string is
a valid password. Suppose the password rules are as follows:

A password must have at least eight characters.
A password consists of only letters and digits.
A password must contain at least two digits.

Write a program that prompts the user to enter a password and displays Valid Password if the rules are followed or
Invalid Password otherwise.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        System.out.print("Enter a password:");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        boolean acceptablePassword = true;
        int num = 0, other = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                num++;
            else if (!(Character.isAlphabetic(password.charAt(i)))) {
                acceptablePassword = false;
                break;
            }
        }
        if (!(password.length() >= 8) || num < 2)
            acceptablePassword = false;

        System.out.println((acceptablePassword) ? "Valid Password" : "Invalid Password");
    }
}
