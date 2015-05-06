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
		                            <li><a href="my_house_grzl.jsp">我的house</a></li>
		                            <li><a href="my_house_wdfb.jsp">我的发布</a></li>
		                            <li><a href="my_house_wdsc.jsp">我的收藏</a></li>
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
		<a href="index.jsp"><img src="images/chuzu2.jpg" alt=""></a>
		<a href="in_index.jsp"><img src="images/qiuzu1.jpg" alt=""></a>
		</div>
	</div>
	<div class="search">
		<form action="" class="form-inline">
			<div class="margin_span"></div>
			<div class="margin_span">
				<span>区域</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="provinces_sel" onchange="district_provinces();city_();" class="form-control margin_top margin_left">
					<option>请选择省</option>
					</select>
					<select id="city_sel" onchange="district_city();country_();" class="form-control margin_top margin_left">
						<option>请选择市</option>
					</select>
					<select id="country_sel" onchange="district_();" class="form-control margin_top margin_left">
					<option>请选择区/县</option>
    			</select>
			</div>
			<div class="margin_span">
				<span>租金</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="" id="" class="form-control margin_top margin_left" value="1">
					<option value ="">不限</option>
					<option value ="1">500元以下</option>
					<option value="">500-1000元</option>
					<option value="">1000-1500元</option>
					<option value="">1500-2000元</option>
					<option value="">2000-3000元</option>
					<option value="">3000-4500元</option>
					<option value="">4500元以上</option>
				</select>
			</div>
			<div class="margin_span">
				<span>方式</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="" id="" class="form-control margin_top margin_left">
					<option value ="">不限</option>
					<option value ="">整套出租</option>
					<option value="">单间出租</option>
					<option value="">床位出租</option>
				</select>
			</div>
			<div class="margin_span">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn btn-info margin_span width" value="搜索">
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
	<div class="suspension">
		<img src="images/defult02.jpg" alt="">
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>