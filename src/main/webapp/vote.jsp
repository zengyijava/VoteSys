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
	//System.out.println("num:"+num);
	if(null==list  || list.size()<=0){
		
	}else{
%>
<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
			<h4><%=list.get(0).getVname()%></h4>
			<p class="info">共有 <%=list.size() %> 个选项，已有<%=num%>个网友参与了投票。</p>
			<form method="post" action="option.action">
			<input type="hidden" value="op" name="updateViews"/>
			<!-- 主题的类型 单选还是多选 -->
			    <input type="hidden" name="vtype" value="<%=list.get(0).getVtype() %>"/> 
				<ol>
				   <%
				   for(OptionVO option:list){
				   %>				   
					<li><input type="checkbox" name="options" value="<%=option.getOpid()%>"/>
				   <%=option.getOpname() %></li>
				   <% 
				   } 
				   %>
				</ol>
				<p class="voteView"><input type="image" src="images/button_vote.gif" />
				<a href="Vote!view.action?entityId=103"><img src="images/button_view.gif" /></a></p>
			</form>
	</ul>
</div>
<%} %>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('input[name="options"]').click(function(){
		//获取类型
		var type=$('input[name="vtype"]').val();
		if(type==1){
			$('input[name="options"]').prop('checked',false);
			//单选的效果
			$(this).prop('checked','true');
		}
	});
});

</script>
</body>
</html>
