<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>manager_menu</title>
    <link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="http://static.solaridc.com/jquery/jquery-1.4.4.js"></script>
    <script type="text/javascript" src="js/jquery.ztree.core-3.0.js"></script>
    <style type="text/css">
    .ztree li a.level0 {height: 25px; text-align: center; display:block; border:0px silver solid; border-right: 0; margin-bottom: 5px;}
    .ztree li a.level1 span{} 
    .ztree li a.level0.cur {background-color: #66A3D2; }
    .ztree li a.level0 span {float:left;display:block; color:#333; padding-top:3px; font-size:12px;word-spacing: 2px;}
    .ztree li a.level0 button {	float:left; margin-left:10px;margin-top: 2px; visibility: visible;}
    .ztree li button.switch.level0 {display:none;}
    .ztree li.level1{margin:0 0 10px 0;}
    .ztree li.level2{margin:3px 0;clear:both;overflow:hidden;display:block}
    .ztree li a.curSelectedNode{color:#DC3912;border:0;background:none;}
    .ztree li a.curSelectedNode{font-weight:bold;}
    </style>
    <script>
    	var weixin = "[{id:'1',pId:'',name:'用户管理',target:'decoratorIframeBody',url:'manager_user.jsp',icon:'images/zTree_37.png'},"
		+"{id:'2',pId:'',name:'房屋管理',target:'decoratorIframeBody',url:'',icon:'images/zTree_40.png'},"
        +"{id:'21',pId:'2',name:'出租房屋管理',target:'decoratorIframeBody',url:'manager_out.jsp',icon:'images/zTree_39.png'},"
        +"{id:'22',pId:'2',name:'求租房屋管理',target:'decoratorIframeBody',url:'manager_in.jsp',icon:'images/zTree_39.png'},"
		+"{id:'3',pId:'',name:'主页通告管理',target:'decoratorIframeBody',url:'manager_news.jsp',icon:'images/zTree_40.png'}]";
		
        var zTree_Menu = null;
        var setting = {
        	view:{showLine:true,selectedMulti:false,dblClickExpand:false,oneclick:true},
        	data:{simpleData:{enable:true}},
        	callback: {
    			onClick:function(e,treeId,treeNode){
    				var mark = $("#mark").attr("mark");
    				zTree_Menu = jQuery.fn.zTree.getZTreeObj(mark);
    				if(zTree_Menu!=null) zTree_Menu.expandNode(treeNode);
    				//添加正在加载loading效果代码
    				if(treeNode.url==null || treeNode.url =="undefined" || treeNode.url =="" || treeNode.url=="#"){
    					//无连接的话只执行展开折叠操作
    				}else{
    					var _rightframe =$("#rightframe",parent.document.body); 
        				var _div =$("#searching",parent.document.body); 
        				var _divSearched =$(".searched",parent.document.body);
        				_divSearched.hide();
        				_div.show();
        				_rightframe.load(function(){
        					_divSearched.show();
        				});
    				}
    			}
        	}
        };
    //为了可以展开先写成这个样 
       $(document).ready(function(){
        	zTree_Menu=jQuery.fn.zTree.init($("#weixin"), setting, eval(weixin)).expandAll(true);
    		$('.ztree li a').each(function(i){
    			if($(this).attr('href')==''||$(this).attr('href')==null){
    				$(this).find('span').css({'font-weight':'bold'});
    			}
    		})
        });
    </script>
</head>
<body style="padding: 0; margin: 0; background:#F3F3F3">
    <div class="dtree" bgcolor="#cccccc">
		<span id="mark" mark="dingdan"></span>
		<ul id="weixin" class="ztree" menuMark="dingdan"></ul>
    </div>
</body>
</html>