package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 文件上传处理的Servlet，对应前端的uploadFile.html
 */
@WebServlet(name = "UploadServlet", value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上传文件对应的Part对象，该方法的参数与上传表单的name属性对应
        Part part = request.getPart("file");
        //获取上传文件的文件名
        String fileName = part.getSubmittedFileName();
        //获取上传文件保存的绝对路径
        String dir = request.getServletContext().getRealPath("/WEB-INF/upload/");
        //将上传文件写入到指定目录
        part.write(dir+fileName);
    }
}
