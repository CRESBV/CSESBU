/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write an abstract superclass encapsulating a vehicle: A vehicle has two attributes: its owner’s
 * name and its number of wheels. This class has two non-abstract subclasses: one encapsulating
 * a Bicycle, and the other encapsulating a motorized vehicle. A motorized vehicle has the
 * following additional attributes: its engine volume displacement, in liters; and a method
 * computing and returning a measure of horsepower- the number of liters times the number of
 * wheels. You also need to include a client class to test the two classes.
 */
public abstract class Vehicle {
    String owner;
    int wheels;

    public Vehicle() {
        owner = "Nerd";
        wheels = 4;
    }

    public Vehicle(String owner) {
        this.owner = owner;
        wheels = 4;
    }

    public Vehicle(String owner, int wheels) {
        this.owner = owner;
        this.wheels = wheels;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

class MotorizedVehicle extends Vehicle {
    double engineVolumeDisplacement;

    public MotorizedVehicle() {
        engineVolumeDisplacement = 1;
    }

    public MotorizedVehicle(String owner, int wheels, double engineVolumeDisplacement) {
        super(owner, wheels);
        this.engineVolumeDisplacement = engineVolumeDisplacement;
    }

    public double horsepower() {
        return engineVolumeDisplacement * wheels;
    }

    public double getEngineVolumeDisplacement() {
        return engineVolumeDisplacement;
    }

    public void setEngineVolumeDisplacement(double engineVolumeDisplacement) {
        this.engineVolumeDisplacement = engineVolumeDisplacement;
    }
}

class Bicycle extends Vehicle {
    public Bicycle() {
        super("nerd", 2);
    }

    public Bicycle(String owner, int wheels) {
        super(owner, wheels);
    }
}

class DriverVehicle {
    public static void main(String[] args) {
        System.out.println("testing MotorizedVehicle");
        MotorizedVehicle mvTest = new MotorizedVehicle();
        System.out.println("Owner: " + mvTest.getOwner() + ", Wheels: " + mvTest.getWheels() + ", " +
                "engineVolumeDisplacement: " + mvTest.getEngineVolumeDisplacement() + ", horsepower: " + mvTest.horsepower());
        System.out.println("testing Bicycle");
        Bicycle bTest = new Bicycle();
        System.out.println("Owner: " + mvTest.getOwner() + ", Wheels: " + mvTest.getWheels());
    }
}