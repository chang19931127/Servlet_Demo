<%@page import="me.czd.bean.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<%
		List<Admin> adminList = (ArrayList<Admin>) session.getAttribute("adminList");
	%>
	<table border="1">
		<%
			for (Admin admin : adminList) {
		%>
		<tr>
			<td><%=admin.getId()%></td>
			<td><%=admin.getUsername()%></td>
			<td><%=admin.getPassword()%></td>
			<td><a href="admin?action=del&id=<%=admin.getId()%>">删除</a></td>
			<td><a href="admin?action=edit&id=<%=admin.getId()%>">编辑</a></td>
		</tr>
		<%
			}
		%>
	</table><br/>
	<a href="servlet_demo/servletDAO/add_admin.jsp">添加</a>
</body>
</html>