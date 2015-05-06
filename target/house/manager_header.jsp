<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_header</title>
	<link href="" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://static.solaridc.com/jquery/jquery-1.4.4.js"></script>
	<style>
		body{margin: 0;font-family:"Microsoft YaHei";}
		.header{height: 50px;margin: 0 auto; background: #364064;font-size: 30px;}
		.ziti{color: #ffffff; }
		.logo{margin-left: 50px;}
		.com{margin-left: 1100px;}
	</style>
</head>
<body>
	<div class="header">
	    <div class="logo">
			<span class="ziti">House管理系统</span>
		</div>
	</div>
	<div class="header-d">
	    <span id="menutitle"></span>
		<div class="com">
	        <span style="width:120px">&nbsp;</span>
	        <span>欢迎您，aheizi</span>
			<a href="javascript:logout();" style="color:#6383FF;padding:0 5px;">[退出]</a>
		</div>
	</div>
</body>
	<script>
		function logout(){
			parent.window.location="logout.do";
		}
	</script>
</html>