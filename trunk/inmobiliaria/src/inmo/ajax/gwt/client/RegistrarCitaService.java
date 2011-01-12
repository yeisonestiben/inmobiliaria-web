package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.CitaBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MotivoCitaBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarCita")
public interface RegistrarCitaService extends RemoteService
{
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, TipoPersona tipoPersona);

	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre, TipoPersona tipoPersona);

	BarrioBean[] getBarrios();

	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial);

	LocalidadBean[] getLocalidades();

	LocalidadBean[] getLocalidades(String idProvincia);

	ProvinciaBean[] getProvincias();

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial);

	Bool saveCita(CitaBean cita);

	MotivoCitaBean[] getMotivosCita();
}
