//Edward Buckler
//111628438
//L05
//20732
/*
Write a class named Q20732 containing:
An instance variable named sum of type integer, initialized to 0.
A method named getSum that returns the value of sum.
A method named add that accepts an integer parameter. The value of sum is increased by the value of the parameter.
*/
public class Q20732 {
    private int sum = 0;

    public int getSum() {
        return sum;
    }

    public void add(int num) {
        sum += num;
    }
}
