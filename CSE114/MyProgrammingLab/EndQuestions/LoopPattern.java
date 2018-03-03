import java.util.Scanner;

public class LoopPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to be a limit of the pattern:");
        int num = input.nextInt();

        System.out.println("Pattern A:");
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern B:");
        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern C:");
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= (num - i); j++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Pattern D:");
        for (int i = 0; i < num; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= num - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}