/**
 * @author Gilyazov Marat
 * 11-905
 */

package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourcePick {
    public Connection openConnection(String url, String username, String pass) {
        try {
            return DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
}
