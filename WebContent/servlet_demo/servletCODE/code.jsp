<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证页面</title>
</head>
<body>
	<script type="text/javascript">
		function fresh() {
			var timestamp = new Date();
			document.getElementById("code").src = "<%=request.getContextPath() %>/code?time=" + timestamp;
		}
	</script>
	<form action="verify.jsp" method="post">
		<img alt="验证码" src="code" id="code"><a href="#" onclick="fresh()">看不清</a>
		<input type="text" name="ucode"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>