package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.TipoDireccionBean;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;
import inmo.db.Direccion;
import inmo.db.DireccionXPersona;
import inmo.db.TipoUbicacion;
import inmo.db.TipoUbicacionDAO;

import java.util.Set;

public class GestorDireccion 
{
	public Direccion getDireccion(DireccionBean direccionBean)
	{
		Barrios barrio = new BarriosDAO().findById(Integer.parseInt(direccionBean.getBarrios().getIdBarrio()));
		String calle = direccionBean.getCalle();
		String cpp = direccionBean.getCpp();
		String departamento = direccionBean.getDepartamento();
		int numero = Integer.parseInt(direccionBean.getNumero());
		Integer piso;
		try
		{
			piso = Integer.parseInt(direccionBean.getPiso());
		}
		catch (Exception ex)
		{
			piso = null;
		}
		TipoUbicacion tipoUbicacion = new TipoUbicacionDAO().findById(Integer.parseInt(direccionBean.getTipoUbicacion().getIdTipoUbicacion()));
		Direccion direccion = new Direccion (tipoUbicacion, barrio, calle, numero, piso, departamento, cpp);
		return direccion;
	}

	@SuppressWarnings("rawtypes")
	public DireccionBean[] getDirecciones(Set direccionXPersonas)
	{
		DireccionBean[] direcciones = new DireccionBean[direccionXPersonas.size()];
		int i = 0;
		for (Object obj : direccionXPersonas)
		{
			DireccionXPersona dxp = (DireccionXPersona) obj;
			Direccion direccion = dxp.getId().getDireccion();
			direcciones[i] = getDireccion(direccion);
			i++;
		}
		return direcciones;
	}

	public DireccionBean getDireccion(Direccion direccion)
	{
		String idDireccion = direccion.getIdDireccion().toString();
		TipoDireccionBean tipoDireccion = null;
		if (direccion.getTipoUbicacion() != null)
			tipoDireccion = new GestorTipoDireccion().getTipoDireccion(
					direccion.getTipoUbicacion());
		BarrioBean barrio = new GestorBarrio().getBarrio(direccion.getBarrios());
		String calle = direccion.getCalle();
		String nro = direccion.getNro().toString();
		String piso = (direccion.getPiso() != null) ? 
				direccion.getPiso().toString() : "";
		String departamento = (direccion.getDepartamento() != null) ? 
				direccion.getDepartamento() : "";
		String cpp =  (direccion.getCpp() != null) ? direccion.getCpp() : "";
		
		DireccionBean direccionBean = new DireccionBean (idDireccion, 
				tipoDireccion, barrio, calle, nro, piso, departamento, cpp);
		return direccionBean;
	}
}
