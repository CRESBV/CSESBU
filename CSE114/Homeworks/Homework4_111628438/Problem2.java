/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Implement the shape hierarchy show in the figure below. Each TwoDimensionalShape should
 * contain method getArea to calculate the area of the two-dimensional shape. Each
 * ThreeDimensionalShape should have methods getArea and getVolume to calculate the surface
 * area and volume, respectively, of the three-dimensional shape. Create a program that uses an
 * array of Shape references to objects of each class in the hierarchy. The program should print a
 * text description of the object to which each array element refers. Also, in the loop that processes
 * all the shapes in the array, determine whether each shape is a TwoDimensionalShape or a
 * ThreeDimensionalShape. If it’s a TwoDimensionalShape, display its area. If it’s a
 * ThreeDimensionalShape, display its area and volume.
 */
public class Problem2 {
    public static void main(String[] args) {
        ShapeHW[] testArr = new ShapeHW[6];
        testArr[0] = new CircleHW();
        testArr[1] = new SquareHW();
        testArr[2] = new TriangleHW();
        testArr[3] = new SphereHW();
        testArr[4] = new CubeHW();
        testArr[5] = new TetrahedronHW();

        for (int i = 0; i<6;i++){
            if ((testArr[i]) instanceof CircleHW) {
                System.out.println("Array Index: "+ i + " Type: Circle " + "Circle Area = " + ((CircleHW)testArr[i])
                        .getArea
                        ());
            }else if ((testArr[i]) instanceof SquareHW){
                System.out.println("Array Index: "+ i + " Type: Square " +"Square Area = " + ((SquareHW)testArr[i])
                        .getArea());
            }else if ((testArr[i]) instanceof TriangleHW){
                System.out.println("Array Index: "+ i + " Type: Triangle " +"Triangle Area = " + ((TriangleHW)
                        testArr[i]).getArea());
            }else if ((testArr[i]) instanceof SphereHW) {
                System.out.println("Array Index: "+ i + " Type: Sphere " +"Sphere Area and Volume = " + ((SphereHW)
                        testArr[i]).getArea() + " " + ((SphereHW)testArr[i]).getVolume());
            }else if ((testArr[i]) instanceof CubeHW) {
                System.out.println("Array Index: "+ i + " Type: Cube " +"Cube Area and Volume = " + ((CubeHW)
                        testArr[i]).getArea() + " " +  ((CubeHW)testArr[i]).getVolume());
            }else if ((testArr[i]) instanceof TetrahedronHW) {
                System.out.println("Array Index: "+ i + " Type: Tetrahedron " +"Tetrahedron Area and Volume = " + (
                        (TetrahedronHW)testArr[i]).getArea() + " " + ((TetrahedronHW)testArr[i]).getVolume());
            }
        }
    }
}

class ShapeHW {
}

abstract class TwoDimensionalShapeHW extends ShapeHW {
    public abstract double getArea();
}

abstract class ThreeDimensionalShapeHW extends ShapeHW {
    public abstract double getArea();

    public abstract double getVolume();
}

class CircleHW extends TwoDimensionalShapeHW {
    double radius;

    public CircleHW() {
        radius = 1;
    }

    public CircleHW(double radius) {
        this.radius = radius;
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class SquareHW extends TwoDimensionalShapeHW {
    double side;

    public SquareHW() {
        side = 1;
    }

    public SquareHW(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}

class TriangleHW extends TwoDimensionalShapeHW {
    double side1, side2, side3;

    public TriangleHW() {
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    public TriangleHW(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return (Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5));
    }
}

class SphereHW extends ThreeDimensionalShapeHW {
    double radius;

    public SphereHW() {
        radius = 1;
    }

    public SphereHW(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

class CubeHW extends ThreeDimensionalShapeHW {
    double side;

    public CubeHW() {
        side = 1;
    }

    public CubeHW(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2) * 6;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
}

class TetrahedronHW extends ThreeDimensionalShapeHW {
    double side1, side2, side3, side4, side5, side6;

    public TetrahedronHW() {
        side1 = 1;
        side2 = 1;
        side3 = 1;
        side4 = 1;
        side5 = 1;
        side6 = 1;
    }

    public TetrahedronHW(double side1, double side2, double side3, double side4, double side5, double side6) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.side5 = side5;
        this.side6 = side6;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getSide4() {
        return side4;
    }

    public void setSide4(double side4) {
        this.side4 = side4;
    }

    public double getSide5() {
        return side5;
    }

    public void setSide5(double side5) {
        this.side5 = side5;
    }

    public double getSide6() {
        return side6;
    }

    public void setSide6(double side6) {
        this.side6 = side6;
    }

    @Override
    public double getArea() {
        double s1 = (side1 + side2 + side4) / 2;
        double s2 = (side2 + side3 + side5) / 2;
        double s3 = (side1 + side3 + side6) / 2;
        double s4 = (side4 + side5 + side6) / 2;
        return Math.pow((s1 * (s1 - side1) * (s1 - side2) * (s1 - side4)), 0.5) +
                Math.pow((s1 * (s1 - side2) * (s1 - side3) * (s1 - side5)), 0.5) +
                Math.pow((s1 * (s1 - side1) * (s1 - side3) * (s1 - side6)), 0.5) +
                Math.pow((s1 * (s1 - side4) * (s1 - side5) * (s1 - side6)), 0.5);
    }

    @Override
    public double getVolume() {
        return (Math.pow(getArea(), 3) / (6 * Math.pow(2, 0.5)));
    }
}