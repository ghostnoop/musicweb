package models.repositories.orm;

import annotation.ManyToOne;
import app.SqlUtils;
import lombok.Getter;
import mapper.DataMapper;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

public class OrmRepositoryJdbc {
    @Getter
    private final DataSource dataSource;
    private final DataMapper dataMapper;

    public OrmRepositoryJdbc(DataSource dataSource, DataMapper dataMapper) {
        this.dataSource = dataSource;
        this.dataMapper = dataMapper;
    }

    public <T> List<T> findAll(Class<T> tClass) {
        try {
            Statement statement = dataSource.getConnection().createStatement();

            StringBuilder query = new StringBuilder("SELECT ");
            Stream.of(tClass.getDeclaredFields()).forEach(field -> {
                if (field.getAnnotation(ManyToOne.class) == null) {
                    query.append(SqlUtils.recognizeFieldDefinition(tClass, field))
                            .append(",");
                } else {
                    Stream.of(field.getType().getDeclaredFields()).forEach(subField -> {
                        query.append(SqlUtils.recognizeFieldDefinition(field.getType(), subField))
                                .append(",");
                    });
                }
            });
            String substring = query.substring(0, query.length() - 1);

            StringBuilder fromQuery = new StringBuilder(substring)
                    .append(" FROM ")
                    .append(SqlUtils.recognizeTableName(tClass));

            Stream.of(tClass.getDeclaredFields())
                    .filter(field -> field.getAnnotation(ManyToOne.class) != null)
                    .forEach(field -> {
                        try {
                            fromQuery.append(" inner join ")
                                    .append(SqlUtils.recognizeTableName(field.getType()))
                                    .append(" ")
                                    .append(SqlUtils.recognizeTableName(field.getType()))
                                    .append(" on ")
                                    .append(SqlUtils.recognizeTableName(field.getType()))
                                    .append(".")
                                    .append(field.getType().getDeclaredField("id").getName())
                                    .append("=")
                                    .append(SqlUtils.recognizeTableName(tClass))
                                    .append(".")
                                    .append(field.getName())
                                    .append(",");
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    });

            String finalSql = fromQuery.substring(0, fromQuery.length());
            ResultSet resultSet = statement.executeQuery(finalSql);

            return dataMapper.collectionMap(resultSet, tClass);
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
