<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function save(){
		location.href="http://localhost:8080/springmvc03/save";
	}
</script>
</head>
<body>
	<!-- restful 风格的URL -->
	<h1>index</h1>
	<c:forEach items="${sessionScope.bookList}" var="b">
		<c:out value="${b.bookId }"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${b.bookName }"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${b.bookAuthor }"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${b.bookPrice }"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:out value="${b.bookInfo }"/>
		<a href="deleteHandler/${b.bookId}">删除</a>
		<a href="loadUpdate/${b.bookId}">修改</a>
		<br/>
	</c:forEach>
	<div>
		<a href="loadAll?page=0">首页</a>
		<a href="loadAll?page=${sessionScope.page-1}">上一页</a>
		<a href="loadAll?page=${sessionScope.page+1}">下一页</a>
		<a href="loadAll?page=${sessionScope.maxPage-1}">末页</a>
	</div>
	<div>
		<button onclick="save()">增加</button>
	</div>
</body>
</html>