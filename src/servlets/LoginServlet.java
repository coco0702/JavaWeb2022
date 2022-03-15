package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven Suo
 * 登录认证Servlet，对应前端的login.html页面
 */
@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    private Map<String,String> userMap;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userMap = new HashMap<>();
        userMap.put("tomcat","1111");
        userMap.put("admin","123456");
        System.out.println("初始化 LoginServlet");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置响应内容类型为HTML，编码集为UTF-8
        response.setContentType("text/html; charset=UTF-8");
        //获取响应输出流
        PrintWriter out = response.getWriter();
        if (userMap.containsKey(username)){
            String pwd = userMap.get(username);
            if (pwd.equals(password)){
                //认证成功，跳转到index.html页面
                request.getRequestDispatcher("index.html").forward(request,response);
            }else{
                //输出
                out.println("密码错误，请重新登录！3秒后会自动返回到登录页面");
                response.setHeader("Refresh","3;URL=login.html");
            }
        }else{
            out.println("用户名不存在，请重新输入！3秒后会自动返回到登录页面");
            response.setHeader("Refresh","3;URL=login.html");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("注销LoginServlet对象");
    }
}
