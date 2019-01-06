<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>外联互助</title>
    <style>

        body {
            margin: 0;
            background-color: #f5f5f5;
        }

        .Main-Topic {
            height: 4rem;
            padding: 0 18%;
            background-color: #EE8434;
            color: #fff;
            width: 100%;
            box-sizing: border-box;

        }

        .Main-Topic-Left {
            display: inline-block;
            padding: 0.3rem 0rem;
        }

        .Main-Topic-LeftUp {
            display: inline-block;
            position: absolute;
            padding: 0rem 0.2rem;
            top: 10px;
        }

        .Main-Topic-Right {
            float: right;
        }

        .Top-span {
            font-size: 15px;
            padding: 1.1rem 0rem;
            display: inline-block;

        }

        .Main-Center {
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
            background-color: #FFF;
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

        .liL:hover {
            color: #E63F00;
            display: block;
            background-color: #FFDECE;

        }

        .aL:link, .aL:visited {
            font-weight: bold;
            color: #888888;
            text-decoration: none;
            text-transform: uppercase;
            width: 100%;
            display: block;
        }

        .Main-Content {
            min-height: 600px;
            padding: 0 1rem;
            -webkit-box-flex: 1;
            -ms-flex: 1;
            flex: 1;
            overflow: hidden;
            display: inline-block;
        }

        .Card-Head {
            height: 120px;
            border: 2px solid #e9e9e9;
            border-radius: 5px 0;
            -moz-border-radius: 25px;
            padding: 0 24px;
        }

        .Card-index {
            height: 100px;
            line-height: 30px;
            width: 100%;
            padding: 24px 0;
        }

        .Card-Head-Title {
            font-size: 24px;
            font-weight: bold;
            display: inline-block;
            text-align: left;
            width: 100%;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
            color: #9C9C9C;
        }

        .Card-image {
            width: 80px;
            height: 80px;
            width: 100%;
            padding : 24px 0px;

        }

        .Card-indexdate {
            font-size: 12px;
            display: inline-block;
            width: 20%;
            text-align: right;
            margin: 0 auto 0 auto;
            padding: 10px 0;
            color: #9C9C9C;
        }

        .Card-indexauthor {
            font-size: 12px;
            display: inline-block;
            text-align: right;
            width: 75%;
            margin: 0 auto 0 auto;
            padding: 10px 0;
            color: #000000;
        }


    </style>
</head>
<div class="Main-Topic"><!-- 导航栏 -->
    <div class="Main-Topic-Left">
        <span style="font-size:40px;">找到你</span> <span style="font-size:10px;">外联版</span>
    </div>
    <div class="Main-Topic-LeftUp">
        <span style="font-size:15px;">用户名</span>
    </div>
    <div class="Main-Topic-Right">
        <span class="Top-span">首页 |</span><span class="Top-span">&nbsp;退出</span>
    </div>
</div>
<div class="Main-Center"><!-- 左导航栏 -->
    <ul class="ulL">
        <li class="liL"><a class="aL" href="">发布订单</a></li>
        <li class="liL"><a class="aL" href="">查看反馈</a></li>
        <li class="liL"><a class="aL" href="">申请记录</a></li>
        <li class="liL"><a class="aL" href="">个人设置</a></li>
    </ul>
    <div class="Main-Content">
        <!-- 卡片头 -->
        <s:iterator value="passageList" status="st" var="pl">
            <div class="Card-Head">
                <!--<div class="Card-image">
                    <image src="image/1.png"/>
                </div>-->
                <div class="Card-index">
                    <div class="Card-Head-Title">
                        <a href="passage?id=<s:property value="id"/>"><s:property value="title"/></a>
                    </div>
                    <div class="Card-indexauthor">作者:<s:property value="author"/></div>
                    <div class="Card-indexdate">时间:<s:property value="date"/></div>
                </div>
            </div>
        </s:iterator>

    </div>
</div>

</body>
</html>