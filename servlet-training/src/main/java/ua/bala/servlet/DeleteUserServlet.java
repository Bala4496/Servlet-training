package ua.bala.servlet;

import ua.bala.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)) users.remove(Integer.valueOf(req.getParameter("id")));

        System.out.println(users.toString());
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
