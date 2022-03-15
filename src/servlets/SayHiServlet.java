package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 打招呼
 * 前端传过来一个用户名，然后输出“您好，用户名！”
 * 支持get和post请求
 * 对应前端的sayHi.html
 */
@WebServlet(name = "SayHiServlet", value = "/sayHi.do")
public class SayHiServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求数据的编码集，以解析POST方式提交的中文数据
        request.setCharacterEncoding("UTF-8");
        //获取用户提交的用户名
        String name = request.getParameter("username");
        //设置响应内容类型为HTML，编码集为UTF-8
        response.setContentType("text/html; charset=UTF-8");
        //获取响应输出流
        PrintWriter out = response.getWriter();
        //输出
        out.println("您好："+name);
        out.close();
    }
}
