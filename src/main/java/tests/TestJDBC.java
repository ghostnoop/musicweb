package tests;

import app.Constants;
import app.DataSourcePick;
import app.Parser;
import model.User;
import model.repositories.UserRepositoryJdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class TestJDBC {
    public static void main(String[] args) {
        DataSourcePick sourcePick = new DataSourcePick();

        Connection connection = sourcePick.openConnection(Constants.jdbcUrl, Constants.jdbcUser, Constants.jdbcPassword);

        System.out.println("GET ALL USERS ->");
        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(connection);
        List<User> users = userRepositoryJdbc.findAll();

        for (int i = 0; i <users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println("END");

        System.out.println("GET USER BY ID->");
        User user = userRepositoryJdbc.findById(1);
        System.out.println(user);
        System.out.println("END");

    }
}
