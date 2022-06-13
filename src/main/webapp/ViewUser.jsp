<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<h1 align="center">User Details</h1>
	<table border="3" cellpadding="20" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="views" items="${view}">
			<tr>
				<td>${views.getId()}</td>
				<td>${views.getName()}</td>
				<td>${views.getPhone()}</td>
				<td>${views.getEmail()}</td>
				<td>${views.getPassword()}</td>
				<td><a href="editUser?id=${views.getId()}">Edit</a></td>
				<td><a href="deleteUser?id=${views.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>