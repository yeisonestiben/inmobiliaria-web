<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Preliminar</title>
<script type="text/javascript" language="javascript"
	src="/inmobiliaria/VistaPreliminarContrato/VistaPreliminarContrato.nocache.js"></script>
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
</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<html:form method="post" action="action/RegistrarEvento.do" >
<div id="contrato"></div>
</html:form>
</body>
</html>
