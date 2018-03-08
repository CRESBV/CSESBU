//Edward Buckler
//111628438
//L05
/*
 Write a method to multiply two matrices. The header of the method is:
𝑝𝑢𝑏𝑙𝑖𝑐 𝑠𝑡𝑎𝑡𝑖𝑐 𝑑𝑜𝑢𝑏𝑙𝑒[][] 𝑚𝑢𝑙𝑡𝑖𝑝𝑙𝑦𝑀𝑎𝑡𝑟𝑖𝑥(𝑑𝑜𝑢𝑏𝑙𝑒 [][] 𝑎, 𝑑𝑜𝑢𝑏𝑙𝑒[][] 𝑏).
To multiply matrix 𝑎 by matrix 𝑏, the number of columns in 𝑎 must be the same as the number
of rows in 𝑏, and the two matrices must have elements of the same or compatible types. Let 𝑐
be the result of the multiplication. Assume the column size of matrix 𝑎 is 𝑛. Each element
𝑐𝑖𝑗 = 𝑎𝑖1 × 𝑏1𝑗 + 𝑎𝑖2 × 𝑏2𝑗 + ⋯ + 𝑎𝑖𝑛 × 𝑏𝑛𝑗 .

Write a test program that prompts the user to enter two 3 × 3 matrices and displays their
product.
*/

import java.util.Scanner;

public class MatrixMultiplier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter matrix1: ");
        System.out.println("Enter matrix2: ");

    }

    public static double[][] arrayFromInput(int length, int width) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        double[][] out = new double[length][width];
        for (int i = 0; i < length; i++) {
           //out[i] = input.nextDouble();
        }
        return out;
    }
}
