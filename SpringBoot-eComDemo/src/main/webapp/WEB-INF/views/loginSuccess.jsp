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
<h1 align="center">Login Successful</h1>
<h1 align="right">${m1.getUserName()}|
<a href="Logout">Logout </a>
</h1><hr>

<h2>Item Details</h2>

	<table border="1" width="70%" cellpadding="2">
		<tr>
			<th>Item Id</th>
			<th>Item Name</th>
			<th>Item Price</th>
			<th></th>
					
		</tr>
<
		<!-- Sample user data - Replace this with actual data from your database -->
		<c:forEach var="us" items="${item}">
			<tr>
				<td>${us.getItemId()}</td>
				<td>${us.getName()}</td>
				<td>${us.getPrice()}</td>
				<td><a href="addToCart/${us.getItemId()}">Add to Cart</a></td>
													
			</tr>
		</c:forEach>
		<!-- Add more rows for additional users -->

	</table>

</body>
</html>