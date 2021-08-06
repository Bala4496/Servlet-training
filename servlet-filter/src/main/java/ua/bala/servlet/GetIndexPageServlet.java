package ua.bala.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetIndexPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final HttpSession session = req.getSession();

        final String state = (String) session.getAttribute("state");

        if(state != null)
            req.setAttribute("dataForView", session.getAttribute("state"));

        req.getRequestDispatcher("/WEB-INF/view/filter-page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = req.getSession();

        final String state = (String) session.getAttribute("state");

        final String data = req.getParameter("data");

        if(state != null) {
            session.setAttribute("state", state + " : " + data);
        } else {

            session.setAttribute("state", data);
        }

        doGet(req, resp);
    }
}
