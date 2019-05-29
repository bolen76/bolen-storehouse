<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/upload"
	method="post"	enctype="multipart/form-data">
		用户名：<input type="text" name="你的名字" /> 
		文本文件：<input type="file" name="file01" /> 
		非文本文件：<input type="file" name="file02" />
			<input type="submit" value="提交">
	</form>
</body>
</html>