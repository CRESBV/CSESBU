import java.util.Date;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named Person and its two subclasses named Student and Employee. Make
 * Faculty and Staff subclasses of Employee. A person has a name, address, phone number, and
 * e-mail address. A student has a class status (freshman, sophomore, junior, or senior). Define
 * the status as a constant. An employee has an office, salary, and date hired. A faculty member
 * has office hours and a rank. A staff member has a title. Override the toString method in each
 * class to display the class name and the person’s name.
 * Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes their
 * toString() methods.
 */
public class Person {
    String name, address, phoneNumber, email;

    public Person() {
        name = "John Nerd";
        address = "42 Nerd Rd.";
        phoneNumber = "424 242 4242";
        email = "JD42@NERD.NERD";
    }

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static void main(String[] args) {
        Person personTest = new Person();
        Student studentTest = new Student("sophomore");
        Employee employeeTest = new Employee();
        Faculty facultyTest = new Faculty();
        Staff staffTest = new Staff();


        System.out.println(personTest.toString());
        System.out.println(studentTest.toString());
        System.out.println(employeeTest.toString());
        System.out.println(facultyTest.toString());
        System.out.println(staffTest.toString());
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}

class Student extends Person {
    final String currentClass;

    public Student() {
        currentClass = "freshman";
    }

    public Student(String currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Employee extends Person {
    String office;
    Date dateHired;
    double salary;

    public Employee(String name, String address, String phoneNumber, String email, String office, Date dateHired, double salary) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        dateHired = new Date();
    }

    public Employee() {
        office = "42 Nerd Bld";
        dateHired = new Date();
        salary = 42;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Faculty extends Employee {
    String rank, officeHours;

    public Faculty() {
        rank = "testMethod";
        officeHours = "10:00 to 12:00";
    }

    public Faculty(String name, String address, String phoneNumber, String email, String office, Date dateHired, double salary, String rank, String officeHours) {
        super(name, address, phoneNumber, email, office, dateHired, salary);
        this.rank = rank;
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Staff extends Employee {
    String title;

    public Staff() {
        title = "testMethod";
    }

    public Staff(String name, String address, String phoneNumber, String email, String office, Date dateHired, double salary, String title) {
        super(name, address, phoneNumber, email, office, dateHired, salary);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                '}';
    }
}

