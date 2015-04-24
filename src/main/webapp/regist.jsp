<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>regist</title>
	<link rel="stylesheet" type="text/css" href="css/regist.css"/>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function checkUser(){
			//check的条件
			
			alert("nihao");
			
			//提交表单
			$("#form").submit();
		}
	</script>
</head>
<body>
	<div class="title">
		<div class="center">
			<span class="logo">
				<a href="index.jsp">
					<img src="images/logo.png">
				</a>
			</span>
		</div>
	</div>
	<div class="win1000">
		<div class="regmenu">
			<div class="left">
				<span class="register">注册</span>
			</div>
			<div class="right">
				<span class="loginTab">
					已有账号？去
					<a href="login.jsp">登陆</a>
				</span>
			</div>
		</div>
		<form id="form" action="user.do?action=saveUser" method="post">
			<input type="hidden" name="type" value="normal">
			<div class="regtable">
				<table>
					<tr>
						<td>用户名</td>
						<td>
							<input type="text" name="userName">
						</td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td>
							<input type="text" name="email">
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td>
							<input type="password" name="password" id="password">
						</td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td>
							<input type="password" id="repassword">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" value="注册" onclick="checkUser()">
							<input type="button" value="清空">
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>