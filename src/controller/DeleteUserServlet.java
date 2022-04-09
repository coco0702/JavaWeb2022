package controller;

import dao.UserMapDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DeleteUserServlet", value = "/delete.do")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("u");
        Map<String, User> userMap = (Map<String, User>) request.getServletContext().getAttribute(IndexServlet.USER_MAP);
        UserMapDao dao = new UserMapDao(userMap);
        dao.delete(username);
        response.sendRedirect("users.view");
    }


}
