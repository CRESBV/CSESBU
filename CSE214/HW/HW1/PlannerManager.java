/**
 * @author edwardBucklerV
 * Write a fully-documented class named PlannerManager
 */

import java.util.Scanner;

public class PlannerManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    Planner mainPlanner = new Planner();
    Planner backup = new Planner();

    public static void main(String[] args) {
        PlannerManager pm = new PlannerManager();
        boolean quit = false;
        while (!quit) {
            printMenu();
            try {
                quit = pm.parser();
            } catch (InputElementException iee) {
                System.out.println(ANSI_RED + "Bad input please re-enter\n" + ANSI_RESET);
            } catch (FullPlannerException e) {
                System.out.println(ANSI_RED + "Planner full\n" + ANSI_RESET);
            }
        }
        System.out.println("Program terminating successfully...");
    }

    /**
     * prints menu
     */
    private static void printMenu() {
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

    /**
     * parses and takes care position
     *
     * @param num
     * @param planner
     * @return formatted pos
     * @throws InputElementException
     */
    private static int position(String num, Planner planner) throws InputElementException {
        int out = 0;
        try {
            out = Integer.parseInt(num);
            if (out < 0 || out > planner.size() + 1) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Number Format Exception with \"position\"" + ANSI_RESET);
        }
        return out;
    }

    /**
     * parses string to a course name (filtered for size)
     *
     * @param name
     * @return formatted course name
     * @throws InputElementException
     */
    private static String courseName(String name) throws InputElementException {
        if (name.length() > 25) {
            throw new InputElementException();
        }
        return name;
    }

    /**
     * parses string to a code that is between 99 and 999
     *
     * @param num
     * @return formatted code
     * @throws InputElementException
     */
    private static int code(String num) throws InputElementException {
        int out = 0;
        try {
            out = Integer.parseInt(num);
            if (out <= 99 || out > 999) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Number Format Exception with \"code\"" + ANSI_RESET);
        }
        return out;
    }

    /**
     * parses string to a section byte
     *
     * @param num
     * @return formatted section
     * @throws InputElementException
     */
    private static Byte section(String num) throws InputElementException {
        byte out = 0;
        try {
            out = Byte.parseByte(num);
            if (out < 1 || out > 99) {
                throw new InputElementException();
            }
        } catch (java.lang.NumberFormatException nfe) {
            System.out.println(ANSI_RED + "Number Format Exception with \"section\"" + ANSI_RESET);
        }
        return out;
    }

    /**
     * parses string to a instructor (check for size)
     *
     * @param inst
     * @return formatted instructor
     * @throws InputElementException
     */
    private static String instructor(String inst) throws InputElementException {
        if (inst.length() > 25) {
            throw new InputElementException();
        }
        return inst;
    }

    /**
     * parses string to a 3 letter department title
     *
     * @param dep
     * @return formatted dep
     * @throws InputElementException
     */
    private static String department(String dep) throws InputElementException {
        if (dep.length() > 3 || dep.length() < 3) {
            throw new InputElementException();
        }
        return dep;
    }

    private static String printSection(Byte section) {
        if (section < 10) {
            return "0" + section;
        } else {
            return Byte.toString(section);
        }
    }

    /**
     * parses user input
     *
     * @return bool on if quit
     * @throws InputElementException
     * @throws FullPlannerException
     */
    public boolean parser() throws InputElementException, FullPlannerException {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextLine()) ;
        String command = input.nextLine();
        command = command.toLowerCase();
        if (command.equals("r") && mainPlanner.size() != 0) { //R - Remove Course <Position>
            System.out.print("Enter position: ");
            int position = position(input.nextLine(), mainPlanner);
            Course temp = mainPlanner.getCourse(position);
            mainPlanner.removeCourse(position);
            System.out.println(temp.getDepartment()+" "+temp.getCode()+"."+printSection(temp.getSection())+" has been " +
                    "successfully removed from the planner.");
        } else if (command.equals("a")) { //A - Add Course <Name> <Department> <Department>
            // <Code> <Section> <Instructor> <Position> TODO: adding to first pos when no in list
            System.out.print("Enter course name: ");
            String courseName = courseName(input.nextLine());
            System.out.print("Enter department: ");
            String department = department(input.nextLine());
            System.out.print("Enter course code: ");
            int code = code(input.nextLine());
            System.out.print("Enter course section: ");
            byte section = section(input.nextLine());
            System.out.print("Enter instructor: ");
            String instructor = instructor(input.nextLine());
            System.out.print("Enter position: ");
            int position = position(input.nextLine(), mainPlanner);
            mainPlanner.addCourse(new Course(courseName, department, code, section, instructor), position);
            System.out.println(department + " " + code + "." + printSection(section) + "successfully added to planner.");
        } else if (command.equals("g")) { //G - Get Course <Position> TODO: add header
            System.out.print("Enter position: ");
            int position = position(input.nextLine(), mainPlanner);
            System.out.println(mainPlanner.getCourse(position));
        } else if (command.equals("p")) { //P - Print Courses in Planner
            mainPlanner.printAllCourses();
        } else if (command.equals("f")) { //F - Filter By Department Code <Department>
            System.out.print("Enter department: ");
            String department = department(input.nextLine());
            mainPlanner.filter(mainPlanner, department);
        } else if (command.equals("l")) { //L - Look For Course <Name> <Department>
            // <Department> <Code> <Section> <Instructor>
            System.out.print("Enter course name: ");
            String courseName = courseName(input.nextLine());
            System.out.print("Enter department: ");
            String department = department(input.nextLine());
            System.out.print("Enter course code: ");
            int code = code(input.nextLine());
            System.out.print("Enter course section: ");
            byte section = section(input.nextLine());
            System.out.print("Enter instructor: ");
            String instructor = instructor(input.nextLine());
            Course tarCourse = new Course(courseName, department, code, section, instructor);
            if (mainPlanner.exists(tarCourse)) {
                for (int i = 1; i < mainPlanner.size() + 1; i++) {
                    if (mainPlanner.getCourse(i).equals(tarCourse)) {
                        System.out.println(department + " " + code + "." + printSection(section) + " is found in the planner at" +
                                " position " + i + ".");
                    }
                }
            } else {
                System.out.println("Course not in planner");
            }
        } else if (command.equals("s")) { //S - Size
            System.out.println("There are " + mainPlanner.size() + " courses in the mainPlanner.");
        } else if (command.equals("b")) { //B - Backup
            backup = (Planner) mainPlanner.clone();
            System.out.println("Created a backup of the current planner.");
        } else if (command.equals("pb")) { //PB - Print Courses in Backup
            System.out.print(backup);
        } else if (command.equals("rb")) { //RB - Revert to Backup
            mainPlanner = (Planner) backup.clone();
            System.out.println("Planner successfully reverted to the backup copy.");
        } else if (command.equals("q")) { //Q - Quit
            return true;
        } else {
            throw new InputElementException();
        }
        return false;
    }

}
