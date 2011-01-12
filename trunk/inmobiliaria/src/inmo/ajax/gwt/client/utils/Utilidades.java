package inmo.ajax.gwt.client.utils;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.i18n.client.NumberFormat;

@SuppressWarnings("deprecation")
public class Utilidades implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static String getDate(Date fecha)
	{
		String lReturn;
		String dia = "";
		String mes = "";
		String anio = "";
		if (fecha.getDate() < 10)
		{
			dia = "0"+fecha.getDate();
		}
		else
		{
			dia = ""+fecha.getDate();
		}
		if (fecha.getMonth() < 9)
		{
			mes = "0"+(fecha.getMonth()+1);
		}
		else
		{
			mes = ""+(fecha.getMonth()+1);
		}
		anio = ""+(fecha.getYear()+1900);
		lReturn = dia+"/"+mes+"/"+anio;

		return lReturn;
	}

	public static Date getDate (String fecha)
	{
		Date date = new Date();
		date.setDate(Integer.parseInt(fecha.substring(0, 2)));
		date.setMonth(Integer.parseInt(fecha.substring(3, 5))-1);
		date.setYear(Integer.parseInt(fecha.substring(6))-1900);
		return date;
	}

	public static String formatearNumero (String numero)
	{
		String monto = NumberFormat.getFormat("00000000.00").format(Double.
				parseDouble(numero));
		while (monto.startsWith("0") && monto.length() > 4)
		{
			monto = monto.substring(1);
		}
		return monto;
	}

	public static boolean isVencido (String date)
	{
		Date fecha = new Date ();
		fecha.setDate(Integer.parseInt(date.substring(0, 2)));
		fecha.setMonth(Integer.parseInt(date.substring(3, 5))-1);
		fecha.setYear(Integer.parseInt(date.substring(6))-1900);

		return isVencido(fecha);
	}

	public static boolean isVencido (Date date)
	{
		boolean lReturn = false;
		Date hoy = new Date();
		hoy.setHours(0);
		hoy.setMinutes(0);
		hoy.setSeconds(0);
		if (date.compareTo(hoy) < 0)
		{
			lReturn = true;
		}
		return lReturn;
	}

	public static boolean isFloat(String numero) 
	{
		boolean isInt = true;
		try {
			Float.parseFloat(numero);
		} catch(NumberFormatException nfe) {
			isInt = false;
		}
		return(isInt);
	}

	public static boolean isInt(String numero)
	{
		boolean isInt = true;
		try {
			Integer.parseInt(numero);
		} catch(NumberFormatException nfe) {
			isInt = false;
		}
		return(isInt);
	}
	
	public static boolean isMissing (String value) {
		return((value == null) || (value.trim().equals("")));
	}
	
	public static Date getHora(String hora)
	{
		Date lReturn = new Date();
		lReturn.setHours(Integer.parseInt(hora.substring(0, 2)));
		lReturn.setMinutes(Integer.parseInt(hora.substring(3)));
		return lReturn;
	}
	
	public static String numeroToString(String numero)
	{
		String n = "";
		if (numero.equals("0")) {
			n = "Cero";
		}
		else if (numero.equals("1")) {
			n = "Uno";
		}
		else if (numero.equals("2")) {
			n = "Dos";
		}
		else if (numero.equals("3")) {
			n = "Tres";
		}
		else if (numero.equals("4")) {
			n = "Cuatro";
		}
		else if (numero.equals("5")) {
			n = "Cinco";
		}
		else if (numero.equals("6")) {
			n = "Seis";
		}
		else if (numero.equals("7")) {
			n = "Siete";
		}
		else if (numero.equals("8")) {
			n = "Ocho";
		}
		else if (numero.equals("9")) {
			n = "Nueve";
		}
		else if (numero.equals("10")) {
			n = "Diez";
		}
		return n;
	}

	public static String getDateImprimible(String fecha)
	{
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(3, 5));
		int anio = Integer.parseInt(fecha.substring(6));

		StringBuilder lReturn = new StringBuilder();
		lReturn.append(dia + " de ");
		lReturn.append(getMes(mes));
		lReturn.append(" ");
		lReturn.append(anio);
		return lReturn.toString();
	}

	public static String getMes(int mes)
	{
		StringBuilder lReturn = new StringBuilder();
		switch (mes) 
		{
			case 1: lReturn.append("Enero");
					break;
			case 2: lReturn.append("Febrero");
					break;
			case 3: lReturn.append("Marzo");
					break;
			case 4: lReturn.append("Abril");
					break;
			case 5: lReturn.append("Mayo");
					break;
			case 6: lReturn.append("Junio");
					break;
			case 7: lReturn.append("Julio");
					break;
			case 8: lReturn.append("Agosto");
					break;
			case 9: lReturn.append("Septiembre");
					break;
			case 10: lReturn.append("Octubre");
					break;
			case 11: lReturn.append("Noviembre");
					break;
			case 12: lReturn.append("Diciembre");
					break;
		}
		return lReturn.toString();
	}

	public static String restarUnDia(Date date)
	{
		if (date.getDate() == 1)
		{
			if (date.getMonth() == 0)
			{
				date.setYear(date.getYear()-1);
				date.setMonth(11);
				date.setDate(31);
			}
			else
			{
				date.setMonth(date.getMonth()-1);
				int mes = date.getMonth() + 1;
				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10)
				{
					
				}
				else if (mes == 2)
				{
					date.setDate(28);
				}
				else
				{
					date.setDate(30);
				}
			}
		}
		else
		{
			date.setDate(date.getDate()-1);
		}
		return getDate(date);
	}
}
