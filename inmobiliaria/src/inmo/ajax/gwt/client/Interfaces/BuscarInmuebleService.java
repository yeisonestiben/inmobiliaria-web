package inmo.ajax.gwt.client.Interfaces;

import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface BuscarInmuebleService extends BuscarBarrioService, 
BuscarPersonaService, BuscarOrganizacionService
{
	void getPropietario(String idPropietario, 
			AsyncCallback<PropietarioBean> callback);
	
	void getCliente(String idPropietario, AsyncCallback<ClienteBean> callback);

	void getPagedInmuebles(PagingLoadConfig loadConfig, String idPropietario,
			String idBarrio, String calle, String numero, 
			String idTipoPropiedad, TipoDisponibilidadBean tipoDisponibilidad,
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);

	void getTipoPropiedades(AsyncCallback<TipoPropiedadBean[]> callback);

	void getPropiedad(String id, AsyncCallback<PropiedadBean> callback);
}
