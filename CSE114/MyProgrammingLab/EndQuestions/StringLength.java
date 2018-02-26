import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {
        System.out.print("Enter a string:");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        System.out.print("The string is of length "+word.length() +" and the first character is "+word.charAt(word.length()-1));

    }
}
