/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Q20725 containing:
 * An instance variable named counter of type int.
 * A constructor that takes one int argument and assigns its value to counter
 * A method named increment that adds one to counter. It does not take parameters or return a value.
 * A method named decrement that subtracts one from counter. It also does not take parameters or return a value.
 * A method named getValue that returns the value of the instance variable counter.
 */
public class Q20726 {
    private int counter;

    public Q20726(int counter) {
        this.counter = counter;
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
}
