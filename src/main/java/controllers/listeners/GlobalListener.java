package controllers.listeners;

import app.Constants;
import app.DataSourcePick;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

public class GlobalListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("datasource", DataSourcePick.getDataSource());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("datasource", null);

    }
}
