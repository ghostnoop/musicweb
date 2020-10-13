package app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static app.Constants.*;

public class DataSourcePick {
    public Connection openConnection(String url, String username, String pass) {
        try {
            return DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
    public static DataSource getDataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(jdbcUser);
        hikariConfig.setPassword(jdbcPassword);
        hikariConfig.setMaximumPoolSize(10);

        return new HikariDataSource(hikariConfig);
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
}
