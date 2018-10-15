/**
 * @author edwardBucklerV
 * 111628438
 * Write a fully-documented class named TrainCar which contains a length in meters (double), a weight in tons (double), and a load reference (ProductLoad). The load variable of the train may be null, which indicates that the train car is empty and contains no product. The train car should have accessor methods for the length, weight, and load variables; however, you should only provide a mutator method for the load variable (the car weight and length should be constant once set). In addition, the class should specify a constructor method (with whatever parameters are necessary), and a method determining whether the car is empty or not. The full list of required methods is:
 *
 * public TrainCar - constructor (you may include a constructor with parameters)
 * getter methods for each variable
 * setter method only for the load variable.
 * isEmpty() method
 */
public class TrainCar {
    private double length;
    private double weight;
    private ProductLoad load;

    public TrainCar() {
        length = 0;
        weight = 0;
        load = new ProductLoad();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ProductLoad getLoad() {
        return load;
    }

    public void setLoad(ProductLoad load) {
        this.load = load;
    }
}
