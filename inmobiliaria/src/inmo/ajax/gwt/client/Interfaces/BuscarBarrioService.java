package inmo.ajax.gwt.client.Interfaces;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BuscarBarrioService {

	void getBarrios(AsyncCallback<BarrioBean[]> callback);
	
	void getBarrios(String idLocalidad, String idProvincia, String inicial, AsyncCallback<BarrioBean[]> callback);

	void getLocalidades(AsyncCallback<LocalidadBean[]> callback);
	
	void getLocalidades(String idProvincia, AsyncCallback<LocalidadBean[]> callback);

	void getProvincias(AsyncCallback<ProvinciaBean[]> callback);

	void getPagedBarrios(PagingLoadConfig loadConfig,
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
	
	void getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial, 
			AsyncCallback<PagingLoadResult<BaseTreeModel>> callback);
	
}
