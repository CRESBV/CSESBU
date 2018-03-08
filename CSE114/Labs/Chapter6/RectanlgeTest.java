//Edward Buckler
//111628438
//L05
/*
Write a test program that creates two Rectangle objects -- one with width 4 and height 40,
and the other with width 3.5 and height 35.9. Display the width, height, area, and perimeter
of each rectangle in this order.
*/
public class RectanlgeTest {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4, 40);
        Rectangle rec2 = new Rectangle(3.5, 35.9);
        System.out.println("width, height, area, and perimeter of rec1: " + rec1.viewAllRecData());
        System.out.println("width, height, area, and perimeter of rec2: " + rec2.viewAllRecData());

    }
}


