//Edward Buckler
//111628438
//L05snippetssnippets

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesSet {
    public static void main(String[] args) {
        //numsSet is a Set<String>, so that String.join works, otherwise I would use stream and map(i -> ""+i)
        //Using a treeSet versus HashSet so that the results are sorted,
        // but they will be sorted alphabetically, not numerically.
        Set<String> numsSet=new TreeSet<>();

        System.out.println("Enter 10 numbers: ");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numsSet.add(""+input.nextInt());
        }
        System.out.println(String.join(" ",numsSet));
    }

}
