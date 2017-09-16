<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="../updateHandler" method="post" commandName="book">
		<form:hidden path="bookId"/>
		作者:<form:input path="bookAuthor"/><br/>
		价格:<form:input path="bookPrice"/><br/>
		信息:<form:input path="bookInfo"/><br/>
		<input type="submit" value="提交"/>
	</form:form>
</body>
</html>