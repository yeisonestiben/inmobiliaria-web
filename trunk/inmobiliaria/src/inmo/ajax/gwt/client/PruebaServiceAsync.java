package inmo.ajax.gwt.client;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Prueba")
public interface PruebaServiceAsync
{

	void getPagedBarrios(PagingLoadConfig loadConfig,
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);

	void getFileName(AsyncCallback<String> callback);
}
