//Edward Buckler
//111628438
//L05
/*
Write a method that sums all the numbers in the major diagonal in an n x n matrix of double values using the following
header:

public static double sumMajorDiagonalLab(double[][] m)

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
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextDouble();
            }
        }
        System.out.print(sumMajorDiagonal(arr));
    }

    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }

}
