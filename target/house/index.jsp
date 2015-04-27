<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>house</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script src="js/province_str.js" type="text/javascript"></script>
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
		                            <li><a href="#">我的house</a></li>
		                            <li><a href="#">我的发布</a></li>
		                            <!-- <li class="divider"></li> -->
		                            <li><a href="#">我的收藏</a></li>
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
				<a href="index.jsp">
					<img src="images/logo.png">
				</a>
			</span>
			<span class="publish">
				<a class="btn btn-default" href="publish.jsp" role="button">发布信息</a>
			</span>
		</div>
	</div>
	<div class="search">
		<form action="" class="form-inline">
			<div class="margin_span">
				<span>区域</span>&nbsp&nbsp&nbsp&nbsp
				<select id="provinces_sel" onchange="city_();" class="form-control margin_top margin_left">
					<option>请选择省</option>
					</select>
					<select id="city_sel" onchange="country_();" class="form-control margin_top margin_left">
						<option>请选择市</option>
					</select>
					<select id="country_sel" class="form-control margin_top margin_left">
					<option>请选择区/县</option>
    			</select>
			</div>
			<div class="margin_span">
				<span>租金</span>&nbsp&nbsp&nbsp&nbsp
				<select name="" id="" class="form-control margin_top margin_left">
					<option value ="">不限</option>
					<option value ="">500元以下</option>
					<option value="">500-1000元</option>
					<option value="">1000-1500元</option>
					<option value="">1500-2000元</option>
					<option value="">2000-3000元</option>
					<option value="">3000-4500元</option>
					<option value="">4500元以上</option>
				</select>
			</div>
			<div class="margin_span">
				<span>厅室</span>&nbsp&nbsp&nbsp&nbsp
				<select name="" id="" class="form-control margin_top margin_left">
					<option value ="">不限</option>
					<option value ="">一室</option>
					<option value="">两室</option>
					<option value="">三室</option>
					<option value="">四室</option>
					<option value="">四室以上</option>
				</select>
			</div>
			<div class="margin_span">
				<span>方式</span>&nbsp&nbsp&nbsp&nbsp
				<select name="" id="" class="form-control margin_top margin_left">
					<option value ="">不限</option>
					<option value ="">整套出租</option>
					<option value="">单间出租</option>
					<option value="">床位出租</option>
				</select>
			</div>
			<div class="margin_span">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<input type="text" class="form-control margin_span" placeholder="详细内容补充">
				<input type="button" class="btn btn-info margin_span" value="搜索">
			</div>
		</form>
		
	</div>
	<div class="body">
		<table>
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
				<td class="price">
					<b class="pri">600</b>元/月
					<br>
					<span class="showroom">1室0厅1卫</span>
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
				<td class="price">
					<b class="pri">600</b>元/月
					<br>
					<span class="showroom">1室0厅1卫</span>
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
				<td class="price">
					<b class="pri">600</b>元/月
					<br>
					<span class="showroom">1室0厅1卫</span>
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
				<td class="price">
					<b class="pri">600</b>元/月
					<br>
					<span class="showroom">1室0厅1卫</span>
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
				<td class="price">
					<b class="pri">600</b>元/月
					<br>
					<span class="showroom">1室0厅1卫</span>
				</td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>