/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named Location for locating a maximal value and its location in a twodimensional
 * array. The class contains public data field’s row, column, and maxValue that store
 * the maximal value and its indices in a two-dimensional array with row and column as int types
 * and maxValue as a double type.
 * Write the following method that returns the location of the largest element in a two –
 * dimensional array:
 * public static Location locateLargest(double[][] a)
 * The return value is an instance of Location. Write a test program that prompts the user to
 * enter a two-dimensional array and display the location of the largest element in the array.
 * Here is the sample run:
 * Enter the number of rows and columns in the array: 3 4
 * Enter the array:
 * 23.5 35 2 10
 * 4.5 3 45 3.5
 * 35 44 5.5 9.6
 * The location of the largest element 45 is at (1, 2)
 */
public class Location {
    public int row, column;
    public double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }

    public static Location locateLargest(double[][] a) {
        double max = a[0][0];
        int row = 0, column = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        return new Location(0,0,0);
    }

}
