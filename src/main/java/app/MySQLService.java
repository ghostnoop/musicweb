package app;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLService {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test_db?useSSL=false";
        String user = "root";
        String password = "";

        String query = "SELECT VERSION()";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(MySQLService.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
