import java.io.Serializable;

/**
 * @author edwardBucklerV
 * 111628438
 * Write a fully-documented class named Auction which represents an active auction currently in the database. The Auction class should contain member
 * variables for the seller's name, the current bid, the time remaining (in hours), current bidder's name, information about the item, and the unique ID for the
 * auction. In addition, the class should implement a toString() method, which should print all of the data members in a neat tabular form.
 * The Auction class can only be altered by a single member method called newBid(), which takes in the name of a bidder and their bid value. This method
 * checks to see if the bid value is greater than the current bid, and if it is, replaces the current bid and buyer name. There should be getter methods for each
 * member variable, however, no setters should be included.
 */


public class Auction implements Serializable {
    private int timeRemaining;
    private double currentBid;
    private String auctionID;
    private String sellerName;
    private String buyerName;
    private String itemInfo;

    /**
     * no arg constructor
     */
    public Auction() {
        timeRemaining = 0;
        currentBid = 0;
        auctionID = "";
        sellerName = "";
        buyerName = "";
        itemInfo = "";
    }

    /**
     * arg constructor
     *
     * @param timeRemaining
     * @param currentBid
     * @param auctionID
     * @param sellerName
     * @param buyerName
     * @param itemInfo
     */
    public Auction(int timeRemaining, double currentBid, String auctionID, String sellerName, String buyerName, String itemInfo) {
        this.timeRemaining = timeRemaining;
        this.currentBid = currentBid;
        this.auctionID = auctionID;
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.itemInfo = itemInfo;
    }

    /**
     * reduce time stop at 0
     *
     * @param time time to reduce by
     */
    public void decrementTimeRemaining(int time) {
        timeRemaining = (timeRemaining - time < 0) ? 0 : timeRemaining - time;
    }

    /**
     * add bid to auction
     *
     * @param bidderName name of new bidder
     * @param bidAmt     value of new bid
     * @throws ClosedAuctionException if auction closed AKA time = 0
     * @throws BidTooLow              new bid not higher than current bid
     */
    public void newBid(String bidderName, double bidAmt) throws ClosedAuctionException, BidTooLow {
        if (timeRemaining <= 0) {
            throw new ClosedAuctionException();
        }
        if (bidAmt > currentBid) {
            currentBid = bidAmt;
            buyerName = bidderName;
        } else {
            throw new BidTooLow();
        }
    }

    /**
     * get time
     *
     * @return time int
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * get bid
     *
     * @return bid double
     */
    public double getCurrentBid() {
        return currentBid;
    }

    /**
     * get id
     *
     * @return id string
     */
    public String getAuctionID() {
        return auctionID;
    }

    /**
     * get seller
     *
     * @return seller string
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * get buyer
     *
     * @return buyer string
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * get info
     *
     * @return info string
     */
    public String getItemInfo() {
        return itemInfo;
    }

    /**
     * to string, human readable table format
     *
     * @return string of general data
     */
    public String toString() {
        return String.format(" Auction ID |      Bid   |        Seller         |          Buyer          |    Time   " +
                        "|  Item Info\n"+"%12s|%12.2f|%23s|%25s|%11d|%30s\n", getAuctionID().replace("\n", ""),
                getCurrentBid(),
                getSellerName().replace("\n", ""), getBuyerName().replace("\n", ""), getTimeRemaining(),
                ((getItemInfo().length() > 30) ? getItemInfo().substring(0, 27).replace("\n", "") + "...":
                        getItemInfo().replace("\n", "")));
    }
}
