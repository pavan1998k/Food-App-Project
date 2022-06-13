<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Menu</h1>
	<table border="3" cellpadding="20" align="center">
		<tr>
			<th>Item Id</th>
			<th>name</th>
			<th>description</th>
			<th>Cost</th>
			<th>Type</th>
			<th>Offer</th>
			<th>Image</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="view" items="${viewmenu}">
			<tr>
				<td>${view.getItemId()}</td>
				<td>${view.getName()}</td>
				<td>${view.getDescription()}</td>
				<td>${view.getCost()}</td>
				<td>${view.getType()}</td>
				<td>${view.getOffer()}</td>
				<td>${view.getImage()}</td>
				<td><a href="editmenu?id=${view.getItemId()}">Edit</a></td>
				<td><a href="deletemenu?id=${view.getItemId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>