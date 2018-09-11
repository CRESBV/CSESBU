/**
 * @author edwardBucklerV
 * Write a fully-documented class named Planner which stores an ordered list of Course objects. The array indices
 * determine the preference of the courses (do not use ArrayList, Vector, or any other Java API Data Structures). A
 * student can insert a course at any position within the range of the list. Make sure there are no gaps between courses
 * on the list. Note that arrays in Java are 0 indexed, but your listing preference should start from 1. The Planner can
 * record a total of 50 courses, so use the final variable MAX_COURSES = 50 (and refrain from using the number 50 within
 * your code). The class will be based on the following ADT specification:
 */
public class Planner {
    private final short MAX_COURSES = 50;
    private Course[] courseList;

    public Planner() {
        courseList = new Course[0];
    }

    public Planner(Course[] courseList) {
        this.courseList = courseList;
    }

    public static void filter(Planner planner, String department) {
        String out = "\nNo. Course Name               Department Code Section Instructor\n" +
                "-------------------------------------------------------------------------------\n";
        for (int i = 1; i < planner.size() + 1; i++) {
            if (planner.getCourse(i).getDepartment().equals(department)) {
                out += i + " " + planner.getCourse(i) + "\n";
            }
        }
        System.out.println(out);
    }

    public boolean exists(Course course) {
        for (int i = 0; i < size(); i++) {
            if (courseList[i].getDepartment().equals(course.getDepartment()) && courseList[i].getCourseName().equals
                    (course.getDepartment()) && courseList[i].getInstructor().equals(course.getInstructor()) &&
                    courseList[i].getCode() == course.getCode() && courseList[i].getSection() == course.getSection()) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return courseList.length;
    }

    public Object clone() {
        Planner backup = new Planner();
        for (int i = 0; i < size(); i++) {
            try {
                backup.addCourse((Course) courseList[i].clone());
            } catch (FullPlannerException fpe) {
                System.out.println("Issue with original planner size");
            }
        }
        return backup;
    }

    public void addCourse(Course newCourse, int position) throws IllegalArgumentException, FullPlannerException {
        if (size() == MAX_COURSES) {
            throw new FullPlannerException();
        }
        Course[] temp = new Course[size() + 1];
        boolean newCourseAdded = false;
        for (int i = 0; i < size() + 1; i++) {
            if (i == position - 1) {
                temp[i] = newCourse;
                newCourseAdded = true;
            } else if (!newCourseAdded) {
                temp[i] = (Course) courseList[i].clone();
            } else {
                temp[i] = (Course) courseList[i - 1].clone();
            }
        }
        courseList = new Course[size() + 1];
        for (int i = 0; i < size(); i++) {
            courseList[i] = temp[i];
        }
    }

    public void addCourse(Course newCourse) throws FullPlannerException {
        addCourse(newCourse, size() + 1);
    }

    public void removeCourse(int position) throws IllegalArgumentException {
        Course[] temp = new Course[size() - 1];
        boolean courseRemoved = false;
        for (int i = 0; i < size() - 1; i++) {
            if (i == position - 1) {
                courseRemoved = true;
            } else if (!courseRemoved) {
                temp[i] = (Course) courseList[i].clone();
            } else {
                temp[i] = (Course) courseList[i + 1].clone();
            }
        }
        courseList = new Course[size() - 1];
        for (int i = 0; i < size(); i++) {
            courseList[i] = temp[i];
        }
    }

    public Course getCourse(int position) throws IllegalArgumentException {
        return courseList[position - 1];
    }

    public String toString() {
        String out = "\nNo. Course Name               Department Code Section Instructor\n" +
                "-------------------------------------------------------------------------------\n";
        for (int i = 0; i < size(); i++) {
            Course temp = courseList[i];
            out += (i + 1) + " " + courseList[i] + "\n";
        }
        return out;
    }

    public void printAllCourses() {
        System.out.println(toString());
    }
}
