<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${Article.var3}-博客</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
<div class="panel panel-default">
	<div class="panel-heading">
		${Article.var3}
	</div>
	<div class="panel-body">
		${Article.var4}
	</div>
</div>

<%-- <div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">评论：欢迎您：${user.name}</h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${listComment}" var="a" varStatus="s">
			<br>${s.index+1}.  ${a.var1} - ${a.var4}
			<br>${a.var3}
		</c:forEach>
		
		<br>
		<input type="hidden" value="${Article.id}" id="aid">
		<input type="hidden" value="${user.id}" id="uid">
		<textarea rows="" cols="" id="var3" style="width:300px; height:100px;"></textarea><br>
		<button type="button" class="btn btn-success" onclick="ajaxshow()">提交评论</button>
    </div>
</div> --%>

</body>
<!-- <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function ajaxshow(){
	$.ajax({
		  type: 'POST',
		  url: "comment?type=1",
		  data:{var2:$("#aid").val(),var1:$("#uid").val(),var3:$("#var3").val()},
		  success: function(){
			  location.reload();
		  }
		});
}
</script> -->
</html>