package inmo;

import java.util.ArrayList;
import java.util.Date;

public class Utilidades {
	
	private static String nombreFormulario;
	private static Date fechaNula = new Date();
	private static ArrayList<String> checks = new ArrayList<String>(); 
	
	@SuppressWarnings("deprecation")
	public static Date getFechaNula() {
		fechaNula.setDate(01);
		fechaNula.setMonth(0);
		fechaNula.setYear(0);
		fechaNula.setHours(0);
		fechaNula.setMinutes(0);
		fechaNula.setSeconds(0);
		return fechaNula;
	}
	public static void setFechaNula(Date fechaNula) {
		Utilidades.fechaNula = fechaNula;
	}
	public static String getNombreFormulario() {
		return nombreFormulario;
	}
	public static void setNombreFormulario(String nombreFormulario) {
		Utilidades.nombreFormulario = nombreFormulario;
	}
	public static ArrayList<String> getChecks() {
		ArrayList<String> returnChecks = checks;
		checks = new ArrayList<String>();
		return returnChecks;
	}
	public static void setChecks(ArrayList<String> checks) {
		Utilidades.checks = checks;
	}
	public static void resetChecks() {
		Utilidades.checks = new ArrayList<String>();
	}
	public static void addCheck(String check)
	{
		checks.add(check);
	}
	public static boolean isFloat(String numero) {
	    boolean isInt = true;
	    try {
	      Float.parseFloat(numero);
	    } catch(NumberFormatException nfe) {
	      isInt = false;
	    }
	    return(isInt);
	  }
	public static boolean isInt(String numero) {
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
}