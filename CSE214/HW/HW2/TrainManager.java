/**
 * @author edwardBucklerV
 * 111628438
 * The main method runs a menu driven application which first creates an empty TrainLinkedList object. The program
 * prompts the user for a command to execute an operation. Once a command has been chosen, the program may ask the user
 * for additional information if necessary, and performs the operation.
 */

import java.util.Scanner;

public class TrainManager {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_BLUE = "\u001b[34m";
    private TrainLinkedList train = new TrainLinkedList();

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        TrainManager trainManager = new TrainManager();
        boolean quit = false;
        while (!quit) {
            mainMenu();
            try {
                quit = trainManager.parser();
            } catch (CursorNull cursorNull) {
                System.out.println(ANSI_RED + "ERROR: Cursor is null. Resetting input and menu." + ANSI_RESET);
            } catch (NextNull nextNull) {
                System.out.println(ANSI_RED + "Error: Next element in list is null. Resetting input and menu." + ANSI_RESET);
            } catch (PrevNull prevNull) {
                System.out.println(ANSI_RED + "ERROR: Previous element is null. Resetting input and menu." + ANSI_RESET);
            } catch (BadInputValue badInputValue) {
                System.out.println(ANSI_RED + "ERROR: Input not recognized. Resetting input and menu." + ANSI_RESET);
            }
        }
        System.out.println("Program terminating successfully...");
    }

    /**
     * prints main menu
     */
    private static void mainMenu() {
        System.out.print(ANSI_BLUE + "\n(F) Cursor Forward \n(B) Cursor Backward \n(I) Insert Car After Cursor \n(R) " +
                "Remove " +
                "Car At " +
                "Cursor \n(L) Set Product Load \n(S) Search For Product \n(T) Display Train \n(M) Display Manifest \n(D)" +
                " Remove Dangerous Cars \n(Q) Quit\n\nEnter a selection:" + ANSI_RESET);
    }

    /**
     * @return bool on whether to stop program
     * @throws CursorNull
     * @throws NextNull
     * @throws PrevNull
     * @throws BadInputValue
     */
    private boolean parser() throws CursorNull, NextNull, PrevNull, BadInputValue {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) ;
        String command = input.nextLine();
        command = command.toLowerCase();
        if (command.equals("f")) {
            train.cursorForward();
            System.out.println("Cursor moved forward");
        } else if (command.equals("b")) {
            train.cursorBackward();
            System.out.println("Cursor moved backward");
        } else if (command.equals("i")) {
            TrainCar newCar = new TrainCar();
            System.out.print("Enter car length in meters: ");
            double lengthTemp = lengthParse(input.nextLine());
            newCar.setLength(lengthTemp);
            System.out.print("Enter car weight in tons: ");
            double weightTemp = weightParse(input.nextLine());
            newCar.setWeight(weightTemp);
            train.insertAfterCursor(newCar);
            System.out.println("New train car " + lengthTemp + " meters " + weightTemp + " tons inserted into train.");
        } else if (command.equals("r")) {
            TrainCar trainCar = train.removeCursor();
            System.out.println("Car successully unlinked. The following load has been removed from the train:\n" +
                    removeCarPrint(trainCar));
        } else if (command.equals("l")) {
            ProductLoad productLoad = new ProductLoad();
            System.out.print("Enter produce name: ");
            String name = input.nextLine();
            productLoad.setName(name);
            System.out.print("Enter product weight in tons: ");
            double weight = weightParse(input.nextLine());
            productLoad.setWeight(weight);
            System.out.print("Enter prduct value in dollars: ");
            productLoad.setValue(valueParse(input.nextLine()));
            System.out.print("Enter is product dangerous? (y/n)");
            productLoad.setDangerous(dangerousParse(input.nextLine()));
            TrainCar newCar = train.getCursorData();
            newCar.setLoad(productLoad);
            train.setCursorData(newCar);
        } else if (command.equals("s")) {
            System.out.print("Enter product name: ");
            train.findProduct(input.nextLine());
        } else if (command.equals("t")) {
            System.out.println(train);
        } else if (command.equals("m")) {
            train.printManifest();
        } else if (command.equals("d")) {
            train.removeDangerousCars();
            System.out.println("Dangerous cars successfully removed from the train.");
        } else if (command.equals("q")) {
            return true;
        } else {
            throw new BadInputValue();
        }
        return false;
    }

    /**
     * parse length input
     *
     * @param lengthSt
     * @return double parsed for length of car
     * @throws BadInputValue
     */
    private double lengthParse(String lengthSt) throws BadInputValue {
        double out = 0;
        try {
            out = Double.parseDouble(lengthSt);
            if (out <= 0) {
                System.out.println(ANSI_RED + "Error: length 0 or less than 0" + ANSI_RESET);
                throw new BadInputValue();
            }
        } catch (NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Error: length not parsable" + ANSI_RESET);
            throw new BadInputValue();
        }
        return out;
    }

    /**
     * parse dangerous input
     *
     * @param dangerousSt
     * @return boolean based on user input string
     * @throws BadInputValue
     */
    private boolean dangerousParse(String dangerousSt) throws BadInputValue {
        if (!dangerousSt.equals("y") && !dangerousSt.equals("n")) {
            System.out.println(ANSI_RED + "Error: can't parse bool input. Must be \"y\" or \"n\"" + ANSI_RESET);
            throw new BadInputValue();
        }
        return (dangerousSt.equals("y"));
    }

    /**
     * parse value input
     *
     * @param valueSt
     * @return double of value parsed
     * @throws BadInputValue
     */
    private double valueParse(String valueSt) throws BadInputValue {
        double out = 0;
        try {
            out = Double.parseDouble(valueSt);
            if (out < 0) {
                System.out.println(ANSI_RED + "Error: less than 0 value" + ANSI_RESET);
                throw new BadInputValue();
            }
        } catch (NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Error: value not parsable" + ANSI_RESET);
            throw new BadInputValue();
        }
        return out;
    }

    /**
     * parse weight input
     *
     * @param weightSt
     * @return double weight parsed
     * @throws BadInputValue
     */
    private double weightParse(String weightSt) throws BadInputValue {
        double out = 0;
        try {
            out = Double.parseDouble(weightSt);
            if (out <= 0) {
                System.out.println(ANSI_RED + "Error: weight 0 or less than 0" + ANSI_RESET);
                throw new BadInputValue();
            }
        } catch (NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Error: weight not parsable" + ANSI_RESET);
            throw new BadInputValue();
        }
        return out;
    }

    /**
     * menu for when a car is removed
     *
     * @param trainCar
     * @return
     */
    private String removeCarPrint(TrainCar trainCar) {
        String out = "    Name      Weight (t)     Value ($)   Dangerous\n" +
                "===================================================\n";
        out += String.format("%9s%15.2f%14.2f%15s", trainCar.getLoad().getName(), trainCar.getLoad().getWeight(),
                trainCar.getLoad().getValue(), ((trainCar.getLoad().isDangerous()) ? ANSI_RED + "YES" :
                        ANSI_GREEN + "NO") + ANSI_RESET);
        return out;

    }
}
