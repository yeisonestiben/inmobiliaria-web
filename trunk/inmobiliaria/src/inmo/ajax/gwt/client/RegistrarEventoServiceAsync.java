package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.db.EventoBean;
import inmo.ajax.gwt.client.db.TipoEventoBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarEventoServiceAsync extends BuscarBarrioService
{

	void getTipoEventos(AsyncCallback<TipoEventoBean[]> callback);

	void saveEvento(EventoBean evento, AsyncCallback<Bool> callback);

}
