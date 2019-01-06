<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找到你</title>
<style type="text/css">
		 ul{/*设置导航栏的框框*/			
			list-style-type: none;
    		margin: 0 auto; /*框框整体的位置*/
    		padding: 0;/*将框框的padding设置为零，不然会导致框框里的内容与框边缘有间隔*/
    		overflow: hidden;
    		background-color:#333;
    		position: fixed;
    		top: 0;
    		width: 100%;    		
		}
		a:link
		{text-decoration: none; color:blue; font-size: 18px; font-family: 微软雅黑;}
    	a:visited
    	{ color:red;}
    	a:hover
    	{color:#09f; font-size: 19px;}
   		a:active
   		{text-decoration: blink; color: yellow;}
		li{
			margin: 0 auto; /*框框整体的位置*/
			float: left;/*将li设置成做浮动，变为联动*/
		}
		aT{
			display: block;/*将a变成块状*/
    		color: white;/*白色字*/
    		text-align: center;/*字体居中*/
    		padding: 14px 16px;
    		text-decoration: none;
		}
		table{
		}
		ulL {
    		list-style-type: none;
    		margin: 0;
    		padding: 0;
   		 	width: 250px;
    		background-color: #43BBEF;
    		position: fixed;
    		height: 100%;
    		overflow: auto;
		}
		liL aL {
    		display: block;
    		color: #000;
    		padding: 8px 16px;
    		text-decoration: none;
    		transition: all 0.5s;
			}
		liL aL.active {
    		background-color: #4364EF;
    		color: white;
		}

		liL aL:hover:not(.active) {
    		background-color: #555;
    		color: white;
		}
		.dropbtn {
		    background-color: #4CAF50;
		    color: white;
		    padding: 16px;
		    font-size: 16px;
		    border: none;
		    cursor: pointer;
		}
		
		.dropdown {
		    position: relative;
		    display: inline-block;
		}
		
		.dropdown-content {
		    display: none;
		    position: absolute;
		    background-color: #f9f9f9;
		    min-width: 160px;
		    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		}
		
		.dropdown-content a {
		    color: black;
		    padding: 12px 16px;
		    text-decoration: none;
		    display: block;
		}
		
		.dropdown-content a:hover {background-color: #f1f1f1}
		
		.dropdown:hover .dropdown-content {
		    display: block;
		}
		
		.dropdown:hover .dropbtn {
		    background-color: #3e8e41;
		}
</style>


</head>
<body>
<div id="导航栏" >
		<ul>
			<li><aT>找到你</aT></li>
			<li><aT><a href="/AMS/index.jsp" style="color: white;">社团展示</a></aT></li>
			<li><aT href="">操作指南</aT></li>
			<li><aT >个人信息</aT></li>
		</ul>
</div>
<div id="显示栏" style="margin-top:50px;">
	<ulL>		
		
		
		
  		<liL><aL class="active" href="#home">社团一览</aL></liL>
  		<liL><aL><a href="index.jsp" style="color: black;">体育运动类</a></aL></liL>
  		<liL><aL href="#contact">实践公益类</aL></liL>
  		<liL><aL href="#about">文化艺术类</aL></liL>
  		<liL><aL><a href="index-hobby.jsp" style="color: black;">兴趣爱好类</a></aL></liL>
  		<liL><aL href="#about">学术科技类</aL></liL>
	</ulL>
	</form>
</div>
<div id="主体" style="padding:25px;margin-top:10px;margin-left:230px;">
	<hr/>
	<div id="主体1" style="margin-top: 0;margin-bottom: 0;padding-top: 0px;height: 200px;background-color: #eee;">
	<br>
	<b style="font-size: 200%"> 足球社</b><br>
	<b style="color:red;">__________</b>
	<p>
	<a href="/AMS/showClassServlet.do?Anumber=01">了解详情&gt;</a>
	</p>
	</div>
	<div id="主体2" style="margin-top: 0;margin-bottom: 0;padding-top: 0px;height: 200px;background-color: #ffffff;">
	<br>
	<b style="font-size: 200%"> 篮球社</b><br>
	<b style="color:red;">__________</b>
	<p>
	<a href="/AMS/showClassServlet.do?Anumber=02">了解详情&gt;</a>
	</p>
	</div>
	<div id="主体3" style="margin-top: 0;margin-bottom: 0;padding-top: 0px;height: 200px;background-color: #eee;">
	<br>
	<b style="font-size: 200%"> 跆拳道社</b><br>
	<b style="color:red;">__________</b>
	<p>
	<a href="/AMS/showClassServlet.do?Anumber=03">了解详情&gt;</a>
	</p>
	</div>
</div>
</body>
</html>