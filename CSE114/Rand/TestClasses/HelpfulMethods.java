import java.util.*;

public class HelpfulMethods {
    public static int[] createArray() {
        Scanner stdin = new Scanner(System.in);
        int len = stdin.nextInt();
        int[] out = new int[len];
        for (int i = 0; i < len; i++) {
            out[i] = stdin.nextInt();
        }
        return out;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
