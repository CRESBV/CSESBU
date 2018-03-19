import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * 10.3) (The MyInteger class) Design a class named MyInteger. The class contains:
 * <p>
 * An int data field named value that stores the int value represented by this object.
 * <p>
 * A constructor that creates a MyInteger object for the specified int value. A getter method that returns the int value.
 * <p>
 * The methods isEven(), isOdd(), and isPrime() that return true if the value in this object is even, odd, or prime, respectively.
 * <p>
 * The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the specified value is even, odd, or prime, respectively.
 * <p>
 * The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified value is even, odd,or prime, respectively.
 * <p>
 * The methods equals(int) and equals(MyInteger) that return true if the value in this object is equal to the specified value.
 * <p>
 * A static method parseInt(char[]) that converts an array of numeric characters to an int value.
 * <p>
 * A static method parseInt(String) that converts a string into an int value.
 * <p>
 * Draw the UML diagram for the class and then implement the class. Write a client program that tests all methods in the class. Given that the definition of a prime number is a positive integer be sure to instruct the use to only enter positive integers.
 */
public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public static boolean isEven(int num) {
        return ((num % 2 == 0) ? true : false);
    }

    public static boolean isOdd(int num) {
        return ((num % 2 == 1) ? true : false);
    }

    public static boolean isPrime(int num) {
        if (num < 4) {
            return true;
        } else {
            for (int i = 2; i < num / 2 + 1; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger num) {
        return num.isEven();
    }

    public static boolean isOdd(MyInteger num) {
        return num.isOdd();
    }

    public static boolean isPrime(MyInteger num) {
        return num.isPrime();
    }

    public static int parseInt(char[] inArr) {
        String temp = new String(inArr);
        return parseInt(temp);
    }

    public static int parseInt(String inString) {
        int out = Integer.parseInt(inString);
        return out;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return isEven(value);
    }

    public boolean isOdd() {
        return isOdd(value);
    }

    public boolean isPrime() {
        return isPrime(value);
    }

    public boolean equals(int num) {
        return ((num == value) ? true : false);
    }

    public boolean equals(MyInteger num) {
        return num.equals(value);
    }

    public static void main(String[] args) {

    }

    public static void testingOutput(String askLine, boolean showAssignLine, int objNum, String[] methodsUsed) {
        Scanner input = new Scanner(System.in);
        System.out.print(askLine);
        int numIn = input.nextInt();
        if (showAssignLine) {
            System.out.println("MyInteger obj"+objNum+" = new MyInteger("+numIn+");");
        }
        for (int i = 0; i < methodsUsed.length; i++) {
            System.out.println();
        }
    }
}
