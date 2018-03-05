//Edward Buckler
//111628438
//L05snippetssnippets

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println("Enter 10 numbers: ");
        Scanner input = new Scanner(System.in);
        int[] numslist = new int[10];
        for (int i = 0; i < 10; i++) {
            numslist[i] = input.nextInt();
        }
        System.out.print("The distinct numbers are: ");
        int[] output = eliminateDuplicate(numslist);
        for (int i = 0; i < output.length; i++)
            System.out.print(output[i]+" ");
    }
    public static int[] eliminateDuplicate(int[] list){

        int[] temp = new int[list.length];
        int tempCount = 0;
        for (int i = 0; i < list.length; i++) {
                if (!containsInt(temp, list[i])){
                    temp[tempCount] = list[i];
                    tempCount++;
            }
        }
        int[] out =new int[tempCount];
        for (int i = 0; i < tempCount; i++) {
            out[i] = temp[i];
        }
        return out;
    }

    public static boolean containsInt(int[] array, int target) {
        for (int i = 0; i<array.length; i++) {
            if (target == array[i]) {
                return true;
            }
        }
        return false;
    }

    //Does this by using the properties of sets (unordered unique collection of numbers).
    // It is more combursome than it needs to be as the numbers
    //were collected in a primitive array.
    public static int[] makeSet(int[] list) {
        Set<Integer> uniqueInts = Arrays.stream(list).boxed().collect(Collectors.toSet());
        return uniqueInts.stream().mapToInt(i -> i).toArray();
    }

    //The one liner version.
    public static List<Integer> makeSet(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

}
