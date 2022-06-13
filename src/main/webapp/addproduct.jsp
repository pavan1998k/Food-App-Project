<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>${msg}</h1>
	
	<form:form action="" modelAttribute="product">
		ID : <form:input path="id" readonly="true"/><br><br>
		NAME : <form:input path="name" readonly="true"/><br><br>
		TYPE : <form:input path="type" readonly="true"/><br><br>
		COST : <form:input path="cost" readonly="true"/><br><br>
		<form:button>update</form:button>
	</form:form>

</body>
</html>