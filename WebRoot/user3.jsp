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
<div class="div_from_aoto" style="width: 500px;">
    <FORM action="user?type=8" method="post">
        <DIV class="control-group">
            <label class="laber_from">姓名</label>
            <DIV  class="controls" ><INPUT class="input_from" name="name" type=text placeholder=" 请输入姓名" required readonly="readonly" value="${userupdate.name}"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码</LABEL><input type="hidden" name="id" value="${userupdate.id}" >
            <DIV  class="controls" ><INPUT class="input_from" name="pwd" type=text placeholder=" 请输入密码" required  value="${userupdate.pwd}"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" ><button type="submit" class="btn btn-primary" style="width:120px;" >确认修改密码</button></DIV>
        </DIV>
    </FORM>
</div>
</body>
</html>