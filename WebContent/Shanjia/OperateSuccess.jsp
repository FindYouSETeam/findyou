<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="jquery-3.3.1.min.js"></script>
    <script src="scrollreveal.min.js"></script>
    <script src="/jquery/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找到你平台</title>
<style>
html
{
	height:100%;
	
}
th
{
	text-align:center;
}
body{
	margin: 0;
	background-color:#f5f5f5;
}
td
{
	text-align: center;
}
a,a:hover
{
	text-decoration:none;
}
.flip {
    		display: block;
    		color: #000;    		
    		padding: 8px 16px;
    		text-decoration: none;
    		transition: all 0.5s;
    		
			}
.flip:hover{
	color:	#E63F00;
	display: block;
	background-color:#FFDECE;	
}
.show {
    		display: block;
    		color: #000;    		
    		padding: 8px 16px;
    		text-decoration: none;
    		transition: all 0.5s;
    		
			}

.show
{
display:none;
}
.Main-Topic { 
    height: 4rem;
    padding: 0 18%;
    background-color: 	#EE8434;
    color: #fff;
    width: 100%;
    box-sizing:border-box; 
         
}
.Main-Topic-Left
{
	display: inline-block;
    padding: 0.3rem 0rem;
}
.Main-Topic-LeftUp
{
	display: inline-block;
	position:absolute;
	padding: 0rem 0.2rem;
    top:10px;
}

.Main-Topic-Right
{
	float:right;
}
.Top-span
{
	font-size:15px;
	padding: 1.1rem 0rem;
	display: inline-block;
   
}
.Main-Center
{
	width: 1100px;
    background-color: #fff;
    padding: 1rem .25rem;
    margin: 0 auto;
    margin-top: 2rem;
    border-radius: 5px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    display: -webkit-flex;
    -webkit-box-pack: start;
    -ms-flex-pack: start;
    justify-content: flex-start;
}
.ulL {
    		
    		margin: 0;
    		padding: 0;
   		 	width: 229px;
    		background-color:#FFF;
    		height: 500px;
    		overflow: auto;
		}
.liL {
    		display: block;
    		color: #000;    		
    		padding: 8px 16px;
    		text-decoration: none;
    		transition: all 0.5s;
    		
			}
.liL:hover{
	color:	#E63F00;
	display: block;
	background-color:#FFDECE;
	
}
.aL:link,.aL:visited{
	font-weight:bold;
	color:#888888;
	padding:6px，0px;
	text-decoration:none;
	width:100%;
	display: block;	
}
.Main-Content
{
	min-height: 550px;
    padding: 0 1rem;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    overflow: hidden;
    display: inline-block;
}
.Card-Head
{
	height: 48px;
    line-height: 48px;
    
    border: 2px solid #e9e9e9;
	border-radius:5px,0;
    padding: 0px 24px;
}
.Card-Body
{
	height: 450px;
    line-height: 48px;
    border: 2px solid #e9e9e9;
	border-radius:0px, 5px;
    padding: 5px;
}
.Card-Head-Title
{
	font-size: 14px;
    display: inline-block;
    text-align:center;
  	margin:0;
    text-overflow: ellipsis;
    width: 100%;
    overflow: hidden;
    white-space: nowrap;
    color:#9C9C9C;
}
.Card-Body-Table
{
	border-collapse:collapse;
	width:100%;
}
.Center-Form
{
	margin:0px auto;
	border:1px;
	font-size: 20px;
}
#cover
{
	background: #000;
	position: fixed;
	left: 0px; 
	top: 0px; 
	width: 100%;
	height:100%;
	filter: alpha(opacity=30); 
	opacity: 0.3; 
	display: none; 
	z-index: 2;
	 
}
#showdiv /* 弹窗 */
{
	width: 360px; 
	height: 360px;
	position: fixed ; 
	left: 50%; 
	top: 50%;
	z-index: 3;
	margin-left: -180px;
	margin-top:-180px; 
	display: none;
	background: #fff;
} 
.title
{
	background: #F8F7F7; 
	width: 100%; 
	height: 2rem; 
	font-size: 1.3rem; 
	line-height: 2rem; 
	border: 1px solid #999; 
	text-align: center;
}
.content
{
	text-indent: 100px; 
	height: 100%; 
	width:100%;
	font-size: 1rem; 
	line-height: 2rem; 
}
.SubmitButton
{
	background: #418BCA; 
	width: 50%;
	margin: 0 auto;
	height: 2rem;
	line-height: 1.5rem;
	text-align: center;
	color: #fff;
	margin-top: 11rem;
	-moz-border-radius: .128rem;
	-webkit-border-radius: .128rem;
	border-radius: .128rem;
	font-size: 1.0rem;
         
}
.Center-Show
{
	margin: 20% 10%;
}
</style>
</head>
<!-- 弹窗 -->

<!-- 遮罩层 -->
<div id="cover">
     
</div>
<div id="showdiv">
    <!-- 标题 -->
    <div class="title">
        	意向详情
    </div>
    <!-- 内容 -->
    <div class="Center-Show">
    		<div style="padding-left: 40px;padding-bottom: 20px;"><a href="ToAddW.jsp" style="font-size:20px">新建活动</a></div>
       	 <table class="Center-Form">
       	 	<tr>
       	 		<td width=50% height=30px;>选择</td>
       	 		<td>XX活动</td>
       	 	</tr>
       	 	<tr>
       	 		<td>选择</td>
       	 		<td>XX活动</td>
       	 	</tr>
       	 	<tr>
       	 		<td>选择</td>
       	 		<td>XX活动</td>
       	 	</tr>
       	 </table>
       	 <div style="padding-left: 100px;"><a href=""style="font-size:20px">提交</a>&nbsp;&nbsp;&nbsp;<a style="font-size:20px" onclick="closeWindow()">关闭</a></div>
    </div>
    <!-- 按钮 -->
</div>
<!-- 弹窗结束 -->
<div class="Main-Topic" ><!-- 导航栏 -->
	<div class="Main-Topic-Left" >
		<span style="font-size:40px;">找到你</span> <span style="font-size:10px;">商家版</span>
	</div>
	<div class="Main-Topic-LeftUp" >
		<span style="font-size:15px;"><s:property value="%{#application.liaisonuser.name}"/></span>
	</div>
	<div class="Main-Topic-Right" >
		<span class="Top-span"><a href="findallliaison.action" style="color: #fff;">首页</a> </span><span class="Top-span">&nbsp;|&nbsp;<a href="exit.action" style="color: #fff;">退出</a></span> 
	</div>
</div>
<div class="Main-Center"><!-- 左导航栏 -->
	<ul class="ulL">
		<li class="liL"><a class="aL" href="/FindYou/Shanjia/ToAddAS.jsp">发布营销计划</a></li>
		<li class="liL"><a class="aL" href="findMyShopActive.action">查看我的营销计划</a></li>
		<li class="liL"><a class="aL" href="/FindYou/Shanjia/ToAddS.jsp">发布订单</a></li>
		<li class="liL"><a class="aL" href="findliaisonrequest.action">查看反馈</a></li>
		<li class="liL"><a class="aL" href="allIntention.action">申请记录</a></li>
		<li class="flip"><a class="aL" href="javascript:void(0);" >历史订单</a></li>
		<div class=show>
			<li class="liL"><a class="aL" href="getOrderDoing.action" >进行中订单</a></li>
			<li class="liL"><a class="aL" href="getOrderDone.action" >已完成订单</a></li>
		</div>
		<li class="liL"><a class="aL" href="/FindYou/Shanjia/ToChangeS.jsp">个人设置</a></li>
	</ul>
	<div class="Main-Content">
		<div class="Card-Head"> <!-- 卡片头 -->
			<h3 class="Card-Head-Title">操作成功</h3>
		</div>
		<div class="Card-Body" >
			
		</div>
	</div>
</div>

</body>
<script type="text/javascript">
    function showWindow() {
        $('#showdiv').show();  //显示弹窗
        $('#cover').css('display', 'block'); //显示遮罩层
        $('#cover').css('height', document.body.clientHeight + 'px'); //设置遮罩层的高度为当前页面高度
    }

    // 关闭弹窗
    function closeWindow() {
        $('#showdiv').hide();  //隐藏弹窗
        $('#cover').css('display', 'none');   //显示遮罩层
    }
	$(document).ready(function(){
		$(".flip").click(function(){
		    $(".show").slideToggle("slow");
		  });
		});
</script>
</html>