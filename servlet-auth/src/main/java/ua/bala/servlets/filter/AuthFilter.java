package ua.bala.servlets.filter;

import ua.bala.dao.UserDAO;
import ua.bala.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        final HttpSession session = req.getSession();

        System.out.println(dao);
        System.out.println(dao.get());


        if(nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))){

            final User.ROLE role = (User.ROLE) session.getAttribute("role");

            moveToMenu(req, resp, role);
        } else if (dao.get().userIsExist(login, password)){

            final User.ROLE role = dao.get().getRoleByLoginAndPassword(login, password);

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, resp, role);
        } else {

            moveToMenu(req, resp, User.ROLE.UNKNOWN);
        }
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse resp,
                            final User.ROLE role) throws ServletException, IOException {

        if(role.equals(User.ROLE.ADMIN)){
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
        } else if(role.equals(User.ROLE.USER)){
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
