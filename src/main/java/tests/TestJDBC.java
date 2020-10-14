package tests;

import app.Constants;
import app.DataSourcePick;
import com.google.gson.Gson;
import models.entities.Album;
import models.entities.Artist;
import models.entities.Song;
import models.entities.User;
import models.repositories.AlbumRepositoryJdbc;
import models.repositories.SongRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;
import service.SQLGenerator;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {
//        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(DataSourcePick.getDataSource());
//
//        System.out.println(userRepositoryJdbc.getAll());
//        System.out.println(userRepositoryJdbc.getById(2));
//
//        User user2 = new User("1emaillmao@gmail.com", "updated", "1lastname", "1avatarimg.png", "1password");
////        System.out.println(userRepositoryJdbc.save(user2));
//        System.out.println(userRepositoryJdbc.updateById(user2,2));
//
//        System.out.println(userRepositoryJdbc.getById(2));
//        System.out.println(userRepositoryJdbc.deleteById(2));
//        System.out.println(userRepositoryJdbc.getById(2));

//        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(DataSourcePick.getDataSource());
//        System.out.println(songRepositoryJdbc.getById(1));
//        System.out.println(albumRepositoryJdbc.getAll());
//        String s= SQLGenerator.generateSave(Album.class);
//        System.out.println(s);
//        Album album=new Album(1, "title", "description", "cover_img",
//                new Artist(1, "emaol@gmail.com", "name smh", "lastname", "avatar_img", "password", new Date()));
//        boolean ans = albumRepositoryJdbc.save(album);
//        System.out.println(ans);
//        String UPD_BY_ID=SQLGenerator.generateUpdateById(Album.class);
//        System.out.println(UPD_BY_ID);
        boolean answ=false;

        String json = new Gson().toJson(answ );
        System.out.println(json);
    }

    public static void testUserJdbc(Connection connection) {
//        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(connection);
//
//
//        System.out.println("USER ORM");
//
//        System.out.println("GET ALL USERS ->");
//        List<User> users = userRepositoryJdbc.getAll();
//
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i));
//        }
//        System.out.println("END");
//
//        System.out.println("GET USER BY ID->");
//        User user = userRepositoryJdbc.getById(2);
//        System.out.println(user);
//        System.out.println("END");
//
//        System.out.println("INSERT USER");
//        User user1 = new User("email@gmail.com", "name", "lastname", "avatarimg.png", "password");
//        System.out.println(userRepositoryJdbc.save(user1));
//        System.out.println("END");
//
//        System.out.println("UPDATE USER");
//        User user2 = new User("1email@gmail.com", "updated", "1lastname", "1avatarimg.png", "1password");
//        System.out.println(userRepositoryJdbc.updateById(user2, 1));
//        System.out.println("END");
//
//        System.out.println("DELETE USER");
//        System.out.println(userRepositoryJdbc.deleteById(1));
//        System.out.println("END");
//
//        System.out.println("EMAIL EXIST");
//        String email="email@gmail.com";
//        System.out.println(userRepositoryJdbc.emailExist(email));
//        System.out.println("END");
    }
}
