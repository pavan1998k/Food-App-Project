<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>${msg}</h1>
	
	<h1>Admin Login</h1>
	
	<form action="login" >
		EMAIL : <input type = "text" name="email"><br><br>
		PASSWORD : <input type = "password" name="password"><br><br>
		<input type="submit" value="login">
	</form>

</body>
</html>