<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registar Liquidaciones de Alquileres</title>
<script type="text/javascript" language="javascript" 
	src="/inmobiliaria/MenuPrincipal/MenuPrincipal.nocache.js"></script>
</head>
<body>
<logic:notPresent scope="session" name="user">
	<logic:forward name="logon"/>
</logic:notPresent>
<div id="menuPrincipal"></div>
<h2>Registrar Liquidaciones de Alquileres</h2>
    <br><br>
    <table style="width: 70%; height: 95px;" align="center">
        <tr>
            <td class="style1">
                                Propietario:</td>
            <td class="style2">
                <input id="Text1" type="text" size="50" value ="Pozo, Ricardo Nicolás" disabled="true"onclick="return Text1_onclick()" /></td>
            <td class="style4">
                <input id="Button1" type="button" value="Buscar" /></td>
        </tr>
     
    </table>
    <h2><center><U>Alquileres a Liquidar</U></center></h2>

<table style="width:70%;" border="1" bgcolor ="aqua" align ="center">
    <tr>
        <th>
            Seleccionar</th>
            <th>
            Nro. Contrato</th>
            <th>
            Tipo Propiedad</th>
            <th>
            Fecha Cobro</th>
            <th>
            Monto Total<th>
            Comisión</th>
            <th>
            Monto a Liquidar</th>
   
    </tr>
    <tr>
        <td style="text-align: center">
            <input id="Checkbox1" type="checkbox" /></td>
        <td class="style3">
            1388</td>
        <td class="style3">
            Departamento</td>
        <td style="text-align: center">
            10/06/2008</td>
        <td style="text-align: center">
            $ 1024</td>
        <td style="text-align: center">
            $ 102,4</td>
        <td style="text-align: center">
            $ 921</td>
    </tr>
    <tr >
        <td style="text-align: center">
            <input id="Checkbox4" type="checkbox" /></td>
        <td class="style3">
            1388</td>
        <td class="style3">
            Departamento</td>
        <td style="text-align: center">
            10/05/2008</td>
        <td style="text-align: center">
            $1126,40</td>
        <td style="text-align: center">
            $112,64</td>
        <td style="text-align: center">
            $1013,76</td>
    </tr>
    <tr>
        <td style="text-align: center">
            <input id="Checkbox2" type="checkbox" /></td>
        <td class="style3">
            1296</td>
        <td class="style3">
            Local Comercial</td>
        <td style="text-align: center">
            10/06/2008</td>
        <td style="text-align: center">
            $ 2130</td>
        <td style="text-align: center">
                        $ 213</td>
        <td style="text-align: center">
            $ 1917</td>
    </tr>
    <tr>
        <td style="text-align: center">
            <input id="Checkbox3" type="checkbox" /></td>
        <td class="style3">
            1295</td>
        <td class="style3">
            Oficina</td>
        <td style="text-align: center">
            10/06/2008</td>
        <td style="text-align: center">
                $ 1890</td>
        <td style="text-align: center">
                $ 189</td>
        <td style="text-align: center">
                $ 1701</td>
   
    <tr>
        <td style="text-align: center">
        </td>
        <td class="style3">
            </td>
        <td class="style3">
            </td>
        <td style="text-align: RIGHT">
            <b>TOTAL</b></td>
        <td style="text-align: center">
                $ 2150,40</td>
        <td style="text-align: center">
                $ 215,04</td>
        <td style="text-align: center">
                $ 1934,76</td>
    </tr>
    
</table>

    <table style="width:30%;" align =right >
        
        <tr>
            <td style="text-align: center">
                <input id="Button2" type="button" value="Aceptar" /></td>
            <td style="text-align: left">
                <input id="Button3" type="button" value="Cancelar" /></td>
        </tr>
        
    </table>

</body>
</html>