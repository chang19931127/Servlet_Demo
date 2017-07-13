<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
	文件一	：<input name = "x" size="40" type="file"><br/>
	文件二	：<input name = "y" size="40" type="file"><br/>
	文件三	：<input name = "z" size="40" type="file"><br/>
	<input name="upload" type="submit" value="开始上传">
	</form>
</body>
</html>