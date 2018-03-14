//Edward Buckler
//111628438
//L05
//20734
/*
Write a class named Q20734 containing:
An instance variable named sum of type integer, initialized to 0.
An instance variable named count of type integer, initialized to 0.
A method named getSum that returns the value of sum.
A method named add that accepts an integer parameter. The value of sum is increased by the value of the parameter and the value of count is incremented by one.
A method named getCount that accepts no parameters. getCount returns the value of the count instance variable, that is, the number of values added to sum.
A method named getAverage that accepts no parameters. getAverage returns the average of the values added to sum. The value returned should be a value of type double (and therefore you must cast the instance variables to double prior to performing the division).
*/
public class Q20734 {
    private int sum = 0, count = 0;

    public int getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }

    public void add(int num) {
        sum += num;
        count++;
    }

    public double getAverage() {
        return (double) sum / count;
    }

}
