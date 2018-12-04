<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
<div class="table-responsive">
  <table class="table">
    <caption>评论管理</caption>
    <thead>
      <tr>
        <th>编号</th>
        <th>时间</th>
        <th>文章标题</th>
        <th>评语</th>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${listComment}" var="a">
    	<tr>
	        <td>${a.id}</td>
	        <td>${a.var4}</td>
	        <td>${a.var2}</td>
	        <td>${a.var3}</td>
	        <td>
	        <form action="comment?type=2" method="post" id="delform${a.id}">
	        	<input type="hidden" value="${a.id}" name="id" >
	        	<a href="javascript:$('#delform${a.id}').submit();">删除</a>
	        </form>
	        </td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>