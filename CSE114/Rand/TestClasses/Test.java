import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test nerd = new TestNerd();
        System.out.println(nerd.testMethod());
        ArrayList<Integer> chiken = new ArrayList<>();
    }

    public String testMethod() {
        return "Hey Weirdo";
    }
}

class Testext extends Test {
    public String testMethod() {
        return "Hey Nerd";
    }

}

class TestNerd extends Testext {
    public String testMethod() {
        return "Hey Moron";
    }
}