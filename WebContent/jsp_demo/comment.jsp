<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp_comment</title>
</head>
<body>

	<!-- 
		jsp注释，其实就是java嵌入到jsp中的注释，
		html源代码可以看到html注释，但是不能看到jsp注释
	 -->


	<!-- 这里是html注释，在html查看源代码是可以看到的 -->

	<!-- 这个页面加载于 <%= (new Date()).toString() %> -->

	<%-- 
		这里是jsp注释，jsp注释在html源代码是看不到的
	 --%>
	 
	 这个页面演示的是 HTML注释和JSP注释
</body>
</html>