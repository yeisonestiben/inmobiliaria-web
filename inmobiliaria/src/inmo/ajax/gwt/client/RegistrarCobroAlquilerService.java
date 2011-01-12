package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.CobroAlquilerBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarCobroAlquiler")
public interface RegistrarCobroAlquilerService extends RemoteService
{
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, TipoPersona tipoPersona);
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre, TipoPersona tipoPersona);

	PagingLoadResult<BaseTreeModel> getCobrosImpagosPorCliente(PagingLoadConfig 
			loadConfig, String idCliente);
	
	Bool saveCobroAlquiler (CobroAlquilerBean[] cobrosBean);

	PagingLoadResult<BaseTreeModel> getCobrosImpagosPorContrato(
			PagingLoadConfig loadConfig, String numeroContrato);
}
