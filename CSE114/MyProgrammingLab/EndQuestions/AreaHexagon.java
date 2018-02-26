import java.util.Scanner;

public class AreaHexagon {
    public static void main(String[] args) {
        System.out.println("Enter the side:");
        Scanner input = new Scanner(System.in);
        double num = input.nextDouble();
        System.out.println("The area of the hexagon is "+(6*Math.pow(num, 2))/(4*Math.tan(Math.PI/6)));
    }
}

