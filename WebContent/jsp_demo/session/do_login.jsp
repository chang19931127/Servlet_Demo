<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录操作</title>
</head>
<body>
	<%
		/*
			session 直接通过对象的 get set 就可以了  因为存储方式就是key value
		*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && password != null){
			if("star".equals(username)&&"star".equals(password)){
				//session 存储
				session.setAttribute("u", username);
				session.setAttribute("flag", "ok");
				//重定向
				response.sendRedirect("index.jsp");
			}else{
				out.print("用户名或者密码不正确，请重新输入！");
			}
		}else{
			out.print("用户名密码不能为空！");
		}
	%>
</body>
</html>