<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome</title>
</head>
<body>
	index......
	<br /> ${hello }
	<br />无可奈何花落去，似曾相识燕归来
	<br />
	<form
		action="${pageContext.request.contextPath }/book/modifyBook.action" method="post">
		书 名:<input type="text" name="name" /><br /> 
		价格:<input type="text"	name="price" /><br /> 
		<input type="submit" value="提交" />
	</form>


</body>
</html>