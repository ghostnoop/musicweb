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

    static HashSet<String> IGNORFIELDS = Stream.of("id", "created_at")
            .collect(Collectors.toCollection(HashSet::new));


}
