/**
 * @author edwardBucklerV
 * 111628438
 * The DirectoryNode class should contain 3 DirectoryNode references, left, middle, and right. In addition,
 * the class should contain a String member variable name, which indicates the name of the node in the tree.
 */
public class DirectoryNode {
    private DirectoryNode child1;
    private DirectoryNode child2;
    private DirectoryNode child3;
    private DirectoryNode parent;
    private DirectoryNode sibling;

    private String name;
    private boolean isFile;

    /**
     * arg constructor
     *
     * @param child1
     * @param child2
     * @param child3
     * @param parent
     * @param sibling
     * @param name
     * @param isFile
     */
    public DirectoryNode(DirectoryNode child1, DirectoryNode child2, DirectoryNode child3, DirectoryNode parent, DirectoryNode sibling, String name, boolean isFile) {
        this.child1 = child1;
        this.child2 = child2;
        this.child3 = child3;
        this.parent = parent;
        this.sibling = sibling;
        this.name = name;
        this.isFile = isFile;
    }

    /**
     * 3 arg construtor
     *
     * @param parent
     * @param name
     * @param isFile
     */
    public DirectoryNode(DirectoryNode parent, String name, boolean isFile) {
        this.parent = parent;
        this.name = name;
        this.isFile = isFile;
        this.child1 = null;
        this.child2 = null;
        this.child3 = null;
        this.sibling = null;
    }

    /**
     * root constructor
     */
    public DirectoryNode() {
        parent = null;
        name = "root";
        isFile = false;
        this.child1 = null;
        this.child2 = null;
        this.child3 = null;
        this.sibling = null;
    }

    /**
     * PLEASE NOTE that FullDirectoryException is used to take care of duplicate values.
     * Be free to make as many files and directories as you would like.
     * adds child. Will take care of creation of "null" nodes
     *
     * @param newChild
     * @throws NotADirectoryException when adding and not in dir. This would be really bad if this was thrown
     */
    public void addChild(DirectoryNode newChild) throws NotADirectoryException, FullDirectoryException{
        if (child1 != null && child1.getName().equals(newChild.getName())) throw new FullDirectoryException();
        if (child2 != null && child2.getName().equals(newChild.getName())) throw new FullDirectoryException();
        if (child3 != null && child3.getName().equals(newChild.getName())) throw new FullDirectoryException();
        if (isFile) throw new NotADirectoryException();
        else if (child1 == null) child1 = newChild;
        else if (child2 == null) child2 = newChild;
        else if (child3 == null) child3 = newChild;
        else {
            if (getSibling() == null) {
                setSibling(new DirectoryNode(this, null, false));
            }
            getSibling().addChild(newChild);
        }
    }

    /**
     * get child 1
     *
     * @return child1 node
     */
    public DirectoryNode getChild1() {
        return child1;
    }

    /**
     * set child 1
     *
     * @param child1
     */
    public void setChild1(DirectoryNode child1) {
        this.child1 = child1;
    }

    /**
     * get child 2
     *
     * @return child2 node
     */
    public DirectoryNode getChild2() {
        return child2;
    }

    /**
     * set child 2
     *
     * @param child2
     */
    public void setChild2(DirectoryNode child2) {
        this.child2 = child2;
    }

    /**
     * get child 3
     *
     * @return child3 node
     */
    public DirectoryNode getChild3() {
        return child3;
    }

    /**
     * set child 3
     *
     * @param child3
     */
    public void setChild3(DirectoryNode child3) {
        this.child3 = child3;
    }

    /**
     * get parent
     *
     * @return parent node
     */
    public DirectoryNode getParent() {
        return parent;
    }

    /**
     * set parent
     *
     * @param parent
     */
    public void setParent(DirectoryNode parent) {
        this.parent = parent;
    }

    /**
     * get sibling
     *
     * @return sibling node
     */
    public DirectoryNode getSibling() {
        return sibling;
    }

    /**
     * set sibling
     *
     * @param sibling
     */
    public void setSibling(DirectoryNode sibling) {
        this.sibling = sibling;
    }

    /**
     * get name
     *
     * @return name string
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * bool is file
     *
     * @return file bool
     */
    public boolean isFile() {
        return isFile;
    }

    /**
     * set file
     *
     * @param file
     */
    public void setFile(boolean file) {
        isFile = file;
    }
}
