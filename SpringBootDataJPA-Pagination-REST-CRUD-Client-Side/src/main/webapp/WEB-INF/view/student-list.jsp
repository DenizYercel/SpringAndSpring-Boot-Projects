<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ogrenciler</title>

</head>

<body>

		<div align="center">
		<frm:form action="list" modelAttribute="pages" method="GET">
	 	<frm:input name="page" path="page" placeholder="Page"></frm:input> 
			<frm:input path="pageSize" placeholder="Page Size"></frm:input> 
			<button type="submit">Getir</button> 
		</frm:form>
		<hr>
		<label>Sayfa ${p} - Veri ${l} - Total Veri ${total}</label>
		</div>

	<hr>

	<table border="1" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Isim</th>
				<th>Soyisim</th>
				<th>Email</th>
				<th>Durum</th>
				<th>İslemler</th>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="st">
			
			<c:url var="first" value="/student/list-link">
			<c:param name="paramLink" value="first"></c:param>
		</c:url>

		<c:url var="prev" value="/student/list-link">
			<c:param name="paramLink" value="prev"></c:param>
		</c:url>

		<c:url var="next" value="/student/list-link">
			<c:param name="paramLink" value="next"></c:param>
		</c:url>

		<c:url var="last" value="/student/list-link">
			<c:param name="paramLink" value="last"></c:param>
		</c:url>
			
			<c:url var="updateLink" value="/student/student-update">
							<c:param name="studentId" value="${st.id}"></c:param>
						</c:url>

						<c:url var="deleteLink" value="/student/student-delete">
							<c:param name="studentId" value="${st.id}"></c:param>
						</c:url>
			
				<tr>
					<td>${st.id}</td>
					<td>${st.isim}</td>
					<td>${st.soyisim}</td>
					<td>${st.email}</td>
					<td>${st.statu}</td>
					<td>
								<button onclick="window.location.href='${updateLink}'"
									class="button-guncelle">Update</button>

								<button
									onclick="if(confirm('Silinecek, Emin Misin?'))window.location.href='${deleteLink}'"
									class="button-sil">Delete</button>

							</td>
							
				</tr>
				
			</c:forEach>
		</tbody>
		
		<tr>
	
			<td colspan="6">
			<div align="center">
			<button onclick="window.location.href='${first}'" ${firstDis}> < < </button>
		<button onclick="window.location.href='${prev}'" ${firstDis}> < </button>
		<label>${p}</label>
		<button onclick="window.location.href='${next}'" ${lastDis}> > </button>
		<button onclick="window.location.href='${last}'" ${lastDis}> >> </button>
		<button onclick="window.location.href='student-insert'" class="button">Student
				Add</button>
				</div>
				</td>
				
				</tr>
					
	</table>



		
	


</body>
</html>