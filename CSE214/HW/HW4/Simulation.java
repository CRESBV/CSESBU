import java.util.ArrayList;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * This class contains the main method that tests your simulation. You
 * should not use hard-coded numbers. Instead, all values should be received from user input.
 */
public class Simulation {
    private static ArrayList<Router> routers; //intermediate
    private static Router dispatcher; //Start router
    private static int totalServiceTime; //All time (man hours vs hours)
    private static int packetsDropped; //when ints are full
    private static int totalPacketsArrived; //At end of simulation
    private static double arrivalProb; //Set by user
    private static int numIntRouters; //Set by user
    private static int maxBufferSize; //Set by user
    private static int minPacketSize; //Set by user
    private static int maxPacketSize; //Set by user
    private static int bandwith; //Set by user
    private static int duration; //Set by user

    private int randInt(int minVal, int maxVal) {
        return (int) (Math.random() * (maxVal + 1) + minVal);
    }

    public double simulate() throws RouterEmpty {
        for (int currTime = 1; currTime <= duration; currTime++) {
            System.out.println("Time:" + currTime);
            ArrayList<Packet> packets = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (Math.random() > arrivalProb) {
                    int size = randInt(minPacketSize, maxBufferSize);
                    packets.add(new Packet(size, currTime, size / 100));
                    System.out.println("Packet " + packets.get(j).getId() + " arrives at dispatcher with size " + size + ".");
                }
            }

            for (Packet pack : packets) {
                int routerTar = 0; //throws RouterEmpty, RouterFull
                try {
                    routerTar = Router.sendPacketTo(routers);
                } catch (RouterFull routerFull) {
                    routerFull.printStackTrace();
                }
                System.out.println("Packet " + pack.getId() + " sent to Router " + routerTar + ".");
                routers.get(routerTar).enqueue(pack);
            }
        }
    }


}
