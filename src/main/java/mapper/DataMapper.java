package mapper;

import annotation.ManyToOne;
import app.SqlUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataMapper {
    public <T> T singleMap(ResultSet resultSet, Class<T> tClass){
        return null;
    }

    public <T> List<T> collectionMap(ResultSet resultSet, Class<T> tClass) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayList<T> list = new ArrayList<>();
        while (resultSet.next()){
            T t = ConstructorUtils.invokeConstructor(tClass, null);
            Stream.of(tClass.getDeclaredFields()).forEach(field -> {
                try {
                    if (field.getAnnotation(ManyToOne.class) == null){
                        PropertyUtils.setProperty(t, field.getName(), resultSet.getObject(SqlUtils.recognizeTableName(tClass) + "_" +field.getName()));
                    } else {
                        Object subT = ConstructorUtils.invokeConstructor(field.getType(), null);
                        Stream.of(field.getType().getDeclaredFields()).forEach(subFields -> {
                            try {
                                PropertyUtils.setProperty(subT, subFields.getName(), resultSet.getObject(SqlUtils.recognizeTableName(field.getType()) + "_" +subFields.getName()));
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SQLException e) {
                                e.printStackTrace();
                            }
                        });
                        PropertyUtils.setProperty(t, field.getName(), subT);
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SQLException | InstantiationException e) {
                    e.printStackTrace();
                }
            });
            list.add(t);
        }
        return list;
    }
}
