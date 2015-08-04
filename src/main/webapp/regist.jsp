<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>regist</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/regist.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/utils.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			$("#checkUserName").hide();
			$("#checkPassword").hide();
			$("#checkEmail").hide();
		});
		
		//检查用户名是否已经注册
		function checkUserName(){
			var userName = $("#userName").val(); 
			jQuery.ajax({
    		    url : "user.do?action=checkUserName",
        	    cache : false,
        	    type : "post",
        	    async : false,
				data: "userName=" + userName,
                success: function(data){
                	$("#checkUserName").hide();
                	$("#regist").removeAttr("disabled");
    			},
    			error:function(msg){
          			$("#checkUserName").show();
          			$("#regist").attr("disabled", "disabled");
          		}
    		});
		}
		
		//检查两次输入的密码是否一致
		function checkPassword(){
			var password = $("#password").val();
			var rePassword = $("#rePassword").val();
			if(password != rePassword){
				$("#checkPassword").show();
				$("#regist").attr("disabled", "disabled");
			}else{
				$("#checkPassword").hide();
				$("#regist").removeAttr("disabled");
			}
		}
		
		//检查邮箱格式是否正确
		function checkEmail(){
			var email= $("#email").val();
			
			if(!IsEmail(email)){
				$("#checkEmail").show();
				$("#regist").attr("disabled", "disabled");
			}else{
				$("#checkEmail").hide();
				$("#regist").removeAttr("disabled");
			}
		}
		
		//提交表单
		function submit(){
			var userName = $("#userName").val(); 
			var email= $("#email").val();
			var password = $("#password").val();
			
			if(userName==""){
				alert("请先输入用户名");
				return false;
			}
			
			if(email==""){
				alert("请先输入邮箱");
				return false;
			}
			
			if(password==""){
				alert("请先输入密码");
				return false;
			}
			
			$("#form").submit();
		}
	</script>
</head>
<body>
	<div class="title">
		<div class="center">
			<span class="logo">
				<a href="index">
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
		<div class="regtable">
			<form id="form" class="form-horizontal" action="user.do?action=saveUser" method="post">
				<input type="hidden" name="type" value="normal">
				<input type="hidden" name="realName" value="">
				<input type="hidden" name="address" value="">
				<input type="hidden" name="zipCode" value="">
				<table>
					<tr>
						<td>用户名</td>
						<td>
							<input type="text" class="form-control margin_top margin_left" name="userName" id="userName" onblur="checkUserName();">
						</td>
						<td>&nbsp&nbsp</td>
						<td>
							<span id="checkUserName" class="mark">该用户名已经被注册</span>
						</td>
					</tr> 
					<tr>
						<td>邮箱</td>
						<td>
							<input type="text" class="form-control margin_top margin_left" name="email" id="email" onblur="checkEmail();">
						</td>
						<td>&nbsp&nbsp</td>
						<td>
							<span id="checkEmail" class="mark">邮箱格式不正确</span>
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td>
							<input type="password" class="form-control margin_top margin_left" name="password" id="password">
						</td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td>
							<input type="password" class="form-control margin_top margin_left" id="rePassword" onblur="checkPassword();">
						</td>
						<td>&nbsp&nbsp</td>
						<td>
							<span id="checkPassword" class="mark">两次输入密码不一致</span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" id="regist" class="btn btn-default margin_top" value="注册" onclick="submit();">
							<input type="button" class="btn btn-default margin_top" value="清空">
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
					