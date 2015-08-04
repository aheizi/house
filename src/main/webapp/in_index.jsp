<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>in_index</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/province_str.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
		$(function(){
			address();
		});
		//回显省市区
		function address(){
			if($("#provinces").val() != ""){
   				$("#provinces_sel").val($("#provinces").val());
   				city_();
   				$("#city_sel").val($("#city").val());
   				country_();
   				$("#country_sel").val($("#country").val());
			}
		}
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
				<c:choose>
					<c:when test="${not empty sessionScope.userSession}">
						<a class="btn btn-default" href="publish_in.jsp" role="button">发布求租信息</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-default" href="login.jsp" role="button">发布求租信息</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>
	</div>
	<div>
		<div class="center">
		<a href="index"><img src="images/chuzu2.jpg"></a>
		<a href="houseIn.do?action=indexHouseIn"><img src="images/qiuzu1.jpg"></a>
		</div>
	</div>
	<div class="search">
		<form action="houseIn.do?action=searchHouseIn" class="form-inline" method="post">
			<input id="provinces" type="hidden" value="${provinces }"/>
			<input id="city" type="hidden" value="${city }"/>
			<input id="country" type="hidden" value="${country }"/>
			<div class="margin_span"></div>
			<div class="margin_span">
				<span>区域</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="provinces" id="provinces_sel" onchange="city_();" class="form-control margin_top margin_left">
				<option>请选择省</option>
				</select>
				<select name="city" id="city_sel" onchange="country_();" class="form-control margin_top margin_left">
					<option>请选择市</option>
				</select>
				<select name="country" id="country_sel" class="form-control margin_top margin_left">
				<option>请选择区/县</option>
   				</select>
			</div>
			<div class="margin_span">
				<span>租金</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="rent" id="" class="form-control margin_top margin_left">
					<option value ="no">不限</option>
					<option value ="0-500" <c:if test="${'0-500' eq rent}">selected</c:if>>500元以下</option>
					<option value="500-1000" <c:if test="${'500-1000' eq rent}">selected</c:if>>500-1000元</option>
					<option value="1000-1500" <c:if test="${'1000-1500' eq rent}">selected</c:if>>1000-1500元</option>
					<option value="1500-2000" <c:if test="${'1500-2000' eq rent}">selected</c:if>>1500-2000元</option>
					<option value="2000-3000" <c:if test="${'2000-3000' eq rent}">selected</c:if>>2000-3000元</option>
					<option value="3000-4500" <c:if test="${'3000-4500' eq rent}">selected</c:if>>3000-4500元</option>
					<option value="4500-1000000" <c:if test="${'4500-1000000' eq rent}">selected</c:if>>4500元以上</option>
				</select>
			</div>
			<div class="margin_span">
				<span>方式</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="hireWay" id="hireWay" class="form-control margin_top margin_left">
					<option value ="no">不限</option>
					<option value ="整套出租" <c:if test="${'整套出租' eq hireWay}">selected</c:if>>整套出租</option>
					<option value ="单间出租" <c:if test="${'单间出租' eq hireWay}">selected</c:if>>单间出租</option>
					<option value ="床位出租" <c:if test="${'床位出租' eq hireWay}">selected</c:if>>床位出租</option>
				</select>
			</div>
			<div class="margin_span">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-info margin_span width" value="搜索">
			</div>
		</form>
		
	</div>
	<div class="body">
		<table>
			<c:forEach items="${houseInList}" var="houseIn">
				<tr>
					<td class="img">
						<a href="houseInDtail.jsp">
							<img src="images/house1.png" class="img_c">
						</a>
					</td>
					<td class="content">
						<h4>
							<a href="houseIn.do?action=houseInDtail&id=${houseIn.id}">
								${houseIn.title}
							</a>
						</h4>
						<p>
							<span>${houseIn.city}${houseIn.country}</span>
							<span>/${houseIn.publishDate}</span>
						</p>
						<p>
							<span>发布人：${houseIn.publisher}</span>
						</p>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="img">
					<a href="houseDtail.jsp">
						<img src="images/house1.png" class="img_c">
					</a>
				</td>
				<td class="content">
					<h4>
						<a href="houseDtail.jsp">
							[整租]600-1300元、一室一厅、隆康路有空调电视热	
						</a>
					</h4>
					<p>
						<span>宜昌市西陵区三峡大学</span>
						<span>/2015年4月20日</span>
					</p>
					<p>
						<span>发布人：黄先生</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="img">
					<a href="houseDtail.jsp">
						<img src="images/defult.png" class="img_c">
					</a>
				</td>
				<td class="content">
					<h4>
						<a href="houseDtail.jsp">
							[整租]600-1300元、一室一厅、隆康路有空调电视热	
						</a>
					</h4>
					<p>
						<span>宜昌市西陵区三峡大学</span>
						<span>/2015年4月20日</span>
					</p>
					<p>
						<span>发布人：黄先生</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="img">
					<a href="houseDtail.jsp">
						<img src="images/defult.png" class="img_c">
					</a>
				</td>
				<td class="content">
					<h4>
						<a href="houseDtail.jsp">
							[整租]600-1300元、一室一厅、隆康路有空调电视热	
						</a>
					</h4>
					<p>
						<span>宜昌市西陵区三峡大学</span>
						<span>/2015年4月20日</span>
					</p>
					<p>
						<span>发布人：黄先生</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="img">
					<a href="houseDtail.jsp">
						<img src="images/defult.png" class="img_c">
					</a>
				</td>
				<td class="content">
					<h4>
						<a href="houseDtail.jsp">
							[整租]600-1300元、一室一厅、隆康路有空调电视热	
						</a>
					</h4>
					<p>
						<span>宜昌市西陵区三峡大学</span>
						<span>/2015年4月20日</span>
					</p>
					<p>
						<span>发布人：黄先生</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="img">
					<a href="houseDtail.jsp">
						<img src="images/defult.png" class="img_c">
					</a>
				</td>
				<td class="content">
					<h4>
						<a href="houseDtail.jsp">
							[整租]600-1300元、一室一厅、隆康路有空调电视热	
						</a>
					</h4>
					<p>
						<span>宜昌市西陵区三峡大学</span>
						<span>/2015年4月20日</span>
					</p>
					<p>
						<span>发布人：黄先生</span>
					</p>
				</td>
			</tr>
		</table>
	</div>
	<div class="suspension">
		<img src="images/defult02.jpg" alt="">
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>