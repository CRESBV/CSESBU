/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Q20725 containing:
 * An instance variable named counter of type int
 * An instance variable named limit of type int.
 * A constructor that takes two int arguments and assigns the first one to counter and the second one to limit
 * A method named increment. It does not take parameters or return a value; if the instance variable counter is less than limit, increment just adds one to the instance variable counter.
 * A method named decrement. It also does not take parameters or return a value; if counter is greater than zero, it just subtracts one from the counter.
 * A method named getValue that returns the value of the instance variable counter.
 */
public class Q20727 {
    private int counter, limit;

    public Q20727(int counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    public void increment() {
        counter += ((counter > limit) ? 0 : 1);
    }
    public void decrement() {
        counter -= ((counter > 0) ? 1 : 0);
    }

    public int getValue() {
        return counter;
    }
}
