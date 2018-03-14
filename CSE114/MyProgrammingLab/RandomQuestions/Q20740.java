/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Write a class named Book containing:
 * Three instance variables named title, author, and tableOfContents of type String. The value of tableOfContents should be initialized to the empty string.
 * An instance variable named nextPage of type int, initialized to 1.
 * A constructor that accepts two String parameters. The value of the first is used to initialize the value of title and the value of the second is used to initialize author.
 * A method named addChapter that accepts two parameters. The first, of type String, is the title of the chapter; the second, is an integer containing the number of pages in the chapter. addChapter appends (that is concatenates) a newline followed by the chapter title followed by the string "..." followed by the value of the nextPage instance variable to the tableOfContents. The method also increases the value of nextPage by the number of pages in the chapter.
 *
 * A method named getPages that accepts no parameters. getPages returns the number of pages in the book.
 *
 * A method named getTableOfContents that accepts no parameters. getTableOfContents returns the values of the tableOfContents instance variable.
 *
 * A method named toString that accepts no parameters. toString returns a String consisting of the value of title, followed by a newline character, followed by the value of author.
 */
public class Q20740 {
    private String title = "", author = "", tableOfContents = "";
    private int nextPage = 1;

    public Q20740(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void addChapter(String chapTitle, int pagesInChap) {
        tableOfContents += "\n" + chapTitle + "..." + nextPage;
        nextPage += pagesInChap;
    }

    public int getPages() {
        return nextPage - 1;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    @Override
    public String toString() {
        return title+"\n"+author;
    }
}
