package inmo.ajax.gwt.client;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Prueba")
public interface PruebaService extends RemoteService
{
	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);

	String getFileName();	
}
