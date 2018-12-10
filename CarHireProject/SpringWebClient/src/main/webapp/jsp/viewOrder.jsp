<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/css/style.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders Page</title>
</head>
<body>
	<h1>Orders</h1>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Date</th>
			<th>Car</th>
			<th>Customer ID</th>
		</tr>

		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.orderID}</td>
				<td>${order.date}</td>
				<td>${order.car}</td>
				<td>${order.cust}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
</body>
</html>