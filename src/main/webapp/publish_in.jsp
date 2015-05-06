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
					<a href="login.jsp">登陆</a>
					<a href="regist.jsp">注册</a>
					<!--
					<li class="dropdown" id="accountmenu">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Tutorials<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">PHP</a></li>
                            <li><a href="#">MySQL</a></li>
                            <li class="divider"></li>
                            <li><a href="#">JavaScript</a></li>
							<li><a href="#">jsp5</a></li>
                        </ul>
                    </li>
                    -->
				</div>
			</div>
		</div>
	</div>
	<div class="title">
		<div class="center">
			<span class="logo"></span>
				<a href="index.jsp">
					<img src="images/logo.png">
				</a>
		</div>
	</div>
	<div class="body">
		<div class="center1">
			<form action="" class="form-inline">
				<table class="formtable">
					<tr>
						<th class="float_r margin_top">*标题</th>
						<td>&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*求租地区</th>
						<td>&nbsp;
							<select id="provinces_sel" onchange="city_();" class="form-control margin_top margin_left">
							<option>请选择省</option>
							</select>
							<select id="city_sel" onchange="country_();" class="form-control margin_top margin_left">
								<option>请选择市</option>
							</select>
							<select id="country_sel" class="form-control margin_top margin_left">
							<option>请选择区/县</option>
			    			</select>
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*租金</th>
						<td>&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="">元/月
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*求租方式</th>
						<td>&nbsp;&nbsp;
							<input type="radio" name="rentway" value="整套出租" checked="checked" />整套求租&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="rentway" value="单间出租" />单间求租&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="rentway" value="床位出租" />床位求租&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*最晚入住时间</th>
						<td>&nbsp;&nbsp;
							<input type="date" class="form-control margin_top margin_left" id="" name=""/>
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*补充说明</th>
						<td>&nbsp;&nbsp;<textarea class="width form-control margin_top margin_left " rows="5"></textarea></td>
					</tr>
					<tr>
						<th class="float_r margin_top">*联系人</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">*联系电话</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<th class="float_r margin_top">QQ号码</th>
						<td>&nbsp;&nbsp;
							<input type="text" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<th class="float_r"></th>
						<td>&nbsp;&nbsp;
							<input type="button" class="btn btn-success margin_top margin_left margin_bottom" value="确认并发布">
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