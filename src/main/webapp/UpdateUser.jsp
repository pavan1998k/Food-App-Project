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
	<form:form action="updateUser" modelAttribute="edit">
		ID    : <form:input path="id" readonly="true"/><br><br>
		Name  : <form:input path="name"/><br><br>
		Phone : <form:input path="phone"/><br><br>
		Email : <form:input path="email"/><br><br>
		Password : <form:password path="password"/><br><br>
		<form:button >Update User</form:button>
	</form:form>
</body>
</html>