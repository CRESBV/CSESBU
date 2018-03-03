import java.util.Scanner;

public class LeapYears {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting year:");
        int startYear = input.nextInt();
        System.out.print("Enter the ending year:");
        int endYear = input.nextInt();
        int closestLeapYear = startYear;
        boolean leapYearSet = false;
        while (!leapYearSet) {
            leapYearSet = true;
            if (closestLeapYear % 4 != 0) {
                closestLeapYear++;
                leapYearSet = false;
            }
        }
        int counter = 0;
        int leapCounter = 0;
        for (int i = closestLeapYear; i <= endYear; i += 4) {
            System.out.print(i + " ");
            counter++;
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
            leapCounter++;
        }
        System.out.println();
        System.out.println("There were " + leapCounter + " leap years from " + startYear + " to " + endYear);
    }
}
