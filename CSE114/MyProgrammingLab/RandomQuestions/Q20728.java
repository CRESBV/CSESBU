/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Counter containing:
 * An instance variable named counter of type int.
 * An instance variable named limit of type int.
 * A static int variable named nCounters which is initialized to 0.
 * A constructor taking two int parameters that assigns the first one to counter and the second one to limit. It also adds one to the static variable nCounters.
 * A method named increment. It does not take parameters or return a value; if the instance variable counter is less than limit, increment just adds one to the instance variable counter.
 * A method named decrement that also doesn't take parameters or return a value; if counter is greater than zero, it just subtracts one from the counter.
 * A method named getValue that returns the value of the instance variable counter.
 * A static method named getNCounters that returns the value of the static variable nCounters.
 */
public class Q20728 {
    private int counter, limit;
    private static int nCounters = 0;

    public Q20728(int counter, int limit) {
        this.counter = counter;
        this.limit = limit;
        nCounters++;
    }

    public void increment() {
        counter += ((counter < limit) ? 1 : 0);
    }

    public void decrement() {
        counter -= ((counter > 0) ? 1 : 0);
    }

    public int getValue() {
        return counter;
    }

    public static int getNCounters() {
        return nCounters;
    }
}
