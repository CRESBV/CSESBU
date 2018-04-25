/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * The superclass Calculator contains:
 * a (protected) double instance variable, accumulator, that contains the current value of the calculator.
 * write a subclass, CalculatorWithMemory, that contains:
 * a double instance variable, memory, initialized to 0
 * a method, save, that assigns the value of accumulator to memory
 * a method, recall, that assigns the value of memory to accumulator
 * a method, clearMemory, that assigns zero to memory
 * a method, getMemory, that returns the value stored in memory
 */
public class Q20750 {
    double accumulator;
}

class CalculatorWithMemory extends Q20750{
    private double memory = 0;

    public void save() {
        super.accumulator = memory;
    }

    public void recall() {
        memory = super.accumulator;
    }

    public void clearMemory() {
        memory = 0;
    }

    public double getMemory() {
        return memory;
    }
}
