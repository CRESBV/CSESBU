import java.util.Scanner;

public class Nerd {
    public static void main(String[] args) {
        boolean nerd = false;
        Scanner input = new Scanner(System.in);

        while (!nerd) {
            System.out.print("if num inputed we will continue");
            nerd = true;
            String temp = input.nextLine();
            for (int i = 0; i < temp.length(); i++) {
                if (Character.isDigit(temp.charAt(i))) {
                    nerd = false;
                }
            }
        }
    }
}
