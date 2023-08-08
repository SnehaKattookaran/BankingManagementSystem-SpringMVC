<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<head>
<meta charset="ISO-8859-1">
<title>customer_signup</title>
</head>
<body>
<h1>Sign Up</h1>
<form:form method="post" action="SignUp">  
<table >  
<tr><td>Name : </td><td><form:input type="text" path="cust_name"  /></td></tr>  
<tr><td>Place :</td><td><form:input type="text" path="cust_place" /></td></tr> 
<tr><td>Mobile Number :</td><td><form:input type="text" path="cust_mobileno" /></td></tr>
<tr><td>Account Type :</td><td><form:input type="radio" path="acc_type" checked value="Savings"/>Savings<form:input type="radio" path="acc_type" value="Current"/>Current/></td></tr>
<tr><td>Username :</td><td><form:input type="email" path="email" /></td></tr> 
<tr><td>Password :</td><td><form:input type="password" path="password" /></td></tr> 
<tr><td> </td><td><input type="submit" value="SignUp" /></td></tr>  
</table>  
</form:form>  
</body>

