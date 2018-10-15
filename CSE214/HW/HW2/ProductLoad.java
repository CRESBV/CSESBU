/**
 * @author edwardBucklerV
 * 111628438
 * 1. Write a fully-documented class named ProductLoad which contains the product name (String), it's weight in tons
 * (double), it's value in dollars (double), and whether the product is dangerous or not (boolean). You should provide accessor and mutator methods for each variable. The mutator methods for weight and value should throw exceptions for illegal arguments (i.e. negative values). The class should include a constructor. The full list of required methods is:
 * <p>
 * public ProductLoad - constructor (you may include a constructor with parameters)
 * getter and setter methods for each variable
 *
 * Stat:
 */
public class ProductLoad {
    private String name;
    private double weight;
    private double value;
    private boolean dangerous;

    /**
     * Constructor
     */
    public ProductLoad() {
        name = "";
        weight = 0;
        value = 0;
        dangerous = false;
    }

    /**
     * get Name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get Weight
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * set Weight with filtering
     *
     * @param weight
     * @throws BadInputValue
     */
    public void setWeight(double weight) throws BadInputValue {
        if (weight < 0) {
            throw new BadInputValue();
        }
        this.weight = weight;
    }

    /**
     * get Value
     *
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * set Value with filtering
     *
     * @param value
     * @throws BadInputValue
     */
    public void setValue(double value) throws BadInputValue {
        if (value < 0) {
            throw new BadInputValue();
        }
        this.value = value;
    }

    /**
     * detects if is Dangerous
     *
     * @return dangerous
     */
    public boolean isDangerous() {
        return dangerous;
    }

    /**
     * set if Dangerous
     *
     * @param dangerous
     */
    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }
}
