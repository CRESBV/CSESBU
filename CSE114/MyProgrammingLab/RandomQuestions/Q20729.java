/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Counter containing:
 * An instance variable named counter of type int.
 * An instance variable named counterID of type int.
 * A static int variable nCounters which is initialized to zero.
 * A constructor that takes an int argument and assigns its value to counter. It also adds one to the static variable nCounters and assigns the result to the instance variable counterID.
 * A method named increment. It does not take parameters or return a value; it just adds one to the instance variable counter.
 * A method named decrement that also doesn't take parameters or return a value; it just subtracts one from the counter.
 * A method named getValue. It returns the value of the instance variable counter.
 * A method named getCounterID: it returns the value of the instance variable counterID.
 */
public class Q20729 {
    private int counter, counterID;
    private static int nCounters = 0;

    public Q20729(int counter) {
        this.counter = counter;
        counterID = ++nCounters;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getValue() {
        return counter;
    }

    public int getCounterID() {
        return counterID;
    }
}
