<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<%
		String flag = (String)session.getAttribute("flag");
		if(flag != null){
			String name = (String) session.getAttribute("u");
			out.print("欢迎"+name+"的到来");
		}else{
			out.print("你还没有登录");
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>