//Edward Buckler
//111628438
//L05
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class MeanAndSD {
    public static void main(String[] args) {
        System.out.println("Enter 10 numbers :");
        Scanner input = new Scanner(System.in);
        double[] numslist = new double[10];
        for (int i = 0; i < 10; i++) {
            numslist[i] = input.nextDouble();
        }
        System.out.printf("The mean is %.2f \n",mean(numslist));
        System.out.printf("The standard deviation is %.5f",deviation(numslist));
    }
    public static double deviation(double[] x){
        double mean = mean(x);
        double out = 0;
        for (int i = 0; i < x.length; i++) {
            out += Math.pow(x[i] - mean, 2);
            //I have tested recently, but it used to be faster to multiply the two numbers, rather than call
            //the power function for squares or cubes.
        }
        out = Math.pow(out / (x.length - 1), 0.5);
        return out;
    }
    public static double mean(double[] x){
        double mean = DoubleStream.of(x).sum()/x.length;
        /*This is also an alternative
        DoubleStream.of(x).summaryStatistics().getAverage();
         */
        return mean;
    }
}
