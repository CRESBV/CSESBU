//Edward Buckler
//111628438
//L05
/*
Write a method that sums all the numbers in the major diagonal in an n x n matrix of double values using the following
header:

public static double sumMajorDiagonal(double[][] m)

Write a test program that first prompts the user to enter the dimension n of an n x n matrix, then asks them to enter
the matrix row by row (with the elements separated by spaces). The program should then prdouble out the sum of the major
diagonal of the matrix.
*/

import java.util.Scanner;

public class SumMajorDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter dimension n of nxn matrix:");
        int n = input.nextInt();
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter row " + i + ":");
            arr[i] = setRow(n);
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }
        System.out.print(sum);
    }

    public static double[] setRow(int n) {
        double[] out = new double[n];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            out[i] = input.nextDouble();
        }
        return out;
    }
}
