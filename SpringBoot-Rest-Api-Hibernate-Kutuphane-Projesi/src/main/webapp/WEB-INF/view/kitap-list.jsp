<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kütüphane</title>
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

	<p style="color:red;text-align:center;font-size:18px;">${mesaj}</p>
	<br/>
	<table>
	<thead>
			<tr>
				<th>Id</th>
				<th>Kitap</th>
				<th>Yazar</th>
				<th>Veriliş Tarih</th>
				<th>İade Tarih</th>				
				<th>Durum</th>
				<th>İşlem</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${kitaplar}" var="ktp">
			
			<c:url var="oduncislemi" value="/oduncAl">
			<c:param name="kitapId" value="${ktp.id}"/>
			</c:url>			
				<tr>
					<td>${ktp.id}</td>
					<td>${ktp.kitapAdi}</td>
					<td>${ktp.yazar}</td>
					<td>${ktp.verTarihi}</td>
					<td>${ktp.iadTarihi}</td>
												
					<td>
					<c:choose>
						  <c:when test="${ktp.ogrenci!=null}">
						    Ogrencide
						  </c:when>
						  <c:when test="${ktp.ogrenci==null}">
						    Kutuphanede
						  </c:when>						 
					</c:choose>
					
					</td>					
					<td>
					<button class="update-button" onclick="window.location.href='${oduncislemi}'">Ödünç İşlemi</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
	
</body>
</html>