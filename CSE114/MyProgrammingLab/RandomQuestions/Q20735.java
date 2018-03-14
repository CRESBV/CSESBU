//Edward Buckler
//111628438
//L05
//20735
/*
Write a class named Q20735 containing:
An instance variable named amount of type double, initialized to 0.
A method named addGas that accepts a parameter of type double. The value of the amount instance variable is increased by the value of the parameter.
A method named useGas that accepts a parameter of type double. The value of the amount instance variable is decreased by the value of the parameter.
A method named getGasLevel that accepts no parameters. getGasLevel returns the value of the amount instance variable.
*/
public class Q20735 {
    private double amount = 0;

    public void addGas(double add) {
        amount += add;
    }
    public void useGas(double used) {
        amount -= used;
    }

    public double getGasLevel() {
        return amount;
    }
}
