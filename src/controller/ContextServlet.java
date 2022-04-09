package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Steven Suo
 * ServletContext对象使用范例
 */
@WebServlet(name = "ContextServlet", value = "/context.view")
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取ServletContext对象
        ServletContext application = this.getServletContext();
        //获取初始化参数
        String webName = application.getInitParameter("ProjectName");
        //输出
        out.println("输出在web.xml中设置的应用参数ProjectName："+webName+"</br>");
        //存储全局变量，这儿是实现一个访问计数器
        //访问计数保存在ServletContext对象，保存的属性名为：count
        Integer count = (Integer) application.getAttribute("count");
        //第一次计数时，count为null，所以需要先初始化
        if (count == null){
            count = 1;
        }else{
            count++;
        }
        //完成本次计数后，将计数值重新存入ServletContext的count属性中
        application.setAttribute("count",count);
        //输出访问计数值
        response.getWriter().println("本Servlet被访问次数："+count+"</br>");
        out.println("请刷新页面查看访问计数的变化");
    }


}
