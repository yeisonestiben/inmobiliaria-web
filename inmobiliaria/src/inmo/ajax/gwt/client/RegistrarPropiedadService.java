package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.EstadoPropiedadBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
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

@RemoteServiceRelativePath("AdministrarPropiedad")
public interface RegistrarPropiedadService extends RemoteService
{
	TipoPropiedadBean[] getTipoPropiedades(); 
	
	BarrioBean[] getBarrios();
	
	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial);
	
	LocalidadBean[] getLocalidades();
	
	LocalidadBean[] getLocalidades(String idProvincia);
	
	ProvinciaBean[] getProvincias();

	EstadoPropiedadBean[] getEstadoPropiedad();

	MonedaBean[] getMonedas();

	TipoDisponibilidadBean[] getTiposDisponibilidad();
	
	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);
	
	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial);
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig loadConfig, TipoPersona tipoPersona);
	
	PagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig loadConfig, String apellido, String nombre, TipoPersona tipoPersona);

	Bool savePropiedad(PropiedadBean propiedad,
			DisponibilidadBean disponibilidad);
	
}
