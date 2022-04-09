package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Steven Suo
 * Home页面需要先登录,再访问
 */
@WebServlet(name = "HomeServlet", value = "/home.html")
public class HomeServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户是否登录的标记就是session对象中是否有命名为loginUser的属性，如果有表示已登录，如果没有则表示未登录
        if(request.getSession().getAttribute(LoginServlet.LOGIN_USER)!=null){
            request.getRequestDispatcher("home.htm").forward(request,response);
        }else{
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("未登录，请先登录后访问！");
            response.setHeader("Refresh","2;URL=index.html");
        }
    }

}
