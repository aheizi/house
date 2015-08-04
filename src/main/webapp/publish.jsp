<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>publish</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/publish.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/province_str.js" type="text/javascript"></script>
	<script src="js/utils.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script type="text/javascript">
		function submit_check(){
			var now = new Date();
			$("#publishDate").val(now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate());
			
			if($("#country_sel").val() == "请选择区/县"){
				alert("请选择出租地区！");
				return false;
			}
			
			if($("#communityName").val() == ""){
				alert("请填写小区！");
				return false;
			}
			
			if($("#room").val() == "" || !IsNumber($("#room").val())){
				alert("请填写室（数字）！");
				return false;
			}
			
			if($("#hall").val() == "" || !IsNumber($("#hall").val())){
				alert("请填写厅（数字）！");
				return false;
			}
			
			if($("#toilet").val() == "" || !IsNumber($("#toilet").val())){
				alert("请填写卫（数字）！");
				return false;
			}
			
			if($("#squareMeter").val() == "" || !IsNumber($("#squareMeter").val())){
				alert("请填写房屋大小（数字）！");
				return false;
			}
			
			if($("#floor").val() == "" || !IsNumber($("#floor").val())){
				alert("请填写第几层（数字）！");
				return false;
			}
			
			if($("#floorth").val() == "" || !IsNumber($("#floor").val())){
				alert("请填写共多少层（数字）！");
				return false;
			}
			
			if($("#rent").val() == "" || !IsNumber($("#rent").val())){
				alert("请填写租金（数字）！");
				return false;
			}
			
			
			
			$("#form").submit();
		}
	</script>
</head>
<body>
	<div class="topbar">
		<div class="center0">
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
			<span class="logo"></span>
				<a href="index">
					<img src="images/logo.png">
				</a>
		</div>
	</div>
	<div class="body">
		<div class="center1">
			<form action="house.do?action=saveHouse" class="form-inline" id="form" method="post">
				<input type="hidden" name="publisher" value="${sessionScope.userSession}">
				<input type="hidden" name="publishDate" value="" id="publishDate">
				<input type="hidden" name="region" value="宜昌">
				<input type="hidden" name="state" value="1">
				<table class="formtable">
					<tr>
						<th class="float_r">*出租方式</th>
						<td>&nbsp;&nbsp;
							<input type="radio" name="hireWay" value="整套出租" checked="checked" />整套出租&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="hireWay" value="单间出租" />单间出租&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="hireWay" value="床位出租" />床位出租&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<th class="float_r">*选择身份</th>
						<td>&nbsp;&nbsp;
							<input type="radio" name="identity" value="个人" checked="checked" />个人 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="identify" value="经纪人" />经纪人 
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*地区</th>
						<td>&nbsp;
							<select name="provinces" id="provinces_sel" onchange="city_();" class="form-control margin_top margin_left">
							<option>请选择省</option>
							</select>
							<select name="city" id="city_sel" onchange="country_();" class="form-control margin_top margin_left">
								<option>请选择市</option>
							</select>
							<select name="country" id="country_sel" class="form-control margin_top margin_left">
							<option>请选择区/县</option>
			    			</select>
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*小区名称</th>
						<td>&nbsp;&nbsp;<input type="text" class="form-control margin_top margin_left" id="communityName" name="communityName"></td>
					</tr>
					<tr>
						<th class="float_r margin_top">*房屋户型</th>
						<td>&nbsp;
							<input type="text" class="form-control margin_top margin_left " id="room" name="room"><span>室</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left " id="hall" name="hall"><span>厅</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left " id="toilet" name="toilet"><span>卫</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left " id="squareMeter" name="squareMeter"><span>㎡</span>&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*楼层</th>
						<td>&nbsp;&nbsp;
							<span>第</span><input type="text" class="form-control margin_top margin_left" id="floor" name="floor"><span>层</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<span>共</span><input type="text" class="form-control margin_top margin_left" id="floorth" name="floorth"><span>层</span>
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*租金</th>
						<td>&nbsp;
							<input type="text" class="form-control margin_top margin_left" id="rent" name="rent">元/月&nbsp;&nbsp;&nbsp;&nbsp;
							<select name="rentWay" id="rentWay" class="form-control margin_top margin_left">
								<option value ="押金方式">押金方式</option>
								<option value ="押一付一">押一付一</option>
								<option value="押一付二">押一付二</option>
								<option value="押一付三">押一付三</option>
								<option value ="押二付一">押二付一</option>
								<option value="押二付二">押二付二</option>
								<option value="押二付三">押二付三</option>
								<option value="半年付">半年付</option>
								<option value="年付">年付</option>
								<option value="面议">面议</option>
							</select>
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*标题</th>
						<td>&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="title">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*房源描述</th>
						<td>&nbsp;&nbsp;<textarea class="form-control margin_top margin_left" rows="3" name="description"></textarea></td>
					</tr>
					<tr>
						<th class="float_r margin_top">上传图片</th>
						<td>
							<input type="file" id="exampleInputFile" class="margin_top left" name="imgUrl">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*联系人</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="contact">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*联系电话</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="contactTel">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">QQ号码</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="qqNum">
						</td>
					</tr>
					<tr>
						<th class="float_r"></th>
						<td>&nbsp;&nbsp;
							<input type="button" class="btn btn-success margin_top margin_left margin_bottom" value="确认并发布" onclick="submit_check();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>