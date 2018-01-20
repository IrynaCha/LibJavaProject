package basicsTwo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Kurnosova Iryna on 16.01.2018.
 */
public class ArrayBook extends ArrayList<Book> {
    public static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=LibJava;" +
            "integratedSecurity=true;" +
            "user=sa;" +
            "password=123";
    private Connection connectionCon;

    public ArrayBook() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionCon = DriverManager.getConnection(CONNECTIONURL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void load() {
        try {
            String sqlQuery = "SELECT * FROM Book";

            Statement statement = connectionCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = statement.executeQuery(sqlQuery);

            while (rs.next()) {
                Book newBook = new Book(rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8));
                add(newBook);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void addBook(Book book) {
        try {
            PreparedStatement preparedStatement = connectionCon.prepareStatement("INSERT INTO Book " +
                    "           ([BookName]\n" +
                    "           ,[BookYear]\n" +
                    "           ,[Author]\n" +
                    "           ,[Price]\n" +
                    "           ,[Status]\n" +
                    "           ,[Edition]\n" +
                    "           ,[Genre]) VALUES" + "(?,?,?,?,?,?,?);" +
                    " SELECT SCOPE_IDENTITY() AS BookId");

            preparedStatement.setString(1, book.getName());
            preparedStatement.setInt(2, book.getYear());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setBoolean(5, book.isStatus());
            preparedStatement.setString(6, book.getEdition());
            preparedStatement.setString(7, book.getGenre());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1));
            }
            book.setBookId(rs.getInt(1));
            System.out.println(book.getBookId());
            System.out.println(preparedStatement.getResultSet());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateBook() throws SQLException {
        try {
            PreparedStatement preparedStatement = connectionCon.prepareStatement("UPDATE Book SET BookName = ?," +
                    " BookYear = ?," +
                    " Author = ?," +
                    " Price = ?," +
                    " Status = ?," +
                    " Edition = ?," +
                    " Genre = ? WHERE bookId = ?");
            preparedStatement.setString(1, "Book");
            preparedStatement.setInt(2, 1300);
            preparedStatement.setString(3, "Au");
            preparedStatement.setInt(4, 15);
            preparedStatement.setBoolean(5, false);
            preparedStatement.setString(6, "DD");
            preparedStatement.setString(7, "Fiction");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void deleteBook(Book book) throws SQLException {
        try {
            PreparedStatement preparedStatement = connectionCon.prepareStatement("DELETE FROM Book WHERE BookId = ?");
            preparedStatement.setInt(1, 23);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}