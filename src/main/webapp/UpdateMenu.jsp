<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updatemenu" modelAttribute="edit">
		Item Id     : <form:input path="itemId"/><br><br>
		Name        : <form:input path="name"/><br><br>
		Description : <form:textarea path="description"/><br><br>
		Cost        : <form:input path="cost"/><br><br>
		Type        : <form:input path="type"/><br><br>
		Offer       : <form:input path="offer"/><br><br>
		image       : <form:input path="image"/><br><br>
		
		<form:button >Update Menu</form:button>
	</form:form>
</body>
</html>