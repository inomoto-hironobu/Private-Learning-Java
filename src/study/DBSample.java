package study;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSample {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:h2:file:~/platform/db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
