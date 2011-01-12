package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ConsultarViviendasServiceAsync
extends BuscarBarrioService
{

	void getTipoPropiedades(AsyncCallback<TipoPropiedadBean[]> callback);

	void getMonedas(AsyncCallback<MonedaBean[]> callback);

	void getTiposDisponibilidad(AsyncCallback<TipoDisponibilidadBean[]> callback);

	void getPagedPropiedades(PagingLoadConfig loadConfig, PropiedadBean propiedadBean,
			DisponibilidadBean disponibilidadBean, String montoDesde,
			String montoHasta, String antiguedad,
			AsyncCallback<BasePagingLoadResult<BaseTreeModel>> callback);
}
