//Edward Buckler
//111628438
//L05
//20725
/*
Write the definition of a class Q20725 containing:
An instance variable counter of type int, initialized to 0.
A method called increment that adds one to the instance variable counter. It does not accept parameters or return a value.
A method called getValue that doesn't accept any parameters. It returns the value of the instance variable counter.
*/
public class Q20725 {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }
}
