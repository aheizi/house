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
				<li class="first">求租房屋管理</li>
			</ul>
			<div class="AccountBox">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="imgList">
						<tr>
							<th>标题</th>
							<th>发布时间</th>
							<th>发布人</th>
							<th>审核状态</th>
							<th>操作</th>
						</tr>
						<tr>
                            <td><a href="" target="_Blank">[整租]600-1300元、一室一厅、隆康路有空调电视</a></td>
                            <td>2015-05-05</td>
							<td>aheizi</td>
							<td>已通过审核</td>
							<td>
								<a class="green_btn" href="###">审核通过</a>
								<a class="green_btn" href="###">审核不通过</a>
								<a class="green_btn" onclick = "javascript:if(!confirm('确认要删除吗？')){return false;}" href="feiyin.do?action=deleteFeiyinDevice&id=$!feiyinDevice.id">删除</a>
                            </td>
						</tr>
						<tr><td colspan="5" align="center">没有符合条件的记录</td></tr>
				</table>
			</div>
	   </div>
   </body>
</html>
