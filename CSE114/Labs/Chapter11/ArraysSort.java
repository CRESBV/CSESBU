/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the following method that sorts an ArrayList of numbers:
 * public static void sort(ArrayList<Integer> list)
 * Write a test program that prompts the user to enter five numbers, stores them in an array list and displays
 * them in increasing order.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArraysSort {
    public static void sort(ArrayList<Integer> list) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 1; i < list.size(); i++) {
                if ((list.get(i-1)) > ((list.get(i)))) {
                    done = false;
                    int temp = list.get(i);
                    list.set(i, list.get(i-1));
                    list.set(i-1, temp);
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input 5 nums:");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }
        sort(list);
    }
}
