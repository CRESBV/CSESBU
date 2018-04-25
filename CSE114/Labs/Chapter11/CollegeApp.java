/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write an abstract superclass encapsulating a college applicant: A college applicant has two
 * attributes: the applicant’s name and the college the applicant is applying to. This class has two
 * non-abstract subclasses: one encapsulating an applicant for undergraduate school, and the other
 * encapsulating an applicant for graduate school. An applicant for undergraduate school has two
 * attributes: a SAT score and a GPA. An applicant for graduate school has one additional
 * attribute: the college of origin. It also has a method that returns “c” if the college of
 * origin is the same as the college applied to; otherwise, it returns “from outside”. You also need
 * to include a class to test two classes.
 */
public abstract class CollegeApp {
    String name, toCollege;
    double GPA;
    int SAT;

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public int getSAT() {
        return SAT;
    }

    public void setSAT(int SAT) {
        this.SAT = SAT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToCollege() {
        return toCollege;
    }

    public void setToCollege(String toCollege) {
        this.toCollege = toCollege;
    }

    public abstract String fromInside();
}

class UndergraduateCollegeApplication extends CollegeApp {
    public String fromInside() {
        return "Does not apply";
    }
}

class GraduateCollegeApplication extends CollegeApp {
    String fromCollege;

    public String getFromCollege() {
        return fromCollege;
    }

    public void setFromCollege(String fromCollege) {
        this.fromCollege = fromCollege;
    }

    public String fromInside() {
        if (fromCollege.equals(toCollege)) {
            return "from inside";
        } else {
            return "from outside";
        }
    }
}

class Driver {
    public static void main(String[] args) {
        System.out.println("testing different schools \"fromInside method\":");
        GraduateCollegeApplication test1 = new GraduateCollegeApplication();
        test1.setFromCollege("A");
        test1.setToCollege("B");
        System.out.println(test1.fromInside());

        System.out.println("testing same schools \"fromInside method\":");
        GraduateCollegeApplication test2 = new GraduateCollegeApplication();
        test2.setFromCollege("A");
        test2.setToCollege("A");
        System.out.println(test2.fromInside());

        System.out.println("testing undergrad schools \"fromInside method\":");
        UndergraduateCollegeApplication test3 = new UndergraduateCollegeApplication();
        System.out.println(test3.fromInside());
    }
}
