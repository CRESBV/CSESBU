/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class named Q20732 containing:
 * An instance variable named sum of type integer.
 * A constructor that accepts an integer parameter, whose value is used to initialize the sum instance variable.
 * A method named getSum that returns the value of sum.
 * A method named add that accepts an integer parameter. The value of sum is increased by the value of the parameter.
 */
public class Q20733 {
    private int sum;

    public Q20733(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void add(int add) {
        sum += add;
    }
}
