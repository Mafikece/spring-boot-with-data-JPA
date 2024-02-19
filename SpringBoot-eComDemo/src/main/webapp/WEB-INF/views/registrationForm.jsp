<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Here</h1>
	<form action="userRegistration">

		<h3>
			Enter User Name <input type="text" name="userName"></input>
		</h3>
		<h3>
			Enter Password <input type="text" name="password"></input>
		</h3>
		<h3>
			Enter Mobile <input type="text" name="mobile"></input>
		</h3>
		<h3>
			Enter Address <input type="text" name="address"></input><br>
		</h3>
		<button type="submit">Register</button>
		<a href="viewUsers">View All Users</a>
	</form>

</body>
</html>