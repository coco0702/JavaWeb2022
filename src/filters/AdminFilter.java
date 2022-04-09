package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(value = "/admin/*")
public class AdminFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession s = request.getSession();
        if(s.getAttribute("loginUser")==null){
            response.sendRedirect("login.html");
        }else{
            String loginUser = (String) s.getAttribute("loginUser");
            if ("admin".equals(loginUser)){
                chain.doFilter(request, response);
            }else{
                response.getWriter().println("无权访问");
                response.setHeader("refresh","3;url=home.htm");
            }

        }
    }
}
