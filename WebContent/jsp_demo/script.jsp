<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp_脚本</title>
</head>
<body>

	<!-- 
		jsp脚本元素包含
			：表达式
			：声明
			：脚本
	 -->

	<p>小脚本</p>
	<pre>
	&lt%
		//这里就可以直接写 java代码
		int sum = 0;
		//循环100之和
		for (int i = 0; i <= 100; i++)
			sum += i;
		//这里输出到html页面
		out.print(sum);
	%&gt
	</pre>
	<%
		//这里就可以直接写 java代码
		int sum = 0;
		//循环100之和
		for (int i = 0; i <= 100; i++)
			sum += i;

		//这里输出到html页面
		out.print(sum);
	%>

	<p>表达式</p>
	<pre>
	&lt%
		int a, b, c;
		a = 10;
		b = 15;
		c = a + b;
	%&gt
	
	&lt%= c %&gt
	</pre>
	<%
		int a, b, c;
		a = 10;
		b = 15;
		c = a + b;
	%>
	<!-- 这里 类似于out.print(sum) -->
	输出:a+b=<%=c%>

	<p>声明</p>
	<!-- 
		这里要解释下什么是声明
		，我们要对当前jsp页面声明变量，方法，类，等等，就是全局的，
		就要使用声明表达式
	 -->

	<%!int i = 0;%>
	<%
		int j = 0;
	%>
	
	i是使用声明表达式声明的，这里i会伴随页面的持续访问，而增加<br>
	i的值：<%= ++i %><br>
	j的值：<%= ++j %>
</body>
</html>