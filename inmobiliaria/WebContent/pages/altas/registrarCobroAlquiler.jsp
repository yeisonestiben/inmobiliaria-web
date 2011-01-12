<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/css/gxt-all.css" />
<link rel="stylesheet" type="text/css" href="/inmobiliaria/resources/themes/jetnet/jetn1011.css" />

<script type="text/javascript" language="javascript"
	src="/inmobiliaria/MenuPrincipal/MenuPrincipal.nocache.js"></script>
<script type="text/javascript" language="javascript" 
	src="/inmobiliaria/RegistrarCobroAlquiler/RegistrarCobroAlquiler.nocache.js"></script>
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

<title>Registar Cobro Alquiler</title>
</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<div id="menuPrincipal"></div>
<h1>Registrar Cobro Alquiler</h1>
<b><font color="RED"><UL>
	<div id="errores"></div>
</UL></font></b>
<form name="RegistrarCobroAlquiler" method="post" action="/inmobiliaria/action/RegistrarCobroAlquiler.do">

	<table>
		<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Seleccione Cliente:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="busqueda"></div>
				<br /><br />
			</td>
		</tr>
		<tr class="inmo-tabheader">
			<td class="inmo-tabtopmiddle" align="left">
				<div class="inmo-tabtitle">
					Seleccione los Cobros a Registrar:
					<br />
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<br />
				<div id="cobros"></div>
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
</form>
</body>
</html>
