<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理</title>
</head>
<body>
	<%
		String name = request.getParameter("username");
		//Cookie 只能new
		Cookie cookie = new Cookie("user",name);
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		response.sendRedirect("readcookies.jsp");
	%>
</body>
</html>