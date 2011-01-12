package inmo.ajax.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MenuPrincipal implements EntryPoint {
	
	public void onModuleLoad() {

		// Make some sub-menus that we will cascade from the top menu.
		MenuBar menuInicio = new MenuBar(true);
		menuInicio.addItem("Cerrar Sesión", crearEnlace("mything"));

		MenuBar menuMovimientos = new MenuBar(true);
		MenuBar menuCobros = new MenuBar(true);
		menuCobros.addItem("Alquiler", crearEnlace("/inmobiliaria/action/" +
				"CargaRegistrarCobroAlquiler.do"));
		menuCobros.addItem("Venta", crearEnlace("mything"));
		menuMovimientos.addItem("Registrar Ingreso", crearEnlace("mything"));
		menuMovimientos.addItem("Registrar Egreso", crearEnlace("/inmobiliaria/" +
				"action/CargaRegistrarEgresos.do"));
		menuMovimientos.addItem("Registrar Cobro", menuCobros);

		MenuBar menuPropiedades = new MenuBar(true);
		menuPropiedades.addItem("Nueva Propiedad", crearEnlace("/inmobiliaria/" +
				"action/CargaRegistrarPropiedades.do"));
		menuPropiedades.addItem("Buscar Propiedad", crearEnlace("/inmobiliaria/" +
				"action/CargaConsultarPropiedades.do"));
		MenuBar menuDisponibilidad = new MenuBar(true);
		menuDisponibilidad.addItem("Alquileres", crearEnlace("mything"));
		menuDisponibilidad.addItem("Ventas", crearEnlace("mything"));
		menuPropiedades.addItem("Disponibilidad", menuDisponibilidad);

		MenuBar menuAgenda = new MenuBar(true);
		MenuBar menuCita = new MenuBar(true);
		menuCita.addItem("Agendar Cita", crearEnlace("/inmobiliaria/action/" +
				"CargaRegistrarCitas.do"));
		menuCita.addItem("Buscar Cita", crearEnlace("mything"));
		menuAgenda.addItem("Citas", menuCita);
		MenuBar menuEvento = new MenuBar(true);
		menuEvento.addItem("Agendar Evento", crearEnlace("/inmobiliaria/" +
				"action/CargaRegistrarEventos.do"));
		menuEvento.addItem("Buscar Evento", crearEnlace("mything"));
		menuAgenda.addItem("Eventos", menuEvento);
		
		MenuBar menuContratos = new MenuBar(true);
		menuContratos.addItem("Buscar", crearEnlace("mything"));
		menuContratos.addItem("Nuevo", crearEnlace("/inmobiliaria/pages/altas/registrarContratoLocacion.jsp"));
		
		MenuBar menuReclamos = new MenuBar(true);
		menuReclamos.addItem("Nuevo", crearEnlace("/inmobiliaria/action/" +
				"CargaRegistrarQuejas.do"));
		menuReclamos.addItem("Seguir", crearEnlace("mything"));
		menuReclamos.addItem("Buscar", crearEnlace("mything"));
		
		MenuBar menuPersonas = new MenuBar(true);
		menuPersonas.addItem("Nuevo", crearEnlace("/inmobiliaria/action/" +
				"CargaRegistrarPersonas.do"));
		menuPersonas.addItem("Buscar", crearEnlace("mything"));
		
		MenuBar menuReportes = new MenuBar(true);
		menuReportes.addItem("Reporte de Ingresos", crearEnlace("mything"));

		// Make a new menu bar, adding a few cascading menus to it.
		MenuBar menu = new MenuBar();
		menu.addItem("Inicio", menuInicio);
		menu.addItem("Movimientos", menuMovimientos);
		menu.addItem("Propiedades", menuPropiedades);
		menu.addItem("Agenda", menuAgenda);
		menu.addItem("Contratos", menuContratos);
		menu.addItem("Reclamos", menuReclamos);
		menu.addItem("Personas", menuPersonas);
		menu.addItem("Reportes", menuReportes);

		// Add it to the root panel.
		RootPanel.get("menuPrincipal").add(menu);
	}
	private Command crearEnlace (String url)
	{
		final String URL = url;
		Command cmd = new Command() {
			public void execute() {
				redirect(URL); 
			}
		};
		return cmd;
	}
	private void redirect (String url)
	{
		Window.open(url, "_self", "");
	}
	 
	/*native void redirect(String url)
	/*-{
	        $wnd.location.replace(url);
	}-*/; 
}
