<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<style>
.error{color:red;}
</style>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/login.css"/>
</head>
<body>
	<f:form id="loginFrom" modelAttribute="login" action="logindb"
		method="post">
		<table align="center">
			<tr>
				<td><f:label path="username">Username</f:label></td>
				<td><f:input path="username" name="username" />
				<f:errors path="username" cssClass="error" />
				</td>
			</tr>

			<tr>
				<td><f:label path="password">Password</f:label></td>
				<td><f:password path="password" name="password" />
				<f:errors path="password" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><f:button id="login" name="login">Login</f:button>
				</td>
			</tr>
			<tr></tr>

			<tr>
				<td></td>

		<!-- 	<button onclick="window.location.href='/SpringCRUDApp-OgrenciKayit-HR-EMPLOYEE/logindb'">Anasayfa Git</button>  -->	
			</tr>

		</table>

		<f:form>
			<table align="center">
				<tr>
					<td style="font-style: italic; color: red;">${message}</td>
				</tr>
			</table>
		</f:form>

	</f:form>
</html>