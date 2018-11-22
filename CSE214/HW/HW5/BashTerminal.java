import java.util.Scanner;

public class BashTerminal {
    private static final String START_LINE = "[esbuckler@Tux]: $";
    private DirectoryTree bash = new DirectoryTree();

    /**
     * main method pretty much just points to parser
     *
     * @param args
     */
    public static void main(String[] args) {
        BashTerminal bt = new BashTerminal();
        boolean quit = false;
        while (!quit) {
            System.out.print(START_LINE);
            quit = bt.parser();
        }
        System.out.println("Program terminating normally");
    }

    /**
     * parses and deals with inputs
     *
     * @return bool to quit or not
     */
    private boolean parser() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) ;
        String command = input.nextLine();
        if (command.equals("pwd")) System.out.println(bash.presentWorkingDirectory(bash.getCursor()));
        else if (command.equals("ls")) System.out.println(bash.listDirectory());
        else if (command.equals("ls -R")) System.out.println(bash.listAll(bash.getCursor(), "", 0));
        else if (command.equals("cd ..")) {
            if (bash.getCursor() == bash.getRoot()) {
                System.out.println("ERROR: Already at root directory.");
            } else {
                bash.setCursor(bash.getCursor().getParent());
            }
        } else if (command.length() > 3 && command.substring(0, 2).equals("cd")) {
            try {
                bash.changeDirectory(command.substring(3));
            } catch (IllegalArgumentException e) {
                System.out.println("-bash: " + command + ": No such file or directory");
            } catch (NotADirectoryException iae) {
                System.out.println("-bash: cd: " + command.substring(3) + ": Not a directory");
            }
        } else if (command.equals("cd /")) {
            System.out.println("Command \'cd /\'recognized");
            bash.resetCursor();
        } else if (command.length() > 6 && command.substring(0, 5).equals("mkdir")) {
            try {
                bash.makeDirectory(command.substring(6));
            } catch (NotADirectoryException e) {
                System.out.println("ERROR: Cursor not at dir (this is a problem)");
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: name has space or / in it");
            } catch (FullDirectoryException e) {
                System.out.println("mkdir: cannot create directory '" + command.substring(6) + "': File exists");
            }
        } else if (command.length() > 6 && command.substring(0, 5).equals("touch")) {
            try {
                bash.makeFile(command.substring(6));
            } catch (NotADirectoryException e) {
                e.printStackTrace();
                System.out.println("ERROR: Cursor not at dir (this is a problem)");
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: name has space or / in it");
            } catch (FullDirectoryException e) {
                System.out.println("mkdir: cannot create file '" + command.substring(6) + "': File exists");
            }
        } else if (command.equals("exit")) return true;
        else if (command.length() > 2 && command.substring(0, 2).equals("mv")) {
            try {
                bash.move(command.substring(3));
            } catch (NotADirectoryException e) {
                System.out.println("ERROR: not moving to dir");
                e.printStackTrace();
            } catch (IllegalArgumentException iae) {
                System.out.println("Error: bad input for move");
            } catch (FullDirectoryException e) {
                System.out.println("mkdir: cannot move directory or file '" + command.substring(6) + "': File exists");
            }
        } else if (command.length() > 4 && command.substring(0, 4).equals("find")) {
            try {
                System.out.println((bash.searchAll(bash.getRoot(), command.substring(5))) ? "" :
                        "find: '" + command.substring(5) + "': No such file or directory");

            } catch (NullPointerException e) {
                System.out.println("find: " + command.substring(5) + ": No such file or directory");
            }

        } else System.out.println("-bash: " + command + ": command not found");
        return false;
    }
}
