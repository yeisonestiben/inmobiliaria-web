package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarContratoLocacionService;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorCliente;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorMonedas;
import inmo.ajax.gwt.server.gestores.GestorOrganizacion;
import inmo.ajax.gwt.server.gestores.GestorPersona;
import inmo.ajax.gwt.server.gestores.GestorPropiedad;
import inmo.ajax.gwt.server.gestores.GestorPropietario;
import inmo.ajax.gwt.server.gestores.GestorProvincia;
import inmo.ajax.gwt.server.gestores.GestorTipoPropiedad;

import javax.servlet.http.HttpSession;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarContratoLocacionServiceImpl extends RemoteServiceServlet  
implements RegistrarContratoLocacionService
{
	private static final long serialVersionUID = 1L;

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, TipoPersona tipoPersona)
	{
		return getPagedPersonas(loadConfig, "", "", tipoPersona);
	}

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre, TipoPersona tipoPersona)
	{
		if (tipoPersona == TipoPersona.TODOS)
		{
			return new GestorPersona().getPagedPersonas(loadConfig, apellido, 
					nombre);
		}
		else if (tipoPersona == TipoPersona.PROPIETARIO)
		{
			return new GestorPropietario().getPagedPropietarios(loadConfig, 
					apellido, nombre);
		}
		else
		{
			return new GestorCliente().getPagedClientes(loadConfig, apellido, 
					nombre);
		}
	}

	public MonedaBean[] getMonedas()
	{
		return new GestorMonedas().getMonedasBean();
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

	public PropietarioBean getPropietario(String idPropietario)
	{
		return new GestorPropietario().getPropietario(idPropietario);
	}

	public PagingLoadResult<BaseTreeModel> getPagedInmuebles(
			PagingLoadConfig loadConfig, String idPropietario, String idBarrio,
			String calle, String numero, String idTipoPropiedad, 
			TipoDisponibilidadBean tipoDisponibilidad)
	{
		return new GestorPropiedad().getPagedPropiedades(loadConfig, 
				idPropietario, idBarrio, calle, numero, idTipoPropiedad, 
				tipoDisponibilidad);
	}

	public TipoPropiedadBean[] getTipoPropiedades()
	{
		return new GestorTipoPropiedad().getTiposPropiedadBean();
	}

	public PropiedadBean getPropiedad(String idPropiedad)
	{
		return new GestorPropiedad().getPropiedad(idPropiedad);
	}

	public ClienteBean getCliente(String idCliente)
	{
		return new GestorCliente().getCliente(idCliente);
	}

	public Bool sendContrato(String html)
	{
		Bool lreturn = new Bool();
		HttpSession session = this.getThreadLocalRequest().getSession();
		session.setAttribute("contratoLocacion", html);
		lreturn.setValue(true);
		return lreturn;
	}

	public PagingLoadResult<BaseTreeModel> getPagedOrganizaciones(
			PagingLoadConfig loadConfig)
	{
		PagingLoadResult<BaseTreeModel> result = 
			new GestorOrganizacion().getPagedPersonas(loadConfig, "");
		return result;
	}

	public PagingLoadResult<BaseTreeModel> getPagedOrganizaciones(
			PagingLoadConfig loadConfig, String nombre)
	{
		return new GestorOrganizacion().getPagedPersonas(loadConfig, nombre);
	}
}
