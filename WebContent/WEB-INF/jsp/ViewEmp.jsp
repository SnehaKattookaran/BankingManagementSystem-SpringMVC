<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>employee_details</title>
</head>
<body>
    <h1>Employee Details</h1>
	<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Place</th><th>Designation</th><th>Age</th><th>Qualification</th><th>Salary</th><th>Basic Pay</th><th>DA</th><th>HRA</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.emp_id}</td>
    <td>${emp.emp_name}</td>
    <td>${emp.emp_place}</td>
    <td>${emp.emp_designation}</td>
    <td>${emp.emp_age}</td>
    <td>${emp.emp_qualification}</td>
    <td>${emp.emp_salary}</td>
    <td>${emp.basic_pay}</td>
    <td>${emp.DA}</td>
    <td>${emp.HRA}</td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <input type="button" value="Back" onclick="history.back();">
</body>
</html>