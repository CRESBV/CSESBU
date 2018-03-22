/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named Stock that contains:
 *  A string data field named symbol for the stock’s symbol.
 *  A string data field named name for the stock’s name.
 *  A double data field named previousClosingPrice that stores the stock previous price for
 * the previous day.
 *  A double data field named currentPrice that stores the stock price for the current time.
 *  A constructor that creates a stock with the specified symbol and name.
 *  A method named getChangePercent() that returns the percentage changed from
 * previousClosingPrice to currentPrice.
 * Write a test program that creates a Stock object with the symbol ORCL, the name Oracle
 * Corporation, and the previous closing price of 34.5. Set a new current price to 34.35 and display
 * the price-change percentage.
 */
public class Stock {
    private String symbol, name;
    private double previousClosingPrice, currentPrice = 0;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public static void main(String[] args) {
        Stock testing = new Stock("ORCL", "Oracle");
        testing.setCurrentPrice(34.5);
        testing.setCurrentPrice(34.35);
        System.out.println("testing.getChangePercent() = " + testing.getChangePercent());
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        previousClosingPrice = this.currentPrice;
        this.currentPrice = currentPrice;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getChangePercent() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}
