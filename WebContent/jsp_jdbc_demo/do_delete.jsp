<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除</title>
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
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "delete from admin where id =" + id;
		Statement stmt = conn.createStatement();
		int res = stmt.executeUpdate(sql);
		if (res < 0) {
			out.print("删除失败");
		} else {
			response.sendRedirect("do_query.jsp");
		}
	%>
</body>
</html>