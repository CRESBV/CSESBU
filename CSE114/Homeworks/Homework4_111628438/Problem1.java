import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a program to create a file named integerFile.txt if it does not exist. Write 100 integers
 * created randomly into the file using text I/O. The random integers should be in the range 0 to
 * 100 (including 0 and 100). Integers should be separated by spaces in the file. Read the data
 * back from the file and display the data in increasing order.
 */
public class Problem1 {
    public static void main(String[] args) {
        File fileInt = new File("integerFile.txt");

        try {
            if (fileInt.createNewFile()) {
                System.out.println("file created");
            }
            FileWriter fileWriterInt = new FileWriter(fileInt);
            PrintWriter printWriterInt = new PrintWriter(fileWriterInt);
            for (int i = 0; i < 100; i++) {
                printWriterInt.print((int) (Math.random() * 101) + " ");
            }
            printWriterInt.flush();

            Scanner scannerFileInt = new Scanner(fileInt);
            int[] out = new int[100];
            int i = 0;
            while (scannerFileInt.hasNextInt()) {
                out[i] = scannerFileInt.nextInt();
                i++;
            }
            Arrays.sort(out);
            System.out.println(Arrays.toString(out));

        } catch (IOException ioex) {
            System.out.println("We done messed up!");
        }

    }
}
