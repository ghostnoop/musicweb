/**
 * @author Gilyazov Marat
 * 11-905
 */

package tests;

import models.entities.User;

import java.lang.reflect.Field;
import java.util.Date;


public class test {
    public static void main(String[] args) {
        User user = new User(1, "test@email", "", "", "", "",new Date());

        try {

            Field f1 = user.getClass().newInstance().getClass().getDeclaredField("email");
            f1.setAccessible(true);
            f1.set(user, "reflecting on life");
            System.out.println(user.getEmail());

        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }

    }
//    public static Field setFieldValue(Object object, String fieldName, Object valueTobeSet) {
//        try {
//
////        Field field = getField(object.getClass(), fieldName);
////        field.setAccessible(true);
////        field.set(object, valueTobeSet);
////        return field;
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;

}
//}
