public class RecursionPracticeSquare {
    public static void main(String[] args) {
        printSquare(7);
    }

    public static void printSquare(int num) {
        helper(num, 1);
    }

    private static void helper(int num, int counter) {
        if (counter == 1 || counter == num) {
            line(num, 1, true);
        } else {
            line(num, 1, false);
        }
        if (counter < num) {
            helper(num, ++counter);
        } else {
            return;
        }
    }

    private static void line(int num, int counter, boolean filled) {
        if (counter == 1 || counter == num) {
            System.out.print("* ");
        } else if (filled) {
            System.out.print("* ");
        } else {
            System.out.print("  ");
        }
        if (counter < num) {
            line(num, ++counter, filled);
        } else {
            System.out.print("\n");
            return;
        }

    }
}
