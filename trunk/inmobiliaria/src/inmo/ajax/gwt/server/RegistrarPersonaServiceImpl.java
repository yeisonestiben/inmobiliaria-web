package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarPersonaService;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.EmpleadoBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoContactoBean;
import inmo.ajax.gwt.client.db.TipoDireccionBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.ajax.gwt.client.db.TipoEmpleadoBean;
import inmo.ajax.gwt.client.db.TituloBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorCliente;
import inmo.ajax.gwt.server.gestores.GestorEmpleado;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorPersona;
import inmo.ajax.gwt.server.gestores.GestorPropietario;
import inmo.ajax.gwt.server.gestores.GestorProvincia;
import inmo.ajax.gwt.server.gestores.GestorTipoContacto;
import inmo.ajax.gwt.server.gestores.GestorTipoDireccion;
import inmo.ajax.gwt.server.gestores.GestorTipoDocumento;
import inmo.ajax.gwt.server.gestores.GestorTipoEmpleado;
import inmo.ajax.gwt.server.gestores.GestorTitulo;
import inmo.db.Persona;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarPersonaServiceImpl extends RemoteServiceServlet 
implements RegistrarPersonaService
{	
	private static final long serialVersionUID = 1L;

	public TipoDocumentoBean[] getTipoDocumentos() 
	{
		return new GestorTipoDocumento().getTipoDocumentos();
	}
	
	public TipoEmpleadoBean[] getTiposEmpleado()
	{
		return new GestorTipoEmpleado().getTiposEmpleado();
	}

	public TituloBean[] getTitulos() {
		return new GestorTitulo().getTitulos();
	}

	public BarrioBean[] getBarrios() {
		return new GestorBarrio().getBarrios();
	}
	
	public BarrioBean[] getBarrios(String idLocalidad, String idProvincia,
			String inicial) 
	{
		BarrioBean[] barriosBean =  new GestorBarrio().getBarrios(idLocalidad,
				idProvincia, inicial);
		return barriosBean;
	}

	public LocalidadBean[] getLocalidades() {
		return new GestorLocalidad().getLocalidades();
	}
	
	public LocalidadBean[] getLocalidades(String idProvincia) {
		return new GestorLocalidad().getLocalidades(idProvincia);
	}

	public ProvinciaBean[] getProvincias() {
		return new GestorProvincia().getProvincias();
	}

	public TipoDireccionBean[] getTipoDirecciones() {
		return new GestorTipoDireccion().getDirecciones();
	}

	public TipoContactoBean[] getTipoContactos() {
		return new GestorTipoContacto().getTiposContacto();
	}

	public Bool savePersona(PersonaBean personaBean) {
		Bool lReturn  = new Bool(false);
		Persona persona = new GestorPersona().savePersona(personaBean);
		if (persona != null)
		{
			lReturn.setValue(true);
		}
		return lReturn;
	}

	public Bool savePropietario(PropietarioBean propietarioBean) {
		return new GestorPropietario().savePropietario(propietarioBean);
	}

	public Bool saveEmpleado(EmpleadoBean empleadoBean) {
		return new GestorEmpleado().saveEmpleado(empleadoBean);
	}

	public Bool saveCliente(ClienteBean clienteBean) {
		return new GestorCliente().saveCliente(clienteBean);
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
}
