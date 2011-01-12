package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoContactoBean;
import inmo.db.TipoContacto;
import inmo.db.TipoContactoDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GestorTipoContacto 
{
	
	@SuppressWarnings("unchecked")
	public TipoContactoBean[] getTiposContacto()
	{
		TipoContactoDAO tipoContactoDAO = new TipoContactoDAO();
		List<TipoContacto> listaTipoContacto = tipoContactoDAO.findAll();
		Collections.sort (listaTipoContacto);
		Iterator<TipoContacto> iterator = listaTipoContacto.iterator();
		
		List<TipoContactoBean> listaTipoContactoBean = new ArrayList<TipoContactoBean>();
		
		while(iterator.hasNext())
		{
			TipoContacto tipo = iterator.next();
			TipoContactoBean tipoBean = 
				new TipoContactoBean(tipo.getIdTipoContacto().toString(), tipo.getNombre());
			listaTipoContactoBean.add(tipoBean);
		}
		return listaTipoContactoBean.toArray(new TipoContactoBean[listaTipoContactoBean.size()]);
	}

	public TipoContactoBean getTipoContacto(TipoContacto tipoContacto)
	{
		TipoContactoBean tipo = 
			new TipoContactoBean(tipoContacto.getIdTipoContacto().toString(), 
					tipoContacto.getNombre());
		return tipo;
	}
}
