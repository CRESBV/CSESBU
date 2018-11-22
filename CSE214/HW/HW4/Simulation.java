import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author edwardBucklerV
 * 111628438
 * This class contains the main method that tests your simulation. You
 * should not use hard-coded numbers. Instead, all values should be received from user input.
 */
public class Simulation {
    public ArrayList<Router> intermediteRouters; //intermediate acting as priority queues
    public Router dispatcher; //Start router
    public ArrayList<Integer> destArrList; //Start router
    public int totalServiceTime; //All time (man hours vs hours)
    public int packetsDropped; //when ints are full
    public int totalPacketsArrived; //At end of simulation
    public double arrivalProb; //Set by user
    public int numIntRouters; //Set by user
    public int maxBufferSize; //Set by user
    public int minPacketSize; //Set by user
    public int maxPacketSize; //Set by user
    public int bandwith; //Set by user
    public int duration; //Set by user

    /**
     * main method takes care of all input values
     *
     * @param args
     */
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Starting simulator...");
        while (!quit) {
            try {
                System.out.print("Enter the number intermediate routers: ");
                simulation.numIntRouters = Integer.parseInt(input.nextLine());
                System.out.print("Enter the arrival probability of a packet: ");
                simulation.arrivalProb = Double.parseDouble(input.nextLine());
                if (simulation.arrivalProb >= 1 || simulation.arrivalProb < 0) {
                    throw new BadInputValue();
                }
                System.out.print("Enter the maximum buffer size of a router: ");
                simulation.maxBufferSize = Integer.parseInt(input.nextLine());
                if (simulation.maxBufferSize <= 0) {
                    throw new BadInputValue();
                }
                System.out.print("Enter the minimum size of a packet: ");
                simulation.minPacketSize = Integer.parseInt(input.nextLine());
                if (simulation.minPacketSize < 0) {
                    throw new BadInputValue();
                }
                System.out.print("Enter the maximum size of a packet: ");
                simulation.maxPacketSize = Integer.parseInt(input.nextLine());
                if (simulation.minPacketSize > simulation.maxPacketSize || simulation.maxPacketSize <= 0) {
                    throw new BadInputValue();
                }
                System.out.print("Enter the bandwidth size: ");
                simulation.bandwith = Integer.parseInt(input.nextLine());
                if (simulation.bandwith <= 0) {
                    throw new BadInputValue();
                }
                System.out.print("Enter the simulation duration: ");
                simulation.duration = Integer.parseInt(input.nextLine());
                if (simulation.duration <= 0) {
                    throw new BadInputValue();
                }

                simulation.simulate();

                System.out.print("Do you want to try another simulation? (y/n): ");
                if (input.nextLine().equalsIgnoreCase("n")) {
                    quit = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Error: Bad input value type.");
            } catch (BadInputValue badInputValue) {
                System.out.println("Error: Bad input value");
            }

        }

        input.close();
        System.out.println("Program terminating successfully...");
    }

    /**
     * generates rand int
     *
     * @param minVal
     * @param maxVal
     * @return rand int between min and max
     */
    private int randInt(int minVal, int maxVal) {
        return (int) ((Math.random() * (maxVal + 1)) + minVal);
    }

    /**
     * runs the simulation. Takes care of all printing. Must take care if inputs outside.
     *
     * @return average
     */
    public double simulate() {
        intermediteRouters = new ArrayList<>();
        dispatcher = new Router();
        destArrList = new ArrayList<>();
        //creates ir
        for (int i = 1; i <= numIntRouters; i++) {
            Router temp = new Router(i, maxBufferSize);
            intermediteRouters.add(temp);
        }
        try {
            //loop for duration amount
            for (int currTime = 1; currTime <= duration; currTime++) {
                System.out.println("Time:" + currTime); // print time
                //loop three times to see how many new packets are added
                for (int j = 0; j < 3; j++) {
                    if (Math.random() < arrivalProb) {
                        int size = randInt(minPacketSize, maxPacketSize);
                        dispatcher.add(new Packet(size, currTime, size / 100));
                        System.out.println("Packet " + dispatcher.get(dispatcher.size() - 1).getId() + " arrives at dispatcher with size " + size + ".");
                    }
                }
                //if there are elements to be sent through into the ir
                if (dispatcher.size() > 0) {
                    while (!dispatcher.isEmpty()) {
                        int routerTar = 0; //throws RouterEmpty, RouterFull
                        try {
                            routerTar = Router.sendPacketTo(intermediteRouters);
                            System.out.println("Packet " + dispatcher.peek().getId() + " sent to Router " + routerTar + ".");
                            intermediteRouters.get(routerTar - 1).enqueue(dispatcher.dequeue());
                        } catch (RouterFull routerFull) {
                            packetsDropped++;
                            System.out.println("Network is congested. Packet " + dispatcher.dequeue().getId() + " is dropped.");
                        }
                    }
                } else {
                    System.out.println("No packets arrived.");
                }

                //Go through all decrement time to dest
                for (Router currRouter : intermediteRouters) {
                    if (currRouter.size() > 0) {
                        if (currRouter.peek().getTimeArrive() != currTime) {
                            currRouter.peek().setTimeToDest(currRouter.peek().getTimeToDest() - 1);

                        }
                        if (currRouter.peek().getTimeToDest() <= 0 && !destArrList.contains(currRouter.getId())) {
                            destArrList.add(currRouter.getId()); //NOTE not starting at 0 here.
                        }
                    }
                }

                //based on what in destination queue unload from intermediteRouters
                for (int i = 0; i < bandwith; i++) {
                    if (!destArrList.isEmpty()) {
                        Packet temp = intermediteRouters.get(destArrList.remove(0) - 1).dequeue();
                        totalServiceTime += currTime - temp.getTimeArrive();
                        totalPacketsArrived++;
                        System.out.println("Packet " + temp.getId() + " has successfully reached its destination: +" + (currTime - temp.getTimeArrive()));
                    }
                }

                //print
                for (int i = 0; i < intermediteRouters.size(); i++) {
                    System.out.println(intermediteRouters.get(i).getId() + ": " + intermediteRouters.get(i).toString());
                }
            }
            double average = (totalPacketsArrived != 0) ? totalServiceTime / totalPacketsArrived : 0;
            System.out.println("Simulation ending...");
            System.out.println("Total service time: " + totalServiceTime);
            System.out.println("Total packets served: " + totalPacketsArrived);
            System.out.println("Average service time per packet: " + average);
            System.out.println("Total packets dropped: " + packetsDropped);
            return average;
        } catch (RouterEmpty routerEmpty) {
            routerEmpty.printStackTrace();
            System.out.println("\nError: No intermediate intermediteRouters or router empty and dequeue tried. Restarting.\n");
            return 0;
        }



    }


}
