<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EMPLOYEE FORM</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<style>
.error{color:red;}
</style>

</head>
<body>
<div id="wrapper">
	<div id="header">
		<h3>Employee Form</h3>
		</div>
		<f:form action="employee-kaydet" modelAttribute="employee" method="POST">
			<f:hidden path="employee_Id" />
			<f:hidden path="isDelete" />
			<table>
			  <tr>
			  <td><label>First Name</label></td>
			  <td><f:input path="firstName" required="true" /><f:errors path="firstName" cssClass="error" />  </td>
			  </tr>
			  
			  <tr>
			  <td><label>Last Name</label></td>
			  <td><f:input path="lastName" required="true" /> <f:errors path="lastName" cssClass="error" /> </td>
			  </tr>
			  
			  <tr>
			  <td><label>EMAİL</label></td>
			  <td><f:input path="email" type="email"  required="true" /> <f:errors path="email" cssClass="error" /> </td>
			  </tr>
			  
			  <tr>
			  <td><label>PHONE NUMBER</label></td>
			  <td><f:input path="phoneNumber"  required="true" pattern="^[0-9+-]+(\\.[0-9+-]+)*[0-9-]+(.[0-9]+)$"  placeholder="123.456.7890" /><f:errors path="phoneNumber" cssClass="error" /></td>
			  </tr>
			  
			  
			  <tr>
			  <td><label>HİRE DATE</label></td>
			  <td><f:input path="hireDate" type="date" required="true" /><f:errors path="hireDate"
							cssClass="error" /></td>
			  </tr>
			  
			  <tr>
			  <td><label>JOB </label></td>
			<td> <f:select path="job.jobId">
			<f:options items="${job}"/>
			</f:select></td>
			  </tr>
			  

			  
			   <tr>
			  <td><label>SALARY</label></td>
			 <td><f:input type="number" path="salary" required="true"/><f:errors path="salary" cssClass="error" /> </td>
			  </tr>
			  
			  
			  <tr>
			  <td><label>MANAGER</label></td>
			 <td><f:select path="manager.employee_Id">
			<f:options items="${manager}"/>
			</f:select></td>
			  </tr>
			  
			  
			  <tr>
			  <td><label>DEPARTMENT </label></td>
			<td> <f:select path="department.departmentId">
			<f:options items="${department}"/>
			</f:select></td>
			  </tr>
			 
			 
			  
			  <tr>
			  	<td></td>
			  	<td><f:button value="save" name="save">Kaydet</f:button></td>
			  </tr>
			
			</table>
		</f:form>
		<br/>
		<button onclick="window.location.href='list'" class="vazgec">Vazgeç</button>
</div>

</body>
</html>