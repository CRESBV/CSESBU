import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class that checks if the contents of two text files are identical and, if not, determine
 * how many lines are different. Lines are different if they differ in one or more characters. Test
 * your class with a client program.
 */
public class FileTester {
    public static int lineDiffTest(String f1Name, String f2Name) {
        File file1 = new File(f1Name);
        File file2 = new File(f2Name);
        int out = 0;
        try {
            if (file1.createNewFile()) {
                System.out.println(f1Name + " created");
            }
            if (file2.createNewFile()) {
                System.out.println(f2Name + " created");
            }
            Scanner scanner1 = new Scanner(file1), scanner2 = new Scanner(file2);

            while (scanner1.hasNextLine() || scanner2.hasNextLine()) {
                try {
                    if (!scanner1.nextLine().equals(scanner2.nextLine())) {
                        out++;
                    }
                } catch (NoSuchElementException ns) {
                    out++;
                }

            }
        } catch (IOException ioex) {
            System.out.println("Problemo in ze IO");
        }

        return out;
    }
}

class DriverFileTester {
    public static void main(String[] args) {
        System.out.println(FileTester.lineDiffTest("f1.txt", "f2.txt"));
    }
}