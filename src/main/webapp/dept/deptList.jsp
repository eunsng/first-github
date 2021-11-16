<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border ="1">
	<tr>
		<th>번호</th>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>부서위치</th>
		<th>삭제</th>
	</tr>
	<!-- 목록출력은 JSTL 문법으로 작성해야함 -->
	<c:forEach var="result" items="${list}" varStatus="status">
		<tr align="center"> 
			<td> </td>
			<td><a href ="deptModify.do?deptno=${result.deptno}"> ${result.deptno} </a></td>
			<td>${result.dname}  </td>
			<td>${result.loc}  </td>
			<td><a href ="deptDelete.do?deptno=${result.deptno}"> Del </a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>