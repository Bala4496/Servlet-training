package ua.bala.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.bala.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/json-page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String data = req.getParameter("data");
        final User user = new ObjectMapper().readValue(data, User.class);

        logUser(user);
    }

    private void logUser(final User user) {
        System.out.println("User unmarshalling : " + user);
        System.out.println("Id : " + user.getId());
        System.out.println("Name : " + user.getName());
        System.out.println("Age : " + user.getAge());
    }
}
