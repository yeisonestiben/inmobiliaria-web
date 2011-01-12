<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<html>
<head>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/Prueba/Prueba.nocache.js"></script>
	

<title>Registrar Nueva Propiedad</title>
</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<div id="menuPrincipal"></div>
<h1>Registrar Nueva Propiedad</h1>
<html:form method="post" action="action/RegistrarPropiedad.do">
	<h4>Datos de la Propiedad:</h4>
	<br />
	<div id="datosPropiedad"></div>
</html:form>
</body>
</html>
