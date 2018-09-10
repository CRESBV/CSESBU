import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author edwardBucklerV
 * Question 3= I do understand that this was supposed to be done in python (noting the input of the program) but I'm
 * not feeling that.
 */
public class Node {
    String val;
    Node left = null;
    Node right = null;

    public Node(String val) {
        this.val = val;
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void deSerialise(String line) {
        String command = "Node node = ";

        //get all names
        ArrayList<String> namesOfNodes = new ArrayList<>();
        for (int i = 0; i < line.length() - 2; i++) {
            if (line.substring(i, i + 3).equals("val")) {
                String nodeName = "";
                i += 6;
                while (true) {
                    char curChar = line.charAt(i);
                    if (curChar != ' ') {
                        nodeName += curChar;
                    } else {
                        break;
                    }
                    i++;
                }
                namesOfNodes.add(nodeName);
            }
        }

        // get all nulls node (name, left(name of), right(name of))
        String[][] nodeStructure = new String[namesOfNodes.size()][3];
        for (int i = 0; i < nodeStructure.length; i++) {
            nodeStructure[i][0] = namesOfNodes.get(i);
            nodeStructure[i][1] = (!line.contains(" (" + "'" + namesOfNodes.get(i) + "'" + " left = )")) ? "" : "null";
            nodeStructure[i][2] = (!line.contains(" (" + "'" + namesOfNodes.get(i) + "'" + " right = )")) ? "" : "null";
        }

        // get all non nulls
        for (int i = 0; i < nodeStructure.length; i++) {
            if (nodeStructure[i][1] != "null") {
                String nodeName = "";
                String leftTarString = "'" + nodeStructure[i][0] + "' left = [val = ";
                int leftStInt = line.indexOf(leftTarString) + leftTarString.length();
                int cur = leftStInt;
                while (true) {
                    char curChar = line.charAt(cur);
                    if (curChar != ' ') {
                        nodeName += curChar;
                    } else {
                        break;
                    }
                    cur++;
                }
                nodeStructure[i][1] = nodeName;
            }
            if (nodeStructure[i][2] != "null") {
                String nodeName = "";
                String rightTarString = "'" + nodeStructure[i][0] + "' right = [val = ";
                int rightStInt = line.indexOf(rightTarString) + rightTarString.length();
                int cur = rightStInt;
                while (true) {
                    char curChar = line.charAt(cur);
                    if (curChar != ' ') {
                        nodeName += curChar;
                    } else {
                        break;
                    }
                    cur++;
                }
                nodeStructure[i][2] = nodeName;
            }
        }

        System.out.println(Arrays.deepToString(nodeStructure));

        // Create Command
        command += createNodeString(nodeStructure, 0);

        System.out.println(Arrays.deepToString(nodeStructure));

        command += ");";
        System.out.println("command: " + command);
    }

    private static int getIndexOf(String[][] list, String target) {
        System.out.println("Searching for: "+target);

        for (int i = 0; i < list.length; i++) {
            if (list[i][0].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    private static String createNodeString(String[][] list, int curList) {
        System.out.println("curList = " + curList);
        return "new Node(" + list[curList][0] + ", " +
                ((list[curList][1] != null) ? (createNodeString(list, getIndexOf(list, list[curList][1]))) : "null")
                + ", " +
                ((list[curList][2] != null) ? (createNodeString(list, getIndexOf(list, list[curList][2]))) : "null");
    }

    public String getVal() {
        return val;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node addLeft(String newVal) {
        left = new Node(newVal);
        return left;

    }

    public Node addRight(String newVal) {
        right = new Node(newVal);
        return right;
    }

    /**
     * @return string prints out all sub nodes
     */
    public String serialize() {
        return "[val = " + val + " (" + "'" + val + "'" + " left = " + ((hasLeft()) ? getLeft().serialize() : "") +
                ")" + " (" + "'" + val + "'" + " right = " + ((hasRight()) ? getRight().serialize() : "") + ")" + "]";
    }

    public boolean hasLeft() {
        return (left != null);
    }

    public boolean hasRight() {
        return (right != null);
    }
}

class NodeDriver {
    public static void main(String[] args) {
        Node node = new Node("root", new Node("B", new Node("C"), null), new Node("D"));
        System.out.println(node.serialize());
        Node.deSerialise(node.serialize());

    }
}

