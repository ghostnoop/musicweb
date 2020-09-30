package models.repositories;

import app.Constants;
import models.entities.User;
import service.SQLGenerator;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static app.Utils.fromResultSetToObjectList;

public class UserRepositoryJdbc implements UserRepository {
    private Connection connection;

    public UserRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }



    @Override
    public List<User> getAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();
        String s = SQLGenerator.generateGetAll(User.class);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(s);

            return fromResultSetToObjectList(resultSet, new User());


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }

    @Override
    public User getById(int id) {

        PreparedStatement preparedStatement = null;
        try {
            String s = SQLGenerator.generateGetById(User.class);
            preparedStatement = connection.prepareStatement(s);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public boolean save(User entity) {
        PreparedStatement preparedStatement = null;

        try {
            String s = SQLGenerator.generateSave(User.class);

            preparedStatement = connection.prepareStatement(s, 1);

            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getLastname());
            preparedStatement.setString(4, entity.getAvatar_img());
            preparedStatement.setString(5, entity.getPassword());


            preparedStatement.executeUpdate();
            ResultSet id = preparedStatement.getGeneratedKeys();

            return id.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateById(User entity, int _id) {
        PreparedStatement preparedStatement = null;
        String s = SQLGenerator.generateUpdateById(User.class);


        try {
            preparedStatement = connection.prepareStatement(s);

            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getLastname());
            preparedStatement.setString(4, entity.getAvatar_img());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setInt(6, _id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int _id) {
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String s = SQLGenerator.generateDeleteById(User.class);
        try {
            preparedStatement = connection.prepareStatement(s);
            preparedStatement.setInt(1, _id);
            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean emailExist(String email) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_USER_EMAIL_EXIST);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;

    }
}
