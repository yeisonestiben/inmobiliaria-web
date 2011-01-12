package inmo.ajax.gwt.server.gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.db.TipoDisponibilidad;
import inmo.db.TipoDisponibilidadDAO;

public class GestorTipoDisponibilidad
{
	public TipoDisponibilidadBean[] getTipoDisponibilidadesBean()
	{
		@SuppressWarnings("unchecked")
		List<TipoDisponibilidad> listTipoDisponibilidades = 
			new TipoDisponibilidadDAO().findAll();
		Collections.sort(listTipoDisponibilidades);
		List<TipoDisponibilidadBean> listTipoDisponibilidadBean = 
			new ArrayList<TipoDisponibilidadBean>();
		
		for (TipoDisponibilidad tipoDisponibilidad : listTipoDisponibilidades)
		{
			TipoDisponibilidadBean tipoDisponibilidadBean = 
				new TipoDisponibilidadBean(
						tipoDisponibilidad.getIdTipoDisponibilidad().toString(), 
						tipoDisponibilidad.getNombre(), 
						tipoDisponibilidad.getDescripcion());
			listTipoDisponibilidadBean.add(tipoDisponibilidadBean);
		}
		return listTipoDisponibilidadBean.toArray(
				new TipoDisponibilidadBean[listTipoDisponibilidades.size()]);
	}
}
