package inmo.ajax.gwt.client.Interfaces;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BuscarOrganizacionService
{
	void getPagedOrganizaciones(PagingLoadConfig loadConfig, 
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
	
	void getPagedOrganizaciones(PagingLoadConfig loadConfig, String nombre, 
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
}
