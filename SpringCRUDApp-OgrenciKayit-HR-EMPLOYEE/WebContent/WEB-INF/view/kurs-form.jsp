<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Kurs Formu</title>

<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css"/>

<style>
.error{color:red;}
</style>

</head>
<body>
<div id="wrapper">
	<div id="header">
		<h3>Kurs Formu</h3>
		</div>
		
<f:form action="kurs-kaydet" modelAttribute="kurs" method="POST">
		<f:hidden path="id" />
		<f:hidden path="isDelete" />
		<table>
			<tr>
				<td>Kurs Adı</td>
				<td><f:input path="kursAdi" required="true" /> <f:errors path="kursAdi" cssClass="error" /> </td>
			</tr>
			
			<tr>
				<td>Kurs Saati</td>
				<td><f:input path="saat" type="number" required="true" /> <f:errors path="saat" cssClass="error" /> </td>
			</tr>
			
			  <tr>
			  <td><label>ÖĞRETMEN </label></td>
			<td> <f:select path="ogretmen.ogretmenId">
			<f:options items="${ogretmen}"/>
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