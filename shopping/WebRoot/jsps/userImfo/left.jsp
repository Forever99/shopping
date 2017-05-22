<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>left</title>
<base target="body" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jsps/css/user/personal.css'/>">

</head>

<body>

	<div align="center">
		<h1>全部功能</h1>
	</div>
	<hr />
	<div align="center">
		<ul>
			<li class="person"><a href="index.html">个人中心</a></li>
			<hr />
			<li class="person"><a href="#">个人资料</a>
			<hr />
				<ol>
					<li class="active"><a href="information.html">&nbsp;&nbsp;&nbsp;个人信息</a></li>
					<li><a href="safety.html">&nbsp;&nbsp;&nbsp;安全设置</a></li>
					<li><a href="address.html">&nbsp;&nbsp;&nbsp;收货地址</a></li>
				</ol>
			</li>
			<hr />
			<li class="person"><a href="#">我的订单</a>
			<hr />
				<ol>
					<li><a href="order.html">&nbsp;&nbsp;&nbsp;订单管理</a></li>
					<li><a href="change.html">&nbsp;&nbsp;&nbsp;退款售后</a></li>
				</ol>
			</li>
			<hr/>
			<!-- 					<li class="person"> -->
			<!-- 						<a href="#">我的资产</a> -->
			<!-- 						<ul> -->
			<!-- 							<li> <a href="coupon.html">优惠券 </a></li> -->
			<!-- 							<li> <a href="bonus.html">红包</a></li> -->
			<!-- 							<li> <a href="bill.html">账单明细</a></li> -->
			<!-- 						</ul> -->
			<!-- 					</li> -->

			<!-- 					<li class="person"> -->
			<!-- 						<a href="#">我的小窝</a> -->
			<!-- 						<ul> -->
			<!-- 							<li> <a href="collection.html">收藏</a></li> -->
			<!-- 							<li> <a href="foot.html">足迹</a></li> -->
			<!-- 							<li> <a href="comment.html">评价</a></li> -->
			<!-- 							<li> <a href="news.html">消息</a></li> -->
			<!-- 						</ul> -->
			<!-- 					</li> -->

		</ul>
	</div>
</body>

</html>
