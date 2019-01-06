<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<s:head theme="xhtml"/>
	<script src="jquery-3.3.1.min.js"></script>
    <script src="scrollreveal.min.js"></script>
    <script src="/jquery/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找到你平台</title>
<style>
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
	font-weight:bold;
	color:#888888;
	padding:6px，0px;
	text-decoration:none;
	width:100%;
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
td
{
	text-align: left;
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
	position:fixed;
}
.Center-Form
{
	margin:0px auto;
	
}
.calendar { table-layout: fixed; }
</style>
</head>
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
			<h3 class="Card-Head-Title">个人信息修改</h3>
		</div>
		<div class="Card-Body" >
			<div class="Center-Form" >
				<s:form class="Center-Form" action ="updateBusinessInfo" method="post">
					<table>
						<tr><s:hidden name="business.businessID" value="%{#application.business.businessID}"/></tr>
					</table>
					<table class="Center-Form">
						<tr>
							<td>用户名不可修改</td>
							<td ><s:textfield name="login.account" value="%{#application.business.login.account}" readonly="true" style="background-color: #cccccc" label="用户名不可修改"/></td>
						</tr>
						<tr>
							<td>请输入密码</td>
							<td><s:password name="login.password" label="请输入密码"/></td>
						</tr>
						<tr>
							<td>请输入姓名</td>
							<td><s:textfield name="business.name" label="请输入姓名"/></td>
						</tr>
						<tr>
							<td>请输入身份证号码</td>
							<td><s:textfield name="business.IDCard" label="请输入身份证号码"/></td>
						</tr>
						<tr>
							<td>请输入电话号码</td>
							<td><s:textfield name="business.phone" label="请输入电话号码"/></td>
						</tr>					
						<tr>
							<td></td>
							<td>
								<table  style="width:100%;">
								<tr>
									<td><s:submit name="submit" value="提交"/></td>
									<td><s:reset name="reset" value="重置"/></td>
								</tr>
								</table>
							</td>
						</tr>
					</table>	
				</s:form>
			</div>
		</div>
	</div>
</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	$(".flip").click(function(){
	    $(".show").slideToggle("slow");
	  });
	});
</script>
</html>