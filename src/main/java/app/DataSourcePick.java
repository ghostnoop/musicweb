package app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSourcePick {
    public HikariDataSource getDataSourcePick() {
        return hikariDataSource;
    }

    private HikariDataSource hikariDataSource;
    public Connection openConnection(String url, String username, String pass) {
        try {
            return DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
    public DataSourcePick(String jdbcUrl,String jdbcUser,String jdbcPassword){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(jdbcUser);
        hikariConfig.setPassword(jdbcPassword);
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(20);
        hikariDataSource=new HikariDataSource(hikariConfig);
        DataSource dataSource = hikariDataSource;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
}
