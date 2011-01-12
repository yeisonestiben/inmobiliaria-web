package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.TipoComprobanteBean;
import inmo.ajax.gwt.client.db.TipoEgresoBean;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdministrarEgreso")
public interface RegistrarEgresoService extends RemoteService
{

	MonedaBean[] getMonedas();

	TipoComprobanteBean[] getTiposComprobante();

	TipoEgresoBean[] getTiposEgreso();

}
