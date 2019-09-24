<%@page import="com.yc.po.UserPO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserPO user=(UserPO) session.getAttribute("user");
Integer count=(Integer)application.getAttribute("userCount");
if(null==user){
	response.sendRedirect("login.jsp");
}else{
%>

<div id="navbar" class="wrap">
	<div class="profile">
		您好，<%=user.getUname() %>
		<span class="return"><a href="manage.jsp">返回列表</a></span>
		<span class="addnew"><a href="add.jsp">添加新投票</a></span>
		<span class="modify"><a href="login.jsp">退出</a></span>
		<span class="modify">你是第<%=count %>位访问用户</span>	
	</div>
	<div class="search">
		<form method="post" action="">
			<input type="text" name="keywords" class="input-text" value=""/><input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>



<% 
}
%>
%>
</body>
</html>