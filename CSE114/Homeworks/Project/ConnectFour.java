import java.util.Scanner;

/**
 * Main driver class takes care of:
 * inputs
 * policing inputs
 * alternating
 * Notes:
 */

public class ConnectFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean win = false;
        while (!win) {
            GameBoard board = new GameBoard();
            board.printBoard();
            for (int i = 0; i < board.getBoardSize(); i++) {
                boolean redTurn = (i % 2 == 0);
                int dropColumn = -1;
                //New line for formatting
                System.out.println();
                //Clean input
                while (dropColumn < 0) {
                    System.out.print((redTurn) ? "Drop a red disk at column (0 - 6): " : "Drop a yellow disk at column (0 " + "-" + " 6): ");
                    try {
                        String inputVal = input.nextLine();
                        int val = Integer.parseInt(inputVal);
                        if ((!(val >= 0) && !(val <= 6))) throw new IllegalStateException();
                        if (board.lowestEmptySpot(val) == -1) throw new IllegalStateException();
                        dropColumn = val;
                    } catch (Exception NFEX) {
                        System.out.println("Column full or incorrect input");
                    }
                }
                int row = board.placeChecker(dropColumn, (redTurn) ? 'R' : 'Y');
                board.printBoard();
                if (win = board.testIfWin(row, dropColumn)) {
                    System.out.println("The " + ((redTurn) ? "Red" : "Yellow") + " player won.");
                    break;
                }
            }
            if (!win) {
                System.out.println("Resetting Board");
            }
        }
        input.close();
    }
}

/**
 * Main methods class:
 * Holds board data
 * printing board
 * empty slot in board
 * placing new checkers
 * finding adjacent checkers to one given
 * discerning if one side has won
 */
class GameBoard {
    static char[][] board = new char[6][7];
    static String baseline;

    static {
        try {
            String operatingSystem = System.getProperty("os.name");
            System.out.println(operatingSystem);
            if (operatingSystem.contains("Windows")) {
                baseline = "  ………………………………";
            } else if (operatingSystem.contains("Mac")) {
                baseline = "  ………………………………………";
            } else
                baseline = "  ………………………………";
        } catch (Exception e) {
            baseline = "  ………………………………";
        }
    }


    /**
     * constructor
     */
    public GameBoard() {
        //init all checkers in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static int getBoardSize() {
        return board.length * board[0].length;
    }

    /**
     * prints board to console
     */
    public void printBoard() {
        System.out.println("   0 1 2 3 4 5 6");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.print("\n");
        }
        // This can be a bit odd based on the screen resolution I have set it so that on my mac it will do more to
        // compensate for higher resolution than my desktop
        System.out.println(baseline);

    }

    /**
     * @param column
     * @return Value of the lowest empty row in specified column if column full return -1
     * This is also the method sends the error message if val is not between 0-6
     */
    public int lowestEmptySpot(int column) {
        //iterating from bottom to top looking for ' ' checker
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                return i;
            }
        }
        return -1;
    }


    /**
     * @param column
     * @param checker
     * @return bool based on Whether or not a checker had been placed
     * Also sends out the Column full error should a player try to put a checker in a full column
     */
    public int placeChecker(int column, char checker) {
        int lowestEmpty = lowestEmptySpot(column);
        board[lowestEmpty][column] = checker;
        return lowestEmpty;
    }

    /**
     * direction:
     * O O X
     * O T X
     * O X X
     * <p>
     * test all 4 directions
     * go as far as can in each direction
     * return that sum
     * ad pos and neg direstions together
     * test if > 3
     *
     * @param row
     * @param column
     * @return
     */
    public boolean testIfWin(int row, int column) {
        int[][] posDirection = {{1, 0}, {1, 1}, {0, 1}, {1, -1}};
        char checkerColor = board[row][column];
        for (int[] direction : posDirection) {
            int posSum = runLength(row, column, direction[0], direction[1], checkerColor);
            int negSum = runLength(row, column, -1 * direction[0], -1 * direction[1], checkerColor);
            if (posSum + negSum >= 3) {
                return true;
            }
        }

        return false;
    }

    private int runLength(int row, int column, int rowDirection, int colDirection, char checkerColor) {
        if (checkerColor == checkerColor(row + rowDirection, column + colDirection)) {
            return 1 + runLength(row + rowDirection, column + colDirection, rowDirection, colDirection, checkerColor);
        }
        return 0;
    }

    /**
     * return of ' ' for out of bounds
     *
     * @param row
     * @param column
     * @return
     */
    private char checkerColor(int row, int column) {
        try {
            return board[row][column];

        } catch (IndexOutOfBoundsException IOBEX) {
            return ' ';
        }
    }
}
