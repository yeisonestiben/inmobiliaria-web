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
<title>Registrar Nueva Queja</title>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/MenuPrincipal/MenuPrincipal.nocache.js"></script>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/RegistrarQueja/RegistrarQueja.nocache.js"></script>
	
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/css/gxt-all.css" />
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/themes/jetnet/jetn1011.css" />
	
</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<div id="menuPrincipal"></div>
<h1>Registrar Nueva Queja</h1>
<b><font color="RED"><UL>
	<div id="errores"></div>
</UL></font></b>
<html:form method="post" action="action/RegistrarQueja.do">
	<table>
		<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Contrato:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="contrato"></div>
				<br /><br />
			</td>
		</tr>
				<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Responsable:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="persona"></div>
				<br /><br />
			</td>
		</tr>
				<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Tipo de Reclamo:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="tipoReclamo"></div>
				<br /><br />
			</td>
		</tr>
				<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Descripción del Reclamo:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="reclamo"></div>
				<br /><br />
			</td>
		</tr>
				<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Comentarios:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="comentarios"></div>
				<br />
			</td>
		</tr>
		<tr>
			<td align="right">
				<br />	
				<div id="submit"></div>
				<br /><br />
			</td>
		</tr>
	</table>
</html:form>
</body>
</html>
