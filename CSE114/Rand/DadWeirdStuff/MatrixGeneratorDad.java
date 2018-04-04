import java.util.Random;

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
public class MatrixGeneratorDad {

    public static void main(String[] args) {
        int[][] ara = new int[4][4];
        Random r=new Random();
        for (int i = 0; i < ara.length; i++) {
            for (int j = 0; j < ara[0].length; j++) {
                ara[i][j] = r.nextInt(2);
            }
        }
        for (int[] temp : ara) {
            System.out.println(printArrayInt(temp));
        }
        System.out.println("The largest row index: " + indexOfMaxVector(ara,true));
        System.out.println("The largest column index: " + indexOfMaxVector(ara,false));
    }

    private static int indexOfMaxVector(int[][] ara, boolean isRow) {
        int maxIndex=0;
        int maxSum=0;
        for (int i = 0; i < (isRow?ara.length:ara[0].length); i++) {
            int sum=0;
            for (int j = 0; j < (isRow?ara[0].length:ara.length); j++) {
                sum+=(isRow?ara[i][j]:ara[j][i]);
            }
            if(sum>maxSum) {maxIndex=i; maxSum=sum;}
        }
        return maxIndex;
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
