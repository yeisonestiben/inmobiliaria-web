package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarCobroAlquilerService;
import inmo.ajax.gwt.client.db.CobroAlquilerBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.server.gestores.GestorCliente;
import inmo.ajax.gwt.server.gestores.GestorCobroAlquiler;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarCobroAlquilerServiceImpl extends RemoteServiceServlet 
	implements RegistrarCobroAlquilerService
{
	private static final long serialVersionUID = 1L;

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, TipoPersona tipoPersona)
	{
		return new GestorCliente().getPagedClientes(loadConfig, "", "");
	}

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, String apellido, String nombre, TipoPersona tipoPersona)
	{
		return new GestorCliente().getPagedClientes(loadConfig, apellido, 
				nombre);
	}

	public PagingLoadResult<BaseTreeModel> getCobrosImpagosPorCliente(
			PagingLoadConfig loadConfig, String idCliente)
	{
		return new GestorCobroAlquiler().getCobrosImpagosPorCliente(loadConfig, 
				idCliente);
	}
	
	public Bool saveCobroAlquiler (CobroAlquilerBean[] cobros)
	{
		return new GestorCobroAlquiler().saveCobroAlquiler(cobros);
	}

	public PagingLoadResult<BaseTreeModel> getCobrosImpagosPorContrato(
			PagingLoadConfig loadConfig, String numeroContrato)
	{
		return new GestorCobroAlquiler().getCobrosImpagosPorContrato(loadConfig, 
				numeroContrato);
	}
}
