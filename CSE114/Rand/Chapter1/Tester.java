import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int total;


        int timeSheets;
        int wage = 0;
        int hours;
        total = 0;
        timeSheets = stdin.nextInt();
        for (int i = 1; i <= timeSheets; i++) {
            hours = 0;
            wage = stdin.nextInt();
            for (int j = 1; j <= 5; j++)
                hours = hours + stdin.nextInt();
            total = total + (hours * wage);
        }


    }
}
