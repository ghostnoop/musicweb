package listener;

import app.Constants;
import app.DataSourcePick;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Listener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataSourcePick sourcePick = new DataSourcePick();
        Connection connection = sourcePick.openConnection(Constants.jdbcUrl, Constants.jdbcUser, Constants.jdbcPassword);
        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(connection);
        servletContextEvent.getServletContext().setAttribute("jdbc", userRepositoryJdbc);
        servletContextEvent.getServletContext().setAttribute("connection", connection);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Connection connection = (Connection) servletContextEvent.getServletContext().getAttribute("connection");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
