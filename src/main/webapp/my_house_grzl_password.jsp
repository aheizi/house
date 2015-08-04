<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>house</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/myhouse.css"/>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/province_str.js" type="text/javascript"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
		function ToUrl(x)   
		{   
		    location.href=x;   
		}
		
		//检查旧密码是否正确
		function checkOldPassword(){
			var oldPassword = $("#oldPassword").val(); 
			var newPassword1 = $("#newPassword1").val();
			var newPassword2 = $("#newPassword2").val();
			
			//判断两次输入是否一致
			if(newPassword1 != newPassword2){
				alert("两次输入密码不一致！");
				return false;
			}
			
			jQuery.ajax({
    		    url : "user.do?action=grzlPasswordAjax",
        	    cache : false,
        	    type : "post",
        	    async : false,
				data: "oldPassword=" + oldPassword + "&newPassword=" + newPassword1,
                success: function(data){
                	alert("修改成功！");
                	//跳转到个人资料主页面
                	ToUrl("user.do?action=grzl_edit");
    			},
    			error:function(msg){
          			alert("旧密码填写错误");
          		}
    		});
		}
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
			<span class="logo">
				<a href="index">
					<img src="images/logo.png">
				</a>
			</span>
			<span class="publish">
				<a class="btn btn-default" href="publish.jsp" role="button">发布出租信息</a>
			</span>
		</div>
	</div>
	<div>
		<div class="center">
			<a href="my_house_grzl.jsp"><img src="images/05.jpg" alt=""></a>
		</div>
	</div>

	<div class="search">
		<div class="lmenu left" >
			<ul id="lmenu_ul">
				<li class="top">
					<a href="user.do?action=grzl"><img src="images/06.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="myHouse.do?action=myHouse"><img src="images/12.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="myHouse.do?action=wdsc"><img src="images/13.jpg" alt=""></a>
				</li>
				<li class="top">
					<a href="my_house_bzzx.jsp"><img src="images/10.jpg" alt=""></a>
				</li>
			</ul>
		</div>
		<div class="right" id="right-con-user">
			<div class="regtable">
			<form class="form-horizontal">
				<table>
					<tr>
						<td>您的用户名</td>
						<td>
							<span class="margin_top margin_left" name="">${sessionScope.userSession}</span>
						</td>
					</tr>
					<tr>
						<td>请输入旧密码</td>
						<td>
							<input id="oldPassword" type="password" class="form-control margin_top margin_left" name="" >
						</td>
					</tr>
					<tr>
						<td>请输入新密码</td>
						<td>
							<input id="newPassword1" type="password" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<td>再次输入密码</td>
						<td>
							<input id="newPassword2" type="password" class="form-control margin_top margin_left" name="">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" class="btn btn-primary margin_top margin_left" value="完成修改" onclick="checkOldPassword();">
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
	</div>

	<div class="footer">
		<span class="outher">@outher aheizi</span>
	</div>
</body>
</html>