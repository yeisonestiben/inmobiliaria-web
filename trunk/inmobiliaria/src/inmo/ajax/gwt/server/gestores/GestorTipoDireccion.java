package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoDireccionBean;
import inmo.db.TipoUbicacion;
import inmo.db.TipoUbicacionDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorTipoDireccion {
	
	@SuppressWarnings("unchecked")
	public TipoDireccionBean[] getDirecciones()
	{
		TipoUbicacionDAO tipoUbicacionDAO = new TipoUbicacionDAO();
		List<TipoUbicacion> listTipoUbicacion = tipoUbicacionDAO.findAll();
		Collections.sort (listTipoUbicacion);
		
		List<TipoDireccionBean> tipoDireccionesBean = 
			new ArrayList<TipoDireccionBean>();
		
		for (TipoUbicacion tipoUbicacion : listTipoUbicacion)
		{
			TipoDireccionBean tipoDireccionBean = 
				new TipoDireccionBean(tipoUbicacion.getIdTipoUbicacion().toString(), 
						tipoUbicacion.getNombre());			
			tipoDireccionesBean.add(tipoDireccionBean);
		}
		return tipoDireccionesBean.toArray(
				new TipoDireccionBean[tipoDireccionesBean.size()]);
	}

	public TipoDireccionBean getTipoDireccion(TipoUbicacion tipoUbicacion)
	{
		TipoDireccionBean tipoDireccion = new TipoDireccionBean(tipoUbicacion.getIdTipoUbicacion().toString(), tipoUbicacion.getNombre());
		return tipoDireccion;
	}
}
