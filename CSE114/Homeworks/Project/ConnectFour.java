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
        Scanner input = new Scanner(System.in);
        boolean redturn = true;
        boolean win = false;
        while (!win) {
            //Print board
            board.printBoard();
            //Print command based on whos turn
            System.out.print((redturn) ? "Drop a red disk at column (0 - 6): " : "Drop a yellow disk at column (0 -" +
                    " 6): ");
            //read what was inputted
            String inputVal = input.nextLine();
            //New line for formatting
            System.out.println();
            //Clean input
            try {
                if ((!(Integer.parseInt(inputVal) >= 0) && !(Integer.parseInt(inputVal) <= 6))) {
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
            if (redturn) {
                if (!board.placeChecker(Integer.parseInt(inputVal), new Checker('R')))
                    continue;
                if (board.testIfWin(Integer.parseInt(inputVal), board.lowestEmptySpot(Integer.parseInt(inputVal) +
                        1), 'R')) {
                    win = true;
                }
                redturn = false;
            } else {
                if (!board.placeChecker(Integer.parseInt(inputVal), new Checker('Y')))
                    continue;
                if (board.testIfWin(Integer.parseInt(inputVal), board.lowestEmptySpot(Integer.parseInt(inputVal) +
                        1), 'Y')) {
                    win = true;
                }
                redturn = true;
            }


        }
        input.close();
    }
}

/**
 * Direction:
 * 1 2 3
 * 8 X 4
 * 7 6 5
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
 * board[row][column]
 */

class GameBoard {
    static Checker[][] board = new Checker[6][7];

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Checker();
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getType() + "|");
            }
            System.out.print("\n");
        }
        System.out.println("………………………………………");
    }

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

        return 0;
    }


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
     * row, column designate origin
     * adjacent designates how many in a row have been found start with 0
     * direction forces which direction to look to -1 if search all
     */
    private int testNextToo(int row, int column, int adjacent, int direction, char type) {
        if (direction == -1) {
            for (int i = 1; i < 9; i++) {
                int[] directionCoord = directionTranslate(row, column, i);
                if (directionCoord[0] != -1) {
                    if (board[directionCoord[0]][directionCoord[1]].getType() == type) {
                        testNextToo(directionCoord[0], directionCoord[1], ++adjacent, i, type);
                    }
                }

            }
        } else {
            int[] directionCoord = directionTranslate(row, column, direction);
            testNextToo(directionCoord[0], directionCoord[1], ++adjacent, direction, type);
        }
        return adjacent;
    }

    public boolean testIfWin(int row, int column, char type) {
        if (testNextToo(row, column, 0, -1, type) >= 3) {
            return true;
        }
        return false;
    }

    /**
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
        //row - 1
        if (direction == 1 && row != 0 && column != 0) {
            return new int[]{row - 1, column - 1};
        } else if (direction == 2 && row != 0) {
            return new int[]{row - 1, column};
        } else if (direction == 3 && row != 0 && column != board[0].length - 1) {
            return new int[]{row - 1, column + 1};
        }
        //row
        else if (direction == 4 && column != 0) {
            return new int[]{row, column + 1};
        } else if (direction == 5 && column != board[0].length - 1) {
            return new int[]{row, column - 1};
        }
        //row + 1
        else if (direction == 6 && row != board.length - 1 && column != 0) {
            return new int[]{row + 1, column - 1};
        } else if (direction == 7 && row != board.length - 1) {
            return new int[]{row + 1, column};
        } else if (direction == 8 && row != board.length - 1 && column != board[0].length - 1) {
            return new int[]{row + 1, column + 1};
        } else {
            return new int[]{-1, -1};
        }
    }
}
