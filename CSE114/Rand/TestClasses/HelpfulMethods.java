
import java.util.*;

public class HelpfulMethods {
    public static void main(String[] args) {
        method(1);
    }

    public static void method(int n) {
        System.out.println("l:"+n);
        if (n < 3) {
            method(n + 1);
        }
        System.out.println("L:"+n);

    }
}
