<%@page import="com.iu.s1.bankbook.BankbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Select Page</h1>

<!-- 주석 -->	
	<h3>num  : ${dto.bookNumber} </h3>
	<h3>Name : ${requestScope.dto.bookName} </h3>
	<h3>count: ${requestScope.count } </h3>
	<h3>count: ${name } </h3>
	<h3>SE : ${sessionScope.se } </h3>
	<h3>SE : ${se } </h3>
</body>
</html>