import java.util.Arrays;

public class Tester {
    public static void main(String args[]) {
        int[][] a2d = new int[1][1];
        boolean isNegative = false;
        int sum = 0;

        for (int i = 0; i < a2d.length; i++) {
            for (int j = 0; j < a2d[i].length; j++) {
                sum += a2d[i][j];
            }
        }

    }
}
