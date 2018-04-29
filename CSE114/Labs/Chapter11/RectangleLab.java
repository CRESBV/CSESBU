public class RectangleLab extends GeometricObjectLab implements Colorable{
    private double width;
    private double height;

    public RectangleLab() {
    }

    public RectangleLab(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all 4 Sides");
    }
}