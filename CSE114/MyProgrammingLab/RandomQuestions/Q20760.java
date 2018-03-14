/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class definition of a class named 'Value' with the following:
 * a boolean instance variable named 'modified', initialized to false
 * an integer instance variable named 'val'
 * a constructor accepting a single parameter whose value is assigned to the instance variable 'val'
 * a method 'getVal' that returns the current value of the instance variable 'val'
 * a method 'setVal' that accepts a single parameter, assigns its value to 'val', and sets the 'modified' instance variable to true, and
 * a boolean method, 'wasModified' that returns true if setVal was ever called.
 */
public class Q20760 {
    private boolean modified = false;
    private int val;

    public Q20760(int val) {
        this.val = val;
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
