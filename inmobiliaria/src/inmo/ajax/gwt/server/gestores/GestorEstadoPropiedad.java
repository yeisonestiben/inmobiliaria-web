package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.EstadoPropiedadBean;
import inmo.db.EstadoPropiedad;
import inmo.db.EstadoPropiedadDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorEstadoPropiedad
{
	public EstadoPropiedadBean[] getEstadosPropiedadBean()
	{
		@SuppressWarnings("unchecked")
		List<EstadoPropiedad> listEstadoPropiedad = 
			new EstadoPropiedadDAO().findAll();
		Collections.sort(listEstadoPropiedad);
		List<EstadoPropiedadBean> listEstadoPropiedadBean = 
			new ArrayList<EstadoPropiedadBean>();
		for (EstadoPropiedad estadoPropiedad : listEstadoPropiedad)
		{
			EstadoPropiedadBean estadoPropiedadBean = 
				new EstadoPropiedadBean(estadoPropiedad.getIdEstadoPropiedad().toString(), 
						estadoPropiedad.getNombre(), estadoPropiedad.getDescipcion());
			listEstadoPropiedadBean.add(estadoPropiedadBean);
		}
		return listEstadoPropiedadBean.toArray(
				new EstadoPropiedadBean[listEstadoPropiedadBean.size()]);
	}

	public EstadoPropiedadBean getEstadoPropiedad(EstadoPropiedad
			estadoPropiedad)
	{
		String idEstadoPropiedad = 
			estadoPropiedad.getIdEstadoPropiedad().toString();
		String nombre = estadoPropiedad.getNombre();
		String descipcion = estadoPropiedad.getDescipcion();
		
		EstadoPropiedadBean estadoBean = 
			new EstadoPropiedadBean(idEstadoPropiedad, nombre, descipcion);
		return estadoBean;
	}
}
