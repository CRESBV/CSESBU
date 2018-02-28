public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        int out = 1;
        for (int i = 2; i < num+1; i++){
            out = out*i;
        }
        System.out.println(out);
    }
}
