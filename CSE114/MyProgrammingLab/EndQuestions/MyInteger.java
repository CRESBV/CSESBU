import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * 10.3) (The MyInteger class) Design a class named MyInteger. The class contains:
 * An int data field named value that stores the int value represented by this object.
 * A constructor that creates a MyInteger object for the specified int value. A getter method that returns the int value.
 * The methods isEven(), isOdd(), and isPrime() that return true if the value in this object is even, odd, or prime, respectively.
 * The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the specified value is even, odd, or prime, respectively.
 * The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified value is even, odd,or prime, respectively.
 * The methods equals(int) and equals(MyInteger) that return true if the value in this object is equal to the specified value.
 * A static method parseInt(char[]) that converts an array of numeric characters to an int value.
 * A static method parseInt(String) that converts a string into an int value.
 * Draw the UML diagram for the class and then implement the class. Write a client program that tests all methods in the class. Given that the definition of a prime number is a positive integer be sure to instruct the use to only enter positive integers.
 * <p>
 * Prompts:
 * Enter a positive integer to create a MyInteger object or to move on to next part of program:
 * Enter a positive integer to test static isXXX(int) methods or to move on to next part of program:
 * Enter a positive integer to test static isXXX(MyInteger) methods or to move on to next part of program:
 * Enter a the first of two positive integers to create obj2 and test obj2.equals(int) or to move on to next part of program:
 * Enter a the second of two positive integers to test obj2.equals(int):
 * Enter a the first of two positive integers to create obj2 and test obj2.equals(MyInteger obj3) or to move on to next part of program:
 * Enter a the second of two positive integers to create obj3 and test obj2.equals(MyInteger obj3):
 * Enter a positive integer that will be placed into a char[] array to demonstrate the MyInteger.parseInt(char[]):
 * Enter a positive integer that will be placed into a String to demonstrate the MyInteger.parseInt(String):
 */


public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean done = false;

        //ONE
        while (!done) {
            done = true;
            System.out.print("Enter a positive integer to create a MyInteger object or <enter> to move on to next part of " +
                    "program:");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                int intTemp = Integer.parseInt(stTemp);
                System.out.println("MyInteger obj0 = new MyInteger(" + intTemp + ");");
                MyInteger myIntTemp = new MyInteger(intTemp);
                System.out.println("obj0.getValue() = " + myIntTemp.getValue());
                System.out.println("obj0.isEven() = " + myIntTemp.isEven());
                System.out.println("obj0.isOdd() = " + myIntTemp.isOdd());
                System.out.println("obj0.isPrime() = " + myIntTemp.isPrime());
            }
        }

        //TWO
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a positive integer to test static isXXX(int) methods or <enter> to move on to next part " +
                    "of program:");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                int intTemp = Integer.parseInt(stTemp);
                System.out.println("MyInteger.isEven(" + intTemp + ") = " + MyInteger.isEven(intTemp));
                System.out.println("MyInteger.isOdd(" + intTemp + ") = " + MyInteger.isOdd(intTemp));
                System.out.println("MyInteger.isPrime(" + intTemp + ") = " + MyInteger.isPrime(intTemp));
            }
        }

        //THREE
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a positive integer to test static isXXX(MyInteger) methods or <enter> to move on to next" +
                    " part of program:");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                int intTemp = Integer.parseInt(stTemp);
                MyInteger myIntTemp = new MyInteger(intTemp);
                System.out.println("MyInteger obj1 = new MyInteger(" + intTemp + ");");
                System.out.println("obj1.getValue() = " + myIntTemp.getValue());
                System.out.println("MyInteger.isEven(obj1) = " + MyInteger.isEven(myIntTemp));
                System.out.println("MyInteger.isOdd(obj1) = " + MyInteger.isOdd(myIntTemp));
                System.out.println("MyInteger.isPrime(obj1) = " + MyInteger.isPrime(myIntTemp));
            }
        }

        //FOUR
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a the first of two positive integers to create obj2 and test obj2.equals(int) or <enter>" +
                    " to move on to next part of program:");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                int intTemp = Integer.parseInt(stTemp);
                MyInteger myIntTemp = new MyInteger(intTemp);
                System.out.println("MyInteger obj2 = new MyInteger(" + intTemp + ");");
                System.out.println("obj2.getValue() = " + myIntTemp.getValue());
                System.out.print("Enter a the second of two positive integers to test obj2.equals(int):");
                int intTemp2 = input.nextInt();
                input.nextLine();
                System.out.println("obj2.equals(" + intTemp2 + ") = " + myIntTemp.equals(intTemp2));
            }
        }

        //FIVE
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a the first of two positive integers to create obj2 and test obj2.equals" +
                    "(MyInteger obj3) or <enter> to move on to next part of program:");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                int intTemp = Integer.parseInt(stTemp);
                MyInteger myIntTemp = new MyInteger(intTemp);
                System.out.println("MyInteger obj2 = new MyInteger(" + intTemp + ");");
                System.out.println("obj2.getValue() = " + myIntTemp.getValue());
                System.out.print("Enter a the second of two positive integers to create obj3 and test obj2.equals(MyInteger obj3):");
                int intTemp2 = input.nextInt();
                input.nextLine();
                System.out.println("MyInteger obj3 = new MyInteger(" + intTemp2 + ");");
                MyInteger myIntTemp2 = new MyInteger(intTemp2);
                System.out.println("obj3.getValue() = " + myIntTemp2.getValue());
                System.out.println("obj2.equals(obj3) = " + myIntTemp.equals(myIntTemp2));
            }
        }

        //SIX
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a positive integer that will be placed into a char[] array to demonstrate the MyInteger.parseInt(char[]):");
            String stTemp = input.nextLine();
            char[] charTempArr = stTemp.toCharArray();
            for (char currentChar : charTempArr) {
                if (Character.isDigit(currentChar)) {
                    done = false;
                }
            }
            if (!done) {
                MyInteger myIntTemp = new MyInteger(MyInteger.parseInt(charTempArr));
                System.out.println("MyInteger obj4 = new MyInteger(MyInteger.parseInt(char []);");
                System.out.println("obj4.getValue() = " + myIntTemp.getValue());
                System.out.println("obj4.isEven() = " + myIntTemp.isEven());
                System.out.println("obj4.isOdd() = " + myIntTemp.isOdd());
                System.out.println("obj4.isPrime() = " + myIntTemp.isPrime());

            }
        }

        //SEVEN
        done = false;
        while (!done) {
            done = true;
            System.out.print("Enter a positive integer that will be placed into a String to demonstrate the MyInteger.parseInt(String):");
            String stTemp = input.nextLine();
            for (int i = 0; i < stTemp.length(); i++) {
                if (Character.isDigit(stTemp.charAt(i))) {
                    done = false;
                }
            }
            if (!done) {
                MyInteger myIntTemp = new MyInteger(MyInteger.parseInt(stTemp));
                System.out.println("MyInteger obj5 = new MyInteger(MyInteger.parseInt(String);");
                System.out.println("obj5.getValue() = " + myIntTemp.getValue());
                System.out.println("obj5.isEven() = " + myIntTemp.isEven());
                System.out.println("obj5.isOdd() = " + myIntTemp.isOdd());
                System.out.println("obj5.isPrime() = " + myIntTemp.isPrime());

            }
        }
    }

    public static boolean isEven(int num) {
        return ((num % 2 == 0) ? true : false);
    }

    public static boolean isOdd(int num) {
        return ((num % 2 == 1) ? true : false);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
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

    public int getValue() {
        return value;
    }
}
