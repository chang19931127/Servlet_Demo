<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="admin" scope="page" class="bean.Admin"></jsp:useBean>

<!-- 将我们的值，直接传入到这里了，全部属性 -->
<jsp:setProperty property="*" name="admin"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usebean jsp</title>
</head>
<body>
	你输入的用户名和密码为<br/>
	用户名：<jsp:getProperty property="username" name="admin"/>
	密码：<jsp:getProperty property="password" name="admin"/>
	
	<jsp:attribute name=""></jsp:attribute>
</body>
</html>