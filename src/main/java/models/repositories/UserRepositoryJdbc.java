package models.repositories;

import app.Constants;
import models.entities.User;
import models.repositories.interfaces.RowMapper;
import models.repositories.interfaces.UserRepository;
import models.repositories.jdbcUtils.SimpleJdbc;
import service.SQLGenerator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static app.Utils.fromResultSetToObjectList;

public class UserRepositoryJdbc implements UserRepository {
    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    private final RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getInt("id"))
            .email(row.getString("email"))
            .name(row.getString("name"))
            .lastname(row.getString("lastname"))
            .password(row.getString("password"))
            .avatar_img(row.getString("avatar_img"))
            .created_at(row.getDate("created_at"))
            .build();

    @Override
    public List<User> getAll() {
        return simpleJdbc.query(SQLGenerator.generateGetAll(User.class), userRowMapper);
    }

    @Override
    public User getById(int id) {
        List<User> users = simpleJdbc.query(SQLGenerator.generateGetById(User.class), userRowMapper, id);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public boolean save(User entity) {
        return simpleJdbc.update(SQLGenerator.generateSave(User.class),
                entity.getEmail(),
                entity.getName(),
                entity.getLastname(),
                entity.getAvatar_img(),
                entity.getPassword()
        );
    }

    @Override
    public boolean updateById(User entity, int _id) {
        return simpleJdbc.update(SQLGenerator.generateUpdateById(User.class),
                entity.getEmail(),
                entity.getName(),
                entity.getLastname(),
                entity.getAvatar_img(),
                entity.getPassword(),
                _id
        );
    }

    @Override
    public boolean deleteById(int _id) {
        return simpleJdbc.update(SQLGenerator.generateDeleteById(User.class), _id);
    }

    @Override
    public boolean emailExist(String email) {
        List<User> user = simpleJdbc.query(Constants.SQL_USER_EMAIL_EXIST, userRowMapper, email);
        return !user.isEmpty();
    }

    @Override
    public User getByEmail(String email) {
        List<User> user = simpleJdbc.query(Constants.SQL_USER_EMAIL_EXIST, userRowMapper, email);
        return !user.isEmpty() ? user.get(0) : null;
    }


}
