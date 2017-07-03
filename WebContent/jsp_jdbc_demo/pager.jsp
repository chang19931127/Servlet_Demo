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
<title>分页查询</title>
</head>
<body>
	<%
		//分页
		int pageCount = 0;//总页面数
		int pageSize = 5;//每页显示记录数
		int currentPage = 1;//当前页面
		int totalCount = 0;//当前记录数	
		//分页

		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbUser = "root";
		String dbPass = "root";
		//这里是桥接模式，都是用的是 jdk 提供的接口对应的实现类都是mysql的
		Connection conn = null;
		//加载驱动
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		//String sql = "select * from admin order by id";
		String sql = "select count(*) as t from admin";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);

		//表中总记录
		if (rs.next())
			totalCount = rs.getInt("t");
		if (totalCount / pageSize == 0)
			pageCount = totalCount / pageSize;
		else
			pageCount = totalCount / pageSize + 1;

		//获得分页条上的当前页码
		String pStr = request.getParameter("p");
		if (pStr == null)
			pStr = "1";
		currentPage = Integer.parseInt(pStr);
		//如果当前页大于总的页面数，当前页赋值为总页面数
		if (currentPage > pageCount)
			currentPage = pageCount;
		//如果当前页面小于0，重置为第一页
		if (currentPage < 0)
			currentPage = 1;
		//分页查询 limit           起始值，多少个
		sql = "select * from admin limit " + (currentPage - 1) * pageSize + "," + pageSize;
		rs = stat.executeQuery(sql);
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
	<%
		//分条页
		if(currentPage >1){
	%>
	<a href="pager.jsp?p=1">第一页</a>
	<a href="pager.jsp?p=<%=currentPage - 1 %>">上一页</a>
	<%
		}
	%>
	<%
		if(currentPage <= pageCount){
	%>
	<a href="pager.jsp?p=<%=currentPage+1 %>">下一页</a>
	<a href="pager.jsp?p=<%=pageCount %>">最后一页</a>	
	<%
		}
	%>
	<br><a href="addAdmin.jsp">添加用户</a>
</body>
</html>