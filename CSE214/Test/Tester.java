import java.io.*;
import java.util.Scanner;

public class Tester {
    private String bob;

    public static void main(String[] args) {
        Tester tester = new Tester();
        Scanner input = new Scanner(System.in);
        try {
            File f = new File("saveFile.obj");
            if (f.exists()) {
                tester.bob = load("saveFile.obj");
            }
            System.out.println("bob = " + tester.bob);
            System.out.println("input text:");
            tester.bob = input.nextLine();
            System.out.println("bob updated to = " + tester.bob);
            save("saveFile.obj", tester.bob);
            System.out.println("closing");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        input.close();
    }

    public static String load(String filename) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream inStream = new ObjectInputStream(file);
        return (String) inStream.readObject();

    }

    public static void save(String filename, String saver) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOutputStream);
        outStream.writeObject(saver);
    }
}




