import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    private static final String[] BLOCK_TYPES = {"def", "for", "while", "if", "else", "elif"};

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        System.out.println("arrayList = " + arrayList);
        arrayList.add(2);
        System.out.println("arrayList = " + arrayList);
        arrayList.remove(arrayList.size()-1);
        System.out.println("arrayList = " + arrayList);

    }

}
