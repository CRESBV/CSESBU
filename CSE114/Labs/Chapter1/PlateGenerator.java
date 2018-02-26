//Edward Buckler
// 111628438
// L05

public class PlateGenerator {
    public static void main(String[] args) {
        String output = "";
        output = "";
        for (int j = 0; j < 3; j++) {
            output += (char) ((65 + Math.random() * 26));
        }
        for (int j = 0; j < 4; j++) {
            output += (char) ((48 + Math.random() * 10));
        }
        System.out.println("Example : " + output);
    }
}
