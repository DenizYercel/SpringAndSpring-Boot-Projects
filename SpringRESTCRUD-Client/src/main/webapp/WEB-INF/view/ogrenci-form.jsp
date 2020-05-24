<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Student</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-ogrenci-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Ogrenci Kayit Ekrani</h2>
		</div>
	</div>

	<div id="container">
		<h3>Ogrenci Kayit ekrani</h3>
	
		<form:form action="ogrenci-kaydet" modelAttribute="ogrenci" method="POST">
			<form:hidden path="id"/>
			<form:hidden path="isDelete"/>
					
			<table>
				<tbody>
				
					<tr>
						<td><label>İsim:</label></td>
						<td><form:input path="isim" /></td>
					</tr>
				
					<tr>
						<td><label>Soyisim:</label></td>
						<td><form:input path="soyisim" /></td>
					</tr>

					<tr>
						<td><label>Ogrenci No:</label></td>
						<td><form:input path="ogrenciNo" /></td>
					</tr>
				

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Kaydet" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/ogrenci/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










