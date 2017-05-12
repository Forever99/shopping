<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <div align="right"><a href="#">登录 </a> &nbsp;     <a href="/shopping/jsps/user/regist.jsp">注册 </a> &nbsp;   </div>
  
  <div align="center"><h3>用户主页</h3></div>
  <table class="table" align="center" border="1">
	<tr class="trTop">
		<td colspan="2" class="tdTop">
			<iframe frameborder="0" " name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td class="tdLeft" rowspan="2">
			<iframe frameborder="0" name="left"></iframe>
		</td>
		<td class="tdSearch" style="border-bottom-width: 0px;">
			<iframe frameborder="0"  name="search"></iframe>
		</td>
	</tr>
	
	<tr>
		<td style="border-top-width: 0px;">
			<iframe frameborder="0"  name="body"></iframe>
		</td>
	</tr>
  
  </body>
</html>
