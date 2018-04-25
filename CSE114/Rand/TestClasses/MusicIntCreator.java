import java.util.Scanner;

/*
A69
B71
C60
D62
E64
F65
G67
DDEDGF DDEDAG DDDBGFE CCBGAG
DDEDGF DDEDGF DDDBGFE DDEDGF
*/

public class MusicIntCreator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String notes = input.nextLine();
        notes.toUpperCase();
        String out = "";
        int[] noteInts = {62, 61, 60, 59, 58, 57, 56, 55, 54};
        for (int i = 0; i < notes.length(); i++) {
            char temp = notes.charAt(i);
            if (temp == 'A') {
                out += noteInts[0] + ", ";
            } else if (temp == 'B') {
                out += noteInts[1] + ", ";
            } else if (temp == 'C') {
                out += noteInts[2] + ", ";
            } else if (temp == 'D') {
                out += noteInts[3] + ", ";
            } else if (temp == 'E') {
                out += noteInts[4] + ", ";
            } else if (temp == 'F') {
                out += noteInts[5] + ", ";
            } else if (temp == 'G') {
                out += noteInts[6] + ", ";
            }
        }

        System.out.println(out);
        input.close();
    }
}
