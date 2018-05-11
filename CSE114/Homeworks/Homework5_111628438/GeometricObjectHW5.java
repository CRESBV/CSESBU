public abstract class GeometricObjectHW5 implements Comparable {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObjectHW5() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObjectHW5(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    static GeometricObjectHW5 max(GeometricObjectHW5 geoObj1, GeometricObjectHW5 geoObj2) {
        return (geoObj1.getArea() > geoObj2.getArea()) ? geoObj1 : geoObj2;
    }
    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}