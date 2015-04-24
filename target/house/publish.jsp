<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>publish</title>
	<link rel="stylesheet" type="text/css" href="css/publish.css"/>
</head>
<body>
	<div class="title">
		<div class="center">
			<span class="logo">
				<a href="index.jsp">
					<img src="images/logo.png">
				</a>
		</div>
	</div>
	<div class="body">
		<div class="center1">
			<form action="">
				<table class="formtable">
					<tr>
						<th>*出租方式</th>
						<td>
							<input type="radio" name="rentway" value="整套出租" checked="checked" />整套出租
							<input type="radio" name="rentway" value="单间出租" />单间出租
							<input type="radio" name="rentway" value="床位出租" />床位出租
						</td>
					</tr>
					<tr>
						<th>*选择身份</th>
						<td>
							<input type="radio" name="identify" value="个人" checked="checked" />个人 
							<input type="radio" name="identify" value="经纪人" />经纪人 
						</td>
					</tr>
					<tr>
						<th>*小区名称</th>
						<td><input type="text" name="" value="" /></td>
					</tr>
					<tr>
						<th>*房屋户型</th>
						<td>
							<input type="text" name=""><span>室</span>
							<input type="text" name=""><span>厅</span>
							<input type="text" name=""><span>卫</span>
							<input type="text" name=""><span>㎡</span>
						</td>
					</tr>
					<tr>
						<th>*楼层</th>
						<td>
							<span>第</span><input type="text" name=""><span>层</span>
							<span>共</span><input type="text" name=""><span>层</span>
						</td>
					</tr>
					<tr>
						<th>*租金</th>
						<td>
							<input type="text" name="">元/月
							<select name="" id="">
								<option value ="">押金方式</option>
								<option value ="">押一付一</option>
								<option value="">押一付二</option>
								<option value="">押一付三</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>*标题</th>
						<td>
							<input type="text">
						</td>
					</tr>
					<tr>
						<th>*房源描述</th>
						<td><input type="textarea" name=""></td>
					</tr>
					<tr>
						<th>上传图片</th>
					</tr>
					<tr>
						<th>*联系人</th>
						<td>
							<input type="text" name="">
						</td>
					</tr>
					<tr>
						<th>*联系电话</th>
						<td>
							<input type="text" name="">
						</td>
					</tr>
					<tr>
						<th>QQ号码</th>
						<td>
							<input type="text" name="">
						</td>
					</tr>
					<tr>
						<th></th>
						<td>
							<input type="button" value="确认并发布">
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