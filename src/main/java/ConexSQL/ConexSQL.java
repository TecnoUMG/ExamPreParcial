package ConexSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexSQL {
        private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_telebot";
        private static final String USER = "root";
        private static final String PASSWORD = "DeLeonSar36202122";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

