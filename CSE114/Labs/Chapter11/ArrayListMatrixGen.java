import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a program that randomly fills in 0s and 1s into an n - by - n matrix, prints the matrix, and
 * finds the rows and columns with the most 1s. (Hint: Use two ArrayLists to store the row and
 * column indices with the most 1s).
 * Here is a sample run of the program:
 * Enter the array size n : 4
 * The random array is
 * 0 0 1 1
 * 0 0 1 1
 * 1 1 0 1
 * 1 0 1 0
 * The largest row index: 2
 * The largest column index: 2, 3
 */
public class ArrayListMatrixGen {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = input.nextInt();

        //Instantiating
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }

        //Creating
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                list.get(i).add((int) (Math.random() * 2));
            }
        }

        //column
        ArrayList<Integer> columnIndex = new ArrayList<>();
        int colVal = 0;
        for (int i = 0; i < size; i++) {
            int temp = 0;
            for (int j = 0; j < size; j++) {
                temp += list.get(i).get(j);
            }
            if (temp > colVal) {
                columnIndex.clear();
                colVal = temp;
                columnIndex.add(i);
            } else if (temp == colVal) {
                columnIndex.add(i);
            }
        }

        //row
        ArrayList<Integer> rowIndex = new ArrayList<>();
        int rowVal = 0;
        for (int i = 0; i < size; i++) {
            int temp = 0;
            for (int j = 0; j < size; j++) {
                temp += list.get(j).get(i);
            }
            if (temp > rowVal) {
                rowIndex.clear();
                rowVal = temp;
                rowIndex.add(i);
            } else if (temp == rowVal) {
                rowIndex.add(i);
            }
        }

        //Printing
        for (int i = 0; i < size; i++) {
            System.out.println(printArrayInt(list.get(i)));
        }

        System.out.println("The largest row index: "+columnIndex+"\n" +
                "The largest column index: "+rowIndex);
    }

    public static String printArrayInt(ArrayList<Integer> array) {
        String out = "";
        for (int i = 0; i < array.size(); i++) {
            out += array.get(i)+" ";
        }
        return out;
    }
}
