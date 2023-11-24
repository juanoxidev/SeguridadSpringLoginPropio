<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido</h1>
	<hr>
	<!-- Spring security tag lib principal trae los atributos -->
	<p>
	Usuario: <security:authentication property="principal.username"/>
	<br/>
	<br/>
	Rol: <security:authentication property="principal.authorities"/>
	</p>
	<br/>
	<!--  Si solo queremos que un tipo de rol vea x contenido utilizamos la etiqueta security:authorize y le pasamos al parametro access hasRole("rol") -->
	<security:authorize access="hasRole('administrador')">
	<!--  link para administradores -->
	<p>
	<a href="${pageContext.request.contextPath}/administradores"> Panel Admin </a>
	</p>
	 </security:authorize>
	 
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout">
	</form:form>
</body>
</html>