package controller;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UsersServlet", value = "/users.view")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用Session验证身份
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser")==null){
            response.sendRedirect("index.html");
        }else{
            String loginUser = (String) session.getAttribute("loginUser");
            if ("admin".equals(loginUser)){
                Map<String, User> userMap = (Map<String, User>) request.getServletContext().getAttribute(IndexServlet.USER_MAP);
               // UserDao userDao = new UserDao(userMap);
                UserDao dbDao = new UserDao();
                request.setAttribute("users",dbDao.selectAll());
                request.getRequestDispatcher("users.jsp").forward(request,response);
            }else{
                response.getWriter().println("无权访问");
                response.setHeader("refresh","3;url=home.htm");
            }

        }
        //使用Cookie验证
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies
        ) {
            if ("admin".equals(cookie.getName()) && "123456".equals(cookie.getValue())){
                request.getRequestDispatcher("users.html").forward(request,response);
            }
        }
        response.sendRedirect("login.html");*/
    }

}
