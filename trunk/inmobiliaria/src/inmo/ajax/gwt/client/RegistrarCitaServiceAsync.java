package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.Interfaces.BuscarPersonaService;
import inmo.ajax.gwt.client.db.CitaBean;
import inmo.ajax.gwt.client.db.MotivoCitaBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarCitaServiceAsync 
extends BuscarPersonaService, BuscarBarrioService
{
	void saveCita(CitaBean cita, AsyncCallback<Bool> callback);

	void getMotivosCita(AsyncCallback<MotivoCitaBean[]> callback);
}
