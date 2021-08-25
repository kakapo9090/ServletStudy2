<%@page import="com.iu.s1.bankbook.BankbookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook List Page</h1>
	
	<table>
		<tr>
			<th>일련번호</th><th>제품명</th><th>이자율</th>
		</tr>
	
	<%
		Object obj = request.getAttribute("list");
		ArrayList<BankbookDTO> ar = (ArrayList<BankbookDTO>)obj;
		for(BankbookDTO dto:ar){
	%>
		<tr>
			<td><%=dto.getBookNumber() %></td>
			<td><a href="./bankbookSelect.do?bookNumber=<%= dto.getBookNumber() %>"><%= dto.getBookName() %></a></td>
			<td><%=dto.getBookRate() %></td>
		</tr>
	<%}%>
	
	</table>
	
	<a href="./bankbookInsert.do">WRITE</a>
	
	
</body>
</html>