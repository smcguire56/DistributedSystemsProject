<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Order</title>
</head>
<body>
	<h1>Update Order</h1>

	<form:form modelAttribute="order">
		<table>
			<!-- the path has to be the same name as in the model -->
			<tr>
				<td>Select orders:</td>
				<td><form:select path="OrderID" items="${ordersList}" /></td>
			</tr>
			<tr>
				<td>Update Customers:</td>
				<td><form:select path="customer.custID" items="${customerList}" /></td>
			</tr>
			<tr>
				<td>Update Cars:</td>
				<td><form:select path="car.carID" items="${carList}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/">Home</a>
</body>
</html>