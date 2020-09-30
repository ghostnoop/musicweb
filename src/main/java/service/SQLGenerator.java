

package service;

import app.Constants;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class SQLGenerator {
    public static String generateSave(Class us) {
        LinkedList<String> availableFields = new LinkedList<>();
        for (Field field : us.getDeclaredFields()) {
            if (!Constants.IGNFIELDS.contains(field.getName())) {
                availableFields.add(field.getName());

            }
        }
        StringBuilder s = new StringBuilder("insert into " + us.getSimpleName().toLowerCase() + " (");
        StringBuilder values = new StringBuilder("VALUES (");
        int size = availableFields.size();
        int k = 0;
        for (String field : availableFields) {
            if (k < size - 1) {
                s.append(field).append(", ");
                values.append("?,");
            } else {
                s.append(field).append(") ");
                values.append("?)");
            }
            k++;
        }

        s.append(values.toString());
        return String.valueOf(s);
    }

    public static String generateGetAll(Class us) {
        return "SELECT * FROM " + us.getSimpleName().toLowerCase();
    }

    public static String generateGetById(Class us) {
        return "SELECT * FROM " + us.getSimpleName().toLowerCase() + " WHERE id= ?";
    }

    public static String generateDeleteById(Class us) {
        return "DELETE FROM " + us.getSimpleName().toLowerCase() + " WHERE id= ?";
    }

    public static String generateUpdateById(Class us) {
        LinkedList<String> availableFields = new LinkedList<>();
        for (Field field : us.getDeclaredFields()) {
            if (!Constants.IGNFIELDS.contains(field.getName())) {
                availableFields.add(field.getName());
            }
        }


        StringBuilder s = new StringBuilder("update " + us.getSimpleName().toLowerCase() + " set ");
        int size = availableFields.size();
        int k = 0;
        for (String field : availableFields) {
            if (k < size - 1) {
                s.append(field + "= ?, ");
            } else
                s.append(field + "= ? where id= ?");
            k++;

        }

        return String.valueOf(s);
    }
}
