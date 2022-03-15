package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 第一个Servlet，输出“Hello Servlet”
 * 只响应Get请求
 */
@WebServlet(urlPatterns = "/hello_servlet.html")
@MultipartConfig
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型为HTML，编码集为UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        //获取响应输出流
        PrintWriter out = resp.getWriter();
        //输出
        out.println("Hello Servlet!");
        out.close();
    }



}
