//Edward Buckler
//111628438
//L05

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        System.out.println("Enter a string :");
        Scanner input = new Scanner(System.in);
        String inputtedString = input.nextLine();
        int vowels = 0;
        int consonants = 0;
        for(int i = 0; i < inputtedString.length(); i++){
            char currentChar = inputtedString.charAt(i);
            if (Character.isLetter(currentChar)) {
                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' ||
                        currentChar == 'u' || currentChar == 'y' || currentChar == 'A' || currentChar == 'E' ||
                        currentChar == 'I' || currentChar == 'O' || currentChar == 'U' || currentChar == 'Y') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }

        }
        System.out.println("The number of vowels is "+vowels);
        System.out.println("The number of consonants is "+consonants);
        input.close();
    }
}
