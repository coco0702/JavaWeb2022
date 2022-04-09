<%--
  Created by IntelliJ IDEA.
  User: Steven Suo
  Date: 2022/3/30
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    out.println(username);


%>
${param.username}

