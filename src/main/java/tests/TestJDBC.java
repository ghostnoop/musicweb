package tests;

import app.Constants;
import app.DataSourcePick;
import models.entities.User;
import models.repositories.UserRepositoryJdbc;

import java.sql.Connection;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {
        DataSourcePick sourcePick = new DataSourcePick();

        Connection connection = sourcePick.openConnection(Constants.jdbcUrl, Constants.jdbcUser, Constants.jdbcPassword);

        System.out.println("USER ORM");

        System.out.println("GET ALL USERS ->");
        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(connection);
        List<User> users = userRepositoryJdbc.getAll();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println("END");

        System.out.println("GET USER BY ID->");
        User user = userRepositoryJdbc.getById(2);
        System.out.println(user);
        System.out.println("END");

        System.out.println("INSERT USER");
        User user1 = new User("email@gmail.com", "name", "lastname", "avatarimg.png", "password");
        System.out.println(userRepositoryJdbc.save(user1));
        System.out.println("END");

        System.out.println("UPDATE USER");
        User user2 = new User("1email@gmail.com", "updated", "1lastname", "1avatarimg.png", "1password");
        System.out.println(userRepositoryJdbc.updateById(user2, 1));
        System.out.println("END");

        System.out.println("DELETE USER");
        System.out.println(userRepositoryJdbc.deleteById(1));
        System.out.println("END");

        System.out.println("EMAIL EXIST");
        String email="email@gmail.com";
        System.out.println(userRepositoryJdbc.emailExist(email));
        System.out.println("END");


    }
}
