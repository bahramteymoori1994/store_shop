package storeshop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "admin";
        String password = "admin123";

        return DriverManager.getConnection(url, user, password);
    }
}