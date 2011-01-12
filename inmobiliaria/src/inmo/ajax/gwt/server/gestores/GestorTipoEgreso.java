package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoEgresoBean;
import inmo.db.TipoEgreso;
import inmo.db.TipoEgresoDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class GestorTipoEgreso
{
	public TipoEgresoBean[] getTiposEgreso()
	{
		List<TipoEgreso> tipos = new TipoEgresoDAO().findAll();
		Collections.sort(tipos);
		
		List<TipoEgresoBean> tiposBean = new ArrayList<TipoEgresoBean>();
		
		for (TipoEgreso tipo : tipos)
		{
			TipoEgresoBean tipoBean = new TipoEgresoBean(String.valueOf(
					tipo.getIdTipoEgreso()), tipo.getNombre(), 
					tipo.getDescripcion());
			tiposBean.add(tipoBean);
		}
		
		return tiposBean.toArray(new TipoEgresoBean[tiposBean.size()]);
	}
}
