<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration<String> es=request.getHeaderNames();
		while(es.hasMoreElements()){
			String headerKey=es.nextElement();
			out.println(headerKey+"--"+request.getHeader(headerKey)+"<br/>");
		}
	%>
	<form action="aaa/nihao.hehe" method="get">
		账号:<input type="text" name="uname"/><br/>
		密码:<input type="password" name="upwd"/><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>