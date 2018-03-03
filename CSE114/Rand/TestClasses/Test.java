import java.util.*;

public class Test {
    private static double radius;
    private static double area;
    private static double circumference;

    public void defineRadius(double rad) {
        radius = rad;
    }

    public double returnRadius() {
        return radius;
    }

    public double returnArea() {
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public double returnCircumference() {
        circumference = radius * 2 * Math.PI;
        return circumference;
    }
}