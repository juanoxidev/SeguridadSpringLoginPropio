<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3 style="text-align:center"> Log in </h3>
<form:form action="${pageContext.request.contextPath}/autenticacionUsuario" method="POST">

<!--  mostramos el error de inicio de sesion -->
<c:if test="${param.error!=null}">
<strong>Datos de sesion invalidos</strong>
</c:if>
<!--  mostramos mensaje al desloguearnos -->
<!--  mostramos el error de inicio de sesion -->
<c:if test="${param.logout!=null}">
<strong>Logout realizado</strong>
</c:if>
<!-- Para que spring tome los valores del form, los name deben ser Username y Password si o si  -->
<label name="username"> Usuario</label>
<input type="text" name="username"/>
<label name="password"> Contrasenia</label>
<input type="password" name="password"/>
<input type="submit" value="log in">
</form:form>
</body>
</html>