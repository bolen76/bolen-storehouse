<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
</head>
<body>
	
	<br/>
	<form action="/bolen-demo/request;jsessionid=<%=session.getId() %>" method="post">
		关键字:<input type="text" name="keywords"/>
			<input type="text" name="en">
		<input type="submit" value="提交"/>
	</form>
	<br/>
	attr:${hello }
	<br/>
	id:${id }
</body>
</html>