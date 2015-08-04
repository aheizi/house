<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype  html>
<html>
   <head>
	<meta charset="utf-8" />
	<title>manager_user</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/public_all.css" />
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <style>
		.blue_btn{cursor:pointer;}
	 </style>
   </head>
   <body>
	   <div id="wrap">
			<ul class="Menu clearfix">
				<li class="first">用户管理</li>
			</ul>
			<div class="AccountBox">
				<div class="addNO">
					<c:if test="${sessionScope.userType == 'admin'}">
				  	  	<input type="button" value="新增管理员"  class="blue_btn button" onclick="window.location.href='manager_user_add.jsp'"/>
				    </c:if>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="imgList">
						<tr>
							<th>用户名</th>
							<th>权限</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${userList}" var="user">
							<tr>
	                            <td>${user.userName}</td>
	                            <c:if test="${user.type == 'manager'}">
							  	  	<td>管理员</td>
							    </c:if>
	                            <c:if test="${user.type == 'normal'}">
							  	  	<td>会员</td>
							    </c:if>
								<td>
									<c:if test="${sessionScope.userType == 'admin'}">
										<c:if test="${user.type == 'manager'}">
											<a class="green_btn" href="feiyin.do?action=editFeiyinDevice&id=$!feiyinDevice.id&feiyinDeviceNo=$!feiyinDevice.feiyinDeviceNo">编辑</a>
									  	  	<a class="green_btn" onclick = "javascript:if(!confirm('确认要删除吗？')){return false;}" href="feiyin.do?action=deleteFeiyinDevice&id=$!feiyinDevice.id">删除</a>
									    </c:if>
			                            <c:if test="${user.type == 'normal'}">
									  	  	<a class="green_btn" onclick = "javascript:if(!confirm('确认要删除吗？')){return false;}" href="feiyin.do?action=deleteFeiyinDevice&id=$!feiyinDevice.id">删除</a>
									    </c:if>
								    </c:if>
								    <c:if test="${sessionScope.userType == 'manager'}">
			                            <c:if test="${user.type == 'normal'}">
									  	  	<a class="green_btn" onclick = "javascript:if(!confirm('确认要删除吗？')){return false;}" href="feiyin.do?action=deleteFeiyinDevice&id=$!feiyinDevice.id">删除</a>
									    </c:if>
								    </c:if>
	                            </td>
							</tr>
						</c:forEach>
						<c:if test="${empty userList}">
					  	  	<tr><td colspan="3" align="center">没有符合条件的记录</td></tr>
					    </c:if>
				</table>
			</div>
			</div>
	   </div>
   </body>
</html>
