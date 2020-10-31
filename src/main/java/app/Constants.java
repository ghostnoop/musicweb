package app;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {
    public static String jdbcUrl = "jdbc:mysql://localhost:3306/musicweb?useSSL=false";
    public static String jdbcUser = "root";
    public static String jdbcPassword = "";

    public static final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static String SQL_USER_EMAIL_EXIST = "SELECT id, email, name, lastname, avatar_img, password, created_at FROM user WHERE email= ? LIMIT 1";
    public static String upload_dir = "C:\\Users\\Marat\\Documents\\GitHub\\musicweb\\uploads";

    public String SQL_SELECT_ALL = "SELECT * FROM user";
    public String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id= ";
    public String SQL_INSERT = "insert into user (email, name, lastname, avatar_img, password) VALUES " + "(?, ?, ?, ?,?)";
    public String SQL_UPDATE = "update user set email= ?, name = ?, lastname = ?, avatar_img = ?, password = ? where id = ?";
    public String SQL_DELETE = "delete from user where id= ?";
    public static String[] INSERT_IGNOREFIELDS = new String[]{"id", "created_at"};
    public static HashSet<String> IGNFIELDS = Stream.of("id", "created_at")
            .collect(Collectors.toCollection(HashSet::new));


}
