<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Öğrenciler</title>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h3>Öğrenci Listeme</h3>
		<hr/>
	</div>
</div>

<div id="container">
<div id="content" >
<table>

<thead>
	<tr>
		<th>ID</th>
		<th>İSİM</th>
		<th>SOYİSİM</th>
		<th>ÖGRENCİ NO</th>
		<th>İşlem</th>
		
	</tr>
</thead>
	
<tbody>
	<c:forEach items="${ogrenciler}" var="ogrnci">
	
		<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle" >
			<c:param name="ogrenciId" value="${ogrnci.id}"></c:param>
		</c:url>
		
		<c:url var="deleteLink" value="/ogrenci/ogrenci-sil" >
			<c:param name="ogrenciId" value="${ogrnci.id}"></c:param>
		</c:url>
		
	
		<tr>
			<td>${ogrnci.id}</td>
			<td>${ogrnci.isim}</td>
			<td>${ogrnci.soyisim}</td>
			<td>${ogrnci.ogrenciNo}</td>
			<!-- 1.tıklama örneği <td><a href="${pageContext.request.contextPath}/ogrenci/ogrenci-guncelle?ogrenciId=${ogrnci.id}">Güncelle
			</a></td> -->	
		<!--2.tıklama örneği <td><a href="${updateLink}">Güncelle</a>
			</td>  -->
		
		<td><button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
			<button onclick="if(confirm('Silmek istediğinizden emin misiniz?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button></td>
	</tr>  
	</c:forEach>

</tbody>

</table>

</div>
</div>
<hr/>
<button onclick="window.location.href='ogrenci-ekle'"  class="general-button" >Öğrenci Ekle</button>
<button onclick="window.location.href='/SpringCRUDApp-OgrenciKayit-HR-EMPLOYEE/logindb'"  class="general2-button" >Anasayfa Git</button>

</body>
</html>