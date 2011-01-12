package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.db.TipoPropiedad;
import inmo.db.TipoPropiedadDAO;

import java.util.ArrayList;
import java.util.List;

public class GestorTipoPropiedad
{
	public TipoPropiedadBean[] getTiposPropiedadBean()
	{
		@SuppressWarnings("unchecked")
		List<TipoPropiedad> listTipoPropiedad = new TipoPropiedadDAO().findAll();
		
		List<TipoPropiedadBean> listTipoPropiedadBean = new ArrayList<TipoPropiedadBean>();
		
		for (TipoPropiedad tipoPropiedad : listTipoPropiedad)
		{
			TipoPropiedadBean tipoPropiedadBean = 
				new TipoPropiedadBean(tipoPropiedad.getIdTipoPropiedad().toString(),
						tipoPropiedad.getNombre(), tipoPropiedad.getNombre());
			listTipoPropiedadBean.add(tipoPropiedadBean);
		}
		return listTipoPropiedadBean.toArray(
				new TipoPropiedadBean[listTipoPropiedadBean.size()]);
	}

	public TipoPropiedadBean getTipoPropiedad(TipoPropiedad tipoPropiedad)
	{
		String idTipoPropiedad = tipoPropiedad.getIdTipoPropiedad().toString();
		String nombre = tipoPropiedad.getNombre();
		String descripcion = tipoPropiedad.getDescripcion();
		TipoPropiedadBean tipoPropiedadBean = new TipoPropiedadBean(idTipoPropiedad, nombre, descripcion);
		return tipoPropiedadBean;
	}
}
