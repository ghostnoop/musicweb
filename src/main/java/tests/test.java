/**
 * @author Gilyazov Marat
 * 11-905
 */

package tests;

import models.entities.User;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static app.Constants.regexEmail;


public class test {
    public static void main(String[] args) {
        HashMap<String, Integer> filterItems = new HashMap<String, Integer>() {
            {
                put("--", 0);
                put("Likes", 1);
                put("New", 2);
            }
        };
        String filterName=null;
        Integer filterIndex=filterItems.get(filterName);
        System.out.println(filterIndex);
//        return filterIndex!=null?filterIndex:0;

        System.out.println(filterItems.get("--3"));
//        User user = new User(1, "test@email", "фвфыв", "фвфывфыв", "вффывфыв", "йуйцуйцвыф23424", new Date());


    }



}
