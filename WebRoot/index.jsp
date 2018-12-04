<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String url="main.jsp";
if(request.getSession().getAttribute("user")!=null){
	url="article?type=0";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>blog</title>
	<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/tendina.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript">
	$(function(){
		for(var i=0;i<$(".div2").length;i++){
			$(".div2").eq(i).next("div").slideToggle("slow") 
			.siblings(".div3:visible");
		}
	});
	
	
	</script>
	<style>
	body{ margin:0;font-family:微软雅黑;}
	.left{ width:195px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; color:#000000; font-size:14px; text-align:center;}
	.div1{text-align:center; width:195px; padding-top:10px;}
	.div2{height:40px; line-height:40px;cursor: pointer; font-size:13px; position:relative;border-bottom:#ccc 1px dotted;}
	.jbsz {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/1.png);}
	.xwzx {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/2.png);}
	.zxcp {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/4.png);}
	.lmtj {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/8.png);}
	.div3{display: none;cursor:pointer; font-size:13px;}
	.div3 ul{margin:0;padding:0;}
	.div3 li{ height:30px; line-height:30px; list-style:none; border-bottom:#ccc 1px dotted; text-align:center;}
	</style>
</head>
<body>
    <!--顶部-->
    <nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">blog</a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="user?type=4"><span class="glyphicon "></span>退出登录</a></li>
	    </ul>
	  </div>
	</nav>
    <!--顶部结束-->
    
	<!--菜单-->
	<div class="layout_left_menu">
	    <div class="left">
		<div class="div1">
		<div class="left_top"><img src="images/bbb_01.jpg"><img src="images/bbb_02.jpg" id="2"><img src="images/bbb_03.jpg"><img src="images/bbb_04.jpg"> </div>
		  <div class="div2"><div class="jbsz"> </div>用户</div>
		      <div class="div3">
		 		<ul>
                    <li><a href="user?type=6" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>添加</a></li>
                    <li><a href="user?type=2" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>查询</a></li>
                </ul>
		  </div>
		    <div class="div2"><div class="xwzx"> </div>文章</div>
		      <div class="div3">
		      <ul>
                  <li><a href="javascript:show('article?type=0')"><i class="glyph-icon icon-chevron-right"></i>查询</a></li>
                  <!-- <li><a href="javascript:show('article?type=4')"><i class="glyph-icon icon-chevron-right"></i>查询我的文章</a></li> -->
                  <li><a href="javascript:show('article?type=3')"><i class="glyph-icon icon-chevron-right"></i>发布</a></li>
              </ul>
		  </div>
		    <div class="div2"><div class="zxcp"> </div>类别</div>
		      <div class="div3">
	          <ul>
                  <li><a href="javascript:show('genre?type=0')"><i class="glyph-icon icon-chevron-right"></i>查询</a></li>
                  <li><a href="javascript:show('genre?type=3')"><i class="glyph-icon icon-chevron-right"></i>添加</a></li>
              </ul>
		  </div>
		</div>
		</div>
	</div>
	<!--菜单结束-->
    
    <div id="layout_right_content" class="layout_right_content">

        <!-- <div class="route_bg">
            <a href="#">主页</a><i class="glyph-icon icon-chevron-right"></i>
            <a href="#">当前栏目</a>
        </div> -->
        <div class="mian_content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame" src="<%=url%>" style="overflow:visible;"
                        scrolling="yes"  frameborder="0" width="100%" height="100%"></iframe>
            </div>
        </div>
    </div>
    <div class="layout_footer">
        <p></p>
    </div>
</body>
<script type="text/javascript">
function show(url){
	$("#menuFrame").attr("src",url);
}
</script>
</html>