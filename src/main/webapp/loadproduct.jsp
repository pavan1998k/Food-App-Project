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
	
	<form:form action="saveproduct" modelAttribute="product">
		NAME : <form:input path="name"/><br><br>
		TYPE : <form:input path="type"/><br><br>
		COST : <form:input path="cost"/><br><br>
		<form:button>save</form:button>
	</form:form>

</body>
</html>