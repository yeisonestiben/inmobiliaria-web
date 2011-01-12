package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.PruebaService;
import inmo.ajax.gwt.server.gestores.GestorBarrio;
import inmo.ajax.gwt.server.reportes.ReportePrueba;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PruebaServiceImpl extends RemoteServiceServlet implements PruebaService
{
	private static final long serialVersionUID = 1L;

	public PagingLoadResult<BaseTreeModel> getPagedBarrios(
			PagingLoadConfig loadConfig)
	{
		return new GestorBarrio().getPagedBarrios(loadConfig);
	}

	public String getFileName()
	{
//		TipoDireccionBean tipoDireccion = new TipoDireccionBean("1", "");
//		BarrioBean barrio = new BarrioBean("1", null, "");
//		DireccionBean direccion = new DireccionBean("", tipoDireccion, barrio, "Humberto 1°", "650", "3", "", "5000");
//		TipoContactoBean tipoContacto = new TipoContactoBean("1", "");
//		ContactoBean contacto = new ContactoBean("", tipoContacto, "4519764");
//		ContactoBean[] contactos = new ContactoBean[1];
//		contactos[0] = contacto;
//		OrganizacionBean organizacion = new OrganizacionBean("", "Globant", direccion, contactos);
//		
//		new GestorOrganizacion().saveOrganizacion(organizacion);
		return new ReportePrueba().generarReporte(getServletContext().getRealPath("/"));
	}
}
