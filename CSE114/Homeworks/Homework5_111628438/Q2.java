import java.util.Scanner;

public class Q2 {
    public static int max(int[] list, int index, int maxVal) {
        if (index < list.length - 1) {
            return max(list, ++index, ((maxVal > list[index]) ? maxVal : list[index]));
        } else {
            return ((maxVal > list[index]) ? maxVal : list[index]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input 8 ints:");
        int[] list = new int[8];
        for (int i = 0; i < 8; i++) {
            list[i] = input.nextInt();
        }
        System.out.println("Largest int: " + max(list, 0, list[0]));
        input.close();
    }
}
