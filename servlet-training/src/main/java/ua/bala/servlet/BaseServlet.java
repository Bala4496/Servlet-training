package ua.bala.servlet;

import ua.bala.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseServlet extends HttpServlet {

    protected Map<Integer, User> users;

    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");

        if(users == null || !(users instanceof ConcurrentHashMap)){
            throw new IllegalStateException("Your repo doesn't initialize!");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }
    }
}
