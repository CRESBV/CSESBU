//Edward Buckler
//111628438
//L05
public class Average10Num {
    public static void main(String[] args) {
        int intOut = 0;
        for (int i = 0; i < 10; i++) {
            double ad = Math.random()*100;
            intOut += (int)ad;
        }
        double out = (double) intOut;
        out /= 10;
        System.out.println("out = " + out);
    }
}
