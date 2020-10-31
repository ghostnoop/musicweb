package controllers.listeners;

import app.Constants;
import app.DataSourcePick;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataSourcePick dataSourcePick = new DataSourcePick(Constants.jdbcUrl, Constants.jdbcUser, Constants.jdbcPassword);
        servletContextEvent.getServletContext().setAttribute("datasource", dataSourcePick);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("datasource", null);

    }
}
