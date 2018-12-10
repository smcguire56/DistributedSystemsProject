<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/css/style.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers Page</title>
</head>
<body>
	<h1>Customers</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>Address</th>
			<th>Email</th>
		</tr>

		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.custFirstName}</td>
				<td>${order.custLastName}</td>
				<td>${order.custMobile}</td>
				<td>${order.custAddress}</td>
				<td>${order.custEmail}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
</body>
</html>