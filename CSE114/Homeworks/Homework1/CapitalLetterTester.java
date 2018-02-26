//Edward Buckler
//111628438
//L05

import java.util.Scanner;

public class CapitalLetterTester {
    public static void main(String[] args) {
        System.out.println("Enter a string :");
        Scanner input = new Scanner(System.in);
        String inputtedString = input.nextLine();
        int UpperCase = 0;
        for (int i = 0; i < inputtedString.length(); i++){
            char currentChar = inputtedString.charAt(i);
            if(Character.isUpperCase(currentChar)){
                UpperCase++;
            }
        }
        System.out.println("The number of uppercase letters is "+UpperCase);
        input.close();
    }
}
