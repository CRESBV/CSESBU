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
//                if (board.testIfWin((board.lowestEmptySpot(val) == -1) ? 0 : board.lowestEmptySpot(val) + 1, val, 'R')) {
                if (board.testIfWin()) {
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
                //if (board.testIfWin((board.lowestEmptySpot(val) == -1) ? 0 : board.lowestEmptySpot(val) + 1, val, 'Y')) {
                if (board.testIfWin()) {
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
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

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
        System.out.println("   0 1 2 3 4 5 6");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getType() + "|");
            }
            System.out.print("\n");
        }
        // Allows for full bar even on different screen resolutions 1920x1080 and 2880x1800 supported default to
        // 1920x1080
        try {
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
     * @return Value of the lowest empty row in specified column if column full return -1
     * This is also the method sends the error message if val is not between 0-6
     */
    public int lowestEmptySpot(int column) {
        try {
            //interating from bottom to top looking for ' ' checker
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
     * Also sends out the Column full error should a player try to put a checker in a full column
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

//    /**
//     * Cool Way
//     * PROBLEM IS PROBABLY HERE!!! Realistically I overlooked something with how stacks work
//     *
//     * @param row
//     * @param column
//     * @param adjacent
//     * @param direction
//     * @param type
//     * @return How many checkers have been found in a row
//     * row, column designate origin
//     * adjacent designates how many in a row have been found start with 0
//     * direction forces which direction to look to -1 if search all
//     * Direction:
//     * 1 2 3
//     * 8 X 4
//     * 7 6 5
//     */
//    private int testNextToo(int row, int column, int adjacent, int direction, char type) {
//        if (direction == -1) {
//            //iterate through all 8 directions
//            for (int i = 1; i <= 8; i++) {
//                ArrayList<Integer[]> temp = new ArrayList<>();
//                Integer[] tempDirCoord = directionTranslate(row, column, i);
//                if (tempDirCoord[0] != -1) {
//                    if (board[tempDirCoord[0]][tempDirCoord[1]].getType() == type) {
//                        System.out.println("got here1");
//                        temp.add(tempDirCoord);
//                    }
//                    for (int j = 0; j < temp.size(); j++) {
//                        //temp call out
//                        System.out.println(adjacent + ": REC 1 detection " + board[temp.get(j)[0]][temp.get(j)[1]].getType()
//                                + " at " + temp.get(j)[2] + " (" + temp.get(j)[0] + ", " + temp.get(j)[1] + ")" + " rel to (" + row + ", " + column + ")");
//                        System.out.println("Rec 1 Call: row " + temp.get(j)[0] + ", column " + temp.get(j)[1] + ", " +
//                                "adjacent " + (adjacent + 1) + ", direction " + temp.get(j)[2] + ", type " + type);
//                        return testNextToo(temp.get(j)[0], temp.get(j)[1], ++adjacent, i, type);
//                    }
//                }
//                if (i == 8 && temp.size() == 0) {
//                    return adjacent;
//                }
//            }
//        } else {
//            Integer[] directionCoord = directionTranslate(row, column, direction);
//            if (directionCoord[0] != -1) {
//                if (board[directionCoord[0]][directionCoord[1]].getType() == type) {
//                    //temp call out
//                    System.out.println(adjacent + ": REC 2 detection " + board[directionCoord[0]][directionCoord[1]].getType()
//                            + " at " + direction + " (" + directionCoord[0] + ", " + directionCoord[1] + ")" + " rel to (" + row + ", " + column + ")");
//                    System.out.println("Rec 2 Call: row " + directionCoord[0] + ", column " + directionCoord[1] + ", " +
//                            "adjacent " + (adjacent + 1) + ", direction " + direction + ", type " + type);
//                    //If checker same type call method again but with that checker as origin
//                    return testNextToo(directionCoord[0], directionCoord[1], ++adjacent, direction, type);
//                }
//            }
//        }
//        return adjacent;
//    }
//    /**
//     * @param row
//     * @param column
//     * @param type
//     * @return bool based on if on side has won
//     */
//    public boolean testIfWin(int row, int column, char type) {
//        int val = testNextToo(row, column, 0, -1, type);
//        //temp call out
//        System.out.println("val = " + val);
//        if (val >= 3) {
//            return true;
//        }
//        return false;
//    }

    public boolean testIfWin() {
        //Vertical
        for (int j = 0; j <= board[0].length - 1; j++) {
            for (int i = 0; i <= board.length - 4; i++) {
                if (board[i][j].getType() == board[i + 1][j].getType() &&
                        board[i][j].getType() == board[i + 2][j].getType() &&
                        board[i][j].getType() == board[i + 3][j].getType() &&
                        board[i][j].getType() != ' ') {
                    return true;
                }
            }
        }
        //Horizontal
        for (int j = 0; j <= board[0].length - 4; j++) {
            for (int i = 0; i <= board.length - 1; i++) {
                if (board[i][j].getType() == board[i][j + 1].getType() &&
                        board[i][j].getType() == board[i][j + 2].getType() &&
                        board[i][j].getType() == board[i][j + 3].getType() &&
                        board[i][j].getType() != ' ') {
                    return true;
                }
            }
        }
        // \
        for (int j = 0; j <= board[0].length - 4; j++) {
            for (int i = 0; i <= board.length - 4; i++) {
                if (board[i][j].getType() == board[i + 1][j + 1].getType() &&
                        board[i][j].getType() == board[i + 2][j + 2].getType() &&
                        board[i][j].getType() == board[i + 3][j + 3].getType() &&
                        board[i][j].getType() != ' ') {
                    return true;
                }
            }
        }
        // /
        for (int j = 3; j <= board[0].length - 1; j++) {
            for (int i = 0; i <= board.length - 4; i++) {
                if (board[i][j].getType() == board[i + 1][j - 1].getType() &&
                        board[i][j].getType() == board[i + 2][j - 2].getType() &&
                        board[i][j].getType() == board[i + 3][j - 3].getType() &&
                        board[i][j].getType() != ' ') {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param row
     * @param column
     * @param direction
     * @return position on board based on origin and direction return (-1, -1) if out of bounds
     * Direction:
     * 1 2 3
     * 8 X 4
     * 7 6 5
     * Direction:
     * (-1, -1) (-1, col) (-1, +1)
     * (row, -1) (row, col) (row, +1)
     * (+1, -1) (+1, col) (+1, +1)
     */
    private Integer[] directionTranslate(int row, int column, int direction) {
        if (direction == 1 && row != 0 && column != 0) {
            return new Integer[]{row - 1, column - 1, direction};
        } else if (direction == 2 && row != 0) {
            return new Integer[]{row - 1, column, direction};
        } else if (direction == 3 && row != 0 && column != board[0].length - 1) {
            return new Integer[]{row - 1, column + 1, direction};
        } else if (direction == 4 && column != board[0].length - 1) {
            return new Integer[]{row, column + 1, direction};
        } else if (direction == 5 && column != board[0].length - 1 && row != board.length - 1) {
            return new Integer[]{row + 1, column + 1, direction};
        } else if (direction == 6 && row != board.length - 1 && row != board.length - 1) {
            return new Integer[]{row + 1, column, direction};
        } else if (direction == 7 && row != board.length - 1 && column != 0) {
            return new Integer[]{row + 1, column - 1, direction};
        } else if (direction == 8 && column != 0) {
            return new Integer[]{row, column - 1, direction};
        } else {
            return new Integer[]{-1, -1};
        }
    }
}
