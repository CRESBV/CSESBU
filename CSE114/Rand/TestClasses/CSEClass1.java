import java.*;

public class CSEClass1 {
    int a, b, c;

    public CSEClass1() {
        System.out.println("NNEEERRRDDDD!!!");
    }

    public CSEClass1(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Nerd2 extends CSEClass1 {
    int d, e, f;
    public Nerd2() {
        System.out.println("hello there");
    }

    public Nerd2(int d, int e, int f) {
        this.d = d;
        this.e = e;
        this.f = f;
    }
}

class DriverCSE {
    public static void main(String[] args) {
        CSEClass1 nerdTest = new Nerd2();
    }
}