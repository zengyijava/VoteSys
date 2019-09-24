
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

<div id="vote" class="wrap">
	<h2>投票列表</h2>
	<ul class="list">
	
	
	
	</ul>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">




//当页面加载时需要发送请求查询投票主题信息
$(function(){
	
	$.get("vote.action",{op:'findVote'},function(data){
		
		console.log(data);
		showVote(data);
	},'json');
});
//显示主题信息

function showVote(arr){
	//清空数据
	$('#vote ul.list').html('');
	var str='';
	for(var i=0;i<arr.length;i++){
		str+='<li  class="odd" ><h4><a href="option.action?op=findByVid&vid='+arr[i].vid+'">'+arr[i].vname+'</a></h4>'
		+'<div class="join"><a href="option.action?op=findVOByVid&vid='+arr[i].vid+'">我要参与</a></div>'
		+'<p class="info">共有 '+arr[i].opNum+'个选项，已有'+arr[i].userNum+'个网友参与了投票。</p></li>';
	}
	$('#vote ul.list').html(str);
} 
</script>
</body>
</html>
