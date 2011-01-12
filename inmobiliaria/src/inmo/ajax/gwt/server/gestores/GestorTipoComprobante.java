package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoComprobanteBean;
import inmo.db.TipoComprobante;
import inmo.db.TipoComprobanteDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class GestorTipoComprobante
{
	public TipoComprobanteBean[] getTiposComprobante()
	{

		List<TipoComprobante> listTipos = new TipoComprobanteDAO().findAll();
		Collections.sort(listTipos);
		List<TipoComprobanteBean> listTiposBean = 
			new ArrayList<TipoComprobanteBean>();

		for (TipoComprobante tipo : listTipos)
		{
			TipoComprobanteBean bean = new TipoComprobanteBean(
					String.valueOf(tipo.getIdTipoComprobante()), 
					tipo.getNombre(),tipo.getDescripcion());
			listTiposBean.add(bean);
		}
		return listTiposBean.toArray(
				new TipoComprobanteBean[listTiposBean.size()]);
	}
}
