package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarCitaService;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.CitaBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MotivoCitaBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorCita;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorMotivoCita;
import inmo.ajax.gwt.server.gestores.GestorPersona;
import inmo.ajax.gwt.server.gestores.GestorProvincia;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarCitaServiceImpl extends RemoteServiceServlet
implements RegistrarCitaService
{
	private static final long serialVersionUID = 1L;

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, TipoPersona tipoPersona)
	{
		return new GestorPersona().getPagedPersonas(loadConfig, "", "");
	}

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, String apellido, String nombre, TipoPersona tipoPersona)
	{
		return new GestorPersona().getPagedPersonas(loadConfig, apellido, 
				nombre);
	}

	public BarrioBean[] getBarrios()
	{
		return new GestorBarrio().getBarrios();
	}

	public BarrioBean[] getBarrios(String idLocalidad, String idProvincia,
			String inicial)
	{
		return new GestorBarrio().getBarrios(idLocalidad, idProvincia, inicial);
	}

	public LocalidadBean[] getLocalidades()
	{
		return new GestorLocalidad().getLocalidades();
	}

	public LocalidadBean[] getLocalidades(String idProvincia)
	{
		return new GestorLocalidad().getLocalidades(idProvincia);
	}

	public ProvinciaBean[] getProvincias()
	{
		return new GestorProvincia().getProvincias();
	}

	public PagingLoadResult<BaseTreeModel> getPagedBarrios(
			PagingLoadConfig loadConfig)
	{
		return new GestorBarrio().getPagedBarrios(loadConfig);
	}

	public PagingLoadResult<BaseTreeModel> getPagedBarrios(
			PagingLoadConfig loadConfig, String idLocalidad,
			String idProvincia, String inicial)
	{
		return new GestorBarrio().getPagedBarrios(loadConfig, idLocalidad, 
				idProvincia, inicial);
	}

	public Bool saveCita(CitaBean cita)
	{
		return new GestorCita().saveCita(cita);
	}

	public MotivoCitaBean[] getMotivosCita()
	{
		return new GestorMotivoCita().getMotivosCita();
	}

}
