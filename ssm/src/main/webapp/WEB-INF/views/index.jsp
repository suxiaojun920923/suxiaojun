<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<div style="margin: auto; width: 600px; font-size: 12px; margin-top: 50px;">
		<table cellspacing="10">
			<tr align="center">
				<td>编号</td>
				<td>名称</td>
				<td>作者</td>
				<td>价格</td>
				<td>信息</td>
			</tr>
			<c:forEach items="${requestScope.bookList}" var="b">
				<tr align="center">
					<td>${b.bookId }</td>
					<td>${b.bookName }</td>
					<td>${b.bookAuthor }</td>
					<td>${b.bookPrice }</td>
					<td>${b.bookInfo }</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
</body>
</html>