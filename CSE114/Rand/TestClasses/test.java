
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String args[]) {
        int[] output = {245004, 1324, 43, 23, 42354234, 123, 4323, 2314234, 542423423, 3243, 1};
        boolean done = false;
        while (!done){
            done = true;
            for (int i = 1; i < output.length; i++) {
                if (output[i-1] > output[i]){
                    int temp = output[i - 1];
                    output[i - 1] = output[i];
                    output[i] = temp;
                    done = false;
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }
}