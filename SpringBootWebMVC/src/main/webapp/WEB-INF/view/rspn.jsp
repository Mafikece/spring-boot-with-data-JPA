<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>User Details</h2>

	<table border="1" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Language</th>
		
		</tr>
<
		<!-- Sample user data - Replace this with actual data from your database -->
		<c:forEach var="us" items="${list}">
			<tr>
				<td>${us.getpId()}</td>
				<td>${us.getpName()}</td>
				<td>${us.getpLang()}</td>								
			</tr>
		</c:forEach>
		<!-- Add more rows for additional users -->

	</table>
</body>
</html>