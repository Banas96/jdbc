package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // httpa//github.com/Banas96
    // jdbc:mysql: //localhost:3306/java_app

    private final static String URL = "jdbc:mysql://localhost:3306/java_app";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    private Connection connection;

    public Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Brak drivera do bazy");
            System.exit(-1);
        }
    }
    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
