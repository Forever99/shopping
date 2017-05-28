<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员添加店铺</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/regist.css'/>">

    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/adminjsps/admin/store/js/edit.js'/>"></script>
  </head>
  
  <body>
<div id="divMain">
  <div id="divTitle">
    <span id="spanTitle">管理员修改店铺</span>
  </div>
  <div id="divBody">
<form action="<c:url value='/admin/AdminStoreServlet'/>" method="post" id="addForm">
	<input type="hidden" name="method" value="editStore"/>  
	
    <table id="tableForm">
      <tr>
        <td class="tdText">店铺名：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="Sname" id="Sname" value="${form.sname }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="SnameError">${errors.sname }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">所属用户名：</td>
        <td>
          <input class="inputClass" type="text" name="loginname" id="loginname" value="${form.loginname }"/>
        </td>
        <td>
          <label class="errorClass" id="loginnameError">${errors.loginname }</label>
        </td>
      </tr>
        <tr>
        <td class="tdText">开店类型：</td>
        <td><select size="1" name="cname" class="inputClass">
           <option value="书" selected>书</option>
           <option value="衣">衣</option>
           <option value="鞋">鞋</option>
           <option value="家用电器">家用电器</option>
           <option value="化妆品">化妆品</option>
           </select>
        </td>
      </tr>
       <tr>
        <td></td>
        <td>
          <input type="image" src="<c:url value='/images/addStore1.jpg'/>" id="submitBtn"/>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
    </table>
</form>    
  </div>
</div>
  </body>
</html>