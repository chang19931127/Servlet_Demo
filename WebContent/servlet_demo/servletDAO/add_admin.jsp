<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/adminDao?action=add" method="post">
		<input type="text" name="username"/><br/>
		<input type="text" name="password"/><br/>
		<input type="submit" value="添加"/><br/>
	</form>
</body>
</html>