public class Nerd {
    private int para1;
    private int para2;
    private int para3;
    static private int weird = 4;

    public Nerd() {
        this(0, 0, 0);
    }

    public Nerd(int p1) {
        this(p1, 0, 0);
    }

    public Nerd(int p1, int p2) {
        this(p1, p2, 0);
    }

    public Nerd(int p1, int p2, int p3) {
        para1 = p1;
        para2 = p2;
        para3 = p3;
    }

    public int getWeird() {
        return weird;
    }

    public void addOneWeird() {
        weird++;
    }

    public static void thisBeTestOfNerd() {
        System.out.println("weird = " + weird);
    }
}
