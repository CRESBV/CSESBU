//Edward Buckler
// 111628438
// L05

import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        System.out.println("Enter the value of n: ");
        Scanner input = new Scanner(System.in);
        int intIn = input.nextInt();
        starsTriangle(intIn);
        input.close();
    }

    public static void starsTriangle(int num) {
        int startSpace = (num / 2)+1;
        System.out.println("startSpace = " + startSpace);
        for (int i = 0; i < num; i++) {
            String line = "";
            for (int j = startSpace; j >= 0; j--)
                line += " ";
            for (int j = 0; j <= i; j++)
                line += "* ";
            startSpace--;
            System.out.println(line);
        }
    }
}




