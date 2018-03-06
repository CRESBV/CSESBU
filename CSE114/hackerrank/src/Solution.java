import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String n = "bob";
        String b = "asdf";
        b = n;
        n = "chicken";
        System.out.println("b = " + b);
        System.out.println("n = " + n);
    }

    public void powerTo(double a, double b, double c) {
        if (b * b - 4 * a * c < 0) {
            System.out.println("no real solutions");
        }
    }
}
