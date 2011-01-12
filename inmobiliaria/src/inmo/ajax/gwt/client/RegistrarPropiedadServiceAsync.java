package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.Interfaces.BuscarPersonaService;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.EstadoPropiedadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarPropiedadServiceAsync extends BuscarBarrioService, BuscarPersonaService
{
	void getTipoPropiedades(AsyncCallback<TipoPropiedadBean[]> callback);

	void getEstadoPropiedad(AsyncCallback<EstadoPropiedadBean[]> callback);

	void getMonedas(AsyncCallback<MonedaBean[]> callback);

	void getTiposDisponibilidad(AsyncCallback<TipoDisponibilidadBean[]> callback);

	void savePropiedad(PropiedadBean propiedad,
			DisponibilidadBean disponibilidad, AsyncCallback<Bool> callback);
}
