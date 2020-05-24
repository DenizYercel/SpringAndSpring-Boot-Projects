<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Kurslar</title>
<link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h3>Kurs Listeme</h3>
	</div>



<table>

<thead>
	<tr>
		<th>ID</th>
		<th>Kurs Adı</th>
		<th>Kurs Saati</th>
		<th>ÖĞRETMEN</th>
		<th>İŞLEM</th>
	</tr>
</thead>

<tbody>
	
	<f:form action="kurs-search" method="POST" modelAttribute="searchKurs">
		<tr>
				<td><f:input path="id" style="width: 90px"/></td>
				<td><f:input path="kursAdi" style="width: 90px"/></td>
				<td><f:input path="saat" style="width: 90px"/></td>
				<td><f:select path="ogretmen.ogretmenId" style="width: 90px">
					<f:option value="">Seçiniz</f:option>
							<f:options items="${ogretmen}" />
						</f:select></td>
				<td><f:button value="save" name="save"  style="width: 100px" class="general-button">Search</f:button></td>
		</tr>	
</f:form>

	<c:forEach items="${kurs}" var="krs">
	
		<c:url var="updateLink" value="/kurs/kurs-guncelle">
			<c:param name="kursId" value="${krs.id}"></c:param>
		</c:url>
		
		<c:url var="deleteLink" value="/kurs/kurs-sil">
			<c:param name="kursId" value="${krs.id}"></c:param>
		</c:url>
	
	
		<tr>
			<td>${krs.id}</td>
			<td>${krs.kursAdi}</td>
			<td>${krs.saat}</td>
			<td>${krs.ogretmen}</td>
		
			<td>
				<button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
				<button onclick="if(confirm('Silmek istediğinizden emin misiniz?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button>
			</td>
		
		</tr>
	
	</c:forEach>


</tbody>
</table>


<hr/>

<button onclick="window.location.href='kurs-ekle'" class="general-button">Kurs Ekle</button>
<button onclick="window.location.href='/SpringCRUDApp-OgrenciKayit-HR-EMPLOYEE/logindb'" class="general2-button">Anasayfa Git</button>
</div>
</body>
</html>