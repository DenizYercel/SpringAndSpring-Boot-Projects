<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Öğrenci İşleri</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  text-align: center;
  padding: 8px;
}
tr:nth-child(odd){background-color: #6EC6FC}
tr:nth-child(even){background-color: #DDFC62}
th {
  background-color: #FF3333;
  color: white;
}
</style>
</head>
<body>
<br/><br/>

		<p style="color:red;text-align:center;font-size:20px;">${mesaj}</p>
		<br/>
	<table>
	<thead>
			<tr>
				<th>Id</th>
				<th>Ogr No</th>
				<th>Ad</th>
				<th>Soyad</th>
				<th>Baslama Tarih</th>
				<th>Mezuniyet Tarih</th>
				<th>Durum</th>
				<th>İşlem</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${ogrenciler}" var="ogr">
			
			<c:url var="mezuniyetLink" value="/mezuniyet">
			<c:param name="ogrenciId" value="${ogr.id}"/>
			</c:url>			
				<tr>
					<td>${ogr.id}</td>
					<td>${ogr.ogrenciNo}</td>
					<td>${ogr.ad}</td>
					<td>${ogr.soyad}</td>
					<td>${ogr.baslDate}</td>
					<td>${ogr.mezDate}</td>					
					<td>
					<c:choose>
						  <c:when test="${ogr.ogrencilikDurumu==0}">
						    Mezun
						  </c:when>
						  <c:when test="${ogr.ogrencilikDurumu==1}">
						    Aktif
						  </c:when>
						  <c:otherwise>
						    ${ogr.ogrencilikDurumu}
						  </c:otherwise>
					</c:choose>
					
					</td>					
					<td>
					<button class="update-button" onclick="window.location.href='${mezuniyetLink}'">Mezuniyet İşlemi</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
	
</body>
</html>