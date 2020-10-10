package models.entities;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Artist {
    private int id;
    private String email;
    private String name;
    private String lastname;
    private String avatar_img;
    private String password;
    private Date created_at;

    public Artist(int id, String email, String name, String lastname, String avatar_img, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = password;
        this.created_at = created_at;
    }

    public Artist(String email, String name, String lastname, String avatar_img, String password) {
        this.id = 0;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = password;
        this.created_at = null;
    }

    public Artist() {
    }
    public Artist(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", avatar_img='" + avatar_img + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public Artist(ResultSet resultSet) {
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

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public String getPassword() {
        return password;
    }
}
