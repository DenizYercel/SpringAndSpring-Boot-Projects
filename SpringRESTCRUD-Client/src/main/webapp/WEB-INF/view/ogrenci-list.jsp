
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<head>
	<title>List Ogrenciler</title>
	
	<!-- reference our style sheet -->

	  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"   /> 

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Ogrenciler Listesi</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Ogrenci -->
		
			<input type="button" value="Add Ogrenci"
				   onclick="window.location.href='ogrenci-ekle'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Islem</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="ogrnci" items="${ogrenciler}">
				
					<!-- construct an "update" link with ogrenci id -->
					<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle" >
						<c:param name="ogrenciId" value="${ogrnci.id}"></c:param>
					</c:url>					

					<!-- construct an "delete" link with ogrenci id -->
					<c:url var="deleteLink" value="/ogrenci/ogrenci-sil" >
						<c:param name="ogrenciId" value="${ogrnci.id}"></c:param>
					</c:url>					
					
					<tr>
						<td> ${ogrnci.id} </td>
						<td> ${ogrnci.isim} </td>
						<td> ${ogrnci.soyisim} </td>
						<td>${ogrnci.ogrenciNo}</td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









