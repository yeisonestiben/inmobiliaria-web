package inmo.ajax.gwt.client;

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

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarContratoLocacion")
public interface RegistrarContratoLocacionService extends RemoteService
{
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, TipoPersona tipoPersona);
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre, 
			TipoPersona tipoPersona);

	PagingLoadResult<BaseTreeModel> getPagedOrganizaciones(PagingLoadConfig 
			loadConfig);
	
	PagingLoadResult<BaseTreeModel> getPagedOrganizaciones(PagingLoadConfig 
	loadConfig, String nombre); 
	
	MonedaBean[] getMonedas();
	
	BarrioBean[] getBarrios();

	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, 
			String inicial);

	LocalidadBean[] getLocalidades();

	LocalidadBean[] getLocalidades(String idProvincia);

	ProvinciaBean[] getProvincias();

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig 
			loadConfig);

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, 
			String idLocalidad, String idProvincia, String inicial);
	
	PropietarioBean getPropietario (String idPropietario);
	
	PagingLoadResult<BaseTreeModel> getPagedInmuebles(PagingLoadConfig 
			loadConfig, String idPropietario, String idBarrio, String calle, 
			String numero, String idTipoPropiedad, 
			TipoDisponibilidadBean tipoDisponibilidad);
	
	TipoPropiedadBean[] getTipoPropiedades(); 
	
	PropiedadBean getPropiedad(String idPropiedad);
	
	ClienteBean getCliente(String idCliente);

	Bool sendContrato(String html);
}
