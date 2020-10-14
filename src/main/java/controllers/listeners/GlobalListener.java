package controllers.listeners;

import app.Constants;
import app.DataSourcePick;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class GlobalListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataSourcePick dataSourcePick = new DataSourcePick(Constants.jdbcUrl,Constants.jdbcUser,Constants.jdbcPassword);
        servletContextEvent.getServletContext().setAttribute("datasource", dataSourcePick.getDataSourcePick());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("datasource", null);

    }
}
