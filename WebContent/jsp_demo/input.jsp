<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log("这里是通过action.jsp请求转发过来的");
	console.info("这里是通过action.jsp请求转发过来的");
	console.debug("这里是通过action.jsp请求转发过来的");
	console.warn("这里是通过action.jsp请求转发过来的");
	console.error("这里是通过action.jsp请求转发过来的");
</script>
</head>
<body>
	<pre>
		这里是被请求转发过来的，这里留着到时候准备进行 bootstrap框架的学习
	</pre>

	jsp include动作：
	<jsp:include page="date.jsp"></jsp:include>
	jsp useBean动作：

	<form action="jspusebean.jsp" method="post">
		<input type="text" name="username" /> <input type="text"
			name="password" /> <input type="submit" value="提交" />
	</form>

	通过页面转发过来的参数
	<%
		out.print(request.getParameter("key"));
	%>

</body>
</html>