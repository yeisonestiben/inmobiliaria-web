package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.ConsultarViviendasService;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.gestores.GestorLocalidad;
import inmo.ajax.gwt.server.gestores.GestorMonedas;
import inmo.ajax.gwt.server.gestores.GestorPropiedad;
import inmo.ajax.gwt.server.gestores.GestorProvincia;
import inmo.ajax.gwt.server.gestores.GestorTipoDisponibilidad;
import inmo.ajax.gwt.server.gestores.GestorTipoPropiedad;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ConsultarViviendasServiceImpl extends RemoteServiceServlet
implements ConsultarViviendasService
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

	public TipoPropiedadBean[] getTipoPropiedades()
	{
		return new GestorTipoPropiedad().getTiposPropiedadBean();
	}

	public MonedaBean[] getMonedas()
	{
		return new GestorMonedas().getMonedasBean();
	}

	public TipoDisponibilidadBean[] getTiposDisponibilidad()
	{
		return new GestorTipoDisponibilidad().getTipoDisponibilidadesBean();
	}

	public BasePagingLoadResult<BaseTreeModel> getPagedPropiedades(
			PagingLoadConfig loadConfig, PropiedadBean propiedadBean,
			DisponibilidadBean disponibilidadBean, String montoDesde,
			String montoHasta, String antiguedad)
	{
		return new GestorPropiedad().getPagedPropiedades(loadConfig, propiedadBean, disponibilidadBean, montoDesde, montoHasta, antiguedad);
	}
}
