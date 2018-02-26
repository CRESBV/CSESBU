//Edward Buckler
//111628438
//L05
import java.util.Scanner;

public class LetterTest {
    public static void main(String[] args) {
        System.out.println("Enter a letter : ");
        Scanner input = new Scanner(System.in);
        char letter = input.next().charAt(0);
        if (Character.isLetter(letter)) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' ||
                    letter == 'u' || letter == 'y' || letter == 'A' || letter == 'E' ||
                    letter == 'I' || letter == 'O' || letter == 'U' || letter == 'Y') {
                System.out.println(letter + "is a vowel");
            }
            else {
                System.out.println(letter + "is a consonant");
            }
        } else {
            System.out.println(letter + "is an invalid input");
        }
        input.close();
    }
}
