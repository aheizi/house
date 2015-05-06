<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_index</title>
	<base target="rightframe"/>
	<script type="text/javascript" src="http://static.solaridc.com/jquery/jquery-1.4.4.js"></script>
	<script>
    	$(function(){
        	$('#header').height();
        	$(window).height();
        	$('#left,#leftframe,#right,#rightframe').height($(window).height()-$('#header').height() -2 + "px");
        	//$('#right,#rightframe').width($(window).width()-$('#left').width());
        })
		$(window).resize(function(){
			$('#left,#leftframe,#right,#rightframe').height($(window).height()-$('#header').height() -2 + "px");
		})
    </script>
    <style>
		body,html{ overflow: hidden;}
        body{margin:0;padding:0;border:0;}
        #header{clear:both;border-bottom:1px solid #3753D1;border-top:1px solid #3854D1;height:80px;}
        #left{height:100%;border-right:1px #9BA9E8 solid;width:200px;position:absolute;left:0;top:82px;}
        #right{margin-left:200px;}
		.sidebar {position: absolute;width: 8px; top: 50%;}
        .sidebar img {cursor: pointer}
    </style>
</head>
<body>
	<div>
    	<div id="header">
    		<iframe id="headerframe" src="manager_header.jsp"  frameborder="0" width="100%" height="80"></iframe>
    	</div>
    	<div id="left">
			<iframe  id="leftframe" name="leftframe" src="manager_menu.jsp" frameborder="0" width="200" height="600"></iframe>
		</div>
    	<div id="right" class="searched">
			<iframe id="rightframe" name="decoratorIframeBody" src="manager_welcome.jsp" frameborder="0" height="100%" width="100%" >
			</iframe>
    	</div>
    </div>
	<div style='text-align:center;padding-top:150px;padding-left:150px;display:none' id="searching" class="searching"><span>正在为您加载页面,请稍后...</span><br/>
		<img src='http://static.solaridc.com/project/51book_cg/images/progress-bar.gif'/>
	</div>
</body>
</html>