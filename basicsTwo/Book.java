package basicsTwo;

/**
 * Created by Kurnosova Iryna on 16.01.2018.
 */
public class Book {
    private int bookId;
    private String bookName;
    private int bookYear;
    private String author;
    private int price;
    private boolean status;
    private String edition;
    private String genre;

    public Book() {
        super();
    }

    public Book(String name, int bookYear, String author, int price, boolean status, String edition, String genre) {
        this.bookId = 0;
        this.bookName = name;
        this.bookYear = bookYear;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {

        this.bookId = bookId;
    }

    public String getName() {
        return bookName;
    }

    public void setName(String name) {
        this.bookName = name;
    }

    public int getYear() {
        return bookYear;
    }

    public void setYear(int year) {
        this.bookYear = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookYear=" + bookYear +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}