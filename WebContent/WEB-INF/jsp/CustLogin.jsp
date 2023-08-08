<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer_portal</title>
</head>
<body>
<h1>Customer Login</h1>
<form action="CustomerLogin" method="post">
<table>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td></td><td><input type="submit" value="Login"/> <a href="CustReg">Sign Up</a></td></tr>
</table>
</form>
</body>
</html>