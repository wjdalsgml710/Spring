<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
</head>
<body>
<h2>직원 목록</h2><a href="writeForm">입력</a>
	<p>kkk 수정시 전달 Message : ${kkk} <p>
	<p>kkk 수정시 전달 Message : ${kk3} <p>
	
<c:set var="num" value="${pg.total-pg.start+1}"></c:set>

<table>
	<tr><th>번호</th><th>사번</th><th>이름</th><th>업무</th><th>급여</th></tr>
	<c:forEach var="emp" items="${listEmp }">
		<tr><td>${num }</td><td>${emp.empno}</td>
		<td><a href="detail?empno=${emp.empno}">${emp.ename}</a></td>
			<td>${emp.job}</td><td>${emp.sal}</td></tr>
		<c:set var="num" value="${num - 1 }"></c:set>		
	</c:forEach>
</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="list?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage}">
	<a href="list?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="list?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
<%-- Count : ${total} --%>
</body>
</html>