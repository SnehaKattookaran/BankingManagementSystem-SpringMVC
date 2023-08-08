<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<head>
<meta charset="ISO-8859-1">
<title>employee_registration</title>
</head>
<body>
<h1>Employee Registration</h1>
<form:form method="post" action="Register">  
<table >  
<tr><td>Employee Name : </td><td><form:input path="emp_name"  /></td></tr>  
<tr><td>Employee Place :</td><td><form:input path="emp_place" /></td></tr> 
<tr><td>Employee Designation :</td><td>
<form:select path="emp_designation" style="width:155px">
<form:option value="Clerk"/>
<form:option value="Officer"/>
<form:option value="Manager"/>
<form:option value="Sr.Manager"/>
</form:select>
</td></tr>
<tr><td>Employee Age :</td><td><form:input path="emp_age" /></td></tr>
<tr><td>Employee Qualification :</td><td><form:input path="emp_qualification" /></td></tr> 
<tr><td> </td><td><input type="submit" value="Register" /></td><td><input type="reset" value="Reset"/></td></tr>
<tr><td><input type="button" value="Back" onclick="history.back();"></td></tr>
</table>  
</form:form>  
</body>

