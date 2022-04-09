package filters;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener, ServletRequestListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.print("ServletContext 对象被创建");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("count",0);
        ServletContextListener.super.contextInitialized(sce);
    }
}
