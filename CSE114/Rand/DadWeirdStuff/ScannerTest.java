import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            if(scan.hasNextInt()) {
                System.out.println("int:"+scan.nextInt());
            } else break;
        }

        System.out.println("Moved on not an int");
    }
}
