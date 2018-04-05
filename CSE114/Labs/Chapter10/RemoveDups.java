import java.util.*;


/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a method that removes the duplicate elements from an array list of integers using the
 * following header:
 * public static void removeDuplicate(ArrayList<Integer> list)
 * Write a test program that prompts the user to enter 10 integers to be added in a list and display
 * the distinct integers in their input order and separated by exactly one space.
 * Here is a sample run:
 * Enter 10 integers: 34 5 3 5 6 4 33 2 2 4
 * The distinct integers are: 34 5 3 6 4 33 2
 */
public class RemoveDups {
    public static void removeDuplicate(ArrayList<Integer> list){
        Set<Integer> out = new LinkedHashSet<Integer>(list);
        System.out.print(printArrayHashSet(out));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        ArrayList<Integer> inpt = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inpt.add(input.nextInt());
        }
        System.out.print("The distinct integers are: ");
        removeDuplicate(inpt);
    }

    public static String printArrayHashSet(Set<Integer> array) {
        String out = "";
        for (Integer hashSetIntegerElement : array) {
            out += hashSetIntegerElement + " ";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }

}
