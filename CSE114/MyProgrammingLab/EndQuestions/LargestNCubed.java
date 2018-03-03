import java.util.Scanner;

public class LargestNCubed {
    public static void main(String[] args) {
        System.out.println("Enter an integer:");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int n;
        for (n = 0; n < num; n++) {
            if (Math.pow(n, 3) > num) {
                break;
            }
        }
        n--;
        System.out.println("The largest n such that n^3 is less then " + num + " is " + n);
    }
}
