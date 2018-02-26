import java.util.Scanner;

public class InsideTheTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point's x- and y-coordinates:");
        int xChord = input.nextInt();
        int yChord = input.nextInt();
        if (xChord >= 0 && yChord >= 0 && yChord <= 100 + ((-0.5)*xChord))
            System.out.println(" The point is in the triangle");
        else
            System.out.println(" The point is not in the triangle");
    }
}