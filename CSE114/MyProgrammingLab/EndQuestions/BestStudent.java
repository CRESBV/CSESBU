
import java.util.Scanner;

public class BestStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students:");
        int n = input.nextInt();
        double max = 0;
        String maxName = "";
        double second = 0;
        String secondName = "";

        for (int i = 1; i <= n; i++) {
            System.out.println("Student "+i+" of "+n);

            System.out.print("Enter student's name:");
            input.nextLine();
            String currentName = input.nextLine();

            System.out.print("Enter student's score:");
            int currentGrade = input.nextInt();

            if (currentGrade > max){
                second = max;
                secondName = maxName;
                max = currentGrade;
                maxName = currentName;
            } else if (currentGrade > second) {
                second = currentGrade;
                secondName = currentName;
            }
        }
        System.out.println("The highest score was " + String.format("%.2f", max) + " and " + maxName + " got it");
        System.out.println("The second highest score was " + String.format("%.2f",second) + " and " + secondName + " got it");
    }
}
