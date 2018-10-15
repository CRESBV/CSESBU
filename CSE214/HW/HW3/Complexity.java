/**
 * @author edwardBucklerV
 * 111628438
 * Big-Oh complexity of some block of code. Since Big-Oh notation can get quite messy (e.g. log(n^(1/2) / n!)), we will
 * restrict the possible orders to powers of two base types: n, and log_n. Following this practice, include two member
 * variables in the Complexity class: nPower (int) and logPower (int). These two variables will keep track of what power
 * each of the base types is present in the complexity object.
 */
public class Complexity {
    private int nPower;
    private int logPower;

    /**
     * no arg constructor
     */
    public Complexity() {
        nPower = 0;
        logPower = 0;
    }

    /**
     * arg constructor
     * @param nPower
     * @param logPower
     */
    public Complexity(int nPower, int logPower) {
        this.nPower = nPower;
        this.logPower = logPower;
    }

    /**
     * get n power
     * @return nPower
     */
    public int getnPower() {
        return nPower;
    }

    /**
     * set n power
     * @param nPower
     */
    public void setnPower(int nPower) {
        this.nPower = nPower;
    }

    /**
     * get logPower
     * @return logPower
     */
    public int getLogPower() {
        return logPower;
    }

    /**
     * set log power
     * @param logPower
     */
    public void setLogPower(int logPower) {
        this.logPower = logPower;
    }

    /**
     * to string
     * @return string of complexity
     */
    @Override
    public String toString() {
        return "O(" + ((nPower == 0 && logPower == 0) ? "1" : "") + ((nPower == 1) ? "n" : "") + ((nPower > 1) ?
                "n^" + nPower : "") + ((logPower > 0 && nPower > 0) ? " * " : "") + ((logPower == 1) ? "log(n)" : "") +
                ((logPower > 1) ? "log(n)^" + logPower : "") + ")";
    }
}


