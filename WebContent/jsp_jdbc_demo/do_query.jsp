<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的记录</title>
</head>
<body>
	<%		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbUser = "root";
		String dbPass = "root";
		//这里是桥接模式，都是用的是 jdk 提供的接口对应的实现类都是mysql的
		Connection conn = null;
		//加载驱动
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		String sql = "select * from admin order by id";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
	%>
	<table border="1">
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("username")%></td>
			<td><%=rs.getString("password")%></td>
			<td><a href="do_delete.jsp?id=<%=rs.getInt("id")%>">删除</a></td>
			<td><a href="do_edit.jsp?id=<%=rs.getInt("id")%>">编辑</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="addAdmin.jsp">添加用户</a><br/>
	<a href="pager.jsp">分页页表</a>
</body>
</html>