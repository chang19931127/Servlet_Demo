<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理请求</title>
</head>
<body>
	处理请求
	内置对象之response对象
	<br />
	<%
		String opt = request.getParameter("opt");
		if("baidu".equals(opt)){
			response.sendRedirect("http://www.baidu.com");
		}else if("wangyi".equals(opt)){
			response.sendRedirect("//http://music.163.com/");
		}else{
			response.sendRedirect("http://sina.com.cn");
		}
	%>
</body>
</html>