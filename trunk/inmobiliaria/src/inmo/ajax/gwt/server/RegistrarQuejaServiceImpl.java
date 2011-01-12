package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarQuejaService;
import inmo.ajax.gwt.client.db.ReclamoBean;
import inmo.ajax.gwt.client.db.TipoReclamoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.server.gestores.GestorPersona;
import inmo.ajax.gwt.server.gestores.GestorReclamo;
import inmo.ajax.gwt.server.gestores.GestorTipoReclamo;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarQuejaServiceImpl extends RemoteServiceServlet implements RegistrarQuejaService
{
	private static final long serialVersionUID = 1L;

	public TipoReclamoBean[] getTipoReclamos()
	{
		return new GestorTipoReclamo().getTiposReclamo();
	}
	
	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, TipoPersona tipoPersona)
	{
		return new GestorPersona().getPagedPersonas(loadConfig, "", "");
	}

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, String apellido, String nombre, 
			TipoPersona tipoPersona)
	{
		return new GestorPersona().getPagedPersonas(loadConfig, 
				apellido, nombre);
	}

	public Bool saveReclamo(ReclamoBean reclamo)
	{
		return new GestorReclamo().saveReclamo(reclamo);
	}
}
