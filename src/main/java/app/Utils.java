

package app;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

import static app.Constants.upload_dir;

public class Utils {
    public Connection openConnection(String url, String username, String pass) {
        try {
            return DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T fromResultSetToObject(ResultSet resultSet, T t) {
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int cols = rsmd.getColumnCount();
            for (int i = 0; i < cols; i++) {
                Field f1 = t.getClass().newInstance().getClass().getDeclaredField(rsmd.getColumnLabel(i + 1));
                f1.setAccessible(true);
                f1.set(t, resultSet.getObject(i + 1));

            }
            return t;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> ArrayList<T> fromResultSetToObjectList(ResultSet resultSet, T t_old) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Object t = t_old.getClass().newInstance();
                int aaa = resultSet.getInt("id");
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int cols = rsmd.getColumnCount();
                for (int i = 0; i < cols; i++) {
                    Field f1 = t.getClass().newInstance().getClass().getDeclaredField(rsmd.getColumnLabel(i + 1));
                    f1.setAccessible(true);
                    f1.set(t, resultSet.getObject(i + 1));

                }
                arrayList.add((T) t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String hashingPassword(String password) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] data = password.getBytes(StandardCharsets.UTF_8);
            messageDigest.update(data);
            byte[] hash = messageDigest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static String fileSaver(Part file) {
        try {
            String file_name = UUID.randomUUID().toString() +
                    "-" +
                    file.getSubmittedFileName();

            IOUtils.copyLarge(
                    file.getInputStream(),
                    new FileOutputStream(upload_dir +
                            File.separator +
                            file_name
                    )
            );
            return file_name;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
