<%@page import="me.czd.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
	<%
		Admin admin = (Admin) session.getAttribute("admin");
	%>
	<form action="admin?action=update" method="post">
		<input type="hidden" name="id" value="<%=admin.getId() %>"/><br/>
		<input type="text" name="username" value="<%=admin.getUsername() %>"/><br/>
		<input type="text" name="password" value="<%=admin.getPassword() %>"/><br/>
		<input type="submit" value="更新"/>
	</form>
</body>
</html>