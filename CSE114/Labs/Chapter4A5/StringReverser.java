//Edward Buckler
// 111628438
// L05

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        System.out.println("Input the string : ");
        Scanner input = new Scanner(System.in);
        String stringIn = input.nextLine();
        reverse(stringIn);
    }

    public static void reverse(String st) {
        String outSt = "";
        for (int i = st.length() - 1; i >= 0; i--) {
            outSt += st.charAt(i);
        }
        System.out.println("The reversed string: " + outSt);
    }
}
