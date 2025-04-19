package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String connStr = DBPropertyUtil.getPropertyString("db.properties");
                connection = DriverManager.getConnection(connStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
