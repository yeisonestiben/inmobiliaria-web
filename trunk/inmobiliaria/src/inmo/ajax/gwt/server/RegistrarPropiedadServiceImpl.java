package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarPropiedadService;
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
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorEstadoPropiedad;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorMonedas;
import inmo.ajax.gwt.server.gestores.GestorPropiedad;
import inmo.ajax.gwt.server.gestores.GestorPropietario;
import inmo.ajax.gwt.server.gestores.GestorProvincia;
import inmo.ajax.gwt.server.gestores.GestorTipoDisponibilidad;
import inmo.ajax.gwt.server.gestores.GestorTipoPropiedad;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarPropiedadServiceImpl extends RemoteServiceServlet 
implements RegistrarPropiedadService
{
	private static final long serialVersionUID = 1L;

	public BarrioBean[] getBarrios() 
	{
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

	public TipoPropiedadBean[] getTipoPropiedades()
	{
		return new GestorTipoPropiedad().getTiposPropiedadBean();
	}

	public EstadoPropiedadBean[] getEstadoPropiedad()
	{
		return new GestorEstadoPropiedad().getEstadosPropiedadBean();
	}

	public MonedaBean[] getMonedas()
	{
		return new GestorMonedas().getMonedasBean();
	}

	public TipoDisponibilidadBean[] getTiposDisponibilidad()
	{
		return new GestorTipoDisponibilidad().getTipoDisponibilidadesBean();
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

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, TipoPersona tipoPersona)
	{
		return new GestorPropietario().getPagedPropietarios(loadConfig, "", "");
	}

	public PagingLoadResult<BaseTreeModel> getPagedPersonas(
			PagingLoadConfig loadConfig, String apellido, String nombre, 
			TipoPersona tipoPersona)
	{
		return new GestorPropietario().getPagedPropietarios(loadConfig, 
				apellido, nombre);
	}

	public Bool savePropiedad(PropiedadBean propiedad,
			DisponibilidadBean disponibilidad)
	{
		return new GestorPropiedad().savePropiedad(propiedad, disponibilidad);
	}
}
