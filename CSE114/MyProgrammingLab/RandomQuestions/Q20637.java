/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Clock. The class has three instance variables: One of type int called hours, another of type boolean called isTicking, and the last one of type Integer called diff. You should also write a constructor that takes three parameters -- an int, a boolean, and another int. The constructor should set the instance variables to the values provided.
 */
public class Q20637 {
    private int hours;
    private boolean isTicking;
    private Integer diff;

    public Q20637(int hours, boolean isTicking, Integer diff) {
        this.hours = hours;
        this.isTicking = isTicking;
        this.diff = diff;
    }
}
