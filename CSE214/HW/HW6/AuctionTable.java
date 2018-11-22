import big.data.DataSource;
import big.data.DataSourceException;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author edwardBucklerV
 * 111628438
 * The database of open auctions will be stored in a hash table to provide constant time insertion and deletion. Use the auctionID as the key for the corresponding
 * Auction object. In this assignment, you may provide your own implementation for the AuctionTable class, or you may use a hash table implementation
 * provided by the Java API.
 */

public class AuctionTable extends HashMap<String, Auction> implements Serializable {
    /**
     * builds hash from url
     *
     * @param URL
     * @return an auction table built from target url
     * @throws IllegalArgumentException not good url
     */
    public static AuctionTable buildFromURL(String URL) throws IllegalArgumentException {
        try {
            DataSource ds = DataSource.connect(URL).load();
            String[] idNumArr = ds.fetchStringArray("listing/auction_info/id_num");
            String[] bidArr = ds.fetchStringArray("listing/auction_info/current_bid");
            String[] sellerArr = ds.fetchStringArray("listing/seller_info/seller_name");
            String[] buyerArr = ds.fetchStringArray("listing/auction_info/high_bidder/bidder_name");
            String[] timeArr = ds.fetchStringArray("listing/auction_info/time_left");
            String[] itemInfoArr = ds.fetchStringArray("listing/item_info/description");
            AuctionTable auctionTable = new AuctionTable();
            int[] timeArrInt = new int[timeArr.length];
            System.out.println("URL recognized, " + idNumArr.length + " auction(s) recognized, adding new ID's to " +
                    "table");
            for (int i = 0; i < timeArr.length; i++) {
                int num = 0;
                String[] timeSplitArr = timeArr[i].split(" ");
                for (int j = 0; j < timeSplitArr.length; j++) {
                    try {
                        num = Integer.parseInt(timeSplitArr[j]);
                        if (timeSplitArr[j + 1].length() >= 3 && timeSplitArr[j + 1].substring(0, 3).equals("day"))
                            num *= 24;
                    } catch (NumberFormatException nfe) {
                        //This is intentionally blank as it means that have hit a non int in list
                    }
                }
                timeArrInt[i] = num;
            }

            for (int i = 0; i < idNumArr.length; i++) {
                auctionTable.put(idNumArr[i], new Auction(timeArrInt[i],
                        Double.parseDouble(bidArr[i].substring(1).replace(",", "")), idNumArr[i],
                        sellerArr[i], buyerArr[i], itemInfoArr[i].replace("\n", "")));
            }
            return auctionTable;
        } catch (DataSourceException dse) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * put auction into hash
     *
     * @param auctionID name of new auction
     * @param auction   new auction
     * @throws IllegalArgumentException if id already used
     */
    public void putAuction(String auctionID, Auction auction) throws IllegalArgumentException {
        if (!containsKey(auctionID)) {
            throw new IllegalArgumentException();
        }
        put(auctionID, auction);
    }

    /**
     * get auction
     *
     * @param auctionID
     * @return get auction
     * @throws IllegalArgumentException bad id
     */
    public Auction getAuction(String auctionID) throws IllegalArgumentException {
        if (get(auctionID) == null) {
            throw new IllegalArgumentException();
        }
        return (Auction) get(auctionID);
    }

    /**
     * let time pass. AKA lowers time by set amount of all auctions
     *
     * @param numHours hours to change
     * @throws IllegalArgumentException throws if value < 0
     */
    public void letTimePass(int numHours) throws IllegalArgumentException {
        if (numHours < 0) {
            throw new IllegalArgumentException();
        }
        forEach((key, value) -> {
            try {
                value.decrementTimeRemaining(numHours);
            } catch (NullPointerException e) {
                //this is intentionally left blank as I simply want to skip null values
            }
        });

    }

    /**
     * removes all auctions at time 0
     */
    public void removeExpiredAuctions() {
        entrySet().removeIf(auctions -> auctions.getValue().getTimeRemaining() == 0);

    }

    /**
     * print in human readable format
     */
    public void printTable() {
        System.out.println(" Auction ID |      Bid   |        Seller         |          Buyer          |    Time   |  Item Info");
        forEach((key, values) -> {
            System.out.printf("%12s|%12.2f|%23s|%25s|%11d|%30s\n", values.getAuctionID().replace("\n", ""),
                    values.getCurrentBid(),
                    values.getSellerName().replace("\n", ""), values.getBuyerName().replace("\n", ""), values.getTimeRemaining(),
                    ((values.getItemInfo().length() > 30) ? values.getItemInfo().substring(0, 27).replace("\n", "") + "...":
                            values.getItemInfo().replace("\n", "")));
        });

    }

}
