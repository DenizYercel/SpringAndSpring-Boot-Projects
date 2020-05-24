<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ogrenci form</title>

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

	
			<h2>Kitap Formu</h2>
			<br/>
			<frm:form action="${pageContext.request.contextPath}/kitapteslim" modelAttribute="kitap" method="post">			
			
			<c:url var="ogrblg" value="/ogrencibilgileri">
			<c:param name="ogrNo" value="${kitap.ogrenci.ogrenciNo}"/>
			</c:url>
			
			<table>
			<tr>
			<td><label>Id:</label></td>
			<td><frm:input path="id"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Kitap Adı:</label></td>
			<td><frm:input path="kitapAdi"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Yazar:</label></td>
			<td><frm:input path="yazar"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Veriliş Tarihi:</label></td>
			<td><frm:input path="verTarihi" type="date"  /></td>
			</tr>
			<tr>
			<td><label>İade Tarihi:</label></td>
			<td><frm:input path="iadTarihi" type="date"  /></td>
			</tr>
			<tr>
			<td><label>Ödünç Alan Öğrenci No:</label></td>
			<td><frm:input path="ogrenci.ogrenciNo"  /></td>
			</tr>							
			<tr>
			<td></td>
			<td>
			<frm:button value="save" name="save">Kaydet</frm:button></td>
			</tr>
			</table>
			</frm:form>
	
<br/>
<a href="${pageContext.request.contextPath}/kutuphaneisleri">Listeye Dön</a>

			&nbsp;/&nbsp;		
 <!--  <c:choose>
	<c:when test="${kitap.ogrenci.ogrenciNo!=null}">
		<button class="update-button" onclick="window.location.href='${ogrblg}'">Öğrenci Bilgileri</button>
  </c:when>						 					 
</c:choose>  -->
 </body>
</html>