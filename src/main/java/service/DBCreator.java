package service;

import annotation.Table;
import app.SqlUtils;
import caster.Castable;
import caster.IntegerCaster;
import caster.ManyToOneCaster;
import caster.StringCaster;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Stream;

public class DBCreator {

    private ArrayList<Castable> castables = new ArrayList<Castable>() {
        {
            add(new IntegerCaster());
        }

        {
            add(new StringCaster());
        }

        {
            add(new ManyToOneCaster());
        }
    };

    public void create() {
        Reflections reflections = new Reflections(
                "models.entities",
                new TypeAnnotationsScanner(),
                new SubTypesScanner()
        );

        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Table.class);
        entities.forEach(aClass -> {
            StringBuilder sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS " + SqlUtils.recognizeTableName(aClass) + " (");

            Stream.of(aClass.getDeclaredFields())
                    .forEach(field -> {
                        sql.append(castables.stream()
                                .filter(castable -> castable.isSupport(field))
                                .map(castable -> castable.cast(field))
                                .findFirst()
                                .orElse("")).append(", ")
                        ;

                    });

            String finalSql = sql.substring(0, sql.length() - 2) + ");";
            try {
                execute(finalSql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void execute(String finalSql) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/test_db?useSSL=false";
        String user = "root";
        String password = "";


        try (Connection connection = DriverManager.getConnection(
                url, user, password)) {

            connection.prepareCall(finalSql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
