<!doctype  html>
<html>
   <head>
	<meta charset="utf-8" />
	<title>manager_user</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/public_all.css" />
	<script type="text/javascript" src="http://static.solaridc.com/jquery/jquery-1.4.4.js"></script>
	 <style>
		.blue_btn{cursor:pointer;}
	 </style>
   </head>
   <body>
	   <div id="wrap">
			<ul class="Menu clearfix">
				<li class="first">用户管理</li>
			</ul>
			<div class="AccountBox">
				<div class="addNO">
					<input type="button" value="新增管理员"  class="blue_btn button" onclick="window.location.href='manager_user_add.jsp'"/>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="imgList">
						<tr>
							<th>用户名</th>
							<th>权限</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
						<tr>
                            <td>黄阳全</td>
                            <td>管理员</td>
							<td>2015-05-05</td>
							<td>
								<a class="green_btn" href="feiyin.do?action=editFeiyinDevice&id=$!feiyinDevice.id&feiyinDeviceNo=$!feiyinDevice.feiyinDeviceNo">编辑</a>
								<a class="green_btn" href="feiyin.do?action=updateStatus&id=$!feiyinDevice.id&feiyinState=$!feiyinDevice.feiyinState">激活</a>
								<a class="green_btn" href="feiyin.do?action=updateStatus&id=$!feiyinDevice.id&feiyinState=$!feiyinDevice.feiyinState">停用</a>
								<a class="green_btn" onclick = "javascript:if(!confirm('确认要删除吗？')){return false;}" href="feiyin.do?action=deleteFeiyinDevice&id=$!feiyinDevice.id">删除</a>
                            </td>
						</tr>
						<tr><td colspan="4" align="center">没有符合条件的记录</td></tr>
				</table>
			</div>
			</div>
	   </div>
   </body>
</html>
