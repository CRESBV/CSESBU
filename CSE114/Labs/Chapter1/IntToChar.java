//Edward Buckler
// 111628438
// L05
import java.util.Scanner;

public class IntToChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please input a number between 0 and 127");
        int num = input.nextInt();
        if (num > 127 || num < 0) {
            throw new RuntimeException("Number is not between 0 and 127");
        } else {
            char letter = (char) num;
            System.out.println("The character for ASCII code " + num + " is " + letter);
        }
    }
}
