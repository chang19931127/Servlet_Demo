<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp_行为，动作</title>
</head>
<body>

	<%--
		<jsp:forward> 用来转移用户的请求，地址栏不会变，就是请求转发
		<jsp:include> 动态包含页面
		<jsp:useBean> 使一个javaBean组件在该页中可用
		<jsp:setProperty> 设置一个或多个bean属性的值
		<jsp:getProperty> 访问一个bean的属性
		等等 十几个
		
		这里有一个逻辑，通过action.jsp请求转发到input.jsp 并且传递一个param
		然后在input.jsp中输入参数，传递到jspuserbean.jsp中被use
	 --%>
	<jsp:forward page="input.jsp">
		<jsp:param value="value" name="key"/>
	</jsp:forward>
	<%
		out.print("这里并不会执行");
	%>
</body>
</html>