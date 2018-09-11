public class Tester {
    private static Planner mainPlanner = new Planner();

    public static void main(String[] args) {
        Course test = new Course("hello", "cse", 214, (byte) 1, "chicken");

        try {
            mainPlanner.addCourse(test,1 );
        } catch (FullPlannerException e) {
            System.out.println("oh no");
        }
        mainPlanner.printAllCourses();
    }
}

