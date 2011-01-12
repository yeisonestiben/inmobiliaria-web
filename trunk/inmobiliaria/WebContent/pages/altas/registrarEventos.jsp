<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Eventos</title>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/MenuPrincipal/MenuPrincipal.nocache.js"></script>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/RegistrarEvento/RegistrarEvento.nocache.js"></script>
<script language="javascript" type="text/javascript">

// <!CDATA[

function stopRKey(evt) {
  var evt = (evt) ? evt : ((event) ? event : null);
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
  if ((evt.keyCode == 13) && (node.type=="text"))  {return false;}
}

document.onkeypress = stopRKey; 

// ]]>
</script>
			
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/css/gxt-all.css" />
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/themes/jetnet/jetn1011.css" />

</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<div id="menuPrincipal"></div>
<h1>Registrar Eventos</h1>
<b><font color="RED"><UL>
	<div id="errores"></div>
</UL></font></b>
<html:form method="post" action="action/RegistrarEvento.do" >
	<table>
		<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Datos del Evento:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="evento"></div>
				<br /><br />
			</td>
		</tr>
				<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Dirección del Evento:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="direccion"></div>
				<br />
			</td>
		</tr>
		<tr>
			<td align="right">
				<div id="submit"></div>
				<br /><br />
			</td>
		</tr>
	</table>
</html:form>
</body>
</html>
