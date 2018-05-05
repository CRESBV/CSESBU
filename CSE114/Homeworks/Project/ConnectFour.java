import java.awt.*;
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
        GameBoard board = new GameBoard();
        board.printBoard();
        Scanner input = new Scanner(System.in);
        boolean redTurn = true;
        boolean win = false;
        while (!win) {
            //Print command based on whos turn
            System.out.print((redTurn) ? "Drop a red disk at column (0 - 6): " : "Drop a yellow disk at column (0 -" +
                    " 6): ");
            //read what was inputted
            String inputVal = input.nextLine();
            int val;
            //New line for formatting
            System.out.println();
            //Clean input
            try {
                val = Integer.parseInt(inputVal);
                if ((!(val >= 0) && !(val <= 6))) {
                    System.out.println("incorrect input");
                    continue;
                }
            } catch (NumberFormatException NFEX) {
                if (inputVal.equals("end"))
                    break;
                System.out.println("incorrect input");
                continue;
            }
            //Alternator
            //Red's turn
            if (redTurn) {
                //if checker not placed continue
                if (!board.placeChecker(val, new Checker('R'))) {
                    continue;
                }
                //if checker placed reprint board
                else {
                    board.printBoard();
                }
                //test if win using lowestEmptySlot + 1 to get value of just dropped checker
                if (board.testIfWin((board.lowestEmptySpot(val) == -1) ? 0 : board.lowestEmptySpot(val) + 1, val, 'R')) {
                    System.out.println("The red player won.");
                    win = true;
                }
                redTurn = false;
            }
            //Yellow's turn
            else {
                //if checker not placed continue
                if (!board.placeChecker(val, new Checker('Y'))) {
                    continue;
                }
                //if checker placed reprint board
                else {
                    board.printBoard();
                }
                //test if win using lowestEmptySlot + 1 to get value of just dropped checker
                if (board.testIfWin((board.lowestEmptySpot(val) == -1) ? 0 : board.lowestEmptySpot(val) + 1, val, 'Y')) {
                    System.out.println("The yellow player won.");
                    win = true;
                }
                redTurn = true;
            }
        }
        input.close();
    }
}


/**
 * Checker object... used to have more stuff in it. Now just a char...
 */
class Checker {
    char type;

    public Checker() {
        type = ' ';
    }

    public Checker(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
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
    static Checker[][] board = new Checker[6][7];

    /**
     * constructor
     */
    public GameBoard() {
        //init all checkers in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Checker();
            }
        }
    }

    /**
     * prints board to console
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getType() + "|");
            }
            System.out.print("\n");
        }
        // Allows for full bar even on different screen resolutions
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("screenSize.width = " + screenSize.width);
            System.out.println("screenSize.height = " + screenSize.height);
            if (screenSize.width == 1920) {
                System.out.println("………………………………");
            } else {
                System.out.println("………………………………………");
            }
        } catch (final Exception e) {
            System.out.println("………………………………");
        }
    }

    /**
     * @param column
     * @return Value of the lowest empty row in specified column
     */
    public int lowestEmptySpot(int column) {
        try {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][column].getType() == ' ') {
                    return i;
                }
            }
        } catch (IndexOutOfBoundsException IOOBEX) {
            System.out.println("Please enter int between 0-6");
        }

        return -1;
    }


    /**
     * @param column
     * @param checker
     * @return bool based on Whether or not a checker had been placed
     */
    public boolean placeChecker(int column, Checker checker) {
        int lowestEmpty = lowestEmptySpot(column);
        if (lowestEmpty == -1) {
            System.out.println("Column full");
            return false;
        }
        board[lowestEmpty][column] = checker;
        return true;
    }

    /**
     * @param row
     * @param column
     * @param adjacent
     * @param direction
     * @param type
     * @return How many checkers have been found in a row
     * row, column designate origin
     * adjacent designates how many in a row have been found start with 0
     * direction forces which direction to look to -1 if search all
     * <p>
     * Direction:
     * 1 2 3
     * 8 X 4
     * 7 6 5
     */
    private int testNextToo(int row, int column, int adjacent, int direction, char type) {
        if (direction == -1) {
            for (int i = 1; i < 9; i++) {
                int[] directionCoord = directionTranslate(row, column, i);
                if (directionCoord[0] != -1) {
                    if (board[directionCoord[0]][directionCoord[1]].getType() == type) {
                        //temp call out
                        System.out.println(adjacent + ": REC 1 detection " + board[directionCoord[0]][directionCoord[1]].getType() + " at " + i + " (" + directionCoord[0] + ", " + directionCoord[1] + ")");
                        System.out.println("Rec Call: row " + directionCoord[0] + ", column " + directionCoord[1] +
                                ", adjacent " + ++adjacent + ", direction " + i + ", type " + type);
                        testNextToo(directionCoord[0], directionCoord[1], ++adjacent, i, type);
                    }
                }
            }
        } else if (row != -1 && column != -1) {
            int[] directionCoord = directionTranslate(row, column, direction);
            if (directionCoord[0] != -1) {
                if (board[directionCoord[0]][directionCoord[1]].getType() == type) {
                    //temp call out
                    System.out.println(adjacent + ": REC 1 detection " + type + " at " + direction + " (" + directionCoord[0] + ", " + directionCoord[1] + ")");
                    testNextToo(directionCoord[0], directionCoord[1], ++adjacent, direction, type);
                }
            }
        }
        return adjacent;
    }

    /**
     * @param row
     * @param column
     * @param type
     * @return bool based on if on side has won
     */
    public boolean testIfWin(int row, int column, char type) {
        int val = testNextToo(row, column, 0, -1, type);
        //temp call out
        System.out.println("val = " + val);
        if (val >= 3) {
            return true;
        }
        return false;
    }

    /**
     * @param row
     * @param column
     * @param direction
     * @return position on board based on origin and direction
     * Direction:
     * 1 2 3
     * 8 X 4
     * 7 6 5
     * Direction:
     * (-1, -1) (-1, col) (-1, +1)
     * (row, -1) (row, col) (row, +1)
     * (+1, -1) (+1, col) (+1, +1)
     */
    private int[] directionTranslate(int row, int column, int direction) {
        if (direction == 1 && row != 0 && column != 0) {
            return new int[]{row - 1, column - 1};
        } else if (direction == 2 && row != 0) {
            return new int[]{row - 1, column};
        } else if (direction == 3 && row != 0 && column != board[0].length - 1) {
            return new int[]{row - 1, column + 1};
        } else if (direction == 4 && column != board[0].length - 1) {
            return new int[]{row, column + 1};
        } else if (direction == 5 && column != board[0].length - 1 && row != board.length - 1) {
            return new int[]{row + 1, column + 1};
        } else if (direction == 6 && row != board.length - 1 && row != board.length - 1) {
            return new int[]{row + 1, column};
        } else if (direction == 7 && row != board.length - 1 && column != 0) {
            return new int[]{row + 1, column - 1};
        } else if (direction == 8 && column != 0) {
            return new int[]{row, column - 1};
        } else {
            return new int[]{-1, -1};
        }
    }
}
