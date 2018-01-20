package basicsTwo;

import java.sql.SQLException;

/**
 * Created by Kurnosova Iryna on 16.01.2018.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayBook arr = new ArrayBook();
        arr.load();
        System.out.println(arr);

        /*Book bookToAdd = new Book("DD", 2003, "A", 225, false, "A", "B");
        arr.addBook(bookToAdd);

        System.out.println(arr);
        System.out.println("*********************");*/

        /*arr.updateBook();
        System.out.println(arr);*/

        /*arr.deleteBook(bookToAdd);
        System.out.println(arr);*/
    }
}