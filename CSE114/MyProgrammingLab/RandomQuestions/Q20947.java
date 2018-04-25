/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Assume the availability of an existing class, ICalculator, that models an integer arithmetic calculator and contains:
 * <p>
 * an instance variable currentValue that stores the current int value of the calculator
 * a getter method for the above instance variable
 * methods add, sub, mul, and div
 * Each method in ICalculator receives an int argument and applies its operation to currentValue and returns the new value of currentValue. So, if currentValue has the value 8 and sub(6) is invoked then currentValue ends up with the value 2, and 2 is returned.
 * <p>
 * So, you are to write the definition of a subclass, ICalculator1, based on ICalculator. The class ICalculator1 has one additional method, sign, that receives no arguments, and doesn't modify currentValue. Instead, it simply returns 1, 0 or -1 depending on the whether currentValue is positive, zero, or negative respectively.
 */
public class Q20947 {
}

/*public class ICalculator1 extends ICalculator {
    public int sign() {
        if (getCurrentValue() > 0)
            return 1;
        else if (getCurrentValue() == 0)
            return 0;
        else
            return -1;
    }

}*/


