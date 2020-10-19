/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.jdbcUtils;

import models.repositories.interfaces.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbc {
    private final DataSource dataSource;

    public SimpleJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {

        ResultSet resultSet = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            List<T> result = new ArrayList<>();

            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));
            }
            resultSet.close();
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> boolean update(String sql, Object... args) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }


            return statement.executeUpdate()!= 0;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
