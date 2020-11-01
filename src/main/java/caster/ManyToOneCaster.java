package caster;

import app.SqlUtils;

import annotation.ManyToOne;

import java.lang.reflect.Field;

public class ManyToOneCaster implements Castable {
    @Override
    public String cast(Field field) {

        return field.getName() + " INT " + SqlUtils.recognizeConstraints(field) + " " + SqlUtils.recognizeForeignKey(field);
    }

    @Override
    public boolean isSupport(Field field) {
        return field.getAnnotation(ManyToOne.class) != null;
    }
}
