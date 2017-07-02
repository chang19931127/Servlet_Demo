<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp_指令</title>
</head>
<body>

	<!-- 
		什么是JSP 指令
		page指令    		&lt%@ page %&gt
			指示当前页面的一些属性  jsp页面头就会有
		include指令		&lt%@ include %&gt
			静态包含，直接将页面插入到当前页面
		taglib指令		&lt%@ taglib %&gt
			标签库引入
	 -->

	通过include指令引入的页面
	<%@ include file="date.jsp"%>

	<%
		out.print("<h1>hello jsp</h1>");
	%>

	<c:out value="hello jstl"></c:out>
</body>
</html>