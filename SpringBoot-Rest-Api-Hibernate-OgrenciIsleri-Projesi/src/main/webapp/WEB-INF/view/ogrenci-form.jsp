<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

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

	
			<h2>Ogrenci Formu</h2>
			<br/>
			<frm:form action="${pageContext.request.contextPath}/mezunEt" modelAttribute="ogr" method="post">			
			<table>
			<tr>
			<td><label>Id:</label></td>
			<td><frm:input path="id"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Öğrenci No:</label></td>
			<td><frm:input path="ogrenciNo"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Ad:</label></td>
			<td><frm:input path="ad"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Soyad:</label></td>
			<td><frm:input path="soyad"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Başlangıç Tarihi:</label></td>
			<td><frm:input path="baslDate" type="date" readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Mezuniyet Tarihi:</label></td>
			<td><frm:input path="mezDate" type="date" /></td>
			</tr>			
			<tr>
			<td><label>Öğrencilik Durumu:</label></td>
			<td>
			<frm:radiobutton path="ogrencilikDurumu" value="0"/> <b>Pasif</b> &nbsp;&nbsp;
			<frm:radiobutton  path="ogrencilikDurumu" value="1"/> <b>Aktif</b>
			</td>
			</tr>			
			<tr>
			<td></td>
			<td>
			<frm:button value="save" name="save">Kaydet</frm:button></td>
			</tr>
			</table>
			</frm:form>
	
<br/>
<a href="${pageContext.request.contextPath}/ogrenciisleri">Listeye Dön</a>

</body>
</html>