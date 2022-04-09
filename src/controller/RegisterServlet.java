package controller;

import entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet", value = "/register.do")
public class RegisterServlet extends HttpServlet {

    public static final String USER_MAP = "userMap";
    private Map<String, User> userMap;

    @Override
    @SuppressWarnings("unchecked")
    public void init(ServletConfig config) throws ServletException {
        //0、获取userMap
        ServletContext sc = config.getServletContext();
        if (sc.getAttribute(USER_MAP) == null){
            userMap = new HashMap<String, User>();
        }else{
            userMap = (Map<String, User>) sc.getAttribute(USER_MAP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取用户提交的信息
        String username = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String[] interests = request.getParameterValues("interest");
        //2、将用户数据封装成一个User对象
        User user = new User();
        user.setUserName(username);
        user.setPwd(pwd);
        user.setGender(gender);
        user.setCategory(category);
        user.setInterest(Arrays.toString(interests));
        //3、检查该用户名是否已注册

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (userMap.containsKey(username)){
            //已经注册，重新选择用户名注册
            out.println("该用户名已注册，请选择其他用户名注册");
            response.setHeader("Refresh","1;URL=register.html");
        }else{
            //该用户名未注册，将用户对象放入到userMap中
            userMap.put(username, user);
            //将userMap放入到ServletContext对象中
            request.getServletContext().setAttribute(USER_MAP,userMap);
            out.println("注册成功");
            response.setHeader("Refresh","1;URL=login.html");
        }

    }
}
