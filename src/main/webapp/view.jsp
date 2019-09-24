<%@page import="com.yc.vo.OptionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>在线投票系统</title>
<link type="image/x-icon" href="images/yc.png" rel="shortcut icon"/>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<%@ include file="controll.jsp" %>
<%
	List<OptionVO> list=(List<OptionVO>) request.getAttribute("ops");
	Integer num=(Integer)request.getAttribute("userNum");
	if(null==list  || list.size()<=0){
		
	}else{
%>
<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		<li>
			<h4><%=list.get(0).getVname()%></h4>
			<p class="info">共有 <%=list.size() %> 个选项，已有 <%=num %> 个网友参与了投票。</p>
				<ol>
				<%
				//求出该主题的所有票数
				int total=0;
				for(OptionVO option:list){
					total+=option.getViews();
					System.out.println(total);
				}
				for(OptionVO option:list){
					double per=(option.getViews()*1.0/total)*100;
					System.out.println(per);
				%> 
				<li>
					<%=option.getOpname()%>
						<div class="rate">
							<div class="ratebg">
							<div class="percent" style="width:<%=per%>%"></div>
							</div>
							<p><%=option.getViews() %>票<span>(<%=per%>%)</span></p>
						</div>
				</li>  
				<%
				} 
				%>	
				  	
				</ol>
				<div class="goback"><a href="manage.jsp">返回投票列表</a></div>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
<%} %>
</body>
</html>
