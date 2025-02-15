package Repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {

    private final String URL = "jdbc:mysql://localhost:3306/db_to_do_list?" +
            "createDatabaseIfNotExist=true";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection getConnection() throws SQLException  {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
