<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>U闲交易平台</title>
<link rel="stylesheet" type="text/css" href="front/css/index.css">
<link rel="icon" href="front/images/icon.ico">
<script type="text/javascript" src="front/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="front/js/jquery.SuperSlide.2.1.1.js"></script>
</head>
<body>
	<!-- header -->
	<div class="header">
		<div class="header_main wrap">
			<h1>
				<a href="#"><img src="front/images/logo-2.png"></a>
			</h1>
			<h2>让你的闲置游起来!</h2>
			<ul class="header_menu clearfix">
				<li><a href="#" class="active">首页</a></li>
				<li><a href="SelectPhone">手机二手</a></li>
				<li><a href="#">二手车估价</a></li>

				<li><a href="front/publish.jsp" target="_blank">发布闲置</a></li>
				<li class="header_wdxz"><a href="#">我是买家</a>
					<ul class="header_xz">
						<li><a href="#">等待发货：<span id='m1'></span></a></li>
						<li><a href="#">待收货：<span id='m2'></span></a></li>
						<li><a href="#">购买记录：<span id='m3'></span></a></li>
					</ul></li>
				<li class="header_wdxz"><a href="#">我是卖家</a>
					<ul class="header_xz">
						<li><a href="#">出售中：<span id='s1'></span></a></li>
						<li><a href="#">待发货：<span id='s2'></span></a></li>
						<li><a href="#">成交记录：<span id='s3'></span></a></li>
					</ul></li>
				<li class="header_mycenter"><a href="#">个人中心</a>
					<ul class="header_center">
						<li><a href="Perfect_front">完善个人信息</a></li>
						<li><a href="front/ChangePwd.jsp">修改密码</a></li>
						<li><a href="#">我的收藏</a></li>
					</ul></li>
				<li class="quit"><a href="ExitLogin_front">退出</a></li>
			</ul>
		</div>
	</div>

	<!-- section1 -->
	<div class="section1 wrap clearfix">
		<ul class="sec1_list">
			<li>
				<div class="shuma"></div> <a href="#" class="sec1_list_first">闲置数码</a>
				<a href="SelectLike?val=手机">手机</a> <a href="SelectLike?val=相机">相机</a> <a href="SelectLike?val=笔记本">笔记本</a>
			</li>
			<li>
				<div class="muying"></div> <a href="#" class="sec1_list_first">闲置母婴</a>
				<a href="SelectLike?val=童装">童装</a> <a href="SelectLike?val=宝宝用品">宝宝用品</a> <a href="SelectLike?val=玩具">玩具</a>
			</li>
			<li>
				<div class="riyong"></div> <a href="#" class="sec1_list_first">家居日用</a>
				<a href="SelectLike?val=家具">家具</a> <a href="SelectLike?val=家纺">家纺</a> <a href="SelectLike?val=日用">日用</a>
			</li>
			<li>
				<div class="jiadian"></div> <a href="#" class="sec1_list_first">影音家电</a>
				<a href="SelectLike?val=大家电">大家电</a> <a href="SelectLike?val=小家电">小家电</a> <a href="SelectLike?val=料理机">料理机</a>
			</li>
			<li>
				<div class="pieshi"></div> <a href="#" class="sec1_list_first">鞋服配饰</a>
				<a href="SelectLike?val=女鞋">女鞋</a> <a href="SelectLike?val=箱包">箱包</a> <a href="SelectLike?val=女装">女装</a> <a href="SelectLike?val=配饰">配饰</a>
			</li>
			<li>
				<div class="zhubao"></div> <a href="#" class="sec1_list_first">闲置数码</a>
				<a href="SelectLike?val=手机">手机</a> <a href="SelectLike?val=相机">相机</a> <a href="SelectLike?val=笔记本">笔记本</a>
			</li>

		</ul>

		<!-- 轮播图 -->
		<div class="lunbo">
			<div class="hd">
				<ul>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="lunbo_bd">
				<ul>
					<li><a href="#" target="_blank"><img
							src="front/images/lunbo.jpg" /></a></li>
					<li><a href="#" target="_blank"><img
							src="front/images/lunbo2.jpg" /></a></li>
				</ul>
			</div>
			<a class="prev" href="javascript:void(0)"></a> <a class="next"
				href="javascript:void(0)"></a>
		</div>
		<script type="text/javascript">
			jQuery(".lunbo").slide({
				mainCell : ".lunbo_bd ul",
				effect : "leftLoop",
				autoPlay : true
			});
		</script>
		<!-- 个人中心 -->
		<div class="personal">
			<div class="clearfix">
				<div class="personal_head">
					<img src="front/images/danhuang.png">
				</div>
				<p class="personal_hi">
					Hi，
					<c:if test="${not empty list}">买家</c:if>
					<c:if test="${empty list}">
						<a href="front/login.jsp" class="login">登录</a>吧！</c:if>
					<br>这里有更多你感兴趣的！
				</p>
			</div>
			<div class="clearfix">
				<a href="front/login.jsp" class="personal_login">登录</a> <a
					href="front/register.jsp" class="personal_register" target="_blank">注册</a>
			</div>
			<div class="clearfix fabuzhuanma">
				<a href="front/publish.jsp" target="_blank" class="fabuxianzhi"> <span
					class="fabuxianzhi_top">发布闲置</span> <span
					class="fabuxianzhi_bottom">闲置换钱 快速出手</span>
				</a> <a href="#" class="yijianzhuanma"> <span
					class="yijianzhuanma_top">一键转卖</span> <span
					class="yijianzhuanma_bottom">转卖已买到的宝贝</span>
				</a>
			</div>
		</div>
	</div>
	<!-- 猜你喜欢 -->
	<div class="wrap like">
		<ul class="tabhd clearfix">
			<li class="on">猜你喜欢</li>
			<li>全新闲置</li>
			<li>同城交易</li>
		</ul>
		<div class="tabbd">
			<div id="tblike" class="tabc clearfix" style="display:block;">
			</div>
			<div class="tabc clearfix">
				<a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad2.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad1.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad2.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad1.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a>
			</div>
			<div class="tabc clearfix">
				<a href="#" target="_blank"> <img src="front/images/ad2.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad2.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad1.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad3.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a> <a href="#" target="_blank"> <img src="front/images/ad2.jpg">
					<span>puma卫衣 男女 春秋款</span>
				</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".tabhd li").click(function() {
				$(".tabhd li").removeClass();
				$(this).addClass("on");
				$(".tabbd .tabc").css("display", "none");
				$(".tabbd .tabc").eq($(this).index()).css("display", "block");
	
			})
		})
	</script>

	<!-- section -->
	<div class="section wrap">
		<h2>
			<a href="#"> 数码控.3C也性感 </a>
		</h2>
		<div class="section_main clearfix">
			<div class="section_left fl">
				<div class="section_left_top">
					<a href="SelectLike?val=显示器"> 显示器 </a> <a href="SelectLike?val=内存"> 内存 </a> <a href="SelectLike?val=主板"> 主板 </a> <a
						href="SelectLike?val=硬盘"> 硬盘 </a> <a href="SelectLike?val=CPU"> CPU </a> <a href="SelectLike?val=显卡">
						显卡 </a> <a href="SelectLike?val=平板"> 平板 </a> <a href="SelectLike?val=无线路由器"> 无线路由器 </a> <a href="SelectLike?val=笔记本 ">
						笔记本 </a> <a href="SelectLike?val=无线鼠标"> 无线鼠标 </a> <a href="SelectLike?val=充电宝"> 充电宝 </a> <a href="SelectLike?val=移动硬盘">
						移动硬盘 </a> <a href="SelectLike?val=数据线"> 数据线 </a>
				</div>
				<div class="section_left_bottom">
					<a href="#"> <img src="front/images/sad.png">
					</a>
				</div>
			</div>
			<div class="section_middle fl">
				<ul class="clearfix" id="typeul">

				</ul>
			</div>
			<div class="section_right fl">
				<div class="section_right_part">
					<a href="#" class="section_right_part_img" target="_blank"> <img
						src="front/images/tututu.png">
					</a>
					<h4>戴上耳机，倾听</h4>
					<p>想要暂时告别千篇一律的生活，踏上没有目的的旅途？记得在行囊里捎上自己心爱的耳机和音乐，有了它们，一路上，不寂寞。</p>
				</div>
				<div class="section_right_part">
					<a href="#" class="section_right_part_img" target="_blank"> <img
						src="front/images/tututu2.png">
					</a>
					<h4>戴上耳机，倾听</h4>
					<p>想要暂时告别千篇一律的生活，踏上没有目的的旅途？记得在行囊里捎上自己心爱的耳机和音乐，有了它们，一路上，不寂寞。</p>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<ul class="wrap clearfix">
			<li><img src="front/images/footer_03.png" alt=""> <span>卖家实名认证</span>
			</li>
			<li><img src="front/images/footer_05.png" alt=""> <span>支付宝担保交易</span>
			</li>
			<li><img src="front/images/footer_07.png" alt=""> <span>专业团队支撑</span>
			</li>
			<li><img src="front/images/footer_09.jpg" alt=""> <span>官方微博</span>
			</li>
		</ul>
	</div>
	<!-- 底部一堆 -->
	<div class="footer_1 wrap">
		<a href="#" target="_blank">关于我们</a> <a href="#" target="_blank">合作伙伴</a>
		<a href="#" target="_blank">营销中心</a> <a href="#" target="_blank">廉正举报</a>
		<a href="#" target="_blank">联系客服</a> <a href="#" target="_blank">开放平台</a>
		<a href="#" target="_blank">诚征英才</a> <a href="#" target="_blank">联系我们</a>
		<a href="#" target="_blank">网站地图</a> <a href="#" target="_blank">法律声明及隐私权政策</a>
		<a href="#" target="_blank">知识产权</a> <span>1999-<i id="year"></i>
			ujiuye.com 版权所有
		</span>
		<script type="text/javascript">
			var day = new Date();
			var year = day.getFullYear();
			document.getElementById('year').innerHTML = year;
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

	<script type="text/javascript">
		$(function() {
			var uid = "${list.u_id}";
			if (uid == '') {
				$("#s1").html('0');
				$("#s2").html('0');
				$("#s3").html('0');
				$("#m1").html('0');
				$("#m2").html('0');
				$("#m3").html('0');
			} else {
				$.ajax({
					url : 'InitMaiData',
					dataType : 'json',
					data : 'uid=' + uid,
					success : function(data) {
						var chushouzhong = data[0].chushouzhong;
						var chengjiaojilu = data[0].chengjiaojilu;
						$('#s1').html(chushouzhong);
						$("#s2").html('0');
						$('#s3').html(chengjiaojilu);
						$('#m1').html(chushouzhong);
						$("#m2").html('0');
						$('#m3').html(chengjiaojilu);
					},
					error : function() {
						alert('请求失败')
					}
				});
			}
		});
	
		$(function() {
			$.ajax({
				url : "IndexServlet",
				type : 'post',
				dataType : "json",
				success : function(data) {
	
					var str = "";
					for (var i = 0; i < 7; i++) {
	
						str += "<a href='xiangqing?id=" + data[i].id + "' target='_blank'>" +
							"<img src='idleimg/" + data[i].idleimg + "' width='160px' height='160px'/>" +
							"<span>" + data[i].name + "</span>" +
							"</a>"
					}
					$('#tblike').html(str);
				},
				error : function() {
					alert('请求失败');
				},
			});
		});
	
		$(function() {
			$.ajax({
				url : "TypeServlet",
				type : 'post',
				dataType : 'json',
				success : function(data) {
					var str = "";
					for (var i = 0; i < 10; i++) {
						str += "<li><a href='xiangqing?id=" + data[i].id + "' target='_blank'> <img src='idleimg/" + data[i].idleimg + "' alt='' width='200px' height='200px'> <span " +
							"class='section_middle_name'>" + data[i].name + "</span> <span " +
							"class='section_middle_price'>¥<i>" + data[i].transfer_price + "</i></span>" +
							"</a></li>"
					}
					$('#typeul').html(str);
				},
				error : function() {
					alert('请求失败');
				},
			});
		});
		
		
	</script>
</body>
</html>