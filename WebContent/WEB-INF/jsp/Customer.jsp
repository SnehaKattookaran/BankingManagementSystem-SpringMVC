<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer_account</title>
</head>
<%@page import="dao.UserDao,bean.UserBean"%>
<c:forEach var="emp" items="${mylist}">
<h1>Welcome ${emp.custname} !</h1>
<body>
<a href="AcctDetails?number=${emp.accno}" onclick="return valid()" >View My Account Details</a><br/>
<form action="CashTrans?balance=${emp.balamnt}&?number=${emp.accno}" method="post">
<table> 
<tr></tr>
<tr><td>Enter Deposit Amount:</td><td><input type="text" name="deposit"/></td><td><input type="submit" value="DEPOSIT" name="deposit"/></td></tr>  
<tr></tr>
<tr><td>Enter Withdraw Amount:</td><td><input type="text" name="withdrawal"/></td><td><input type="submit" value="WITHDRAW" name="withdrawal"/></td></tr>
</table>
</form>
<br/><a href="Logout"><button>Logout</button></a><br/>
</body>
</c:forEach>
</html>