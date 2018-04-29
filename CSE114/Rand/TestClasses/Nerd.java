import java.util.Scanner;

public class Nerd {
    public static void main(String[] args) {
        int[] nerdArr = {1, 2, 3, 4, 5, 2, 3, 1, 3};
        System.out.println(max(nerdArr, nerdArr[0], 0));
    }

    public static int max(int[] list, int max, int index) {
        if (index == list.length) {
            return max;
        } else {
            if (list[index] > max) {
                return max(list, list[index], ++index);
            } else {
                return max(list, max, ++index);
            }
        }
    }
}
