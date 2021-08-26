<%@page import="com.iu.s1.bankbook.BankbookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook List Page BY JSTL</h1>
	
	<table>
		<tr>
			<th>일련번호</th><th>제품명</th><th>이자율</th><th>Status</th>
		</tr>
		<!-- 태그 >>  속성-->
		<c:forEach items="${list}" var="dto" varStatus="i">
		<tr>
			<td>${dto.bookNumber} </td>
			<td><a href="./bankbookSelect.do?bookNumber=${dto.bookNumber}" >${dto.bookName }</a></td>
			<td>${dto.bookRate }</td>
			<td>
				<p>현재 아이템 : ${i.current}</p>
				<p>인덱스 번호 : ${i.index}</p>
				<p>순서  번호 : ${i.count}</p>
				<p>반복문이 처음인가? : ${i.first}</p>
				<p>반복문이 마지막인가? : ${i.last}</p>
			</td>
		</tr>
		</c:forEach>
	
	</table>
	
	<div>
		<c:forEach begin="1" end="10" step="1" var="num" varStatus="i">
			<button>${num} : ${i.begin } : ${i.end } : ${i.step }</button>
		</c:forEach>
		
	</div>
	
	
	<a href="./bankbookInsert.do">WRITE</a>
	
	
</body>
</html>