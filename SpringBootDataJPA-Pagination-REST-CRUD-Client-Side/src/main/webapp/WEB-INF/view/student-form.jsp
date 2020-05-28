<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Student Form</title>
</head>
<body>
	<div align="center">
	<frm:form action="student-save" modelAttribute="student"
			method="POST">
			<frm:hidden path="id" />
			<table>

				<tr>
					<td><label>Isim</label></td>
					<td><frm:input path="isim" /></td>
				</tr>
				<tr>
					<td><label>Soyisim</label></td>
					<td><frm:input path="soyisim" /></td>
				</tr>

				<tr>
					<td><label>Email</label></td>
					<td><frm:input path="email" /></td>
				</tr>
			
			<tr>
					<td><label>Durum(1/0)</label></td>
					<td><frm:input path="statu" /></td>
				</tr>
				
				
			
				<tr>
					<td></td>
					<td><frm:button value="save" name="save" class="button">Save</frm:button></td>
				</tr>

			</table>

		</frm:form>
		</div>
</body>
</html>