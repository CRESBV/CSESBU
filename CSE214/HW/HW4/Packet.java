/**
 * @author edwardBucklerV
 * 111628438
 * This class represents a packet that will be sent through the network.
 */
public class Packet {
    private static int packetCount;

    private int id;
    private int packetSize;
    private int timeArrive;
    private int timeToDest;

    /**
     * constructor with args
     *
     * @param packetSize size (bytes)
     * @param timeArrive simulation unit when created
     * @param timeToDest time left to exit ir
     */
    public Packet(int packetSize, int timeArrive, int timeToDest) {
        id = ++packetCount;
        this.packetSize = packetSize;
        this.timeArrive = timeArrive;
        this.timeToDest = timeToDest;
    }

    /**
     * no arg constructor
     */
    public Packet() {
        id = ++packetCount;
    }

    /**
     * return num of packets
     *
     * @return pack count
     */
    public static int getPacketCount() {
        return packetCount;
    }

    /**
     * set packet count
     *
     * @param packetCount
     */
    public static void setPacketCount(int packetCount) {
        Packet.packetCount = packetCount;
    }

    /**
     * get id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get packet size
     *
     * @return packet size
     */
    public int getPacketSize() {
        return packetSize;
    }

    /**
     * set packet size
     *
     * @param packetSize
     */
    public void setPacketSize(int packetSize) {
        this.packetSize = packetSize;
    }

    /**
     * get time arrive
     *
     * @return time arrive
     */
    public int getTimeArrive() {
        return timeArrive;
    }

    /**
     * set time arrive
     *
     * @param timeArrive
     */
    public void setTimeArrive(int timeArrive) {
        this.timeArrive = timeArrive;
    }

    /**
     * get time to dest
     *
     * @return time to dest
     */
    public int getTimeToDest() {
        return timeToDest;
    }

    /**
     * set time to dest
     *
     * @param timeToDest
     */
    public void setTimeToDest(int timeToDest) {
        this.timeToDest = timeToDest;
    }

    /**
     * human readbale string of packet
     *
     * @return human readable string
     */
    @Override
//    TODO: make official
    public String toString() {
        return "[" + id + ", " + timeArrive + ", " + timeToDest + "]";
    }
}

