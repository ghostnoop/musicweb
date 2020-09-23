/**
 * @author Gilyazov Marat
 * 11-905
 */

package model.repositories;

import app.Parser;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    private Connection connection;

    public UserRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    private String SQL_SELECT_ALL = "SELECT * FROM user";
    private String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id= ";

    @Override
    public List<User> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                users.add(new User(resultSet));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }

    @Override
    public User findById(int id) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            if (resultSet.next()) {
                return new User(resultSet);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }
}
