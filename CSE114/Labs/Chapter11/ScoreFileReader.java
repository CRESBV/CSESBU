import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Suppose a text file contains an unspecified number of scores separated by spaces. Write a
 * program that prompts the user to enter the file, read the scores from the file, and display their
 * total and average.
 */
public class ScoreFileReader {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        ArrayList<Double> listOfScores = new ArrayList<>();
        while (!done) {
            try {
                System.out.print("Enter file Path:");
                File filePath = new File(input.next());
                Scanner reader = new Scanner(filePath);
                while (reader.hasNext()) {
                    if (reader.hasNextDouble()) {
                        listOfScores.add(reader.nextDouble());
                    } else {
                        reader.next();
                    }
                }
                done = true;
            } catch (IOException ioex) {
                System.out.println("Incorrect Input");
            }
        }
        double sum = 0;
        for (int i = 0; i < listOfScores.size(); i++) {
            sum += listOfScores.get(i);
        }
        System.out.println("Total: " + sum);
        System.out.println("Average: " + sum / listOfScores.size());
        input.close();
    }
}
