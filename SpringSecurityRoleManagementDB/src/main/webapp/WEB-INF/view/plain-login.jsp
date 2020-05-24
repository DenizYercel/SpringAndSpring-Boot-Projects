<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Form</title>
<style>
.failed{color:red;}
</style>
</head>
<body>

<h3>My Custom Login Page</h3>
<f:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" > 


<c:if test="${param.error!=null }">

<i class="failed">Sorry! You entered invalid username/password.</i>

</c:if>

<p>
Username:<input  type="text"  name="username"/>
</p>
<p>
Password:<input type="password"  name="password"/>
</p>

<input type="submit" value="Login" />

</f:form>

</body>
</html>