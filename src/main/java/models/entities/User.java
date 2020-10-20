package models.entities;

import annotation.Constraint;
import annotation.Table;
import app.Utils;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "liked")
public class User {
    @Constraint(pk = true, uniq = true)
    private int id;
    private String email;
    private String name;
    private String lastname;
    private String password;
    private String avatar_img;
    private Date created_at;

    //    GET from table
    public User(int id, String email, String name, String lastname, String avatar_img, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = password;
        this.created_at = created_at;
    }

    //    POST from user
    public User(String email, String name, String lastname, String avatar_img, String password) {
        this.id = 0;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = Utils.hashingPassword(password);
    }

    public User() {

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
