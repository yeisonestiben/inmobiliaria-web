package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.ReclamoBean;
import inmo.ajax.gwt.client.db.TipoReclamoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarQueja")
public interface RegistrarQuejaService extends RemoteService
{

	TipoReclamoBean[] getTipoReclamos();
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, TipoPersona tipoPersona);
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre, TipoPersona tipoPersona);

	Bool saveReclamo(ReclamoBean reclamo);

}
