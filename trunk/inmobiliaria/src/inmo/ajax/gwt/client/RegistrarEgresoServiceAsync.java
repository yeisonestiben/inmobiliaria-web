package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.TipoComprobanteBean;
import inmo.ajax.gwt.client.db.TipoEgresoBean;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarEgresoServiceAsync
{

	void getMonedas(AsyncCallback<MonedaBean[]> callback);

	void getTiposComprobante(AsyncCallback<TipoComprobanteBean[]> callback);

	void getTiposEgreso(AsyncCallback<TipoEgresoBean[]> callback);

}
