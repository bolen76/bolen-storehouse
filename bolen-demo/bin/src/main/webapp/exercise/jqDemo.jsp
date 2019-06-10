<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome</title>
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>

</head>
<body>
	<input type="button" id="hel" value="提交" />
	<div>
		hello
		<div />
</body>
<script type="application/javascript">

	$("#hel").click(function(){
		alert("123");
	var args={name:"bolen",age:31};
		$.post("${pageContext.request.contextPath}/jqServlet",args,function(data){
			alert(data);
			var dat=eval("(" + data + ")");
			alert(dat.back);
			$("div").text(dat.back);
		});
		
		
	}); 
	
	/*  $("#hel").click(function(){
	  	 $("div").text("hello java......");
	  }); */


</script>
</html>