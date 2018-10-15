/**
 * @author edwardBucklerV
 * 111628438
 * The class will also contain a static final int variable SPACE_COUNT = 4 which will be used to determine the
 * indentation of each statement (see below). In addition, include a static traceFile method, which will take as a
 * parameter the name of a file containing a Python function. The traceFile method will open the indicated file, trace
 * through the code of the Python function contained within the file, and output the details of the trace and the
 * overall complexity to the console.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class PythonTracer {
    private static final int SPACE_COUNT = 4;
    private static final String[] BLOCK_TYPES_SPACE = {"def ", " for ", " while ", " if ", " else ", " elif "};
    private static int elementCount = 0;
    private static ArrayList<Integer> nameArr = new ArrayList<>();

    /**
     * parses and get complexity of python def
     * @param filename
     * @return complexity of python def
     */
    public static Complexity traceFile(String filename) {
        elementCount = 0;
        nameArr = new ArrayList<>();
        Stack<CodeBlock> stack = new Stack();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (!line.isEmpty() && !line.contains("#")) {
                    int indents = countIndent(line);
                    while (elementCount > indents) {
                        if (indents == 0) {
                            input.close();
                            return stack.pop().getHighestSubComplexity();
                        } else {
                            elementCount--;
                            CodeBlock oldTop = stack.pop();
                            Complexity oldTopComplexity = new Complexity(oldTop.getHighestSubComplexity().getnPower() + oldTop.getBlockComplexity().getnPower(), oldTop.getHighestSubComplexity().getLogPower() + oldTop.getBlockComplexity().getLogPower());
                            if (compareComplexity(oldTopComplexity, stack.peek().getHighestSubComplexity())) {
                                stack.peek().setHighestSubComplexity(oldTopComplexity);
                                System.out.println("Leaving block " + oldTop.getName() + ", updating block " + stack.peek().getName() +
                                        ":\n\t" + stack.peek());
                            } else {
                                System.out.println("Leaving block " + oldTop.getName() + ", nothing to update." +
                                        "\n\t" + stack.peek());
                            }
                        }
                    }
                    if (Arrays.stream(BLOCK_TYPES_SPACE).anyMatch(line::contains)) {
                        nameArr = arrListInt(nameArr, indents);
                        String currName = nameGenerator(nameArr, indents);
                        if (line.contains(" for ")) {
                            System.out.print("Entering block " + currName + " 'for':\n\t");
                            if (line.trim().split(" ")[line.trim().split(" ").length - 1].equals("log_N:")) {
                                stack.push(new CodeBlock(new Complexity(0, 1), new Complexity(), currName,
                                        ""));
                                elementCount++;

                            } else {
                                stack.push(new CodeBlock(new Complexity(1, 0), new Complexity(), currName, ""));
                                elementCount++;
                            }

                        } else if (line.contains(" while ")) {
                            System.out.print("Entering block " + currName + " 'while':\n\t");
                            stack.push(new CodeBlock(new Complexity(), new Complexity(), currName, line.trim().split(" ")[1]));
                            elementCount++;
                        } else {
                            System.out.print("Entering block " + currName + " " + ((line.contains(" if ") ? "'if'" :
                                    (line.contains(" else ") ? "'else'" : (line.contains(" elif ") ? "'elif'" : "'def'")) + ":\n" +
                                            "\t")));
                            stack.push(new CodeBlock(new Complexity(0, 0), new Complexity(), currName, ""));
                            elementCount++;
                        }
                        System.out.println(stack.peek());
                    } else if (!stack.peek().getLoopVariable().equals("") && line.contains(stack.peek().getLoopVariable())) {
                        if (line.trim().split(" ")[1].equals("/=")) {
                            stack.peek().setBlockComplexity(new Complexity(0, 1));
                        } else {
                            stack.peek().setBlockComplexity(new Complexity(1, 0));
                        }
                        System.out.println("Found update statement, updating block " + stack.peek().getName() + ":\n" +
                                "\t" + stack.peek());

                    }
                } else {
                    continue;
                }
            }
            while (elementCount > 1) {
                CodeBlock oldTop = stack.pop();
                Complexity oldTopComplexity = new Complexity(oldTop.getHighestSubComplexity().getnPower() + oldTop.getBlockComplexity().getnPower(), oldTop.getHighestSubComplexity().getLogPower() + oldTop.getBlockComplexity().getLogPower());
                if (compareComplexity(oldTopComplexity, stack.peek().getHighestSubComplexity())) {
                    stack.peek().setHighestSubComplexity(oldTopComplexity);
                }
            }
            //TODO: sketchy
            System.out.println("\nLeaving block 1.\n");
            return stack.pop().getHighestSubComplexity();
        } catch (FileNotFoundException e) {
            //TODO: ANSI colors
            System.out.println("Error: File not found");
        } catch (java.util.EmptyStackException e) {
            System.out.println("Error: file empty");
        }
        return null;
    }

    /**
     * compares two complexities and returns true if first one larger
     * @param oldTop
     * @param currentTop
     * @return boolean on if larger
     */
    private static boolean compareComplexity(Complexity oldTop, Complexity currentTop) {
        if (oldTop.getnPower() > currentTop.getnPower()) {
            return true;
        } else if (currentTop.getnPower() > oldTop.getnPower()) {
            return false;
        } else if (oldTop.getLogPower() > currentTop.getLogPower()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * generates the names for codeblocks
     * @param list
     * @param indents
     * @return string for code block
     */
    private static String nameGenerator(ArrayList<Integer> list, int indents) {
        String output = "";
        for (int i = 0; i <= indents; i++) {
            if (i == list.size() - 1) {
                output += list.get(i);
            } else {
                output += list.get(i) + ".";
            }
        }
        return output;
    }

    /**
     * modifies the arraylist for codeblocks names
     * @param list
     * @param indents
     * @return updated arraylist
     */
    private static ArrayList<Integer> arrListInt(ArrayList<Integer> list, int indents) {
        if (list.size() == 0 && indents == 0) {
            list.add(1);
        } else if (indents > list.size() - 1) {
            list.add(1);
        } else {
            int val = list.get(list.size() - 1) + 1;
            list.set(indents, val);
        }
        return list;
    }

    /**
     * main method to run and menu
     * @param args
     */
    public static void main(String[] args) {
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while (!quit) {
            System.out.print("Please enter a file name (or 'quit' to quit): ");
            while (!input.hasNextLine()) ;
            String inputVal = input.nextLine();
            if (!inputVal.equals("quit")) {
                System.out.println("Overall complexity of test_function: " + traceFile(inputVal));
            } else {
                quit = true;
            }

        }
        input.close();
        System.out.println("Program terminating successfully...");
    }

    /**
     * counts indents
     * @param line
     * @return int countindent
     */
    private static int countIndent(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        return count / SPACE_COUNT;
    }
}
