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
@Table(name = "user")
public class User {
    @Constraint(pk = true, uniq = true)
    private int id;
    private String email;
    private String name;
    private String lastname;
    private String avatar_img;
    private String password;
    private Date created_at;

    public User() {

    }

    public User(int id, String email, String name, String lastname, String avatar_img, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.avatar_img = avatar_img;
        this.password = password;
        this.created_at = created_at;
    }


}
