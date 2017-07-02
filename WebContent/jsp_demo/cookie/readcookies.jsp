<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取cookie</title>
</head>
<body>
	<%
		Cookie c = null;
		String name = null;
		//只能这么获取
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("user")){
					name=cookie.getValue();
				}
			}
			if(name != null){
				out.print(name+"有效期10 秒");
			}else{
				out.print("cookie 已经失效");
			}
		}
	%>
</body>
</html>