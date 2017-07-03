<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库的连接</title>
</head>
<body>
	<%
		String dbDriver = "com.mysql.jdbc.Driver";	
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbUser ="root";
		String dbPass ="root";
		//这里是桥接模式，都是用的是 jdk 提供的接口对应的实现类都是mysql的
		Connection conn = null;
		//加载驱动
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		if(conn != null){
			out.print("数据库连接成功！");
		}else{
			out.print("数据库连接失败！");
		}
	%>
</body>
</html>