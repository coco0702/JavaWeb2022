package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
/**
 * @author Steven Suo
 * 日志过滤器，记录下所有
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("请求的URL:"+request.getRequestURI());
        System.out.println("请求的IP:"+request.getRemoteAddr());
        System.out.println("请求的时间:"+ new Date());
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
