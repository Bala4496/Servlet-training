package ua.bala.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetIndexPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("simpleOutput", new Poem());

        final List<String> operations = new ArrayList<>();
        operations.add("eq - проверка на равенство");
        operations.add("ne - проверка на неравенство");
        operations.add("lt - строго менее чем");
        operations.add("gt - строго более чем");
        operations.add("le - менее либо равно чему-то");
        operations.add("ge - более либо равно чему-то");
        req.setAttribute("operations", operations);

        req.setAttribute("condition", true);

        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    public static class Poem {
        private String text = "Пой же, пой. На проклятой гитаре\n" +
                "Пальцы пляшут твои вполукруг.\n" +
                "Захлебнуться бы в этом угаре,\n" +
                "Мой последний, единственный друг.\n" +
                "Сергей Есенин — Пой же, пой";

        public String getText() {
            return text;
        }
    }
}
