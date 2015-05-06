<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_news_add</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/public_all.css" />
	<style>
	<style>
    	.ipttxt{width: 213px;}
    	table{margin: 5% auto;}
    	.green_btn{padding:5px 20px;text-align:center;cursor:pointer;margin:0px 5px}
	</style>
</head>
<body>
	<div id="wrap">
			<ul class="Menu clearfix">
				<li class="first">主页通告管理</li>
			</ul>
			<div class="AccountBox">
				<h1 class="wx_title">新增通告</h1>
				<form id="form" action="###" method="post">
					<input type="hidden" name="feiyinMerchantId" value="61">
    				<table cellpadding="0" cellspacing="0">
						<tr>
    						<td class="t-left" colspan="2">标题:&nbsp;<input type="text" class="ipttxt" name="feiyinDeviceNo" id="feiyinDeviceNo" value=""/></td>
    					</tr>
						<tr>
						<td class="t-left" colspan="2">内容:&nbsp;<input type="textarea" class="ipttxt" name="deviceNumber" id="deviceNumber" value=""/></td>
						</tr>
    					<tr>
    						<td class="t-center" colspan="2">
    							<input type="button" class="green_btn" value="确定" onclick="checkFeiyinDevice()"/>
    							<input type="button" class="green_btn" value="取消" onclick="window.location.href='feiyin.do'"/>
    						</td>
    					</tr>
    				</table>
                </form>
			</div>
	   </div>
</body>
</html>