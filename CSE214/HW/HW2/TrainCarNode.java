/**
 * @author edwardBucklerV
 * 111628438
 * node level for a train car. Takes care of the next, previous, tail and head
 */
public class TrainCarNode {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private TrainCarNode prev;
    private TrainCarNode next;
    private TrainCar car;
    private boolean isTail;
    private boolean isHead;

    /**
     * no arg constructor
     */
    public TrainCarNode() {
        isHead = false;
        isTail = false;
        prev = null;
        next = null;
        car = new TrainCar();
    }

    /**
     * arg car constructor
     * @param car
     */
    public TrainCarNode(TrainCar car) {
        this.car = car;
    }

    /**
     * all arg constructor
     * @param prev
     * @param next
     * @param car
     */
    public TrainCarNode(TrainCarNode prev, TrainCarNode next, TrainCar car) {
        this.prev = prev;
        this.next = next;
        this.car = car;
    }

    /**
     * get prev
     * @return prev
     */
    public TrainCarNode getPrev() {
        return prev;
    }

    /**
     * set prev
     * @param prev
     */
    public void setPrev(TrainCarNode prev) {
        this.prev = prev;
    }

    /**
     * get next
     * @return next
     */
    public TrainCarNode getNext() {
        return next;
    }

    /**
     * set next
     * @param next
     */
    public void setNext(TrainCarNode next) {
        this.next = next;
    }

    /**
     * get car
     * @return car
     */
    public TrainCar getCar() {
        return car;
    }

    /**
     * set car
     * @param car
     */
    public void setCar(TrainCar car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return String.format("%12.2f%14.2f  |%10s%14.2f%14.2f%21s", getCar().getLength(), getCar().getWeight(),
                ((getCar().getLoad().getName().isEmpty() || getCar().getLoad().getName() == null) ? "Empty" :
                        getCar().getLoad().getName()), getCar().getLoad().getWeight(), getCar().getLoad().getValue(),
                ((getCar().getLoad().isDangerous()) ? ANSI_RED + "YES" : ANSI_GREEN + "NO") + ANSI_RESET);
    }

    /**
     * get tail
     * @return tail
     */
    public boolean isTail() {
        return isTail;
    }

    /**
     * set tail
     * @param tail
     */
    public void setTail(boolean tail) {
        isTail = tail;
    }

    /**
     * get head
     * @return head
     */
    public boolean isHead() {
        return isHead;
    }

    /**
     *  set head
     * @param head
     */
    public void setHead(boolean head) {
        isHead = head;
    }
}
