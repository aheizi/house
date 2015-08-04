<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype  html>
<html>
   <head>
	<meta charset="utf-8" />
	<title>manager_user</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/public_all.css" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript" src="http://static.solaridc.com/jquery/jquery-1.4.4.js"></script>
	 <style>
		.blue_btn{cursor:pointer;}
	 </style>
   </head>
   <body>
	   <div id="wrap">
			<ul class="Menu clearfix">
				<li class="first">出租房屋管理</li>
			</ul>
			<div class="AccountBox">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="imgList">
						<tr>
							<th>标题</th>
							<th>发布时间</th>
							<th>发布人</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${noCheckHouseOutList}" var="houseOut">
							<tr>
	                            <td><a href="house.do?action=houseDtail&id=${houseOut.id}" target="_Blank">${houseOut.title}</a></td>
	                            <td>${houseOut.publishDate}</td>
								<td>${houseOut.publisher}</td>
								<td>
									<a class="green_btn" href="house.do?action=managerCheck&state=2&id=${houseOut.id}">审核通过</a>
									<a class="green_btn" href="house.do?action=managerCheck&state=3&id=${houseOut.id}">审核不通过</a>
	                            </td>
							</tr>
						</c:forEach>
						<c:if test="${empty noCheckHouseOutList}">
							<tr><td colspan="5" align="center">没有符合条件的记录</td></tr>
						</c:if>
				</table>
			</div>
	   </div>
   </body>
</html>
