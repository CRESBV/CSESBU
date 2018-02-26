import java.util.Scanner;

public class FeetToMeters {
    public static void main(String[] args) {
        System.out.print("Enter a value for feet: ");
        Scanner input = new Scanner(System.in);
        double num = input.nextDouble();
        System.out.println(num+" feet is "+num*(.305)+" meters");
    }
}
