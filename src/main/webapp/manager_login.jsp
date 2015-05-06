<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_login</title>
	<link rel="stylesheet" href="css/manger_login.css" type="text/css">
</head>
<body>
	<div class="herder">
	<div class="head"></div>
	</div>
	<div class="content">
		<div class="logo-fx" style="padding-bottom: 20px;">
	        <span style="font:20px/25px arial;color:#36c;">House</span>
			<span style="padding-left:5px;font-family:inherit;font-size:15px;font-weight:bold;color:#36c;font-style: italic;">管理系统</span>
		</div>
		<div class="login-bg">	
			<div class="hotline" style="size:12px"></div>
		</div>
		<div class="login-box">
			<div class="login-item">
				<form name="loginform" action="login.do" method="post">
					<ul>
	    				<li class="f-left gray" style="width:60px;">用户名：</li>
	    				<li class="f-left">
							<input type="text" name="username" value="" class="pad5 border-g" style="width:160px;" />
						</li>
	                </ul>
					<ul>
	    				<li class="f-left gray" style="width:60px;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	    				<li class="f-left">
							<input type="password" name="password" class="pad5 border-g" style="width:160px;"/>
						</li>
	                </ul>
	                <ul>
	                	<li class="f-left gray" style="width:60px;"></li>
	                	<li class="f-left">
	                		<input type="submit" class="checkinimg" value="" />
	                		<input type="reset" class="checkresetimg" value="" />
	                	</li>
	                </ul>
	                
	            </form>
	        </div>
	    </div>
	</div>
	<div class="footer gray">
		<br/><br/>
		<p>版权所有 20111121_黄阳全_毕业设计</p>
	</div>

</body>
</html>