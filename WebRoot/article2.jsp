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
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
    <FORM action="article?type=1" method="post">
    	<DIV class="control-group">
            <LABEL class="laber_from">内别</LABEL>
            <DIV  class="controls" >
                <SELECT class="input_select" name="var2">
                <c:forEach items="${listGenre}" var="a">
                    <OPTION value="${a.id}">${a.var1}</OPTION>
                </c:forEach>
                </SELECT>
            </DIV>
        </DIV>
        <DIV class="control-group">
            <label class="laber_from">标题</label>
            <DIV  class="controls" ><INPUT class="input_from" name="var3" type=text placeholder=" 请输入文章标题" required><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <label class="laber_from">内容</label>
            <DIV  class="controls" >
            <textarea class="input_from" name="var4" placeholder=" 请输入文章内容" required style="width:400px; height:250px;"></textarea>
            </DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" ><button type="submit" class="btn btn-primary" style="width:120px;" >确认添加</button></DIV>
        </DIV>
    </FORM>
</div>
</body>
</html>