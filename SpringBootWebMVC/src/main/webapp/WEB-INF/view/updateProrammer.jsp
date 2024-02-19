<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateProgrammer" method="post">

		<h3>Enter Programmer's ID</h3>
		<input type="text" name="pId"></input>
		
		<h3>Enter Programmer's Name</h3>
		<input type="text" name="pName"></input>

		<h3>Enter Programmer's Language</h3>
		<input type="text" name="pLang"></input>

		<button type="submit">Update Programmer</button>
	</form>
</body>
</html>