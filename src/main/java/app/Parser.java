

package app;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Parser {
    public static ArrayList<Object> parser(Object object, ResultSet resultSet) {
        ArrayList<Object> list = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {


            try {

                switch (field.getType().getSimpleName()) {
                    case "int":
                        list.add(resultSet.getInt(field.getName()));
                        break;
                    case ("String"):
                        list.add(resultSet.getString(field.getName()));
                        break;
                    case ("Date"):
                        list.add(resultSet.getDate(field.getName()));
                        break;
                }
            } catch (SQLException ex) {
            }


        }
        return list;


    }
}
