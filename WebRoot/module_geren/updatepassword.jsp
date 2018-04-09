<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">个人中心</a></li>
			<li><a href="#">修改密码</a></li>
		</ul>
	</div>

	<form action="UpdatePwd">
		<div class="formbody">
			<div class="formtitle">
				<span>修改密码</span>
			</div>
			<ul class="forminfo">
				<li><label>原始密码</label> <input id="oldpwd" onblur="checkold()"
					name="oldpwd" type="password" class="dfinput" /> <i id="m"></i></li>
				<li><label>新密码</label> <input id="npwd" name="npwd"
					readonly="readonly" type="password" class="dfinput" /></li>
				<li><label>确认密码</label> <input onblur="checksamepwd()"
					id="cnpwd" name="cnpwd" readonly="readonly" type="password"
					class="dfinput" /></li>
				<li><label>&nbsp;</label> <input id="sub" disabled="disabled"
					name="" type="button" class="btn" value="确认保存"
					onclick="updatepwd()" /></li>
			</ul>
		</div>
	</form>

	<script src="<%=basePath%>js/upload.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery.js"></script>
	<script>
		function checkold() {
			var oldpwd = $('#oldpwd').val();
			$.ajax({
				url : 'CheckOldPwd',
				data : 'oldpwd=' + oldpwd + '',
				success : function(data) {
					if (data == 'ok') {
						$('#m').html("<font color='green'>√</font>");
						$('#npwd').removeAttr('readonly');
						$('#cnpwd').removeAttr('readonly');
					} else {
						$('#m').html("<font color='red'>×</font>");
					}
	
				},
				error : function() {
					alert('请求失败');
				}
			});
		}
		function checksamepwd() {
			var npwd = $('#npwd').val();
			var cnpwd = $('#cnpwd').val();
			if (npwd == cnpwd) {
				$('#sub').removeAttr('disabled');
			} else {
				alert('两次密码不一致');
			}
		}
		function updatepwd() {
			var npwd = $('#npwd').val();
			$.ajax({
				url : 'UpdatePwd',
				data : 'npwd=' + npwd + '',
				success : function(m) {
					if (m == "ok") {
						parent.location.href = "front/login.jsp"
					} else {
						alert("密码更改失败")
					}
				}
			});
		}
	</script>
</body>
</html>
