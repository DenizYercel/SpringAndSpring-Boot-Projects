<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ogrenci Bilgileri</title>


</head>
<body>

	
			<h2>Öğrenci Bilgileri</h2>
			<br/>
			<table>
			<tr>
			<td><label>Id:</label>&nbsp;${ogr.id}</td>
			</tr>
			<tr>
			<td><label>Öğrenci No:</label>&nbsp;${ogr.ogrenciNo}</td>
			</tr>
			<tr>
			<td><label>Ad:</label>&nbsp;${ogr.ad}</td>
			</tr>
			<tr>
			<td><label>Soyad:</label>&nbsp;${ogr.soyad}</td>
			</tr>			
			</table>			
	
<br/>
<a href="${pageContext.request.contextPath}/kutuphaneisleri">Listeye Dön</a>
			
</body>
</html>