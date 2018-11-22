/**
 * @author edwardBucklerV
 * 111628438
 * This class represents a router in the network, which is ultimately a queue.
 * If you use a Java API class, you must use inheritance (extend a Java API class) to simplify the class
 * definition. To make it simple, we will use the same definitions for all the different types of intermediteRouters in the
 * network.
 */

import java.util.ArrayList;

public class Router extends ArrayList<Packet> {
    private int id;
    private int maxBufferSize;

    /**
     * constructor no arg
     */
    public Router() {
        id = 1;
        maxBufferSize = 1;
    }

    /**
     * arg constructor
     *
     * @param id
     * @param maxBufferSize
     */
    public Router(int id, int maxBufferSize) {
        this.id = id;
        this.maxBufferSize = maxBufferSize;
    }

    /**
     * returns which router (id) the data needs to go
     *
     * @param routers
     * @return int value of id where to be placed
     * @throws RouterEmpty does this if routers has nothing in it
     * @throws RouterFull  does this if all routers full
     */
    public static int sendPacketTo(ArrayList<Router> routers) throws RouterEmpty, RouterFull {
        if (routers.isEmpty()) {
            throw new RouterEmpty();
        } else {
            Router max = routers.get(0);
            for (int i = 1; i < routers.size(); i++) {
                if (routers.get(i).getMaxBufferSize() - routers.get(i).size() > max.getMaxBufferSize() - max.size()) {
                    max = routers.get(i);
                }
            }
            if (max.getMaxBufferSize() - max.size() == 0) {
                throw new RouterFull();
            } else {
                return max.getId();
            }
        }
    }

    /**
     * add packet to last pos
     *
     * @param packet
     */
    public void enqueue(Packet packet) {
        add(packet);
    }

    /**
     * remove from front
     *
     * @return what got removed
     * @throws RouterEmpty does this if dequeue from empty
     */
    public Packet dequeue() throws RouterEmpty {
        if (!isEmpty()) {
            return (Packet) remove(0);

        } else {
            throw new RouterEmpty();
        }
    }

    /**
     * peeks first packet
     *
     * @return first packet
     */
    public Packet peek() {
        return (Packet) get(0);
    }

    /**
     * get size
     *
     * @return size
     */
    public int size() {
        return super.size();
    }

    /**
     * bool if empty
     *
     * @return bool empty
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * to string
     *
     * @return string human readable
     */
    @Override
    public String toString() {
        return ((size() > 0) ? get(0).toString() : "") + ((size() > 1) ? get(1).toString() : "") + ((size() > 3) ? "." +
                ".." : "") + ((size() > 2) ? get(size() - 1).toString() : "");
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
     * get buffered size
     *
     * @return buffered size
     */
    public int getMaxBufferSize() {
        return maxBufferSize;
    }

    /**
     * set max buffer
     *
     * @param maxBufferSize
     */
    public void setMaxBufferSize(int maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
    }
}
