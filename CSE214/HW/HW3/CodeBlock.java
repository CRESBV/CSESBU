/**
 * @author edwardBucklerV
 * 111628438
 * There are different types of code blocks you must consider (e.g. a for block, a while block, etc.), so create a
 * static final array of six String variables named BLOCK_TYPES to enumerate the types of blocks available for nesting.
 * "def", "for", "while", "if", "elif", "else". You should also declare six static final int variables corresponding to
 * the indices of the BLOCK_TYPE array: DEF = 0, FOR = 1, WHILE = 2, IF = 3, ELIF = 4, ELSE = 5.
 */
public class CodeBlock {
    static final String[] BLOCK_TYPES = {"def", "for", "while", "if", "else", "elif"};
    static final int DEF = 0;
    static final int FOR = 1;
    static final int WHILE = 2;
    static final int IF = 3;
    static final int ELIF = 4;
    static final int ELSE = 5;

    private Complexity blockComplexity;
    private Complexity highestSubComplexity;
    private String name;
    private String loopVariable;

    /**
     * no arg constructor
     */
    public CodeBlock() {
    }

    /**
     * arg constructor
     * @param blockComplexity
     * @param highestSubComplexity
     * @param name
     * @param loopVariable
     */
    public CodeBlock(Complexity blockComplexity, Complexity highestSubComplexity, String name, String loopVariable) {
        this.blockComplexity = blockComplexity;
        this.highestSubComplexity = highestSubComplexity;
        this.name = name;
        this.loopVariable = loopVariable;
    }

    /**
     * get complexity
     * @return
     */
    public Complexity getBlockComplexity() {
        return blockComplexity;
    }

    /**
     * set block complexity
     * @param blockComplexity
     */
    public void setBlockComplexity(Complexity blockComplexity) {
        this.blockComplexity = blockComplexity;
    }

    /**
     * get max sub complexity
     * @return highestSubComplexity
     */
    public Complexity getHighestSubComplexity() {
        return highestSubComplexity;
    }

    /**
     * set max sub complexity
     * @param highestSubComplexity
     */
    public void setHighestSubComplexity(Complexity highestSubComplexity) {
        this.highestSubComplexity = highestSubComplexity;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get loop var
     * @return loopVariable
     */
    public String getLoopVariable() {
        return loopVariable;
    }

    /**
     * set loop var
     * @param loopVariable
     */
    public void setLoopVariable(String loopVariable) {
        this.loopVariable = loopVariable;
    }

    /**
     * to string
     * @return human readable string of code block
     */
    @Override
    public String toString() {
        return String.format("BLOCK %-8s block complexity = %-10s highest sub-complexity = %s", name + ":",
                blockComplexity, highestSubComplexity);
    }
}
