<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello_jsp</title>
</head>
<body>
	
	<!-- 
		这里是html注释
		这里讲一下，什么是jsp，jsp就是java平台的动态页面，为了开发web程序创造的
		期初java出现了一个叫做servlet 的东西，但是servlet开发前台页面很复杂，因此
		出现了jsp，jsp其实也是servlet，在每次被服务器加载的时候都要先转换一下，
		然后servlet在通过编程成class文件，
		这样子就可以被servlet容器去掉用了
		servlet就是java文件，哈哈
		jsp---转化翻译servlet---编译class---被jvm进行调用
		一般转化的文件在tomcat 的work目录下，自己可以看下jsp和servlet之间的区别
	 -->

	<% out.print("<h1>hello jsp</h1>"); %>
</body>
</html>