import java.util.Scanner;

public class BestStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students:");
        int n = input.nextInt();
        int max = 0;
        String maxName = "";
        for (int i = 1; i <= n; i++) {
            System.out.println("Student "+i+" of "+n);

            System.out.print("Enter student's name:");
            input.nextLine();
            String currentName = input.nextLine();

            System.out.print("Enter student's score:");
            int currentGrade = input.nextInt();

            if (currentGrade > max){
                max = currentGrade;
                maxName = currentName;
            }
        }
        System.out.print("The highest score was "+max+" and "+maxName+" got it");
    }
}
