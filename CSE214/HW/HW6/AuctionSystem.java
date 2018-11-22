import java.io.*;
import java.util.Scanner;
/**
 * @author edwardBucklerV
 * 111628438
 * Main class that deals with inputs and save and loads
 */

public class AuctionSystem {
    private static final String MENU = "    (D) - Import Data from URL\n" +
            "    (A) - Create a New Auction\n" +
            "    (B) - Bid on an Item\n" +
            "    (I) - Get Info on Auction\n" +
            "    (P) - Print All Auctions\n" +
            "    (R) - Remove Expired Auctions\n" +
            "    (T) - Let Time Pass\n" +
            "    (Q) - Quit\n" +
            "\n" +
            "\n" +
            "Please select an option: ";
    private AuctionTable auctionTable = new AuctionTable();

    /**
     * main method lets parser deal with most inputs passed the command inputed
     *
     * @param args none
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Starting...\n");
        AuctionSystem auctionSystem = new AuctionSystem();
        File f = new File("saveFile.obj");
        if (f.exists()) {
            try {
                auctionSystem.auctionTable = load("saveFile.obj");
                System.out.println("Loading previous Auction Table...");
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
            } catch (IOException e) {
                System.out.println("IOException");
            } catch (ClassCastException e) {
                System.out.println("Save file found but not of right type.");
            }
        } else {
            System.out.println("No previous auction table detected.\n" +
                    "Creating new table... ");
        }
        System.out.print("Please select a username: ");
        String username = input.nextLine();
        boolean quit = false;
        while (!quit) {
            System.out.print(MENU);
            quit = auctionSystem.parser(username);
        }

        try {
            save("saveFile.obj", auctionSystem.auctionTable);
        } catch (IOException e) {
            System.out.println("Issue with save files");
        }
        input.close();
        System.out.println("Done!\n\n" +
                "Goodbye.");
    }

    /**
     * loads file in. user serilization and a file called saveFile.obj
     *
     * @param filename
     * @return
     * @throws IOException            issues with files general
     * @throws ClassNotFoundException issue with casting classes
     * @throws ClassCastException     save file of wrong type
     */
    public static AuctionTable load(String filename) throws IOException, ClassNotFoundException, ClassCastException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream inStream = new ObjectInputStream(file);
        Object object = inStream.readObject();
        if (!(object instanceof AuctionTable)) {
            throw new ClassCastException();
        }
        AuctionTable auctionTable = (AuctionTable) object;
        return auctionTable;
    }

    /**
     * save instance to saveFile.obj
     *
     * @param filename name of save file
     * @param saver    auction table to save
     * @throws IOException thrown if issue with files
     */
    public static void save(String filename, AuctionTable saver) throws IOException {
        System.out.println("Saving...");
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOutputStream);
        outStream.writeObject(saver);
        System.out.println("Saved");
    }

    /**
     * parser for inputs, deals with calling of methods, and errors
     *
     * @param username username of user
     * @return bool whether to stop
     */
    private boolean parser(String username) {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) ;
        String command = input.nextLine();
        if (command.toLowerCase().equals("d")) {
            System.out.print("Please enter a URL: ");
            String url = input.nextLine();
            try {
                auctionTable = auctionTable.buildFromURL(url);
                System.out.println("Loading...\n" +
                        "Auction data loaded successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("URL not correct.");
                return false;
            }
        } else if (command.toLowerCase().equals("a")) {
            System.out.println("Creating new Auction as " + username);
            System.out.print("Please enter an Auction ID: ");
            String auctionID = input.nextLine();
            System.out.print("Please enter an Auction time (hours): ");
            int timeRemaining = timeParser(input.nextLine());
            if (timeRemaining == -1) {
                System.out.println("Bad time input");
                return false;
            }
            System.out.print("Please enter some Item Info: ");
            String itemInfo = input.nextLine();
            Auction auction = new Auction(timeRemaining, 0, auctionID, username, "", itemInfo);
            auctionTable.put(auctionID, auction);
        } else if (command.toLowerCase().equals("b")) {
            System.out.print("Please enter an Auction ID: ");
            String auctionId = input.nextLine();
            if (auctionTable.containsKey(auctionId) && auctionTable.get(auctionId).getTimeRemaining() > 0) {
                System.out.println("Auction " + auctionId + " is OPEN\n" +
                        "\tCurrent Bid: $ " + auctionTable.get(auctionId).getCurrentBid());
                System.out.print("What would you like to bid?: ");
                double bitAmt = bidParser(input.nextLine());
                try {
                    System.out.println("auctionId = " + auctionId);
                    Auction auction = auctionTable.getAuction(auctionId);
                    auction.newBid(username, bitAmt);
                } catch (ClosedAuctionException e) {
                    System.out.println("Auction closed");
                    return false;
                } catch (BidTooLow bidTooLow) {
                    System.out.println("Bid too low");
                    return false;
                }
            } else if (!auctionTable.containsKey(auctionId)) {
                System.out.println("Auction ID doesn't exist");
                return false;
            } else {
                return false;
            }
        } else if (command.toLowerCase().equals("i")) {
            System.out.print("Please enter an Auction ID: ");
            String auctionId = input.nextLine();
            try {
                System.out.println(auctionTable.getAuction(auctionId));
            } catch (IllegalArgumentException e) {
                System.out.println("Auction ID doesn't exist");
                return false;
            }
        } else if (command.toLowerCase().equals("p")) {
            auctionTable.printTable();
        } else if (command.toLowerCase().equals("r")) {
            System.out.println("Removing expired auctions...\n" +
                    "All expired auctions removed.");
            auctionTable.removeExpiredAuctions();
        } else if (command.toLowerCase().equals("t")) {
            System.out.print("How many hours should pass: ");
            int numHours = timeParser(input.nextLine());
            try {
                auctionTable.letTimePass(numHours);
            } catch (IllegalArgumentException e) {
                System.out.println("Bad time input");
                return false;
            }
        } else if (command.toLowerCase().equals("q")) {
            return true;
        } else {
            System.out.println("Input not recognized");
        }
        return false;
    }

    /**
     * parses a time input
     *
     * @param inString string value of time
     * @return int in hours of time
     */
    private int timeParser(String inString) {
        int out;
        try {
            out = Integer.parseInt(inString);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (out < 0) {
            return -1;
        } else {
            return out;
        }
    }

    /**
     * parses a bid
     *
     * @param inString string value of bid
     * @return double value of bid
     */
    private double bidParser(String inString) {
        double out;
        try {
            out = Double.parseDouble(inString);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (out < 0) {
            return -1;
        } else {
            return out;
        }
    }
}
