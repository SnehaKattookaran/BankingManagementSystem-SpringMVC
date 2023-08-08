<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>account_details</title>
</head>
<h1>My Account Details</h1>
<body>
<c:forEach var="emp" items="${mylist1}">
<table>
<tr><td>Name:</td><td>${emp.cust_name}</td></tr>
<tr><td>Place:</td><td>${emp.cust_place}</td></tr>
<tr><td>Mobile Number:</td><td>${emp.cust_mobileno}</td></tr>
<tr><td>Account Type:</td><td>${emp.acc_type}</td></tr>
<tr><td>Email:</td><td>${emp.email}</td></tr>
<tr><td>Password:</td><td>${emp.password}</td></tr>
<tr><td>Balance Amount:</td><td>${emp.bal_amnt}</td></tr>
<tr><td>Account Number:</td><td>${emp.acc_no}</td></tr>
<tr><td><input type="button" value="Back" onclick="history.back()"></td></tr>
</table>
</c:forEach>
</body>
</html>
