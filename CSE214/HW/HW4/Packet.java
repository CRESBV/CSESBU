/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * This class represents a packet that will be sent through the network.
 */
public class Packet {
    private static int packetCount;

    private int id;
    private int packetSize;
    private int timeArrive;
    private int timeToDest;

    public Packet(int packetSize, int timeArrive, int timeToDest) {
        id = ++packetCount;
        this.packetSize = packetSize;
        this.timeArrive = timeArrive;
        this.timeToDest = timeToDest;
    }

    public Packet() {
        id = ++packetCount;
    }

    public static int getPacketCount() {
        return packetCount;
    }

    public static void setPacketCount(int packetCount) {
        Packet.packetCount = packetCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(int packetSize) {
        this.packetSize = packetSize;
    }

    public int getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(int timeArrive) {
        this.timeArrive = timeArrive;
    }

    public int getTimeToDest() {
        return timeToDest;
    }

    public void setTimeToDest(int timeToDest) {
        this.timeToDest = timeToDest;
    }

    @Override
//    TODO: make official
    public String toString() {
        return "Packet{" +
                "id=" + id +
                ", timeArrive=" + timeArrive +
                ", timeToDest=" + timeToDest +
                '}';
    }
}

