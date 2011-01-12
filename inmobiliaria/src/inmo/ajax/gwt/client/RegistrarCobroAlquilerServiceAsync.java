package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarPersonaService;
import inmo.ajax.gwt.client.db.CobroAlquilerBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarCobroAlquilerServiceAsync extends BuscarPersonaService
{
	void getCobrosImpagosPorCliente(PagingLoadConfig loadConfig,
			String idCliente, AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);

	void getCobrosImpagosPorContrato(PagingLoadConfig loadConfig,
			String numeroContrato, AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
	
	void saveCobroAlquiler(CobroAlquilerBean[] cobrosBean,
			AsyncCallback<Bool> callback);

}
