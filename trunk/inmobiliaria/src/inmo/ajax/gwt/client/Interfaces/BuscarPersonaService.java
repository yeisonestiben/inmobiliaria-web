package inmo.ajax.gwt.client.Interfaces;

import inmo.ajax.gwt.client.utils.TipoPersona;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BuscarPersonaService
{
	void getPagedPersonas(PagingLoadConfig loadConfig, String apellido, String
			nombres, TipoPersona tipoPersona, 
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);

	void getPagedPersonas(PagingLoadConfig loadConfig, TipoPersona tipoPersona,
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
}