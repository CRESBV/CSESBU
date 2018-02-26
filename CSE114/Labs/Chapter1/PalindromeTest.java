//Edward Buckler
// 111628438
// L05

import java.util.Scanner;

public class PalindromeTest {
    public static void main(String[] args) {
        System.out.println("enter a three digit (positive) integer: ");
        Scanner input = new Scanner(System.in);
        String val = input.nextLine();
        String posVal;
        if(val.charAt(0) == '-')
            posVal = val.substring(1);
        else
            posVal = val;
        if (posVal.charAt(0) == posVal.charAt(2) && posVal.length() < 4 && Character.isDigit(posVal.charAt(0)) &&
                Character.isDigit(posVal.charAt(1)) && Character.isDigit(posVal.charAt(2)) && posVal.length() > 2) {
            System.out.println(val + " is a palindrome ");
        } else {
            System.out.println(val + " is not a palindrome or is not a digit or is longer than 3 digits");
        }
        input.close();
    }
}
