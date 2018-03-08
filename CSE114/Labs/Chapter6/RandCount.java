import java.util.Arrays;

//Edward Buckler
//111628438
//L05
/*
Write a program that generates 100 random integers between 0 and 9 and displays the
count for each number. (Hint: Use an array of 10 integers say counts, to store the counts
for the number of 0s, 1s, …,9s)
*/
public class RandCount {
    public static void main(String[] args) {
        int[] countArr = new int[10];
        for (int i = 0; i < 100; i++) {
            countArr[(int)(Math.random()*10)] ++;
        }
        System.out.println(Arrays.toString(countArr));
    }
}
