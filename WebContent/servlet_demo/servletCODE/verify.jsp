<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证结果</title>
</head>
<body>
	<%
		String scode = (String) session.getAttribute("scode");
		String ucode = request.getParameter("ucode");
		if (scode.equals(ucode))
			out.print("输入的验证码正确");
		else
			out.print("输入的验证码错误");
	%>

</body>
</html>