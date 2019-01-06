<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.zjut.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="jquery-3.3.1.min.js"></script>
    <script src="scrollreveal.min.js"></script>
    <script src="/jquery/jquery-1.11.1.min.js"></script>
    <%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找到你平台</title>
<style>
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
body{
	margin: 0;
	background-color:#f5f5f5;
}
td
{
	text-align: center;
}
a
{
	font-weight:bold;
	color:#888888;
	padding:6px，0px;
	text-decoration:none;
	width:100%;
}
.Main-Topic { 
    height: 64px;
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
	padding:6px,0px;
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
    padding: 0 24px;
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
    text-align:left;
    text-overflow: ellipsis;
    margin:0;
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
#showdiv /* 弹窗 */
{
	width: 580px; 
	height: 360px;
	position: fixed ; 
	left: 50%; 
	top: 50%;
	z-index: 3;
	margin-left: -290px;
	margin-top:-180px; 
/*  	display: none;  */
	background: #fff;
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
/* 	display: none;  */
	z-index: 2;
	 
}
</style>
</head>
<s:action name="DemandAction" namespace="" executeResult="false"/>
<div class="Main-Topic" ><!-- 导航栏 -->
	<div class="Main-Topic-Left" >
		<span style="font-size:40px;">找到你</span> <span style="font-size:10px;">外联版</span>
	</div>
	<div class="Main-Topic-LeftUp" >
		<span style="font-size:15px;"><s:property value="%{#application.liaisonuser.name}"/></span>
	</div>
	<div class="Main-Topic-Right" >
		<span class="Top-span"><a href="findallbusiness.action" style="color: #fff;">首页</a> </span><span class="Top-span">&nbsp;|&nbsp;<a href="exit.action" style="color: #fff;">退出</a></span> 
	</div>
</div>


<div class="Main-Center"><!-- 左导航栏 -->
	<ul class="ulL">
		<li class="liL"><a class="aL" href="/FindYou/Wailian/ToAddW.jsp">发布订单</a></li>
		<li class="liL"><a class="aL" href="findbusinessrequest.action">查看反馈</a></li>
		<li class="liL"><a class="aL" href="allIntention.action">申请记录</a></li>
		<li class="flip"><a class="aL" href="javascript:void(0);" >历史订单</a></li>
		<div class=show>
			<li class="liL"><a class="aL"  href="getOrderDoing.action" >进行中订单</a></li>
			<li class="liL"><a class="aL" href="getOrderDone.action" >已完成订单</a></li>
		</div>
		<li class="liL"><a class="aL" href="/FindYou/Wailian/ToChangeW.jsp">个人设置</a></li>	
		<li class="liL"><a class="aL" href="plist.action">查看外联互助</a></li>	
	</ul>
	<div class="Main-Content">
		<div class="Card-Head"> <!-- 卡片头 -->
			<h3 class="Card-Head-Title" style="text-align: center">收到的申请</h3>
		</div>
		<div class="Card-Body" >
			<table class="Card-Body-Table">
				<tr style="background-color:#f5f5f5;">
					<th>商家名</th>
					<th>最小金额</th>
					<th>最大金额</th>
					<th>发布时间</th>
					<th>覆盖人数</th>
					<th>电话</th>
					<th>是否接受</th>
				</tr>
				<s:iterator value="businessrequestList" >
				<tr>
					<td><a href="showShopdetail.action?shopID=<s:property value="shopID"/>" onclick="showWindow()"><s:property value="shopname"/></a></td>
					<td><s:property value="mincapital"/></td>
					<td><s:property value="maxcapital"/></td>
					<td><s:property value="publisheddate"/></td>
					<td><s:property value="overallnum"/></td>
					<td><s:property value="phone"/></td>
					<td><a href="rejectBusinessrequestOrnot.action?reject=0&intentionID=<s:property value="intentionID"/>">接受</a></td>
					<td><a href="rejectBusinessrequestOrnot.action?reject=1&intentionID=<s:property value="intentionID"/>">拒绝</a></td>
				</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</div>

<% 
   	int i=0;
	Shop s=new Shop();
	System.out.println(s.getShopname());
	if(application.getAttribute("shop")!=null)
  		{s=(Shop)application.getAttribute("shop");
  		System.out.println(s.getShopname());
  		}
   
   if (s.getShopID()!=0)
   {
 	%> 
<!-- 弹窗 -->

<!-- 遮罩层 -->
<div id="cover">
     
</div>
<div id="showdiv" >
    <!-- 标题 -->
    <div  class="title" style="text-align: center;background:#f5f5f5">
        	商家详情
    </div>
    <!-- 内容 -->
    <div  class="Center-Show"  >
       	 <table class="Card-Body-Table">
	       	 <tr>
	       	 	<td style="height: 50px">店铺名</td>
	       	 	<td><s:property value="%{#application.shop.shopname}"/></td>
	       	 </tr>
	       	 <tr >
	       	 	<td style="height: 50px">店铺类型</td>
	       	 	<td><s:property value="%{#application.shop.shoptype}"/></td>
	       	 </tr>
	       	 <tr>
	       	 	<td style="height: 50px">店铺详情</td>
	       	 	<td> <s:property value="%{#application.shop.shopdetail}"/></td>
	       	 </tr>
	       	 <tr>
	       	 	<td style="height: 50px">地址</td>
	       	 	<td><s:property value="%{#application.shop.address}"/></td>
	       	 </tr>
       	 </table>
       	 <div style="padding-left: 40%;"><a href=""style="font-size:20px">提交</a>&nbsp;&nbsp;&nbsp;<a href="closeShopdetail.action" style="font-size:20px" onclick="closeWindow()">关闭</a></div>
    </div>
    <!-- 按钮 -->
</div>
<!-- 弹窗结束 -->
 <% } %>

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
    $(document).ready(function(){//滑动界面查看订单
		$(".flip").click(function(){
		    $(".show").slideToggle("slow");
		  });
		});
</script>
</html>
