import java.util.Scanner;

//Edward Buckler
//111628438
//L05
/*
Write down a sort method to sort an array of String using bubble-sort algorithm. Bubble sort
algorithm makes several passes through the array. On each pass, successive neighboring pairs
are compared. If a pair is not in order, its values are swapped; otherwise the value remains
unchanged. The technique is called bubble sort or sinking sort because the smaller values
gradually “bubble” their way to the top, and the larger values “sink” to the bottom.
Write a test program that reads in 10 String values and invokes the bubble sort method. Display
the sorted string array.
*/

public class SortStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 strings: ");
        String line = input.nextLine();
        String[] listString = line.split(",");

    }

    public static String printArrayInt(int[] array) {
        String out = "";
        for (int intElement : array) {
            out += intElement + ", ";
        }
        out = out.substring(0, out.length() - 2);
        return out;
    }

    public static String[] bubbleSortArray(String[] array) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1].compareToIgnoreCase(array[i]) < 0) {
                    done = false;
                    String temp = array[i];
                    array[i] = array[i - 1];
                    array[i-1] = temp;
                }
            }
        }
        return array;
    }
}

