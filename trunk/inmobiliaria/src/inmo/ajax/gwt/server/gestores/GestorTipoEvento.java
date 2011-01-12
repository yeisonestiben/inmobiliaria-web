package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoEventoBean;
import inmo.db.TipoEvento;
import inmo.db.TipoEventoDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestorTipoEvento
{
	@SuppressWarnings("unchecked")
	public TipoEventoBean[] getTiposContacto()
	{
		TipoEventoDAO tipoEventoDAO = new TipoEventoDAO();
		List<TipoEvento> listaTipoEvento = tipoEventoDAO.findAll();
//		Collections.sort (listaTipoEvento);
		Iterator<TipoEvento> iterator = listaTipoEvento.iterator();
		
		List<TipoEventoBean> listaTipoEventoBean = 
			new ArrayList<TipoEventoBean>();
		
		while(iterator.hasNext())
		{
			TipoEvento tipo = iterator.next();
			TipoEventoBean tipoBean = 
				new TipoEventoBean(tipo.getIdTipoEvento().toString(), 
						tipo.getNombre(), tipo.getDescripcion());
			listaTipoEventoBean.add(tipoBean);
		}
		return listaTipoEventoBean.toArray(new 
				TipoEventoBean[listaTipoEventoBean.size()]);
	}
}
