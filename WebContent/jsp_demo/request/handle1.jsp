<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理中文</title>
</head>
<body>
	处理中文
	内置对象之request对象
	<br />
	<%
		//设置请求编码方式
		request.setCharacterEncoding("UTF-8");
		String str = new String(request.getParameter("attr"));
	%>
	<%=str%>
</body>
</html>