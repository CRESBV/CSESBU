/**
 * @author edwardBucklerV
 * Write a fully-documented class named Course which contains the course name (String), department (String), code
 * (int), section (byte), and instructor (String). You should provide accessor and mutator methods for each variable. The mutator methods for code and section should throw an appropriate exception for invalid values (e.g. a negative value). Also, include a constructor for the class, as well as the clone() and equals() methods. The full list of required methods is:
 * public Course - constructor (you may include a constructor with parameters)
 * getter/setter methods for each variable
 * public Object clone() - the return value is a copy of this Course. Subsequent changes to the copy will not affect the original and vice versa. Note that the return value must be typecasted to a Course before it can be used.
 * public boolean equals(Object obj) - a return value of true indicates that obj refers to a Course object with the same attributes as this Course. Otherwise, the return value is false.
 */
public class Course {
    private String courseName;
    private String department;
    private int code;
    private byte section;
    private String instructor;

    /**
     * basic constructor
     */
    public Course() {
    }

    /**
     * arg constructor
     *
     * @param courseName
     * @param department
     * @param code
     * @param section
     * @param instructor
     */
    public Course(String courseName, String department, int code, byte section, String instructor) {
        this.courseName = courseName;
        this.department = department;
        this.code = code;
        this.section = section;
        this.instructor = instructor;
    }

    /**
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return section
     */
    public byte getSection() {
        return section;
    }

    /**
     * @param section
     */
    public void setSection(byte section) {
        this.section = section;
    }

    /**
     * @return instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * @return
     */
    public Object clone() {
        return new Course(courseName, department, code, section, instructor);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Course && ((Course) obj).getCourseName().equals(courseName) && ((Course) obj)
                .getDepartment().equals(department) && ((Course) obj).getCode() == code && ((Course) obj).getSection
                () == section && ((Course) obj).getInstructor().equals(instructor));
    }

    public String toString() {
        return courseName + spaceGenerator(26 - courseName.length()) + department + spaceGenerator(12 - department
                .length()) + code + spaceGenerator(9 - String.valueOf(code).length()) + ((section < 10) ?
                "0" : "") + section + " " + instructor;
    }

    //No. Course Name               Department Code Section Instructor
//-------------------------------------------------------------------------------
//  2 System Fundamentals       CSE         220      01 Kevin McDonnell
//  3 Data Structures           CSE         214      01 Ahmad Esmaili
    public String spaceGenerator(int num) {
        String out = "";
        for (int i = 0; i < num; i++) {
            out += " ";
        }
        return out;
    }
}