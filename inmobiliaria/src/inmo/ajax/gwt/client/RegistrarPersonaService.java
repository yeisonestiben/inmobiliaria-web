package inmo.ajax.gwt.client;

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

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarPersona")
public interface RegistrarPersonaService extends RemoteService 
{
	TipoDocumentoBean[] getTipoDocumentos();
	
	TipoEmpleadoBean[] getTiposEmpleado();
	
	TituloBean[] getTitulos();
	
	BarrioBean[] getBarrios();
	
	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial);
	
	LocalidadBean[] getLocalidades();
	
	LocalidadBean[] getLocalidades(String idProvincia);
	
	ProvinciaBean[] getProvincias();

	TipoDireccionBean[] getTipoDirecciones();

	TipoContactoBean[] getTipoContactos();

	Bool savePersona(PersonaBean persona);

	Bool savePropietario(PropietarioBean propietario);

	Bool saveEmpleado(EmpleadoBean empleado);

	Bool saveCliente(ClienteBean cliente);
	
	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);
	
	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial);
}
