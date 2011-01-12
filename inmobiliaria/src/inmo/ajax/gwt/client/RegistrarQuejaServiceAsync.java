package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarPersonaService;
import inmo.ajax.gwt.client.db.ReclamoBean;
import inmo.ajax.gwt.client.db.TipoReclamoBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarQuejaServiceAsync extends BuscarPersonaService
{

	void getTipoReclamos(AsyncCallback<TipoReclamoBean[]> callback);

	void saveReclamo(ReclamoBean reclamo, AsyncCallback<Bool> callback);

}
