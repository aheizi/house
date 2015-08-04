<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>house</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/myhouse.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/province_str.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
	</script>
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
					<c:choose>
						<c:when test="${not empty sessionScope.userSession}">
							<li class="dropdown" id="accountmenu">
		                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${sessionScope.userSession}<b class="caret"></b></a>
		                        <ul class="dropdown-menu">
		                            <li><a href="user.do?action=grzl">我的house</a></li>
		                            <li><a href="myHouse.do?action=myHouse">我的发布</a></li>
		                            <li><a href="myHouse.do?action=wdsc">我的收藏</a></li>
									<li><a href="user.do?action=logout">退出</a></li>
		                        </ul>
		                    </li>
						</c:when>
						<c:otherwise>
							<a href="login.jsp">登陆</a>
							<a href="regist.jsp">注册</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="title">
		<div class="center">
			<span class="logo">
				<a href="index">
					<img src="images/logo.png">
				</a>
			</span>
			<span class="publish">
				<a class="btn btn-default" href="publish.jsp" role="button">发布出租信息</a>
			</span>
		</div>
	</div>
	<div>
		<div class="center">
			<a href="my_house_grzl.jsp"><img src="images/05.jpg" alt=""></a>
		</div>
	</div>

	<div class="search">
		<div class="lmenu left" >
			<ul id="lmenu_ul">
				<li class="top">
					<a href="user.do?action=grzl"><img src="images/11.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="myHouse.do?action=myHouse"><img src="images/07.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="myHouse.do?action=wdsc"><img src="images/13.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="my_house_bzzx.jsp"><img src="images/10.jpg" alt=""></a>
				</li>
			</ul>
		</div>
		<div class="right" id="right-con-user">
		
			<table class="table table-hover">
			  <h4 style="color:#1E90FF;">【出租】</h4>
			  <thead>
			  	<th>标题</th>
			  	<th>发布时间</th>
			  	<th>审核时间</th>
			  	<th>审核状态</th>
			  	<th>操作</th>
			  </thead>
			  <c:forEach items="${houseOutList}" var="houseOut">
				<tr>
					<td><a href="house.do?action=houseDtail&id=${houseOut.id}" target="_blank">${houseOut.title}</a></td>
					<td>2014-09-12</td>
				  	<td>${houseOut.publishDate}</td>
				  	<c:if test="${houseOut.state == 1}">
						<td>未审核</td>
					</c:if>
					<c:if test="${houseOut.state == 2}">
						<td>审核通过</td>
					</c:if>
					<c:if test="${houseOut.state == 3}">
						<td>审核未通过</td>
					</c:if>
				  	<td>
				  		<!-- <a href="">编辑</a> -->
						<a href="house.do?action=deleteHouseOut&houseOutId=${houseOut.id}">删除</a>
			  		</td>
				</tr>
			  </c:forEach>
			  <c:if test="${empty houseOutList}">
			  	<tr><td colspan="5" align="center">没有符合条件的记录</td></tr>
			  </c:if>
			</table>
			
			<table class="table table-hover">
			  <h4 style="color:#1E90FF;">【求租】</h4>
			  <thead>
			  	<th>标题</th>
			  	<th>发布时间</th>
			  	<th>审核状态</th>
			  	<th>操作</th>
			  </thead>
			  <c:forEach items="${houseInList}" var="houseIn">
				<tr>
					<td><a href="houseIn.do?action=houseInDtail&id=${houseIn.id}" target="_blank">${houseIn.title}</a></td>
				  	<td>${houseIn.publishDate}</td>
				  	<c:if test="${houseIn.state == 1}">
						<td>未审核</td>
					</c:if>
					<c:if test="${houseIn.state == 2}">
						<td>审核通过</td>
					</c:if>
					<c:if test="${houseIn.state == 3}">
						<td>审核未通过</td>
					</c:if>
				  	<td>
				  		<!-- <a href="">编辑</a> -->
						<a href="houseIn.do?action=deleteHouseIn&houseInId=${houseIn.id}">删除</a>
			  		</td>
				</tr>
			  </c:forEach>
			  <c:if test="${empty houseOutList}">
			  	<tr><td colspan="5" align="center">没有符合条件的记录</td></tr>
			  </c:if>
			</table>
		</div>
	</div>

	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>