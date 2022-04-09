package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", value = "/cookie.view")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cookieInHeader = request.getHeader("cookie");
        out.println("Request对象Header中的Cookie字符串："+cookieInHeader+"</br>");
        Cookie[] cookies = request.getCookies();
        out.println("遍历从Request对象中获取的Cookie对象数组：</br>");
        for (Cookie c :cookies
        ) {
            out.println("Cookie Name:"+c.getName()+"  Cookie Value:"+c.getValue()+"</br>");
        }

        //发送一个Cookie，secret=123456
        Cookie cookie = new Cookie("secret","123456");
        cookie.setMaxAge(60*60);
        out.println(cookie.getMaxAge());
        response.addCookie(cookie);
        //获取Cookie
        out.println("请刷新本页面，将看到新添加的Cookie</br>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
