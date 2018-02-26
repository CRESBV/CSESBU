//Edward Buckler
//111628438
//L05
import java.util.Scanner;

public class TriangleLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] sideLengths = new double[3];
        System.out.println("Please enter side length 1, 2, and 3 clicking enter after each:");
        for (int i = 0; i < sideLengths.length; i++) {
            sideLengths[i] = input.nextDouble();
        }
        if (sideLengths[2] <= sideLengths[0] + sideLengths[1] && sideLengths[1] <= sideLengths[0] + sideLengths[2] &&
                sideLengths[0] <= sideLengths[2] + sideLengths[1]) {
            System.out.println("input valid, and perimeter is: "+(sideLengths[0] + sideLengths[1] + sideLengths[2]));
        } else {
            System.out.println("input invalid");
        }
    }
}

