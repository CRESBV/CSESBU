/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class named Q20735 containing:
 * An instance variable named amount of type double, initialized to 0.
 * An instance variable named capacity of type double.
 * A constructor that accepts a parameter of type double. The value of the parameter is used to initialize the value of capacity.
 * A method named addGas that accepts a parameter of type double. The value of the amount instance variable is increased by the value of the parameter. However, if the value of amount is increased beyond the value of capacity, amount is set to capacity.
 * A method named useGas that accepts a parameter of type double. The value of the amount instance variable is decreased by the value of the parameter. However, if the value of amount is decreased below 0, amount is set to 0.
 * A method named isEmpty that accepts no parameters. isEmpty returns a boolean value: true if the value of amount is less than 0.1, and false otherwise.
 * A method named isFull that accepts no parameters. isFull returns a boolean value: true if the value of amount is greater than capacity-0.1, and false otherwise.
 * A method named getGasLevel that accepts no parameters. getGasLevel returns the value of the amount instance variable.
 */
public class Q20737 {
    private double amount = 0;
    private double capacity;

    public Q20737(double capacity) {
        this.capacity = capacity;
    }

    public void addGas(double add) {
        amount = ((amount + add > capacity) ? capacity : amount + add);
    }

    public void useGas(double used) {
        amount = ((amount - used < 0) ? 0 : amount - used);
    }

    public boolean isEmpty() {
        return ((amount < 0.1) ? true : false);
    }

    public boolean isFull() {
        return ((amount <= capacity - 0.1) ? false : true);
    }

    public double getGasLevel() {
        return amount;
    }

    public double fillUp() {
        double out = capacity - amount;
        amount = capacity;
        return out;
    }
}
