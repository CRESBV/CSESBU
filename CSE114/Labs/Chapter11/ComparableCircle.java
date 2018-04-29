/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Define a class named ComparableCircle that extends Circle and implements Comparable.
 * Implement the compareTo method to compare the circles on the basis of area. Write a test class
 * to find the larger of the two instances of ComparableCircle objects.
 */
public class ComparableCircle extends CircleLab implements Comparable {
    public ComparableCircle(double radius) {
        super(radius);
    }

    public int compareTo(Object o) {
        if (o instanceof ComparableCircle) {

            if (getArea() > ((ComparableCircle) o).getArea())
                return 1;
            else if (getArea() < ((ComparableCircle) o).getArea())
                return -1;
            else
                return 0;
        }
        return 0;
    }

}

class DriverCC {
    public static void main(String[] args) {
        ComparableCircle t1 = new ComparableCircle(3.0);
        ComparableCircle t2 = new ComparableCircle(2.0);
        System.out.println(t1.compareTo(t2));
    }
}

