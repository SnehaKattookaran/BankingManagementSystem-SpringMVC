<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer_details</title>
</head>
<body>
    <h1>Customers Details</h1>
	<table border="2" width="70%" cellpadding="2">
    <tr><th>Account Number</th><th>Name</th><th>Place</th><th>Mobile Number</th><th>Account Type</th><th>Email</th><th>Password</th><th>Balance Amount</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.acc_no}</td>
    <td>${emp.cust_name}</td>
    <td>${emp.cust_place}</td>
    <td>${emp.cust_mobileno}</td>
    <td>${emp.acc_type}</td>
    <td>${emp.email}</td>
    <td>${emp.password}</td>
    <td>${emp.bal_amnt}</td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <input type="button" value="Back" onclick="history.back();">
</body>
</html>