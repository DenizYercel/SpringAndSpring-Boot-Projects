<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EMPLOYEES</title>
<link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h3>Employee List</h3>
	</div>

<table >


<thead>
	<tr>
		<th>EMPLOYEE ID</th>
		<th>FİRST NAME</th>
		<th>LAST NAME</th>
		<th>EMAİL</th>
		<th>PHONE NUMBER</th>
		<th>HİRE DATE</th>
		<th>JOB </th>
		<th>SALARY</th>
		<th>MANAGER </th>
		<th>DEPARTMENT </th>
		<th>İŞLEM</th>
	</tr>
</thead>

<tbody>
<f:form action="employee-search" method="POST" modelAttribute="employeeSearch">

	
	<tr>
				<td><f:input path="employee_Id" style="width: 90px"/></td>
				<td><f:input path="firstName" style="width: 90px"/></td>
				<td><f:input path="lastName" style="width: 90px"/></td>
				 <td><label>EMAİL</label></td>
				 <td><label>PHONE NUMBER</label></td>
				 <td><label>HİRE DATE</label></td>
				
				<td><f:select path="job.jobId" style="width: 90px">
					<f:option value="">Seçiniz</f:option>
							<f:options items="${job}" />
						</f:select></td>
						
				 <td><label>SALARY</label></td>
						
				<td><f:select path="manager.employee_Id" style="width: 90px">
					<f:option value="">Seçiniz</f:option>
							<f:options items="${manager}" />
						</f:select></td>
						
				<td><f:select path="department.departmentId" style="width: 90px">
					<f:option value="">Seçiniz</f:option>
							<f:options items="${department}" />
						</f:select></td>
						
				<td><f:button value="save" name="save"  style="width: 100px" class="general-button">Search</f:button></td>
	</tr>

</f:form>				




	<c:forEach items="${employee}" var="emp">
	
		<c:url var="updateLink" value="/employee/employee-guncelle" >
			<c:param name="employeeId" value="${emp.employee_Id}"></c:param>
		</c:url>
		
		<c:url var="deleteLink" value="/employee/employee-sil" >
			<c:param name="employeeId" value="${emp.employee_Id}"></c:param>
		</c:url>
		
	
	
		<tr>
			<td>${emp.employee_Id}</td>
			<td>${emp.firstName }</td>
			<td>${emp.lastName}</td>
			<td>${emp.email}</td>
			<td>${emp.phoneNumber }</td>
			<td>${emp.hireDate}</td>
			<td>${emp.job.jobTitle}</td>
			<td>${emp.salary }</td>
			<td>${emp.manager}</td>
			<td>${emp.department.departmentName}</td>
		
			<td><button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
			<button onclick="if(confirm('Silmek istediğinizden emin misiniz?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button></td>
		</tr>
	
	</c:forEach>


</tbody>
</table>




<hr/>

<button onclick="window.location.href='employee-ekle'" class="general-button">Employee Add</button>
<button onclick="window.location.href='/SpringCRUDApp-OgrenciKayit-HR-EMPLOYEE/logindb'" class="general2-button" >Anasayfa Git</button>
</div>
</body>
</html>