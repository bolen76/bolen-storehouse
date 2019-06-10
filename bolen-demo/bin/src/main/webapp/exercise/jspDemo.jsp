<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/index.jsp">

		<input type="submit" value="提交" />
	</form>
	<br/>
	<%
		List<String> names = new ArrayList<String>();
		names.add("zhangSan");
		names.add("liSi");
		names.add("wangWu");
		names.add("zhaoLiu");
		pageContext.setAttribute("ns", names);
	%>
	<c:forEach var="item" items="${ns }" varStatus="vs">
		<c:if test="${vs.first }">第一行：</c:if>
		<c:if test="${vs.last }">最后一行：</c:if>
		<c:out value="第${vs.count }行: " />
		<c:out value="[${vs.index }]: " />
		<c:out value="name: ${vs.current }" />
		<br />
	</c:forEach>
	<c:out value="哈哈"></c:out>
${fn:length(ns) }
</body>
</html>