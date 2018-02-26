import java.util.Scanner;
import java.text.DecimalFormat;

public class AvgWithLoop {
    public static void main(String[] args) {
        System.out.print("Enter an integer, the input ends if it is 0:");
        Scanner input = new Scanner(System.in);
        int numPos, numNeg;
        double total, average;
        numNeg = numPos = 0;
        total = average = 0.0;
        int currentNum = input.nextInt();
        while (currentNum != 0) {
            if (currentNum > 0)
                numPos++;
            if (currentNum < 0)
                numNeg++;
            total += currentNum;
            average++;
            currentNum = input.nextInt();
        }
        average = total/average;
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println("The number of positives is " + numPos);
        System.out.println("The number of negatives is " + numNeg);
        System.out.println("The total is " + total);
        System.out.println("The average is " + f.format(average));
    }
}
