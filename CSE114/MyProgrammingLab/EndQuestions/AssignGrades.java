//Edward Buckler
//111628438
//L05
/*
(Assign grades) Write a program that reads student scores, gets the best score, and then assigns grades based on the
following scheme:

Grade is A if score is >= best - 10
Grade is B if score is >= best - 20;
Grade is C if score is >= best - 30;
Grade is D if score is >= best - 40;
Grade is F otherwise.

The program prompts the user to enter the total number of students, then prompts the user to enter all of the scores as
whole numbers (i.e. integers), and concludes by displaying the integer scores and the corresponding grades.
*/
import java.util.Scanner;

public class AssignGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        System.out.print("Enter " + numStudents + " scores: ");
        int[] grades = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            grades[i] = input.nextInt();
        }
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student "+ i + " score is "+ grades[i] + " and grade is "+giveGrade(grades, i));
        }

    }

    public static char giveGrade(int[] arr, int element) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        if (arr[element] >= max - 10) {
            return 'A';
        }
        else if (arr[element] >= max - 20) {
            return 'B';
        }
        else if (arr[element] >= max - 30) {
            return 'C';
        }
        else if (arr[element] >= max - 40) {
            return 'D';
        }
        else {
            return 'F';
        }
    }

}
