import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

/**
 * @author edwardBucklerV
 * 111628438
 * Write a fully-documented class named TrainlinkedList which implements a Double-Linked List ADT. The class should
 * contain references to the head and tail of the list, as well as a cursor variable (all TrainCarNode), and should
 * provide methods to perform insertion, deletion, search, and various other operations.
 */
public class TrainLinkedList {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_MAGENTA = "\u001b[35m";
    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private int trainSize;
    private double length;
    private double value;
    private double weight;
    private boolean dangerous;
    private int dangerousCount;

    /**
     * no arg constructor
     */
    public TrainLinkedList() {
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * gives out train car at cursor
     *
     * @return train car
     * @throws CursorNull
     */
    public TrainCar getCursorData() throws CursorNull {
        if (cursor != null) {
            return cursor.getCar();
        } else {
            throw new CursorNull();
        }
    }

    /**
     * sets the traincar data at cursor
     *
     * @param car
     * @throws CursorNull
     */
    public void setCursorData(TrainCar car) throws CursorNull {
        if (cursor != null) {
            length += car.getLength();
            weight += (car.getLoad().getWeight());
            value += car.getLoad().getValue();
            dangerousCount += (car.getLoad().isDangerous()) ? 1 : 0;
            dangerous = (dangerousCount != 0);
            cursor.setCar(car);
        } else {
            throw new CursorNull();
        }
    }

    /**
     * pushed cursor one car forward in list
     *
     * @throws CursorNull
     * @throws NextNull
     */
//    public void cursorForward() throws CursorNull, NextNull {
//        if (cursor != null && !cursor.isTail()) {
//            cursor = cursor.getNext();
//        } else if (cursor == null) {
//            throw new CursorNull();
//        } else {
//            throw new NextNull();
//        }
//    }

    public void cursorForward() throws CursorNull, NextNull {
        try{
            if (cursor != null && !cursor.isTail()) {
                cursor = cursor.getNext();
            } else if (cursor == null) {
                throw new Exception();
            } else {
                throw new Exception();
            }
        } catch(Exception e) {
            System.out.println("Oh no a big bad Exception!");
        }
    }

    /**
     * brings cursor back one car in list
     *
     * @throws PrevNull
     * @throws CursorNull
     */
    public void cursorBackward() throws PrevNull, CursorNull {
        if (cursor != null && cursor.getPrev() != null) {
            cursor = cursor.getPrev();
        } else if (cursor == null) {
            throw new CursorNull();
        } else {
            throw new PrevNull();
        }
    }

    /**
     * puts car after cursor
     *
     * @param newCar
     * @throws IllegalArgumentException
     */
    public void insertAfterCursor(TrainCar newCar) throws IllegalArgumentException {
        if (newCar == null) {
            throw new IllegalArgumentException();
        }
        //TODO: Turn this into method
        TrainCarNode newCarNode = new TrainCarNode(newCar);
        addCarData(newCar);
        if (cursor == null) { //if no elements
            cursor = newCarNode;
            tail = newCarNode;
            head = newCarNode;
            newCarNode.setHead(true);
            newCarNode.setTail(true);
        } else if (cursor.isTail()) { //if no element after (tail)
            tail = newCarNode;
            newCarNode.setPrev(cursor);
            cursor.setNext(newCarNode);
            cursor.setTail(false);
            cursor = newCarNode;
            newCarNode.setTail(true);
        } else { //if node after
            newCarNode.setNext(cursor.getNext());
            newCarNode.setPrev(cursor);
            cursor.getNext().setPrev(newCarNode);
            cursor.setNext(newCarNode);
            cursor = newCarNode;
        }
    }

    /**
     * removes car at cursor
     *
     * @return data on car removed
     * @throws CursorNull
     */
    public TrainCar removeCursor() throws CursorNull {
        TrainCar out = cursor.getCar();
        if (cursor == null) { //if cursor null
            throw new CursorNull();
        } else if (cursor.isHead() && cursor.isTail()) { // one element
            removeCarData(cursor.getCar());
            cursor = null;
            tail = null;
            head = null;
        } else if (cursor.isTail() && cursor.getPrev().isHead()) { // if tail and prev is head
            removeCarData(cursor.getCar());
            cursor.getPrev().setTail(true);
            cursor.getPrev().setNext(null);
            tail = cursor.getPrev();
            cursor = null;
            cursor = tail;
        } else if (cursor.isHead() && cursor.getNext().isTail()) { // if head and next is tail
            removeCarData(cursor.getCar());
            cursor.getNext().setHead(true);
            cursor.getNext().setPrev(null);
            head = cursor.getNext();
            cursor = null;
            cursor = head;
        } else if (cursor.isTail()) { //if tail
            removeCarData(cursor.getCar());
            cursor.getPrev().setTail(true);
            tail = cursor.getPrev();
            cursor.getPrev().setNext(null);
            cursor = null;
            cursor = tail;
        } else if (cursor.isHead()) { // if head
            removeCarData(cursor.getCar());
            cursor.getNext().setHead(true);
            head = cursor.getNext();
            cursor.getNext().setPrev(null);
            cursor = null;
            cursor = head;

        } else { //if middle
            removeCarData(cursor.getCar());
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            TrainCarNode temp = cursor.getNext();
            cursor = null;
            cursor = temp;
        }
        return out;
    }

    /**
     * for when removing a car
     *
     * @param trainCar
     */
    private void removeCarData(TrainCar trainCar) {
        length -= trainCar.getLength();
        weight -= (trainCar.getLoad().getWeight());
        trainSize--;
        value -= trainCar.getLoad().getValue();
        dangerousCount -= (trainCar.getLoad().isDangerous()) ? 1 : 0;
        dangerous = (dangerousCount != 0);
    }

    /**
     * for when adding a car
     *
     * @param trainCar
     */
    private void addCarData(TrainCar trainCar) {
        length += trainCar.getLength();
        weight += trainCar.getWeight();
        trainSize++;
        value += trainCar.getLoad().getValue();
        dangerousCount += (trainCar.getLoad().isDangerous()) ? 1 : 0;
        dangerous = (dangerousCount != 0);
    }

    /**
     * returns if list dangerous
     *
     * @return
     */
    public boolean isDangerous() {
        return dangerous;
    }

    /**
     * find and print all products of type in list
     *
     * @param name
     * @throws CursorNull
     */
    public void findProduct(String name) throws CursorNull {
        if (cursor == null) {
            throw new CursorNull();
        } else {
            boolean carFound = false;
            ProductLoad out = new ProductLoad();
            TrainCarNode temp = head;
            while (temp != null) {//TODO: might not be able to get to last one because might == null
                if (temp.getCar().getLoad().getName().equals(name)) {
                    carFound = true;
                    out.setDangerous(temp.getCar().getLoad().isDangerous());
                    try {
                        out.setValue(out.getValue() + temp.getCar().getLoad().getValue());
                        out.setWeight(out.getWeight() + temp.getCar().getLoad().getWeight());
                    } catch (BadInputValue badInputValue) {
                        System.out.println(ANSI_RED + "ERROR: Bad value in find product" + ANSI_RESET);
                    }
                }
                temp = temp.getNext();
            }
            if (carFound) {
                System.out.println("    Name      Weight (t)     Value ($)   Dangerous\n" +
                        "===================================================\n" + String.format("%9s%15.2f%14.2f%15s"
                        , name, out.getWeight(), out.getValue(), ((out.isDangerous()) ? ANSI_RED + "YES" :
                                ANSI_GREEN + "NO") + ANSI_RESET));
            } else {
                System.out.println(ANSI_YELLOW + "WARNING: Car with given name not found" + ANSI_RESET);
            }
        }
    }

    /**
     * get size
     *
     * @return size
     */
    public int getSize() {
        return trainSize;
    }

    /**
     * get length
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * get value
     *
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * get weight
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * output string of general data
     *
     * @return general data string
     */
    @Override
    public String toString() { //TODO: Make this better... Maybe... This looks good right?
        return "Train: " + trainSize + " cars, " + length + " meters, " + weight + " tons, $" + value + " value, " +
                ((dangerous) ? "is" : "not") + " dangerous.";
    }

    /**
     * prints out all cars in list
     *
     * @throws CursorNull
     */
    public void printManifest() throws CursorNull {
        TrainCarNode temp = head;
        System.out.println(listTop());
        int count = 1;
        if (temp == null) {
            throw new CursorNull();
        } else {
            while (temp != null) {
                System.out.printf(((temp == cursor) ? ANSI_MAGENTA : "") + "%4d" + temp + "\n" + ((temp == cursor) ?
                        ANSI_RESET : ""), count);
                temp = temp.getNext();
                count++;
            }
        }
    }

    /**
     * string for top of list
     *
     * @return string for top header
     */
    public String listTop() {
        return "CAR:\t\t\t\t\tLOAD:\t(cursor in purple)\n" +
                "Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous\n" +
                "==================================+===================================================";
    }

    /**
     * removes all dangerous cars from list
     *
     * @throws CursorNull
     */
    public void removeDangerousCars() throws CursorNull {
        if (cursor == null) {
            throw new CursorNull();
        } else {
            TrainCarNode temp = cursor;
            cursor = head;
            boolean done = false;
            while (!done) {
                if (cursor == null) {
                    done = true;
                } else if (cursor.getCar().getLoad().isDangerous()) {
                    removeCursor();
                } else if (!cursor.getCar().getLoad().isDangerous()) {
                    cursor = cursor.getNext();
                } else if (cursor == tail) {
                    if (tail.getCar().getLoad().isDangerous()) {
                        removeCursor();
                    }
                    done = true;
                }
            }
        }
        System.out.println(ANSI_YELLOW + "Deletion done cursor being put back to head." + ANSI_RESET);
        cursor = head;
    }
}
