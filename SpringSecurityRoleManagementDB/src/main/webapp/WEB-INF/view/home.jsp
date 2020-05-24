<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>hello</title>
</head>
<body>
<h2>hosgeldin</h2>
<br/>

<hr>
	<p>
		User:<security:authentication property="principal.username"/>
		
		Role(s):<security:authentication property="principal.authorities" />
	</p>

</hr>

<security:authorize access="hasRole('ADMIN')">
<a href="admin/home">Admin ana sayfa</a>
</security:authorize>


<!-- <security:authorize access="hasRole('EMPLOYEE')">
<a href="employee/home">Employee ana sayfa</a>
</security:authorize>  -->

<security:authorize access="hasAnyRole('EMPLOYEE','ADMIN')">
<a href="employee/home">Employee ana sayfa</a>
</security:authorize>

<f:form action="${pageContext.request.contextPath}/logout" method="POST">

<input  type="submit" value="Logout" />

</f:form>

</body>
</html>