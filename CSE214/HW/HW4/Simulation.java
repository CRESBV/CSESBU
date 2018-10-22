import java.util.ArrayList;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * This class contains the main method that tests your simulation. You
 * should not use hard-coded numbers. Instead, all values should be received from user input.
 */
public class Simulation {
    private Router dispatcher;
    ArrayList<Router> routers;
    private int totalServiceTime;
    private int packetsDropped;
    private int totalPacketsArrived;
    private double arrivalProb;
    private int numIntRouters;
    private int maxBufferSize;
    private int minPacketSize;
    private int maxPacketSize;
    private int bandwith;
    private int duration;

    private int randInt(int minVal, int maxVal) {
        return (int) (Math.random() * (maxVal + 1) + minVal);
    }


}
