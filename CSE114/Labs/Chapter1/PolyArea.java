//Edward Buckler
// 111628438
// L05
import java.util.Scanner;

public class PolyArea {
    public static void main(String[] args) {
        System.out.println("Enter the number of sides : ");
        Scanner input1 = new Scanner(System.in);
        int numSide = input1.nextInt();
        System.out.println("Enter the side : ");
        Scanner input2 = new Scanner(System.in);
        double numLength = input2.nextDouble();
        System.out.println("The area of the polygon is "+((numSide * Math.pow(numLength, 2))/(4*Math.tan(Math.PI/numSide))));
    }
}
