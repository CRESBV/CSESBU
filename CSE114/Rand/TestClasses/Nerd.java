public class Nerd {
    public static void main(String[] args) {
        String line = "[val = root ('root' left = [val = B ('B' left = [val = C ('C' left = ) ('C' right = )]) ('B' right = )]) ('root' right = [val = D ('D' left = ) ('D' right = )])]";
        if (line.contains(" (" + "'" + "root" + "'" + " left = )")) {
            System.out.println("nerd");
        }
    }
}
