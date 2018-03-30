import java.util.Arrays;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a program that randomly fills in 0𝑠 and 1𝑠 into a 4-by-4 matrix, prints the matrix, and
 * finds the first row and column with most 1𝑠.
 * Here is a sample run of the program:
 * 0011
 * 0011
 * 1101
 * 1010
 * The largest row index: 2
 * The largest column index: 2
 */
public class MatrixGenerator {
    public static void main(String[] args) {
        int[][] ara = new int[4][4];
        int[] largestCol = new int[4], largestRowInd = {0, 0}, largestColInd = {0, 0};
        for (int i = 0; i < 4; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                int num = (int) (Math.random() * 2);
                ara[i][j] = num;
                temp += num;
                largestCol[j] += num;
            }
            if (temp > largestRowInd[1]) {
                largestRowInd[0] = i;
                largestRowInd[1] = temp;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (largestCol[i] > largestColInd[1]) {
                largestColInd[0] = i;
                largestColInd[1] = largestCol[i];
            }
        }
        for (int[] temp : ara) {
            System.out.println(printArrayInt(temp));
        }
        System.out.println("The largest row index: " + largestRowInd[0]);
        System.out.println("The largest column index: " + largestColInd[0]);
    }

    public static String printArrayInt(int[] array) {
        String out = "";
        for (int intElement : array) {
            out += intElement + " ";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }
}
