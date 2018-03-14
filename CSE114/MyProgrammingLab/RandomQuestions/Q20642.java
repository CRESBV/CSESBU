/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write the definition of a class Telephone. The class has no constructors, one instance variable of type String called number, and two static variables. One is of type int called quantity; the other is of type double called total. Besides that, the class has one static method makeFullNumber. The method accepts two arguments, a String containing a telephone number and an int containing an area code. The method concatenates the two arguments in the following manner: First comes the area code, then a dash, then the telephone number. The method returns the resultant string.
 */
public class Q20642 {
    private String number;
    private static int quantity;
    private static double total;

    public static String makeFullNumber(String phoneNumber, int areaCode) {
        return areaCode + "-" + phoneNumber;
    }

}
