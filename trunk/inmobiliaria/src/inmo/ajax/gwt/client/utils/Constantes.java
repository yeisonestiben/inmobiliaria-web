package inmo.ajax.gwt.client.utils;

import inmo.ajax.gwt.client.db.PropiedadBean;

import java.util.Arrays;
import java.util.List;

public class Constantes
{
	public static String getDescripcionPropiedad(PropiedadBean propiedad)
	{
		StringBuffer descripcion = new StringBuffer();
		
		descripcion.append("Calle ");
		descripcion.append(propiedad.getDireccion().getCalle());
		descripcion.append(" N° ");
		descripcion.append(propiedad.getDireccion().getNumero());
		if (propiedad.getDireccion().getDepartamento() != null 
				&& !propiedad.getDireccion().getDepartamento().equals(""))
		{
			descripcion.append(", Departamento: ");
			descripcion.append(propiedad.getDireccion().getDepartamento());
		}
		if (propiedad.getDireccion().getPiso() != null
				&& !propiedad.getDireccion().getPiso().equals(""))
		{
			descripcion.append(", Piso: ");
			if (propiedad.getDireccion().getPiso().equals(0))
				descripcion.append("PB");
			else
				descripcion.append(propiedad.getDireccion().getPiso());
		}
		descripcion.append(", Barrio: ");
		descripcion.append(propiedad.getDireccion().getBarrios().getNombre());
		descripcion.append(", de la ciudad de ");
		descripcion.append(propiedad.getDireccion().getBarrios().getNombreLocalidad());
		
		if (propiedad.getTipoPropiedad().getNombre().equals("Casa") 
			|| propiedad.getTipoPropiedad().getNombre().equals("Departamento"))
		{
			descripcion.append(", el cual consta de: ");
			descripcion.append("Dormitorios: ");
			descripcion.append(Utilidades.numeroToString(propiedad.getDormitorios()));
			descripcion.append(", Baños: ");
			descripcion.append(Utilidades.numeroToString(propiedad.getBanios()));
		}
		
		return descripcion.toString();
	}
	
	public static List<String> getOrdinales()
	{
		String ordins[] = {"PRIMERA","SEGUNDA","TERCERA","CUARTA","QUINTA",
				"SEXTA","SÉPTIMA","OCTAVA","NOVENA","DÉCIMA","DÉCIMA PRIMERA",
				"DÉCIMA SEGUNDA","DÉCIMA TERCERA","DÉCIMA CUARTA",
				"DÉCIMA QUINTA","DÉCIMA SEXTA","DÉCIMA SÉPTIMA","DÉCIMA OCTAVA",
				"DÉCIMO NOVENA","VIGÉSIMA","VIGÉSIMA PRIMERA",
				"VIGÉSIMA SEGUNDA","VIGÉSIMA TERCERA","VIGÉSIMA CUARTA",
				"VIGÉSIMA QUINTA","VIGÉSIMA SEXTA","VIGÉSIMA SÉPTIMA",
				"VIGÉSIMA OCTAVA","VIGÉSIMA NOVENA","TRIGÉSIMA"};
		List<String> ordinales = Arrays.asList(ordins);
		return ordinales;
	}
}
