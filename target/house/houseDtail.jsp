<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>houseDtail</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/houseDtail.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div class="topbar">
		<div class="center">
			<div class="bar_left">
				<div class="city">
					<span>宜昌</span>
					<a href="###">[切换城市]</a>
				</div>
			</div>
			<div class="bar_right">
				<div class="login">
					<a href="login.jsp">登陆</a>
					<a href="regist.jsp">注册</a>
				</div>
			</div>
		</div>
	</div>
	<div class="title">
		<div class="center">
			<span class="logo">
				<a href="index.jsp">
					<img src="images/logo.png">
				</a>
			</span>
			<span class="publish">
				<c:choose>
					<c:when test="${not empty sessionScope.userSession}">
						<a class="btn btn-default" href="publish.jsp" role="button">发布信息</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-default" href="login.jsp" role="button">发布信息</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>
	</div>
	<div class="content">
		<div class="main">
			<div class="mainTitle">
				<h3>${houseDtail.title}</h3>
			</div>
			<div class="time">
				<span>${houseDtail.publishDate}</span>
			</div>
			<div class="mainTop">
				<div class="img">
					<span>
						<img src="images/defult.png" class="img_c">
					</span>
				</div>
			</div>
			<div class="dtail">
				<li class="margin_top">
					<div class="sub_t">价格</div>
					<div class="sub_c">${houseDtail.rent}元</div>
				</li>
				<li class="margin_top">
					<div class="sub_t">概况</div>
					<div class="sub_c">${houseDtail.room}室${houseDtail.hall}厅${houseDtail.toilet}卫  &nbsp&nbsp&nbsp&nbsp ${houseDtail.squareMeter}㎡</div>
				</li>
				<li class="margin_top">
					<div class="sub_t">楼层</div>
					<div class="sub_c">${houseDtail.floor}层/${houseDtail.floorth}层</div>
				</li>
				<li class="margin_top">
					<div class="sub_t">区域</div>
					<div class="sub_c">${houseDtail.communityName}</div>
				</li>
				<li class="margin_top">
					<div class="sub_t">联系</div>
					<div class="sub_c">${houseDtail.contact}(${houseDtail.identity})/电话:${houseDtail.contactTel}</div>
				</li>
			</div>
		</div>
	</div>
	<div class="describ">
		<div class="textDes">
			<h3>房源描述</h3>
		</div>
		<div class="cur">
			<span>
				${houseDtail.id}
			</span>
		</div>
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>