package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.EventoBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoEventoBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarEvento")
public interface RegistrarEventoService extends RemoteService
{
	BarrioBean[] getBarrios();

	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial);

	LocalidadBean[] getLocalidades();

	LocalidadBean[] getLocalidades(String idProvincia);

	ProvinciaBean[] getProvincias();

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial);

	TipoEventoBean[] getTipoEventos();

	Bool saveEvento(EventoBean evento);
}
