<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo/Editar Contacto</title>
</head>
<body>
	<div align="center">
		<h1>Nuevo/Editar Contacto</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Correo:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>