package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarInmuebleService;
import inmo.ajax.gwt.client.Interfaces.BuscarOrganizacionService;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarContratoLocacionServiceAsync 
extends BuscarOrganizacionService, BuscarInmuebleService
{

	void getMonedas(AsyncCallback<MonedaBean[]> callback);

	void sendContrato(String html, AsyncCallback<Bool> callback);

}
