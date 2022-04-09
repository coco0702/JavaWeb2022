<%@ page import="entity.User" %>
<!--JSP的page指令，指令元素-->
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>首页</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/main1.css" rel="stylesheet">
	</head>
	<body>
<!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <!-- 导航栏 开始-->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Project</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">首页</a></li>
          <li><a href="admin.jsp">管理页面</a></li>
          <li><a href="#">退出</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
   <!-- 导航栏 结束-->
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>成功登录！</h1>
    </div>
    <p class="lead">欢迎您：
    <%
        User loginUser = (User) session.getAttribute("loginUser");
        out.println(loginUser.getUserName());
        out.println(loginUser.getPwd());
    %>
    </p>
    <p class="lead">欢迎您：<%=(User)session.getAttribute("loginUser")%></p>
    <p class="lead">用户名：<c:out value="${loginUser1.userName}" default="Guest"/></p>
    <p class="lead">用户名：${sessionScope.users[0].userName}</p>
    <p class="lead">密码：${sessionScope.users[0].pwd}</p>

      <c:forEach items="${sessionScope.users}" var="u">
          <td>${u.userName}</td>
          <td>${u.pwd}</td>
      </c:forEach>




  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">网站访问次数：</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>