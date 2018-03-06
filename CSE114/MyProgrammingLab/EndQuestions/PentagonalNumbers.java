import java.util.Scanner;

/*6-1) (Math: pentagonal numbers) A pentagonal number is defined as n(3n–1)/2 for n = 1, 2, . . ., and so on. Therefore, the first few numbers are 1, 5, 12, 22, . . . . Write a method with the following header that returns a pentagonal number:

public static int getPentagonalNumber(int n)

Write a test program that uses this method to display the first n pentagonal
numbers with 10 numbers on each line, one space between each number, and the user entering the integer value for n.*/

public class PentagonalNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer for the n pentagonal numbers you want displayed:");
        int num = input.nextInt();
        int counter = 1;
        for (int i = 1; i <= num; i++) {
            System.out.print(getPentagonalNumber(i) + " ");

            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
            counter++;
        }
    }

    public static int getPentagonalNumber(int n) {
        int out = n * (3 * n - 1) / 2;
        return out;
    }
}
