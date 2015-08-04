<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_login</title>
	<link rel="stylesheet" href="css/manger_login.css" type="text/css">
	<script src="js/jquery.min.js" type="text/javascript"></script>
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
    		    url : "user.do?action=managerLogin",
        	    cache : false,
        	    type : "post",
        	    async : false,
				data: "userName=" + userName + "&password=" + password,
                success: function(data){
                	//跳转到主页面
                	ToUrl("manager_index.jsp");
    			},
    			error:function(msg){
          			alert("用户名或密码错误！");
          		}
    		});
		}

	</script>
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
				<form name="loginform" action="user.do?action=managerLogin" method="post">
					<ul>
	    				<li class="f-left gray" style="width:60px;">用户名：</li>
	    				<li class="f-left">
							<input type="text" id="userName" name="username" value="" class="pad5 border-g" style="width:160px;" />
						</li>
	                </ul>
					<ul>
	    				<li class="f-left gray" style="width:60px;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	    				<li class="f-left">
							<input type="password" id="password" name="password" class="pad5 border-g" style="width:160px;"/>
						</li>
	                </ul>
	                <ul>
	                	<li class="f-left gray" style="width:60px;"></li>
	                	<li class="f-left">
	                		<input type="botton" class="checkinimg" value="" onclick="submit_check();"/>
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