//Edward Buckler
//111628438
//L05
/*
this be to show off
*/


public class CSEClass1 {
    public static void main(String[] args) {
        try {
            int[] list = new int[10];
            System.out.println("list[10]" + list[10]);
        } catch (ArithmeticException ex) {
            System.out.println("A");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("B");
        } catch (RuntimeException ex) {
            System.out.println("You right");
        }
    }
}


