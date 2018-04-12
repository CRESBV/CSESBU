import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Creates an array with 100 randomly chosen integers in the range of 1 to 100 (including
 * 1 and 100).
 * Prompts the user to enter the index of the array, then displays the corresponding
 * elements value. If the specified index is out of bounds, display the message “Out of
 * Bounds”.
 * (Hint: Use ArrayIndexOutOfBoundsException)
 */
public class HundredRand {
    public static void main(String[] args) {
        int[] list = new int[100];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100 + 1);
        }
        try {
            System.out.print("enter the index of the array");
            int temp = input.nextInt();
            System.out.println(list[temp]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds");
        }
    }
}
