package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ConsultarVivienda")
public interface ConsultarViviendasService extends RemoteService
{
	BarrioBean[] getBarrios();

	BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial);

	LocalidadBean[] getLocalidades();

	LocalidadBean[] getLocalidades(String idProvincia);

	ProvinciaBean[] getProvincias();

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig);

	PagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial);

	TipoPropiedadBean[] getTipoPropiedades();

	MonedaBean[] getMonedas();

	TipoDisponibilidadBean[] getTiposDisponibilidad();

	BasePagingLoadResult<BaseTreeModel> getPagedPropiedades(
			PagingLoadConfig loadConfig, PropiedadBean propiedadBean,
			DisponibilidadBean disponibilidadBean, String montoDesde,
			String montoHasta, String antiguedad);
}
