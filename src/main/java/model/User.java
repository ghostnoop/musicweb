package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class User {
    private int id;
    private String email;
    private String name;
    private String lastname;
    private String avatar_img;
    private String password;
    private Date created_at;

    public User(int id, String email, String name, String lastname, String avatar_img, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = password;
        this.created_at = created_at;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", avatar_img='" + avatar_img + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.email = resultSet.getString("email");
            this.name = resultSet.getString("name");
            this.lastname = resultSet.getString("lastname");
            this.avatar_img = resultSet.getString("avatar_img");
            this.password = resultSet.getString("password");
            this.created_at = resultSet.getDate("created_at");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
