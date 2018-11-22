import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

/**
 * @author edwardBucklerV
 * 111628438
 * The class should contain a reference to the root of the tree, a cursor for the present working directory, and various
 * methods for insertion and deletion.
 */
public class DirectoryTree {
    private DirectoryNode root;
    private DirectoryNode cursor;

    /**
     * no arg constructor
     */
    public DirectoryTree() {
        root = new DirectoryNode();
        cursor = root;
    }

    /**
     * cursor set to root
     */
    public void resetCursor() {
        cursor = root;
    }

    /**
     * change dir. Can target any dir or default to those below it
     *
     * @param name
     * @throws NotADirectoryException really big problem if this happens. somehow means that cursor is in file
     */
    public void changeDirectory(String name) throws NotADirectoryException {
        if (!name.contains("/")) name = presentWorkingDirectory(getCursor()) + "/" + name;
        cursor = find(name);
    }

    /**
     * find node
     *
     * @param name
     * @return the trageted node
     * @throws NotADirectoryException   really big problem if this happens. somehow means that cursor is in file
     * @throws IllegalArgumentException file doesn't exist
     */
    public DirectoryNode find(String name) throws NotADirectoryException, IllegalArgumentException {
        String[] nameList = name.split("/");
        DirectoryNode pointer = root;
        for (int i = 1; i < nameList.length; i++) {
            pointer = findHelper(nameList[i], pointer);
            if (pointer == null) throw new IllegalArgumentException();
        }
        if (pointer.isFile()) throw new NotADirectoryException();
        else return pointer;
    }

    /**
     * recursive helper method for find
     *
     * @param target
     * @param node
     * @return node of target or intermediate node
     */
    public DirectoryNode findHelper(String target, DirectoryNode node) {
        DirectoryNode pointer = node;
        while (pointer != null) {
            if (pointer.getChild1() != null && pointer.getChild1().getName().equals(target)) return pointer.getChild1();
            else if (pointer.getChild2() != null && pointer.getChild2().getName().equals(target))
                return pointer.getChild2();
            else if (pointer.getChild3() != null && pointer.getChild3().getName().equals(target))
                return pointer.getChild3();
            pointer = pointer.getSibling();
        }
        return null;
    }

    /**
     * string of current dir
     *
     * @param node
     * @return string dir path
     */
    public String presentWorkingDirectory(DirectoryNode node) {
        DirectoryNode pointer = node;
        String out = "";
        while (pointer != null) {
            out = pointer.getName() + "/" + out;
            pointer = pointer.getParent();
        }
        return out.substring(0, out.length() - 1);
    }

    /**
     * Used to blind search all
     * @param node
     * @param target
     * @return node of target
     */
    public boolean searchAll(DirectoryNode node, String target) {
        if (node.getName().equals(target) && node==root) {
            System.out.println(presentWorkingDirectory(node));
            return true; //root case
        }
        Boolean targetFound = false;
        DirectoryNode pointer = node;
        while (pointer != null) {
            if (pointer.getChild1() != null && !pointer.getChild1().isFile())
                if(pointer.getChild1().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild1()));
                    searchAll(pointer.getChild1(), target);
                    targetFound = true;
                } else targetFound = searchAll(pointer.getChild1(), target);
            if (pointer.getChild2() != null && !pointer.getChild2().isFile())
                if(pointer.getChild2().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild2()));
                    searchAll(pointer.getChild2(), target);
                    targetFound = true;
                } else targetFound = searchAll(pointer.getChild2(), target);
            if (pointer.getChild3() != null && !pointer.getChild3().isFile())
                if(pointer.getChild3().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild3()));
                    searchAll(pointer.getChild3(), target);
                    targetFound = true;
                } else targetFound = searchAll(pointer.getChild3(), target);
            pointer = pointer.getSibling();
        }
        pointer = node;
        while (pointer != null) {
            if (pointer.getChild1() != null && pointer.getChild1().isFile() )
                if(pointer.getChild1().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild1()));
                    targetFound = true;
                }
            if (pointer.getChild2() != null && pointer.getChild2().isFile() )
                if(pointer.getChild2().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild2()));
                    targetFound = true;
                }
            if (pointer.getChild3() != null && pointer.getChild3().isFile() )
                if(pointer.getChild3().getName().equals(target)) {
                    System.out.println(presentWorkingDirectory(pointer.getChild3()));
                    targetFound = true;
                }
            pointer = pointer.getSibling();
        }
        return targetFound;
    }

    /**
     * list all files/dirs in current dir
     *
     * @return string dirs/files
     */
    public String listDirectory() {
        DirectoryNode pointer = cursor;
        String out = "";
        while (pointer != null) {
            if (pointer.getChild1() != null) out += pointer.getChild1().getName() + " ";
            if (pointer.getChild2() != null) out += pointer.getChild2().getName() + " ";
            if (pointer.getChild3() != null) out += pointer.getChild3().getName() + " ";
            pointer = pointer.getSibling();
        }
        return out;
    }

    /**
     * PLEASE NOTE that FullDirectoryException is NOT used here because my system never runs into that problem.
     *
     * @param name
     * @throws IllegalArgumentException has a space or / in name
     */
    public void makeFile(String name) throws IllegalArgumentException, NotADirectoryException, FullDirectoryException {
        if (name.contains("/") || name.contains(" ")) throw new IllegalArgumentException();
        else cursor.addChild(new DirectoryNode(cursor, name, true));
    }

    /**
     * AGAIN PLEASE NOTE that FullDirectoryException is NOT used here because my system never runs into that problem.
     *
     * @param name
     * @throws IllegalArgumentException has space or / in it
     * @throws NotADirectoryException   really big problem if this happens. somehow means that cursor is in file
     */
    public void makeDirectory(String name) throws IllegalArgumentException, NotADirectoryException, FullDirectoryException {
        if (name.contains("/") || name.contains(" ")) throw new IllegalArgumentException();
        else cursor.addChild(new DirectoryNode(cursor, name, false));
    }

    /**
     * list all in human readable way
     *
     * @param node
     * @param out
     * @param level
     * @return string of all elements
     */
    public String listAll(DirectoryNode node, String out, int level) {
        DirectoryNode pointer = node;
        out += new String(new char[level]).replace("\0", "\t") + "|- " + node.getName() + "\n";
        while (pointer != null) {
            if (pointer.getChild1() != null && !pointer.getChild1().isFile())
                out = listAll(node.getChild1(), out, level + 1);
            if (pointer.getChild2() != null && !pointer.getChild2().isFile())
                out = listAll(node.getChild2(), out, level + 1);
            if (pointer.getChild3() != null && !pointer.getChild3().isFile())
                out = listAll(node.getChild3(), out, level + 1);
            pointer = pointer.getSibling();
        }
        pointer = node;
        while (pointer != null) {
            if (pointer.getChild1() != null && pointer.getChild1().isFile())
                out += new String(new char[level + 1]).replace("\0", "\t") + "- " + pointer.getChild1().getName() +
                        "\n";
            if (pointer.getChild2() != null && pointer.getChild2().isFile())
                out += new String(new char[level + 1]).replace("\0", "\t") + "- " + pointer.getChild2().getName() +
                        "\n";
            if (pointer.getChild3() != null && pointer.getChild3().isFile())
                out += new String(new char[level + 1]).replace("\0", "\t") + "- " + pointer.getChild3().getName() +
                        "\n";
            pointer = pointer.getSibling();
        }
        return out;
    }

    /**
     * get root
     *
     * @return root node
     */
    public DirectoryNode getRoot() {
        return root;
    }

    /**
     * set root
     *
     * @param root
     */
    public void setRoot(DirectoryNode root) {
        this.root = root;
    }

    /**
     * get cursor
     *
     * @return cursor node
     */
    public DirectoryNode getCursor() {
        return cursor;
    }

    /**
     * set cursor
     *
     * @param cursor
     */
    public void setCursor(DirectoryNode cursor) {
        this.cursor = cursor;
    }

    /**
     * move to folder
     *
     * @param substring
     * @throws IllegalArgumentException folder doesn't exist or is not a folder
     * @throws NotADirectoryException   target is file
     */
    public void move(String substring) throws IllegalArgumentException, NotADirectoryException, FullDirectoryException {
        String[] stringsArr = substring.split(" ");
        if (stringsArr.length != 2) throw new IllegalArgumentException();
        else {
            DirectoryNode orignal = find(stringsArr[0]);
            DirectoryNode target = find(stringsArr[1]);
            if (target.isFile()) throw new NotADirectoryException();
            if (orignal.getParent().getChild1() != null && orignal.getParent().getChild1() == orignal)
                orignal.getParent().setChild1(null);
            else if (orignal.getParent().getChild2() != null && orignal.getParent().getChild2() == orignal)
                orignal.getParent().setChild2(null);
            else if (orignal.getParent().getChild3() != null && orignal.getParent().getChild3() == orignal)
                orignal.getParent().setChild3(null);
            orignal.setParent(target);
            target.addChild(orignal);
        }
    }
}
