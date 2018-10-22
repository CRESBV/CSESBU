import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Tester {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(5);
        test.push(4);
        test.push(3);
        test.push(2);
        test.push(1);
        System.out.println(Arrays.toString(test.toArray()));

        try {
            Stack<Integer> t1 = reverse(test);

            System.out.println(Arrays.toString(t1.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Stack<Integer> reverse(Stack<Integer> stck) throws Exception {
        if (stck == null) {
            throw new Exception("empty");
        } else {
            Stack<Integer> temp = new Stack<>();
            return reverseHelper(stck, temp);
        }
    }

    private static Stack<Integer> reverseHelper(Stack<Integer> main, Stack<Integer> sec) throws Exception {
        if (main == null) {
            throw new Exception("empty");
        } else {
            if (main.size() >= 1) {
                sec.push(main.pop());
                reverseHelper(main, sec);
            }
            return sec;
        }
    }


}
