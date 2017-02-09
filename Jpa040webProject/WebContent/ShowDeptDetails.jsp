<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Department Details</title>
	</head>
	<body>
		<table border = '1'>

<tr>
	<th>Department Id</th>
	<th>Department Name</th>
	</tr>
	
	<tr>
		<td>${ requestScope.deptDetails.deptNo }</td>
		<td>${deptDetails.deptNm }</td>
	</tr>
	<tr>
	<th>Employee Number</th>
	<th>Name</th>
	<th>Salary</th>
	</tr>
	<c:forEach var="emp" items="${requestScope.deptDetails.empList }">
	<tr>
		<td>${emp.empNo }</td>
		<td>${emp.empNm }</td>
		<td>${emp.empSal }</td>
	</tr>
	</c:forEach> 
		
	</table>
		
	</body>
</html>