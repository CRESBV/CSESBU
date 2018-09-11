import java.util.Scanner;

public class PlannerManager {

    public static void main(String[] args) {
        Planner planner = new Planner();
        Planner backup = new Planner();
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            printMenu();
            try {
                quit = parser(input.nextLine(), planner, backup);
            } catch (InputElementException iee) {
                System.out.println("Bad input please re-enter\n");
            } catch (FullPlannerException e) {
                System.out.println("Planner full\n");
            }
        }
        System.out.println("Program terminating successfully...");
        input.close();
    }

    public static void printMenu() {
        System.out.print("A - Add Course <Name> <Department> <Code> <Section> <Instructor> <Position>\nAdds a new " +
                "course into " +
                "the list.\nG - Get Course <Position>\nDisplays information of a Course at the given position.\nR " +
                "- Remove Course <Position>\nRemoves the Course at the given position.\nP - Print Courses in " +
                "Planner\nDisplays all courses in the list.\nF - Filter By Department Code <Department>\nDisplays " +
                "courses that match the given department code.\nL - Look For Course <Name> <Department> <Code> " +
                "<Section> <Instructor>\nDetermines whether the course with the given attributes is in the list.\nS" +
                " - Size\nDetermines the number of courses in the Planner.\nB - Backup\nCreates a copy of the " +
                "given Planner. Changes to the copy will not affect the original and vice versa.\nPB - Print " +
                "Courses in Backup\nDisplays all the courses from the backed-up list.\nRB - Revert to Backup\n" +
                "Reverts the current Planner to the backed up copy.\nQ - Quit\nTerminates the program.\n\nEnter a " +
                "selection: ");
    }

    public static int position(String num, Planner planner) throws InputElementException {
        int out = 0;
        try {
            out = Integer.parseInt(num);
            if (out < 1 || out > planner.size()) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println("Number Format Exception with \"position\"");
        }
        return out;
    }

    public static String courseName(String name) throws InputElementException {
        if (name.length() > 26) {
            throw new InputElementException();
        }
        return name;
    }

    public static int code(String num) throws InputElementException {
        int out = 0;
        try {
            out = Integer.parseInt(num);
            if (out <= 99) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println("Number Format Exception with \"code\"");
        }
        return out;
    }

    public static Byte section(String num) throws InputElementException {
        byte out = 0;
        try {
            out = Byte.parseByte(num);
            if (out < 1 || out > 99) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println("Number Format Exception with \"section\"");
        }
        return out;
    }

    public static String instructor(String inst) throws InputElementException {
        if (inst.length() > 25) {
            throw new InputElementException();
        }
        return inst;
    }

    public static String department(String dep) throws InputElementException {
        if (dep.length() > 3 || dep.length() < 3) {
            throw new InputElementException();
        }
        return dep;
    }

    public static boolean parser(String line, Planner planner, Planner backup) throws InputElementException,
            FullPlannerException {
        String[] lineSplit = line.split(" ");
        String command = lineSplit[0];
        command = command.toLowerCase();
        if (command.equals("r") && lineSplit.length == 2 && planner.size() != 0) { //R - Remove Course <Position>
            planner.removeCourse(position(command, planner));
        } else if (command.equals("a") && lineSplit.length == 7) { //A - Add Course <Name> <Department> <Department>
            // <Code> <Section> <Instructor> <Position>
            planner.addCourse(new Course(courseName(lineSplit[1]), department(lineSplit[2]),
                    code(lineSplit[3]), section(lineSplit[4]), instructor(lineSplit[5])), position(lineSplit[6], planner));
        } else if (command.equals("a") && lineSplit.length == 6) { //A - Add Course <Name> <Department> <Department>
            // <Code> <Section> <Instructor>
            planner.addCourse(new Course(courseName(lineSplit[1]), department(lineSplit[2]),
                    code(lineSplit[3]), section(lineSplit[4]), instructor(lineSplit[5])));
        }else if (command.equals("g") && lineSplit.length == 2) { //G - Get Course <Position>
            planner.getCourse(position(lineSplit[1], planner));
        } else if (command.equals("p") && lineSplit.length == 1) { //P - Print Courses in Planner
            planner.printAllCourses();
        } else if (command.equals("f") && lineSplit.length == 2) { //F - Filter By Department Code <Department>
            planner.filter(planner, department(lineSplit[1]));
        } else if (command.equals("l") && lineSplit.length == 6) { //L - Look For Course <Name> <Department>
            // <Department> <Code> <Section> <Instructor>
            planner.exists(new Course(courseName(lineSplit[1]), department(lineSplit[2]), code(lineSplit[3]),
                    section(lineSplit[4]), instructor(lineSplit[5])));
        } else if (command.equals("s") && lineSplit.length == 1) { //S - Size
            System.out.println("There are " + planner.size() + " courses in the planner.");
        } else if (command.equals("b") && lineSplit.length == 1) { //B - Backup
            backup = (Planner) planner.clone();
        } else if (command.equals("pb") && lineSplit.length == 1) { //PB - Print Courses in Backup
            backup.printAllCourses();
        } else if (command.equals("rb") && lineSplit.length == 1) { //RB - Revert to Backup
            planner = (Planner) backup.clone();
        } else if (command.equals("q") && lineSplit.length == 1) { //Q - Quit
            return true;
        } else {
            throw new InputElementException();
        }
        return false;
    }

}
