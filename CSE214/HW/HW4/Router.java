/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * This class represents a router in the network, which is ultimately a queue.
 * If you use a Java API class, you must use inheritance (extend a Java API class) to simplify the class
 * definition. To make it simple, we will use the same definitions for all the different types of routers in the
 * network.
 */

import sun.invoke.empty.Empty;

import java.util.ArrayList;

public class Router extends ArrayList {
    private int id;
    private int maxBufferSize;

    public Router() {
        id = 1;
        maxBufferSize = 1;
    }

    public Router(int id, int maxBufferSize) {
        this.id = id;
        this.maxBufferSize = maxBufferSize;
    }

    public void enqueue(Packet packet) {
        add(packet);
    }

    public Packet dequeue() throws RouterEmpty {
        if (!isEmpty()) {
            return (Packet) remove(0);

        } else {
            throw new RouterEmpty();
        }
    }

    public Packet peek() {
        return (Packet) get(0);
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
//    TODO: make official
    public String toString() {
        return super.toString();
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxBufferSize() {
        return maxBufferSize;
    }

    public void setMaxBufferSize(int maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
    }
}
