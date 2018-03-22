import java.util.Scanner;

public class MarkovMatrixTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row:");
        double[][] arrIn = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double inputVal = input.nextDouble();
                arrIn[i][j] = inputVal;
            }
        }
        System.out.println((isMarkovMatrix(arrIn)) ? "It is a Markov matrix":"It is not a Markov matrix");
    }

    public static boolean isMarkovMatrix(double[][] m) {

        for (int i = 0; i < 3; i++) {
            double count = 0;
            for (int j = 0; j < 3; j++) {
                count += m[j][i];
            }
            if (count != 1) {
                return false;
            }
        }
        return true;
    }
}
