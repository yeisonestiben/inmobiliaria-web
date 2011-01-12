<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<html>
<head>
<title>Inicie Sesión, Por favor!</title>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/pages/utilidades/ajax/inmo.ajax.gwt.MenuPrincipal/inmo.ajax.gwt.MenuPrincipal.nocache.js"></script>
<html:base />
</head>
<body>
<html:form action="action/ValidateLogon.do" focus="username">
	<div class="contenedor">
	<div class="centrado">
	<div class="contenido">
	<h2><center>Iniciar Sesión</center></h2>

	<p align="center"><html:errors /></p>

	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
		<TR>
			<TD><IMG
				SRC="/inmobiliaria/pages/utilidades/images/cornerIzqArr.png"></TD>
			<TD background="/inmobiliaria/pages/utilidades/images/hborder.png"></TD>
			<TD><IMG
				SRC="/inmobiliaria/pages/utilidades/images/cornerDerArr.png"></TD>
		</TR>
		<TR>
			<TD background="/inmobiliaria/pages/utilidades/images/vborder.png">&nbsp;</TD>
			<TD background="/inmobiliaria/pages/utilidades/images/caption.PNG"
				valign="middle" height="30">&nbsp;&nbsp;Ingrese sus Datos:</TD>
			<TD background="/inmobiliaria/pages/utilidades/images/vborder.png">&nbsp;</TD>
		</TR>
		<TR>
			<TD background="/inmobiliaria/pages/utilidades/images/vborder.png"></TD>
			<TD valign="top">
			<table border="0" width="100%" align="center">
				<tr>
					<td align="right">Nombre de Usuario:</td>
					<td align="left"><html:text property="username" /></td>
				</tr>

				<tr>
					<td align="right">Contraseña:</td>
					<td align="left"><html:password property="password" /></td>
				</tr>

				<tr>
					<td align="right"><html:submit property="submit"
						value="Submit" /></td>
					<td align="left"><html:reset /></td>
				</tr>

			</table>
			</TD>
			<TD background="/inmobiliaria/pages/utilidades/images/vborder.png"></TD>
		</TR>
		<TR>
			<TD><IMG
				SRC="/inmobiliaria/pages/utilidades/images/cornerIzqAbj.png"></TD>
			<TD align="center"
				background="/inmobiliaria/pages/utilidades/images/hborder.png"></TD>
			<TD><IMG
				SRC="/inmobiliaria/pages/utilidades/images/cornerDerAbj.png"></TD>
		</TR>
	</TABLE>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</div>
	</div>
	</div>
</html:form>
</body>
</html>
