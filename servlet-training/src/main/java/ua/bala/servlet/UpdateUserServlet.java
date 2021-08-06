package ua.bala.servlet;

import ua.bala.model.User;
import ua.bala.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(Utils.requestIsValid(req)){
            final String id = req.getParameter("id");
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");

            final User user = users.get(Integer.parseInt(id));
            user.setName(name);
            user.setAge(Integer.parseInt(age));
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String id = req.getParameter("id");

        log("update do get");

        if(Utils.idIsInvalid(id, users)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        final User user = users.get(Integer.parseInt(id));
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req, resp);
    }
}
