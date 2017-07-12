<%@page import="me.czd.util.PageBean"%>
<%@page import="me.czd.bean.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表分页显示</title>
</head>
<body>
	<%
		PageBean pg = (PageBean) session.getAttribute("pg");
		List<Admin> adminList = pg.getList();
	%>
	<table border="1">
		<%
			for (Admin admin : adminList) {
		%>
		<tr>
			<td><%=admin.getId()%></td>
			<td><%=admin.getUsername()%></td>
			<td><%=admin.getPassword()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="5">
				共&nbsp;<%=pg.getTotalPages()%>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
				当前第&nbsp;<%=pg.getPageNo()%>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="admin.html?action=pager&pageNo=<%=pg.getTopPageNo() %>">首页</a>
				<a href="admin.html?action=pager&pageNo=<%=pg.getPreviousPageNo() %>">上一页</a>
				<a href="admin.html?action=pager&pageNo=<%=pg.getNextPageNo() %>">下一页</a>
				<a href="admin.html?action=pager&pageNo=<%=pg.getBottomPageNo() %>">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>