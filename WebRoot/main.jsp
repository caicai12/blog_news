<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <FORM action="user?type=1" method="post">
        <DIV class="control-group">
            <label class="laber_from">用户名</label>
            <DIV  class="controls" ><INPUT class="input_from" name="name" type=text placeholder=" 请输入用户名"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码</LABEL>
            <DIV  class="controls" ><INPUT class="input_from" name="pwd" type=text placeholder=" 请输入密码"><P class=help-block></P></DIV>
        </DIV>
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
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" >
            	<button type="submit" class="btn btn-primary" style="width:96px;" >登陆</button>
            	<button type="reset" class="btn btn-primary" style="width:96px;" >重置</button>
            </DIV>
        </DIV>
    </FORM>
</div>
</body>
<script type="text/javascript">
var aQuery = window.location.href.split("?");//取?后面的参数
var aQuery1 = window.location.href.split("html");//取html后面的参数
var aGET = new Array();
if(aQuery.length > 1){
	var aBuf = aQuery[1].split("&");
	for(var i=0, iLoop = aBuf.length; i<iLoop; i++){
		var aTmp = aBuf[i].split("=");//分离key与Value
		aGET[aTmp[0]] = aTmp[1];
	}
}
var msg = aGET['msg'];
if(msg!=undefined && msg=="1"){
	alert("账号密码错误！");
}

</script>
</html>