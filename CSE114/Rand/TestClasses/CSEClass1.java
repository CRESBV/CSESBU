//Edward Buckler
//111628438
//L05
/*
this be to show off
*/


import java.util.Arrays;
import java.util.stream.IntStream;

public class CSEClass1 {
    public static void main(String[] args) {
        char[] list1 = new char[10];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = (char)((int)((int)'a'+Math.random()*26));
        }
        System.out.println("list1 = " + Arrays.toString(list1));
        //int sum = IntStream.of(list1).sum();
        //System.out.println("sum = " + sum);
       // list1 = bubbleSortArray(list1);
        System.out.println("Arrays.toString(list1) = " + Arrays.toString(list1));
        /*int x = 10;
        int y = 24;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);*/


    }
    public static int[] bubbleSortArray
    (int[]array){
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 1; i < array.length; i++) {
                if ((array[i - 1])>((array[i]))) {
                    done = false;
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }

}
