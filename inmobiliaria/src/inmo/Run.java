package inmo;

import inmo.ajax.gwt.client.utils.Constantes;

import java.util.List;

public class Run
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		Propiedades propiedad = new PropiedadesDAO().findById(Integer.valueOf("1"));
//		System.out.println(propiedad.getDireccion().getTipoUbicacion().getNombre());
//		System.out.println(propiedad.getDireccion().getIdDireccion());
//		System.out.println(propiedad.getDireccion().getBarrios().getNombre());
//		TipoPropiedadBean tipPropiedad = new GestorTipoPropiedad().getTipoPropiedad(propiedad.getTipoPropiedad());
//		System.out.println(tipPropiedad.getNombre());
		
//		Direccion direccion = new DireccionDAO().findById(propiedad.getDireccion().getIdDireccion());
//		System.out.println(direccion.getTipoUbicacion().getNombre());
//		System.out.println(direccion.getCpp());
		
//		PropiedadBean propiedadBean = new GestorPropiedad().getPropiedad(propiedad);
//		System.out.println(propiedadBean.getTipoPropiedad().getNombre());
//		new GestorPropiedad().getPropiedad("1");
		List<String> list = Constantes.getOrdinales();
		for(String s : list) {
			System.out.println(s);
		}
	}


}
