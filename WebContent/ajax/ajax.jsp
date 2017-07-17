<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax请求</title>
</head>
<script type="text/javascript">
	var xmlHttp;
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	function createQueryString() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		console.log(username+password);
		var queryString = "username=" + username + "&password=" + password;
		return queryString;
	}
	function sendGet(){
		createXMLHttpRequest();
		var queryString = "<%= request.getContextPath()%>/ajax?";
		queryString = queryString + createQueryString()+"&timeStamp="+new Date().getTime();
		xmlHttp.open("GET",queryString,true);
		xmlHttp.send(null);
	}
	function sendPost(){
		createXMLHttpRequest();
		var url = "<%= request.getContextPath()%>/ajax? timeStamp =" + new Date().getTime();
		var queryString = createQueryString();
		xmlHttp.open("POST",url,true);
		xmlHttp.onreadystatechange=handleStateChange();
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttp.send(queryString);
	}
	function handleStateChange(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){
				parseResults();
			}
		}
	}
	function parseResults(){
		alert(xmlHttp.responseText);
	}
</script>
<body>
	<form action="" method="post">
		用户名：<input type="text" name="username" id="username"/>
		密码：<input type="text" name="password" id="password"/>
		<input type="button" value="get" onclick="sendGet();">
		<input type="button" value="post" onclick="sendPost();">
	</form>
</body>
</html>