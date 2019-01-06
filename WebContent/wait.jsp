<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	font-weight:bold;
	color:#888888;
	padding:6px，0px;
	text-decoration:none;
	width:100%;

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
    text-align:left;
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
.Center-Show
{
	margin: 20% 10%;
}
</style>
</head>

<div class="Main-Topic" ><!-- 导航栏 -->
	<div class="Main-Topic-Left" >
		<span style="font-size:40px;">找到你</span> <span style="font-size:10px;"></span>
	</div>
	<div class="Main-Topic-LeftUp" >
		<span style="font-size:15px;"><s:property value="%{#application.liaisonuser.name}"/></span>
	</div>
	<div class="Main-Topic-Right" >
		<span class="Top-span"><span class="Top-span"><a href="exit.action" style="color: #fff;">退出</a></span> 
	</div>
</div>
<div class="Main-Center"><!-- 左导航栏 -->
	<ul class="ulL">
	
	</ul>
	<div class="Main-Content">
		<div class="Card-Head"> <!-- 卡片头 -->
			<h3 class="Card-Head-Title" style="text-align: center">您的账号还在审核中</h3>
		</div>
		<div class="Card-Body" >
		<table class="Card-Body-Table">
			
		</table>
		</div>
	</div>
</div>

</html>