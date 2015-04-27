<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		function ToUrl(x)   
		{   
		    location.href=x;   
		}
		
		function submit_check(){
			var userName = $("#userName").val(); 
			var password = $("#password").val();
			
			if(userName==""){
				alert("请先输入用户名");
				return false;
			}
			
			if(password==""){
				alert("请先输入密码");
				return false;
			}
			
			//检查用户名是否已经注册
			jQuery.ajax({
    		    url : "user.do?action=login",
        	    cache : false,
        	    type : "post",
        	    async : false,
				data: "userName=" + userName + "&password=" + password,
                success: function(data){
                	//跳转到主页面
                	ToUrl("index.jsp");
    			},
    			error:function(msg){
          			alert(msg.responseText);
          		}
    		});
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
	<div class="house">
		<img src="images/house.png" class="houseImg">
	</div>
	<div class="logintable">
		<form class="form-horizontal" action="user.do?action=login" method="post">
			<table>
				<tr>
					<td>
						<label>用户名</label>
					</td>
					<td>
						<input type="text" class="form-control margin_top margin_left" name="userName" id="userName">
					</td>
				</tr>
				<tr>
					<td>
						<label>密码</label>
					</td>
					<td>
						<input type="password" class="form-control margin_top margin_left" name="password" id="password">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" class="btn btn-default margin_top margin_left_big" value="登陆" onclick="submit_check();">
						<a href="index.jsp">
							<input type="button" class="btn btn-default margin_top margin_left_big" value="注册">
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>