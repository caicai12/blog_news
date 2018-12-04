<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect("main.jsp");
}
%>
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
<c:if test="${user.state==1}">
	您的权限不够！
</c:if>
<c:if test="${user.state==0}">
	<div class="div_from_aoto" style="width: 500px;">
	    <FORM action="user?type=3" method="post">
	   		<DIV class="control-group">
	            <LABEL class="laber_from">权限</LABEL>
	            <DIV  class="controls" >
	                <SELECT class="input_select" name="state">
	                    <OPTION value="1">普通用户</OPTION>
	                    <OPTION value="0" selected="selected">超级管理</OPTION>
	                </SELECT>
	            </DIV>
	        </DIV>
	        <DIV class="control-group">
	            <label class="laber_from">姓名</label>
	            <DIV  class="controls" ><INPUT class="input_from" name="name" type=text placeholder=" 请输入姓名" required><P class=help-block></P></DIV>
	        </DIV>
	        <DIV class="control-group">
	            <LABEL class="laber_from">密码</LABEL>
	            <DIV  class="controls" ><INPUT class="input_from" name="pwd" type=text placeholder=" 请输入密码" required><P class=help-block></P></DIV>
	        </DIV>
	        <DIV class="control-group">
	            <label class="laber_from">邮箱</label>
	            <DIV  class="controls" ><INPUT class="input_from" name="email" type=text placeholder=" 请输入邮箱" required><P class=help-block></P></DIV>
	        </DIV>
	        <DIV class="control-group">
	            <LABEL class="laber_from" ></LABEL>
	            <DIV class="controls" ><button type="submit" class="btn btn-primary" style="width:120px;" >确认注册</button></DIV>
	        </DIV>
	    </FORM>
	</div>
</c:if>
</body>
</html>