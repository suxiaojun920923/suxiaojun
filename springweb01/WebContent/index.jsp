<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font>hello</font>
	<h1>index</h1>
	<c:forEach items="${sessionScope.userList}" var="user">
		<c:out value="${user.userId}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${user.userName}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${user.userPwd}"/><br/>
	</c:forEach>
</body>
</html>