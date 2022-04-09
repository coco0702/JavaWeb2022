package controller;

import dao.IUserDao;
import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author Steven Suo
 * 登录认证Servlet，对应前端的login.html页面
 */
@WebServlet(name = "LoginServlet",loadOnStartup=1, value = "/login.do")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_USER = "loginUser";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户输入的用户名和密码
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        //验证码
        String code = request.getParameter("code");
        //设置响应内容类型为HTML，编码集为UTF-8
        response.setContentType("text/html; charset=UTF-8");
        //获取响应输出流
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //先判断ServletContext中是否有userMap，如果没有，表示没有用户注册过，需要先注册
      /*  if (request.getServletContext().getAttribute(IndexServlet.USER_MAP) == null) {
            out.println("请先注册......");
            response.setHeader("Refresh","1;URL=register.html");
        }*/
        //判断验证码是否正确
        if(session.getAttribute(CaptchaServlet.CAPTCHA) == null || !session.getAttribute(CaptchaServlet.CAPTCHA).equals(code)){
                out.println("验证码错误，请重新输入！");
                response.setHeader("Refresh","1;URL=index.html");
            }
        else{
            //取出userMap
            Map<String,User> userMap = (Map<String, User>) request.getServletContext().getAttribute(IndexServlet.USER_MAP);
            IUserDao dao = new UserDao();
            //认证用户名和密码
            if (dao.authenticate(username,password)){
                request.getSession().setAttribute(LOGIN_USER,username);
                System.out.println(request.getParameter("rememberMe"));
                response.sendRedirect("home.html");
            }else{
                out.println("用户名或密码错误！......");
                response.setHeader("Refresh","1;URL=index.html");
            }
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("注销LoginServlet对象");
    }
}
