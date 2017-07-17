<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery 的ajax</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/ajax/jquery.js"></script>
</head>
<script type="text/javascript">
	function sayHello(){
	var username = $("#username").val();
	var password = $("#password").val();
	$.post("<%=request.getContextPath()%>/ajax", {
			"username" : username,
			"password" : password
		}, function(data) {
			alert(data);
		});
	}
</script>
<body>
	<form action="" method="post">
		用户名：<input type="text" name="username" id="username" /> 
		密码：<input type="text" name="password" id="password" /> 
		<input type="button" value="get" onclick="sayHello();">
	</form>
</body>
</html>