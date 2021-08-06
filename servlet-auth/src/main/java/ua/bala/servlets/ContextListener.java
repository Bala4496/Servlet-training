package ua.bala.servlets;

import ua.bala.dao.UserDAO;
import ua.bala.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

import static ua.bala.model.User.ROLE.ADMIN;
import static ua.bala.model.User.ROLE.USER;

public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        dao = new AtomicReference<>(new UserDAO());

        System.out.println("dao created");
        dao.get().add(new User(1, "Igor", "1", ADMIN));
        dao.get().add(new User(2, "Bala", "2", USER));

        System.out.println("dao users added");
        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
        System.out.println("dao servletContext.setAttribute done");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        dao = null;
    }
}
