package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarEventoService;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.EventoBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoEventoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorEvento;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorProvincia;
import inmo.ajax.gwt.server.gestores.GestorTipoEvento;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarEventoServiceImpl extends RemoteServiceServlet 
implements RegistrarEventoService
{
	private static final long serialVersionUID = 1L;

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
		return new GestorBarrio().getPagedBarrios(loadConfig, idLocalidad, idProvincia, inicial);
	}

	public TipoEventoBean[] getTipoEventos()
	{
		return new GestorTipoEvento().getTiposContacto();
	}

	public Bool saveEvento(EventoBean evento)
	{
		return new GestorEvento().saveEvento(evento);
	}

}
