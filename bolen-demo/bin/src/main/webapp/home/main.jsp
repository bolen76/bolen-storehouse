<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>main</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
</style>
</head>



<frameset rows="100,*" framespacing="10" border="10" frameborder="10">
	<frame src="${pageContext.request.contextPath }/home/top2.jsp"
		name="top2" scrolling="no" />
	<frameset cols="200,*" id="resize">
		<frame name="menu"
			src="${pageContext.request.contextPath }/home/left.jsp"
			scrolling="yes" />
		<frame name="body"
			src="${pageContext.request.contextPath }/home/body.jsp"
			scrolling="yes" />
	</frameset>

</frameset>


<body>


</body>

</html>
