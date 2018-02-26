//Edward Buckler
// 111628438
// L05
import java.util.Random;

public class MonthRandGen {
    public static void main(String[] args) {
        Random num = new Random();
        int monthNum = num.nextInt(12);
        String monthList[] = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        System.out.println(monthList[monthNum]);
    }
}
