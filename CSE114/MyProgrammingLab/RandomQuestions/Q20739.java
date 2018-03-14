/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class named Book containing:
 * Two instance variables named title and author of type String.
 * A constructor that accepts two String parameters. The value of the first is used to initialize the value of title and the value of the second is used to initialize author.
 * A method named toString that accepts no parameters. toString returns a String consisting of the value of title, followed by a newline character, followed by the value of author.
 */
public class Q20739 {
    private String title, author;

    public Q20739(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + "\n" + author;
    }
}
