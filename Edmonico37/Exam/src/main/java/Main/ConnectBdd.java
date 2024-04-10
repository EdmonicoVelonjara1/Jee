package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBdd {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/mit";
    private static final String DB_USER = "mit";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection() {
        try {
//            Class.forName("org.mariadb.jdbc.Driver");
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");       
            } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
