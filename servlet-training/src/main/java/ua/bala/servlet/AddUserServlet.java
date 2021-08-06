package ua.bala.servlet;

import ua.bala.model.User;
import ua.bala.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class AddUserServlet extends BaseServlet {

    private final AtomicInteger id = new AtomicInteger(2);;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (Utils.requestIsValid(req)) {
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");

            final User user = new User();
            final int id = this.id.getAndIncrement();
            user.setId(id);
            user.setName(name);
            user.setAge(Integer.parseInt(age));

            users.put(id, user);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
