package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", value = "/session.view")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       HttpSession session = request.getSession();
       session.setAttribute("secret","servlet");
       out.println("Session ID:"+session.getId()+"</br>");
       out.println("Session 默认最大存活时间:"+session.getMaxInactiveInterval()+"</br>");
       session.setMaxInactiveInterval(60 * 60);
       out.println("Session 最大存活时间:"+session.getMaxInactiveInterval()+"</br>");
       out.println("Session中保存的loginUser属性:"+(String)session.getAttribute("loginUser")+"</br>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
