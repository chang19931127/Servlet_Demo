<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp九大内置对象</title>
</head>
<body>
	这里是out对象就是输出流<br>
	<%
		out.print("输出字符数组<br/>");
		out.print(new char[]{'c','h','a','r'});
		out.print("输出双精度数<br/>");
		out.print(12.4);
		out.print("输出单精度数<br/>");
		out.print(12.4F);
	%>
</body>
</html>