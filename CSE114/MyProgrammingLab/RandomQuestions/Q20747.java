//Edward Buckler
//111628438
//L05
//20747
/*
Write the definition of a class Q20747 that provides the following behavior (methods):
A method called setSkies that has one parameter, a String.
A method called setHigh that has one parameter, an int.
A method called setLow that has one parameter, an int.
A method called getSkies that has no parameters and that returns the value that was last used as an argument in setSkies.
A method called getHigh that has no parameters and that returns the value that was last used as an argument in setHigh.
A method called getLow that has no parameters and that returns the value that was last used as an argument in setLow.
No constructor need be defined. Be sure to define instance variables as needed by your "get"/"set" methods-- initialize all numeric variables to 0 and any String variables to the empty string.
*/
public class Q20747 {
    private String skies = "";
    private int high = 0, low = 0;

    public void setSkies(String sky) {
        this.skies = sky;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getSkies() {
        return skies;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
