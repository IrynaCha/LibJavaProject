package basicsTwo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Kurnosova Iryna on 16.01.2018.
 */
public class ConnectToDb {
    public static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=LibJava;" +
            "integratedSecurity=true;" +
            "user=sa;" +
            "password=123";

    public static Connection cnn(String connectionUrl) {
        Connection con;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONNECTIONURL);
        } catch (Exception e) {
            return null;
        }
        return con;
    }
}