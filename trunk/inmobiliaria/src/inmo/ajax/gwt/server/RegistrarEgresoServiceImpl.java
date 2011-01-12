package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.RegistrarEgresoService;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.TipoComprobanteBean;
import inmo.ajax.gwt.client.db.TipoEgresoBean;
import inmo.ajax.gwt.server.gestores.GestorMonedas;
import inmo.ajax.gwt.server.gestores.GestorTipoComprobante;
import inmo.ajax.gwt.server.gestores.GestorTipoEgreso;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrarEgresoServiceImpl extends RemoteServiceServlet 
implements RegistrarEgresoService
{
	private static final long serialVersionUID = 1L;

	public MonedaBean[] getMonedas()
	{
		return new GestorMonedas().getMonedasBean();
	}

	public TipoComprobanteBean[] getTiposComprobante()
	{
		return new GestorTipoComprobante().getTiposComprobante();
	}

	public TipoEgresoBean[] getTiposEgreso()
	{
		return new GestorTipoEgreso().getTiposEgreso();
	}

}
