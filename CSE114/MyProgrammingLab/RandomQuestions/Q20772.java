/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class definition of a class named 'Value' with the following:
 * a constructor accepting a single integer parameter
 * a constructor with no parameters
 * a method 'setVal' that accepts a single parameter,
 * a boolean method, 'wasModified' that returns true if setVal was ever called for the object.
 * a method 'getVal' that returns an integer value as follows: if setVal has ever been called, it getVal returns the last value passed to setVal. Otherwise if the "single int parameter" constructor was used to create the object, getVal returns the value passed to that constructor. Otherwise getVal returns 0.
 */
public class Q20772 {
    private boolean modified = false;
    private int val;

    public Q20772(int val) {
        this.val = val;
    }

    public Q20772() {
        val = 0;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
        modified = true;
    }

    public boolean wasModified() {
        return modified;
    }
}
