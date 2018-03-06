/*
(Sort three numbers) Write a method with the following header to display three
numbers in increasing order (one blank space between numbers):


public static void displaySortedNumbers(double num1, double num2, double num3)


Add a main method to the class that prompts for three numbers that are sent to the displaySortedNumbers
method
 */

import java.util.Arrays;
import java.util.Scanner;

public class SortedNumbers {
    public static void main(String[] args) {
        System.out.print("Enter the three numbers: ");
        Scanner input = new Scanner(System.in);
        getDisplaySortedNumbers(input.nextDouble(), input.nextDouble(), input.nextDouble());
    }

    public static void getDisplaySortedNumbers(double num1, double num2, double num3) {
        double[] numList = {num1, num2, num3};
        Arrays.sort(numList);
        System.out.println(numList[0] + " " + numList[1] + " " + numList[2]);
    }
}
