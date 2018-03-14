//Edward Buckler
//111628438
//L05
import java.util.Scanner;
public class AverageAcceleration {
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[3];
        System.out.println("Please enter number doubles v0, v1, and t clicking enter after each:");
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = input.nextDouble();
        }
        double out = (numbers[1]-numbers[0])/numbers[2];
        System.out.println("The average acceleration is: "+out);
    }

}
