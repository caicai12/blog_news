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
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
<div class="table-responsive">
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>编号</th>
        <th>名称</th>
        <th>操作</th>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGenre}" var="a" varStatus="status">
    	<tr class="
    	<c:if test="${status.index%1==0}">active</c:if>
    	<c:if test="${status.index%2==0}">success</c:if>
    	<c:if test="${status.index%3==0}">warning</c:if>
    	<c:if test="${status.index%4==0}">danger</c:if>
    	">
	        <td>${a.id}</td>
	        <td>${a.var1}</td>
	        <td>
	        <form action="genre?type=2" method="post" id="delform${a.id}">
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