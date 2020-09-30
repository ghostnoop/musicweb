

package app;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

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
}
