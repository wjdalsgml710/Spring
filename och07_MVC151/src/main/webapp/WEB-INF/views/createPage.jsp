<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
createPage.jsp <br />
<c:if test="${name != '' }">
	${name}
</c:if>
<c:if test="${id != '' }">
	${id}
</c:if>
<%
	String context = request.getContextPath();
%>
context  :  <%=context%>  <p> 
<form action="<%=context%>/student/create">
	<%-- 이름 : <input type="text" name="name" value="${student.name}"> <br /> --%>
	이름 : <input type="text" name="name" > <br />
	아이디 : <input type="text" name="id" > <br />
	<input type="submit" value="전송"> <br />
</form>

</body>
</html>