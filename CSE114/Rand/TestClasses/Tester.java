public class Tester {
    public static void main(String[] args) {
        Test heyLook = new Test();
        heyLook.defineRadius(5.67);
        System.out.println(heyLook.returnRadius());
        System.out.println(heyLook.returnArea());
        System.out.println(heyLook.returnCircumference());
        System.out.println("At 100 rpm this wheel will cover: " + 100 * heyLook.returnCircumference());
    }
}
