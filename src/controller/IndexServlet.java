package controller;

import dao.UserMapDao;
import entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginViewServlet", value = "/index.html")
public class IndexServlet extends HttpServlet {

    public static final String USER_MAP = "userMap";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //db.selectAll();
        //1、自动登录
        //声明变量表示从cookie中获取的用户名和密码
        String username = null;
        String pwd = null;
        //获取Cookie数组
        Cookie[] cookies = request.getCookies();
        //遍历Cookie数组，从中获取保存在Cookie中的用户名和密码以实现自动登录
        //保存用户名的Cookie命名为username
        //保存用户密码的Cookie命名为password
        if (cookies != null){
            for (Cookie cookie:cookies
            ) {
                if ("username".equals(cookie.getName())){
                    username = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    pwd = cookie.getValue();
                }
            }
        }
        //如果没有从Cookie中获取到用户名或密码，或ServletContext中没有userMap，都跳转到登录页面，login.html
        if (username == null || pwd == null || request.getServletContext().getAttribute(USER_MAP) == null) {
            request.getRequestDispatcher("login.html").forward(request,response);
        }else{
            //验证Cookie中的用户名和密码是否正确
            //从ServletContext中取出userMap
            ServletContext sc = request.getServletContext();
            Map<String, User> userMap = (Map<String, User>) sc.getAttribute(USER_MAP);
            UserMapDao userMapDao = new UserMapDao(userMap);
            if (userMapDao.authenticate(username,pwd)){
                request.getSession().setAttribute("loginUser",username);
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().println("自动登录中...");
                response.setHeader("Refresh","1;URL=home.html");
            }else{
                request.getRequestDispatcher("login.html").forward(request,response);
            }
        }
    }

}
