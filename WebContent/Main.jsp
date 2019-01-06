<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找到你平台</title>
<style>
.opacity_ {
	widht: 100%;
	height: 100%;
	background-color: #FFFF00;
	position: fixed;
	left: 0px;
	top: 0px;
}

.login {
	width: 360px;
	height: 360px;
	background-color: #FF0000;
	position: fixed;
	left: 50%;
	top: 50%;
	margin-left: -180px;
	margin-top: -180px;
}

td {
	text-align: center;
}

a:link {
	color: white;
	font-size: 16;
	text-decoration: none;
}

a:visited {
	color: #d6d5a9;
	font-size: 16;
	text-decoration: none;
}

a:hover {
	color: #8ac9d6;
	font-size: 16;
	text-decoration: none;
}

a:active {
	color: #a9d6b5;
	font-size: 16;
	text-decoration: none;
}

.rightp {
	color: white;
	left: 80%;
	position: absolute;
}

.buttondown {
	top: 500px;
	margin: 0 auto;
	position: absolute;
	text-align: center;
}

.word {
	color: white;
	font-size: 30px;
	top: 200px;
	left: 35%;
	position: absolute;
	text-align: center;
	margin: 0 auto;
}

.leftTd {
	text-align: left;
}
</style>
<script src="jquery-3.3.1.min.js"></script>
<script src="scrollreveal.min.js"></script>
<!--<script src="https://unpkg.com/scrollreveal"></script>-->

</head>
<body>

	<!-- 弹窗 -->

	<!-- 遮罩层 -->
	<div id="cover"
		style="background: #000; position: fixed; left: 0px; top: 0px; width: 100%; filter: alpha(opacity = 30); opacity: 0.3; display: none; z-index: 2">
	</div>
	<div id="showdiv"
		style="width: 360px; height: 360px; position: fixed; left: 50%; top: 50%; z-index: 3; margin-left: -180px; margin-top: -180px; display: none; background: #fff">
		<!-- 标题 -->
		<div
			style="background: #F8F7F7; width: 100%; height: 2rem; font-size: 1.3rem; line-height: 2rem; border: 1px solid #999; text-align: center;">
			提示</div>
		<!-- 内容 -->
		<div
			style="text-indent: 100px; height: 4rem; font-size: 1rem; padding: 1rem; line-height: 2rem;">
			<table>
				<tr>
					<td>ss</td>
					<td>ss</td>
				</tr>
				<tr>
					<td>ss</td>
					<td>ss</td>
				</tr>
			</table>
		</div>
		<!-- 按钮 -->
		<div
			style="background: #418BCA; width: 50%; margin: 0 auto; height: 2rem; line-height: 1.5rem; text-align: center; color: #fff; margin-top: 11rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem; font-size: 1.0rem;"
			onclick="closeWindow()">确 定</div>
	</div>

	<div id="showdiv_login"
		style="width: 360px; height: 360px; position: fixed; left: 50%; top: 50%; z-index: 3; margin-left: -180px; margin-top: -180px; display: none; background: #fff">
		<!-- 标题 -->
		<div
			style="background: #F8F7F7; width: 100%; height: 2rem; font-size: 1.3rem; line-height: 2rem; border: 1px solid #999; text-align: center;">
			登 陆</div>
		<!-- 内容 -->
		<div
			style="height: 40px; font-size: 20px; padding: 10px; line-height: 20px;">
			<a href="VisiterToSeeActive.action" style="color: black">游客入口</a>
			<s:form action="login" method="post">
				<table>
					<tr>
						<td style="text-align: left;">请输入用户名</td>
						<td><s:textfield name="login.account" label="请输入用户名" /></td>
					</tr>
					<tr>
						<td style="text-align: left;">请输入密码</td>
						<td><s:password name="login.password" label="请输入密码" /></td>
					</tr>
					<tr>
						<td><input name="type" type="radio" value="business" />商家</td>
						<td><input name="type" type="radio" value="liaisonuser" />外联</td>
					</tr>
					<tr>
						<td>
							<table style="width: 100%;">
								<tr>
									<td><s:submit name="submit" value="登录" /></td>
								</tr>
							</table>
						</td>
						<td>
							<table style="width: 100%;">
								<tr>
									<td><s:reset name="reset" value="重置" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</s:form>

		</div>
		<!-- 按钮 -->
		<div
			style="background: #418BCA; width: 50%; margin: 0 auto; height: 2rem; line-height: 1.5rem; text-align: center; color: #fff; margin-top: 11rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem; font-size: 1.0rem;"
			onclick="closeWindow()">关闭</div>


	</div>

	<!-- 弹窗结束 -->

	<div id="主体1"
		style="margin-top: 0; margin-bottom: 0; padding-top: 0px; height: 800px; background-color: #FFFFFF; background: url(image/timg.jpg) no-repeat">
		<div class="rightp" id="rightp">
			<a href="javascript:void(0);" onclick="logind()"><font color="#0066FF"><b>登陆</b></font></a> | <a
				href="RegisterUser.jsp"><font color="#0066FF"><b>注册</b></font></a>
		</div>
		<div class="word" id="word" align="center">
			.<br />  .<br />
			<h2>.</h2>
			<br />
		</div>
		<div class="button" align="center" style="color: #b0d6d4"
			align="center">
			<a class="buttondown" id="buttondown" href="javascript:void(0);"><h2><br><br><br><br><br><br>.</h2>
			</a>
		</div>
		<!--<div class="button" align="center"><a id="button" onclick="showWindow();">点击弹窗</a></div>-->
	</div>

	<div id="主体2"
		style="margin-top: 0%; margin-bottom: 0; padding-top: 0px; height: 500px; background-color: #eee;"
		align="center">
		功能介绍1
		<h2>We are still preparing for this</h2>
		<h3>
			We are still preparing for this<br />We are still preparing for this
		</h3>
		<ul class="mobile">
			<img class="setting-picture sr-picture" src="image/test.png"
				width="10%" alt="666" />
			<img class="setting-picture sr-picture" src="image/test.png"
				width="10%" alt="666" />
		</ul>
	</div>
	<div id="主体3"
		style="margin-top: 0%; margin-bottom: 0; padding-top: 0px; height: 500px; background-color: #FFFFFF;"
		align="center">

		<h2>We are still preparing for this</h2>
		<h3>
			We are still preparing for this<br />We are still preparing for this
		</h3>
		<img src="image/test.png" width="15%"
			class="setting-picture sr-create-org" alt="创建组织"> 功能介绍2
	</div>
	<div id="主体4" class="666"
		style="margin-top: 0%; margin-bottom: 0; padding-top: 0px; height: 500px; background-color: #eee;"
		align="center">
		功能介绍3
		<div class="white-container">
			<div class="container setting-center">
				<h2>更多功能</h2>
				<div style="height: 20px"></div>
				<div class="moreContentFlexBox">
					<div class="moreContentBox sr-more">
						<img width="40px"
							src="http://cdn.muyutech.com/home1.2/more1.1.png" alt="" />
						<p class="moreContentTitle">创建组织</p>
						<p>支持手动导入，Excel批量导入</p>
						<p>不同应用环境，自由选择</p>
					</div>
					<div class="moreContentBox sr-more">
						<img width="40px"
							src="http://cdn.muyutech.com/home1.2/more2.1.png" alt="" />
						<p class="moreContentTitle">二次提醒</p>
						<p>对未回复通知的人一键发送短信提醒</p>
						<p>不再担忧收到却不回复</p>
					</div>
					<div class="moreContentBox sr-more">
						<img width="40px"
							src="http://cdn.muyutech.com/home1.2/more3.1.png" alt="" />
						<p class="moreContentTitle">适应各种应用环境</p>
						<p>对报名类通知添加回复截止时间</p>
						<p>超过时间后不再接受回复</p>
					</div>
					<div class="moreContentBox sr-more">
						<img width="40px"
							src="http://cdn.muyutech.com/home1.2/more4.1.png" alt="" />
						<p class="moreContentTitle">简化工作</p>
						<p>简单步骤制作表单</p>
						<p>统计调研轻松完成</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<h1 class="headline">页面制作人员……</h1>
	<div class="opacity_"></div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        window.sr = new ScrollReveal({duration: "1000", reset: false});
        sr.reveal('.headline');
        sr.reveal('.sr-picture', {}, 200);
        sr.reveal('.sr-create-org', {origin: 'left', distance: '100px', scale: 1}, 200);
        sr.reveal('.sr-more', {}, 200);
    });
    $(function () {
        webHeight = window.innerHeight;
        $(".buttondown").click(function () {
            $("html,body").animate({
                scrollTop: webHeight
            }, 800);
        })
    })

    // 弹窗
    function showWindow() {
        $('#showdiv').show();  //显示弹窗
        $('#cover').css('display', 'block'); //显示遮罩层
        $('#cover').css('height', document.body.clientHeight + 'px'); //设置遮罩层的高度为当前页面高度
    }

    function logind() {
        $('#showdiv_login').show();  //显示弹窗
        $('#cover').css('display', 'block'); //显示遮罩层
        $('#cover').css('height', document.body.clientHeight + 'px'); //设置遮罩层的高度为当前页面高度
    }

    // 关闭弹窗
    function closeWindow() {
        $('#showdiv').hide();  //隐藏弹窗
        $('#showdiv_login').hide();  //隐藏弹窗
        $('#cover').css('display', 'none');   //显示遮罩层
    }
</script>
</html>