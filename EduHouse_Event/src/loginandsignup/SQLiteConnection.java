package loginandsignup;

import java.sql.*;

public class SQLiteConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // Will create this file if it doesn't exist
            String url = "jdbc:sqlite:java_evet_db.db"; // in project folder
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite.");
        } catch (Exception e) {
            System.out.println("SQLite connection error: " + e.getMessage());
        }
        return conn;
    }
}
