import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeLists {
    public static void main(String[] args) {
        System.out.print("Enter list1 size and contents: ");
        int[] arr1 = createArray();
        System.out.print("Enter list2 size and contents: ");
        int[] arr2 = createArray();
        System.out.print("List1 is: ");
        printArray(arr1);
        System.out.println();
        System.out.print("List2 is: ");
        printArray(arr2);
        System.out.println();
        int[] mergedArray = merge(arr1, arr2);
        System.out.print("The merged list is: ");
        printArray(mergedArray);

    }

    public static int[] createArray() {
        Scanner stdin = new Scanner(System.in);
        int len = stdin.nextInt();
        int[] out = new int[len];
        for (int i = 0; i < len; i++) {
            out[i] = stdin.nextInt();
        }
        return out;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] out = new int[list1.length + list2.length];
        for (int i = 0; i < list1.length; i++) {
            out[i] = list1[i];
        }
        for (int i = 0; i < list2.length; i++) {
            int outIndex = i + list1.length;
            out[outIndex] = list2[i];
        }
        Arrays.sort(out);
        return out;
    }
}
