<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta charset="UTF-8">
	<title>U闲交易平台</title>
	<link rel="stylesheet" type="text/css" href="front/css/publish.css">
	<link rel="icon" href="front/images/icon.ico">
</head>
<body>
	<!-- header -->
    <div class="header">
        <div class="header_main wrap">
            <h1><a href="index.html" target="_blank"></a><img src="front/images/logo-2.png"></a></h1>
            <h2>让你的闲置游起来!</h2>
            <ul class="header_menu clearfix">
                <li><a href="index.html" target="_blank">首页</a></li>
                <li><a href="#">手机二手</a></li>
                <li><a href="#">二手车估价</a></li>
                <li><a href="#">降降降</a></li>
                <li><a href="#" class="active">发布闲置</a></li>
                <li class="header_wdxz">
                    <a href="list.html" target="_blank">我的闲置</a>
                    <ul class="header_xz">  
                        <li><a href="#">出售中：<span>0</span></a></li>  
                        <li><a href="#">交易中：<span>0</span></a></li>  
                        <li><a href="#">新留言：<span>0</span></a></li>
                        <li><a href="#">新会话：<span>0</span></a></li>    
                    </ul> 
                </li>
                <li class="header_mycenter">
                    <a href="#">个人中心</a>
                    <ul class="header_center">  
                        <li><a href="#">完善个人信息</a></li>  
                        <li><a href="#">修改密码</a></li>  
                        <li><a href="#">我的收藏</a></li>  
                    </ul> 
                </li>
                <li class="quit"><a href="javascript:void(0)">退出</a></li>
            </ul>
        </div>
    </div>

    <!-- 宝贝信息 -->
    <form method="post" action="UpdatePerfect">
    <div class="bbxx wrap">
    	<div class="biaodan"><span>昵称：</span><input name="u_nickname" type="text" value="${map.u_nickname}"></div>
        <div class="biaodan"><span>手机：</span><input name="u_phonenum" type="text" value="${map.u_phonenum}"></div>
        <div class="biaodan"><span>生日：</span><input name="u_birthday" type="text" value="${map.u_birthday}"></div>
        <div class="biaodan"><span>省  &nbsp;&nbsp;：</span><input name="u_province" type="text" value="${map.u_province}"></div>
        <div class="biaodan"><span>市  &nbsp;&nbsp;：</span><input name="u_city" type="text" value="${map.u_city}"></div>
        <div class="biaodan"><span>区  &nbsp;&nbsp;：</span><input name="u_district" type="text" value="${map.u_district}"></div>
        <input type="submit" class="qqfb" value="确认修改">
    </div>
    </form>
    <!-- 底部一堆 -->
    <div class="footer_1 wrap">
        <a href="#" target="_blank">关于我们</a>
        <a href="#" target="_blank">合作伙伴</a>
        <a href="#" target="_blank">营销中心</a>
        <a href="#" target="_blank">廉正举报</a>
        <a href="#" target="_blank">联系客服</a>
        <a href="#" target="_blank">开放平台</a>
        <a href="#" target="_blank">诚征英才</a>
        <a href="#" target="_blank">联系我们</a>
        <a href="#" target="_blank">网站地图</a>
        <a href="#" target="_blank">法律声明及隐私权政策</a>
        <a href="#" target="_blank">知识产权</a>
        <span>1999-<i id="year"></i> ujiuye.com 版权所有</span>
        <script type="text/javascript">
            var day = new Date();
            var year = day.getFullYear();
            document.getElementById('year').innerHTML=year;
        </script>
    </div>
    <div class="footer_2 wrap">
        <a href="#" target="_blank"><img src="front/images/ft1.gif"></a>
        <a href="#" target="_blank"><img src="front/images/ft_01.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_03.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_05.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_07.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_09.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_11.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_13.jpg"></a>
        <a href="#" target="_blank"><img src="front/images/ft_15.jpg"></a>
    </div>
</body>
</html>
