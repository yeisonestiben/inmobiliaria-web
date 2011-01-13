package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarBarrio;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.EmpleadoBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoContactoBean;
import inmo.ajax.gwt.client.db.TipoDireccionBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.ajax.gwt.client.db.TipoEmpleadoBean;
import inmo.ajax.gwt.client.db.TituloBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarPersona extends Registro implements EntryPoint
{

	private RegistrarPersonaServiceAsync registrarPersonaSvc = 
		GWT.create(RegistrarPersonaService.class);
	
	//Mensajes de Error
	VerticalPanel panelErrores = new VerticalPanel();
	MensajeError errorNombre;
	MensajeError errorApellido;
	MensajeError errorNumeroDocumento;
	MensajeError errorDireccion;
	MensajeError errorContacto;

	//Tipo de Persona
	final ListBox listTipoPersona = new ListBox();
	final ListBox listTipoEmpleado = new ListBox();
	final ListBox listTitulo = new ListBox();
	private FlexTable tablaTipoPersona = new FlexTable();
	private Button botonAgregarTitulo = new Button("Agregar");
	private HorizontalPanel panelTitulo = new HorizontalPanel();
	private ArrayList<String> titulos = new ArrayList<String>();
	final ContentPanel panelGrillaTitulos = new ContentPanel();
	private Grid<BaseTreeModel> gridTitulos;
	private ColumnModel columnModelTitulos;
	private ListStore<BaseTreeModel> storeTitulos;
	
	//Datos Personales
	FlexTable tablaDatosPersonales = new FlexTable();
	final TextBox textoNombres = new TextBox();
	final TextBox textoApellido = new TextBox();
	final TextBox textoDocumento = new TextBox();
	final ListBox listTipoDocumento = new ListBox();
	
	//Direcciones
	final FlexTable tablaDatos = new FlexTable();
	final TextBox textCalle = new TextBox();
	final TextBox textNumero = new TextBox();
	final TextBox textPiso = new TextBox();
	final TextBox textDepartamento = new TextBox();
	final TextBox textBarrio = new TextBox();
	final TextBox textLocalidad = new TextBox();
	final TextBox textProvincia = new TextBox();
	final TextBox textCodigoPostal = new TextBox();
	final Button btnBuscarBarrio = new Button();
	final Button agregarDireccion = new Button();	
	final ListBox listTipoDireccion = new ListBox();
	private Hidden hiddenIdBarrio = new Hidden();
	private ArrayList<String> direcciones = new ArrayList<String>();
	final BuscarBarrio dialogBuscarBarrio = new BuscarBarrio(hiddenIdBarrio, 
			textBarrio, textLocalidad, textProvincia, registrarPersonaSvc);
	final ContentPanel panelGrillaDirecciones = new ContentPanel();
	private Grid<BaseTreeModel> gridDirecciones;
	private ColumnModel columnModelDirecciones;
	private ListStore<BaseTreeModel> storeDirecciones;
	
	//Contactos
	final FlexTable tablaContactos = new FlexTable();
	final TextBox textContacto = new TextBox();
	final ListBox listaTipoContactos = new ListBox();
	final Button botonAgregarContactos = new Button();
	final ContentPanel panelGrillaContactos = new ContentPanel();
	private Grid<BaseTreeModel> gridContactos;
	private ColumnModel columnModelContactos;
	
	private ListStore<BaseTreeModel> storeContactos;
	private ArrayList<String> contactos = new ArrayList<String>();
	
	//Boton Submit	
	Submit submit = new Submit("Aceptar");
	
	public void onModuleLoad() 
	{	
		/**
		 * Inicializo los paneles a Agregar
		 */
		completarPanelErrores();
		completarPanelTipoPersona();
		completarPanelTitulosAgregados();
		completarPanelDatosPersonales();
		completarPanelDirecciones();
		completarPanelDireccionesAgregadas();
		completarPanelContactos();
		completarPanelContactosAgregados();
		completarPanelSubmit();
	
		/**
		 * Acá agrego los paneles a las JSP
		 */
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("seleccionarTipoPersona").add(tablaTipoPersona);
		RootPanel.get("titulosAgregados").add(panelGrillaTitulos);
		RootPanel.get("datosPersonales").add(tablaDatosPersonales);
		RootPanel.get("altaDomicilios").add(tablaDatos);
		RootPanel.get("domiciliosAgregados").add(panelGrillaDirecciones);
		RootPanel.get("altaContactos").add(tablaContactos);
		RootPanel.get("contactosAgregados").add(panelGrillaContactos);
		RootPanel.get("submit").add(submit);
	}
	
	private void completarPanelTipoPersona ()
	{
		tablaTipoPersona.setText(0, 0, "Tipo de Persona: ");
		tablaTipoPersona.setWidget(0, 1, listTipoPersona);

		listTipoPersona.addItem("Cliente", "0");
		listTipoPersona.addItem("Propietario", "1");
		listTipoPersona.addItem("Empleado", "2");
		
		completarComboTipoEmpleado(listTipoEmpleado);
		completarComboTitulos();
		
		botonAgregarTitulo.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				agregarTitulo();				
			}
		});
		
		panelTitulo.add(listTitulo);
		panelTitulo.add (botonAgregarTitulo);
		
		listTipoPersona.addChangeHandler(new ChangeHandler() {
			
			public void onChange(ChangeEvent event) {
				if (listTipoPersona.getSelectedIndex()==2)
				{
					tablaTipoPersona.setText(1, 0, "Tipo de Empleado: ");
					tablaTipoPersona.setWidget(1, 1, listTipoEmpleado);
					tablaTipoPersona.setText(1, 2, "Título: ");
					tablaTipoPersona.setWidget(1, 3, panelTitulo);
				}
				else
				{
					tablaTipoPersona.removeRow(1);
					
					storeTitulos.removeAll();
					panelGrillaTitulos.setVisible(false);
					
					titulos = new ArrayList<String>();
				}
			}
		});
	}
	
	private void completarPanelDatosPersonales()
	{
		tablaDatosPersonales.setText(0, 0, "Nombres: ");
		tablaDatosPersonales.setText(0, 2, "Apellido: ");
		tablaDatosPersonales.setText(1, 0, "Tipo Documento: ");
		tablaDatosPersonales.setText(1, 2, "Numero Documento: ");
		tablaDatosPersonales.setWidget(0, 1, textoNombres);
		tablaDatosPersonales.setWidget(0, 3, textoApellido);
		tablaDatosPersonales.setWidget(1, 1, listTipoDocumento);
		tablaDatosPersonales.setWidget(1, 3, textoDocumento);
		
		completarComboTipoDocumento();
	}
	
	private void completarPanelDirecciones()
	{
		completarComboTipoDireccion();
		
		btnBuscarBarrio.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				dialogBuscarBarrio.showDialog();		
			}
		});
		
		agregarDireccion.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				agregarDireccion();
			}
		});
		
		btnBuscarBarrio.setText("...");
		
		agregarDireccion.setText("Agregar");
		
		textBarrio.setReadOnly(true);
		textLocalidad.setReadOnly(true);
		textProvincia.setReadOnly(true);
		
		tablaDatos.setText(0, 0, "Calle: ");
		tablaDatos.setText(0, 3, "Número: ");
		tablaDatos.setText(1, 0, "Piso: ");
		tablaDatos.setText(1, 3, "Departamento: ");
		tablaDatos.setText(2, 0, "Barrio: ");
		tablaDatos.setText(2, 3, "Tipo Direccion: ");
		tablaDatos.setText(3, 0, "Localidad: ");
		tablaDatos.setText(3, 3, "Provincia: ");
		tablaDatos.setText(4, 0, "Código Postal: ");
		tablaDatos.setWidget(0, 1, textCalle);
		tablaDatos.setWidget(0, 4, textNumero);
		tablaDatos.setWidget(1, 1, textPiso);
		tablaDatos.setWidget(1, 4, textDepartamento);
		tablaDatos.setWidget(2, 1, textBarrio);
		tablaDatos.setWidget(2, 2, btnBuscarBarrio);
		tablaDatos.setWidget(2, 4, listTipoDireccion);
		tablaDatos.setWidget(3, 1, textLocalidad);
		tablaDatos.setWidget(3, 4, textProvincia);
		tablaDatos.setWidget(4, 1, textCodigoPostal);
		tablaDatos.setWidget(5, 4, agregarDireccion);		
	}
	
	private void completarPanelDireccionesAgregadas()
	{
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		
		GridCellRenderer<BaseTreeModel> eliminarRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{

			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{
				final ListStore<BaseTreeModel> s = store;
				final BaseTreeModel m = model;
				final Grid<BaseTreeModel> g = grid;
				com.extjs.gxt.ui.client.widget.button.Button b = 
					new com.extjs.gxt.ui.client.widget.button.Button("Eliminar", 
							new SelectionListener<ButtonEvent>() {  
					@Override  
					public void componentSelected(ButtonEvent ce) {   
						s.remove(m);
						g.reconfigure(s, columnModelDirecciones);
						
						String calle = m.get("calle");
						String numero = m.get("numero");
						String piso = m.get("piso");
						String departamento = m.get("departamento");
						String barrio = m.get("barrio");
						String localidad = m.get("localidad");
						String provincia = m.get("provincia");
						String tipoDireccion = m.get("tipoDireccion");
						String cpp = m.get("cpp");
						
						final String direccion = calle+numero+piso+departamento+
							barrio+localidad+provincia+tipoDireccion+cpp;
						
						int removedIndex = direcciones.indexOf(direccion);
						direcciones.remove(removedIndex);

						if (direcciones.size() == 0)
						{
							panelGrillaDirecciones.setVisible(false);
						}
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;  
			}
		};		
		
		ColumnConfig eliminarColunm = new ColumnConfig("eliminar", "Eliminar",60);
		eliminarColunm.setRenderer(eliminarRenderer);
		columns.add(eliminarColunm);
		columns.add (new ColumnConfig("calle", "Calle", 120));
		columns.add (new ColumnConfig("numero", "Número", 50));
		columns.add (new ColumnConfig("piso", "Piso", 40));
		columns.add (new ColumnConfig("departamento", "Departamento", 80));
		columns.add (new ColumnConfig("barrio", "Barrio", 120));
		columns.add (new ColumnConfig("localidad", "Localidad", 120));
		columns.add (new ColumnConfig("provincia", "Provincia", 120));
		columns.add (new ColumnConfig("tipoDireccion", "Tipo Direccion", 90));
		columns.add (new ColumnConfig("cpp", "Código Postal", 90));

		storeDirecciones = new ListStore<BaseTreeModel>();
		
		columnModelDirecciones = new ColumnModel(columns);
		
		gridDirecciones = new Grid<BaseTreeModel>(storeDirecciones, 
				columnModelDirecciones);
		gridDirecciones.setLoadMask(true);  
		gridDirecciones.setBorders(true);  
		
		panelGrillaDirecciones.setVisible(false);
		panelGrillaDirecciones.setFrame(true);   
		panelGrillaDirecciones.setBorders(true);
		panelGrillaDirecciones.setHeading("Direcciones Agregadas");  
		panelGrillaDirecciones.setLayout(new FitLayout());  
		panelGrillaDirecciones.add(gridDirecciones);  
//		panelGrillaDirecciones.setSize(400, 150);
		panelGrillaDirecciones.setHeight(150);
	}
	
	private void completarPanelContactos()
	{
		completarComboTipoContacto();
		
		botonAgregarContactos.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				agregarContacto();
			}
		});
		
		botonAgregarContactos.setText("Agregar");
		
		tablaContactos.setText(0, 0, "TipoContacto: ");
		tablaContactos.setText(0, 2, "Contacto: ");
		tablaContactos.setWidget(0, 1, listaTipoContactos);
		tablaContactos.setWidget(0, 3, textContacto);
		tablaContactos.setWidget(0, 4, botonAgregarContactos);
	}
	
	private void completarPanelContactosAgregados ()
	{
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		
		GridCellRenderer<BaseTreeModel> eliminarRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{

			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{
				final ListStore<BaseTreeModel> s = store;
				final BaseTreeModel m = model;
				final Grid<BaseTreeModel> g = grid;
				com.extjs.gxt.ui.client.widget.button.Button b = 
					new com.extjs.gxt.ui.client.widget.button.Button("Eliminar", 
							new SelectionListener<ButtonEvent>() {  
					@Override  
					public void componentSelected(ButtonEvent ce) {   
						s.remove(m);
						g.reconfigure(s, columnModelContactos);
						
						String idTipoContacto = m.get("idTipo");
						String nombreTipoContacto = m.get("tipoContacto");
						String contacto = m.get("contacto");
						
						String contactoCompleto = 
							(idTipoContacto+nombreTipoContacto+contacto).toLowerCase();
						
						int removedIndex = contactos.indexOf(contactoCompleto);
						contactos.remove(removedIndex);
						if (contactos.size() == 0)
						{
							panelGrillaContactos.setVisible(false);
						}
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;  
			}
		};		
		
		ColumnConfig eliminarColunm = new ColumnConfig("eliminar", "Eliminar", 60);
		eliminarColunm.setRenderer(eliminarRenderer);
		columns.add(eliminarColunm);
		columns.add (new ColumnConfig("tipoContacto", "Tipo Contacto", 100));
		columns.add (new ColumnConfig("contacto", "Contacto", 200));

		storeContactos = new ListStore<BaseTreeModel>();
		
		columnModelContactos = new ColumnModel(columns);
		
		gridContactos = new Grid<BaseTreeModel>(storeContactos, columnModelContactos);
		gridContactos.setLoadMask(true);  
		gridContactos.setBorders(true);  
		
		panelGrillaContactos.setVisible(false);
		panelGrillaContactos.setFrame(true);   
		panelGrillaContactos.setBorders(true);
		panelGrillaContactos.setHeading("Contactos Agregados");  
		panelGrillaContactos.setLayout(new FitLayout());  
		panelGrillaContactos.add(gridContactos);  
		panelGrillaContactos.setSize(400, 150);
//		panelGrillaContactos.setHeight(150);
	}

	private void completarPanelTitulosAgregados()
	{
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		
		GridCellRenderer<BaseTreeModel> eliminarRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{

			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{
				final ListStore<BaseTreeModel> s = store;
				final BaseTreeModel m = model;
				final Grid<BaseTreeModel> g = grid;
				com.extjs.gxt.ui.client.widget.button.Button b = 
					new com.extjs.gxt.ui.client.widget.button.Button("Eliminar", 
							new SelectionListener<ButtonEvent>() {  
					@Override  
					public void componentSelected(ButtonEvent ce) {   
						s.remove(m);
						g.reconfigure(s, columnModelTitulos);
						
						String idTitulo = m.get("idTitulo");
						String titulo = m.get("titulo");
						
						String tituloCompleto = (idTitulo+titulo).toLowerCase();
						
						int removedIndex = titulos.indexOf(tituloCompleto);
						titulos.remove(removedIndex);
						if (titulos.size() == 0)
						{
							panelGrillaTitulos.setVisible(false);
						}
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;  
			}
		};		
		
		ColumnConfig eliminarColunm = new ColumnConfig("eliminar", "Eliminar", 60);
		eliminarColunm.setRenderer(eliminarRenderer);
		columns.add(eliminarColunm);
		columns.add (new ColumnConfig("titulo", "Título", 200));

		storeTitulos = new ListStore<BaseTreeModel>();
		
		columnModelTitulos = new ColumnModel(columns);
		
		gridTitulos = new Grid<BaseTreeModel>(storeTitulos, columnModelTitulos);
		gridTitulos.setLoadMask(true);  
		gridTitulos.setBorders(true);  
		
		panelGrillaTitulos.setVisible(false);
		panelGrillaTitulos.setFrame(true);   
		panelGrillaTitulos.setBorders(true);
		panelGrillaTitulos.setHeading("Títulos Agregados");  
		panelGrillaTitulos.setLayout(new FitLayout());  
		panelGrillaTitulos.add(gridTitulos);  
		panelGrillaTitulos.setSize(300, 150);
//		panelGrillaContactos.setHeight(150);
	}
	
	@Override
	protected void completarPanelSubmit()
	{
		/**
		 * Acá inicializo el boton Submit
		 */
		submit.addClickHandler(new ClickHandler() 
		{		
			public void onClick(ClickEvent event) 
			{
				boolean error = validarCampos();
				
				if (!error)
				{
					boolean confirm = Window.confirm("¿Está seguro que desea " +
							"registrar la nueva Persona?");
					if (confirm)
					{
						realizarRegistro(submit);
					}
				}	
				else
				{
					Window.scrollTo(0, 0);
				}
			}
		});
	}
	
	@Override
	protected void completarPanelErrores()
	{
		/**
		 * Acá inicializo los mensaje de Error
		 */
		errorNombre = new MensajeError("Nombre", TipoError.REQUERIDO);
		errorApellido = new MensajeError("Apellido", TipoError.REQUERIDO);
		errorNumeroDocumento = new MensajeError("Número de Documento", 
				TipoError.REQUERIDO);
		errorDireccion = new MensajeError("Dirección", TipoError.REQUERIDO);
		errorContacto = new MensajeError("Contacto", TipoError.REQUERIDO);
		
		panelErrores.add(errorNombre);
		panelErrores.add(errorApellido);
		panelErrores.add(errorNumeroDocumento);
		panelErrores.add(errorDireccion);
		panelErrores.add(errorContacto);
	}

	private void completarComboTipoEmpleado(final ListBox lista)
	{
		if (registrarPersonaSvc == null) {
			registrarPersonaSvc = GWT.create(RegistrarPersonaService.class);
		}
		AsyncCallback<TipoEmpleadoBean[]> callback = 
			new AsyncCallback<TipoEmpleadoBean[]>(){
				public void onFailure(Throwable caught) {
					Window.alert("Error al traer los Tipos de Empleado");				
				}
				public void onSuccess(TipoEmpleadoBean[] result) {
					for (int i = 0; i<result.length; i++)
					{
						lista.addItem(result[i].getNombre(), result[i].getIdTipoEmpleado());
					}
				}
			};
		 
		 registrarPersonaSvc.getTiposEmpleado(callback);
	}
	
	private void completarComboTitulos()
	{
		 if (registrarPersonaSvc == null) {
		    	registrarPersonaSvc = GWT.create(RegistrarPersonaService.class);
		 }
		 AsyncCallback<TituloBean[]> callback = new AsyncCallback<TituloBean[]>() {
			 public void onFailure(Throwable caught) {
				 Window.alert("Error al traer los Titulos");						
			 }

			public void onSuccess(TituloBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listTitulo.addItem(result[i].getNombre(), result[i].getIdTitulo());
				}
			}
		};
		registrarPersonaSvc.getTitulos(callback);
	}
	
	private void completarComboTipoDireccion()
	{
		if (registrarPersonaSvc == null) 
		{
	    	registrarPersonaSvc = GWT.create(RegistrarPersonaService.class);
		 }
		AsyncCallback<TipoDireccionBean[]> callback = new AsyncCallback<TipoDireccionBean[]>() {
			public void onFailure(Throwable caught) {
				Window.alert("Error al traer los tipos de Documento");						
			}

			public void onSuccess(TipoDireccionBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listTipoDireccion.addItem(result[i].getNombre(),
							result[i].getIdTipoUbicacion());
				}
			}
		};
		registrarPersonaSvc.getTipoDirecciones(callback);
	}

	private void completarComboTipoDocumento()
	{
		if (registrarPersonaSvc == null) {
			registrarPersonaSvc = GWT.create(RegistrarPersonaService.class);
		}
		AsyncCallback<TipoDocumentoBean[]> callback =
			new AsyncCallback<TipoDocumentoBean[]>()
			{
				public void onFailure(Throwable caught) 
				{
					Window.alert("Error al traer los tipos de Documento");						
				}

				public void onSuccess(TipoDocumentoBean[] result) {
					for (int i = 0; i<result.length; i++)
					{
						listTipoDocumento.addItem(result[i].getTipo(), 
								result[i].getIdTipo());
					}
				}
			};
			registrarPersonaSvc.getTipoDocumentos(callback);
	}
	
	private void completarComboTipoContacto()
	{
		if (registrarPersonaSvc == null) {
			registrarPersonaSvc = GWT.create(RegistrarPersonaService.class);
		}
		AsyncCallback<TipoContactoBean[]> callback = 
			new AsyncCallback<TipoContactoBean[]>() {
				public void onFailure(Throwable caught) {
					Window.alert("Error al traer los tipos de Contacto");						
				}

				public void onSuccess(TipoContactoBean[] result) {
					for (int i = 0; i<result.length; i++)
					{
						listaTipoContactos.addItem(result[i].getNombre(), 
								result[i].getIdTipoContacto());
					}
				}
			};
			registrarPersonaSvc.getTipoContactos(callback);
	}
	
	private void agregarTitulo()
	{
		final String idTitulo = listTitulo.getValue(listTitulo.getSelectedIndex());
		final String titulo = listTitulo.getItemText((listTitulo.getSelectedIndex()));
		

		
		final String tituloCompleto = (idTitulo+titulo).toLowerCase();
		
		if (!titulos.contains(tituloCompleto))
		{
			titulos.add(tituloCompleto);

			BaseTreeModel tituloModel = new BaseTreeModel();
			tituloModel.set("titulo", titulo);
			tituloModel.set("idTitulo", idTitulo);
			
			storeTitulos.add(tituloModel);	
			gridTitulos.reconfigure(storeTitulos, columnModelTitulos);
			
			panelGrillaTitulos.setVisible(true);
		}
	}
	
	
	private void agregarDireccion()
	{
		// executed when user clicks the addButton
		final String calle = textCalle.getText().trim();
		final String numero = textNumero.getText().trim();
		final String piso = textPiso.getText().trim();
		final String departamento = textDepartamento.getText().trim();
		final String barrio = textBarrio.getText().trim();
		final String idBarrio = hiddenIdBarrio.getValue().trim();
		final String idTipoDomicilio = listTipoDireccion.getValue(listTipoDireccion.getSelectedIndex());
		final String localidad = textLocalidad.getText().trim();
		final String provincia = textProvincia.getText().trim();
		final String tipoDireccion = listTipoDireccion.getItemText(listTipoDireccion.getSelectedIndex());
		final String cpp = textCodigoPostal.getText().trim();
		
		final String direccion = calle+numero+piso+departamento+barrio+localidad+provincia+tipoDireccion+cpp;

		if (validarDireccion(calle, numero, idBarrio, piso))
		{
			textCalle.setFocus(true);
			textCalle.setText("");
			textNumero.setText("");
			textPiso.setText("");
			textDepartamento.setText("");
			textBarrio.setText("");
			hiddenIdBarrio.setValue("");
			textLocalidad.setText("");
			textProvincia.setText("");
			textCodigoPostal.setText("");
			
			if (!direcciones.contains(direccion))
			{				
				direcciones.add(direccion);
				
				BaseTreeModel direccionModel = new BaseTreeModel();
				direccionModel.set("calle", calle);
				direccionModel.set("numero", numero);
				direccionModel.set("piso", piso);
				direccionModel.set("departamento", departamento);
				direccionModel.set("barrio", barrio);
				direccionModel.set("localidad", localidad);
				direccionModel.set("provincia", provincia);
				direccionModel.set("tipoDireccion", tipoDireccion);
				direccionModel.set("cpp", cpp);
				direccionModel.set("idBarrio", idBarrio);
				direccionModel.set("idTipoDomicilio", idTipoDomicilio);
				
				storeDirecciones.add(direccionModel);
				gridDirecciones.reconfigure(storeDirecciones, columnModelDirecciones);
				
				panelGrillaDirecciones.setVisible(true);
			}
		}		
	}
	
	private void agregarContacto()
	{
		final String idTipoContacto = listaTipoContactos.getValue(listaTipoContactos.getSelectedIndex()).trim();
		final String nombreTipoContacto = listaTipoContactos.getItemText(listaTipoContactos.getSelectedIndex()).trim();
		final String contacto = textContacto.getText().trim();
		
		final String contactoCompleto = (idTipoContacto+nombreTipoContacto+contacto).toLowerCase();
		
		if (validarContacto(contacto))
		{
			textContacto.setFocus(true);
			textContacto.setText("");
			
			if (!contactos.contains(contactoCompleto))
			{				
				contactos.add(contactoCompleto);
				
				BaseTreeModel contactoModel = new BaseTreeModel();
				contactoModel.set("tipoContacto", nombreTipoContacto);
				contactoModel.set("contacto", contacto);
				contactoModel.set("idTipo", idTipoContacto);
				
				storeContactos.add(contactoModel);	
				gridContactos.reconfigure(storeContactos, columnModelContactos);
				
				panelGrillaContactos.setVisible(true);
			}
		}
	}
	
	
	private boolean validarDireccion(String calle, String numero, String idBarrio, String piso)
	{
		boolean lReturn = true;
		String condicion = ""; 
		int errores = 0;
		
		if (calle.matches(""))
		{
			errores ++;
			condicion = "Calle";
		}
		if (numero.matches(""))
		{
			if (errores > 0)
			{
				condicion  += ", ";
			}
			errores ++;
			condicion += "Número";
		}
		if (idBarrio.matches(""))
		{
			if (errores > 0)
			{
				condicion  += ", ";
			}
			errores ++;
			condicion += "Barrio";
		}
		if (errores > 0)
		{
			String mostrar = "";
			if (errores == 1)
			{
				mostrar = "El campo "+condicion+" no puede ser nulo";
			}
			else
			{
				mostrar = "Los campos "+condicion+" no pueden ser nulos";
			}
			Window.alert(mostrar);
			lReturn = false;
		}

		condicion = "";
		errores = 0;
		try {
			Integer.parseInt(numero);
		}
		catch (Exception e) {
			errores ++;
			condicion = "Número";
		}
		try {
			if (!piso.equals(""))
				Integer.parseInt(piso);
		}
		catch (Exception e) {
			if (errores > 0)
			{
				condicion  += ", ";
			}
			errores ++;
			condicion += "Piso";
		}
		if (errores > 0)
		{
			String mostrar = "";
			if (errores == 1)
			{
				mostrar = "El campo "+condicion+" debe ser numérico";
			}
			else
			{
				mostrar = "Los campos "+condicion+" deben ser numéricos";
			}
			Window.alert(mostrar);
			lReturn = false;
		}
		return lReturn;
	}
	
	private boolean validarContacto(String cont)
	{
		boolean lReturn = true;
		if (cont.matches(""))
		{
			lReturn = false;
			Window.alert("El campo Contacto no puede estar vacío");
		}
		return lReturn;
	}
	
	
	protected boolean validarCampos() {
		boolean error = false;
		if (textoNombres.getText().trim().equals(""))
		{
			error = true;
			errorNombre.setVisible(true);
		}
		else
		{
			errorNombre.setVisible(false);
		}
		if (textoApellido.getText().trim().equals(""))
		{
			error = true;
			errorApellido.setVisible(true);
		}
		else
		{
			errorApellido.setVisible(false);
		}
		if (textoDocumento.getText().trim().equals(""))
		{
			error = true;
			errorNumeroDocumento.setVisible(true);
		}
		else
		{
			errorNumeroDocumento.setVisible(false);
		}
		if (direcciones.size() == 0)
		{
			error = true;
			errorDireccion.setVisible(true);
		}
		else
		{
			errorDireccion.setVisible(false);
		}
		if (contactos.size() == 0)
		{
			error = true;
			errorContacto.setVisible(true);
		}
		else
		{
			errorContacto.setVisible(false);
		}
		return error;
	}
	
	protected void realizarRegistro(final Submit submit)
	{		
		TipoDocumentoBean tipoDocumentoBean = new TipoDocumentoBean("",
				listTipoDocumento.getValue(listTipoDocumento.
						getSelectedIndex()));
		String apellidoString = textoApellido.getText();
		String nombreString = textoNombres.getText();
		String numeroDocumentoString = textoDocumento.getText();
		//TODO modificar esto para que lo tome de un radioButton
		String sexo = "m";
		List<DireccionBean> arrayDirecciones = new ArrayList<DireccionBean>();

		for (int i = 0; i < storeDirecciones.getCount(); i++)
		{
			String idBarrio = storeDirecciones.getAt(i).get("idBarrio");
			String idTipoDomicilio = 
				storeDirecciones.getAt(i).get("idTipoDomicilio");
			String calle = storeDirecciones.getAt(i).get("calle");
			String numero = storeDirecciones.getAt(i).get("numero");
			String piso = storeDirecciones.getAt(i).get("piso");
			String departamento = storeDirecciones.getAt(i).get("departamento");
			String cpp = storeDirecciones.getAt(i).get("cpp");
			
			BarrioBean barrioBean = new BarrioBean(idBarrio, null, null);
			TipoDireccionBean tipoDireccionBean =
				new TipoDireccionBean(idTipoDomicilio, null);
			DireccionBean direccion = new DireccionBean("", tipoDireccionBean, 
					barrioBean, calle, numero, piso, departamento, cpp);
			arrayDirecciones.add(direccion);			
		}
		List<ContactoBean> arrayContactos = new ArrayList<ContactoBean>();
		for (int i = 0; i < storeContactos.getCount(); i++)
		{
			String idTipoContacto = storeContactos.getAt(i).get("idTipo");
			TipoContactoBean tipoContacto = new TipoContactoBean(idTipoContacto, 
					null);
			String contacto = tablaContactos.getText(i, 1);
			ContactoBean contactoBean = new ContactoBean(null, tipoContacto, 
					contacto);
			arrayContactos.add(contactoBean);
			i++;
		}
		DireccionBean[] direcciones = 
			arrayDirecciones.toArray(new DireccionBean[arrayDirecciones.size()]);
		ContactoBean[] contactos = 
			arrayContactos.toArray(new ContactoBean[arrayContactos.size()]);
		

		if (listTipoPersona.getValue(listTipoPersona.getSelectedIndex()).trim().
				equals("1"))
		{
			//Propietario
			PropietarioBean propietario = new PropietarioBean("","", 
					tipoDocumentoBean, apellidoString, nombreString, 
					numeroDocumentoString, sexo, direcciones, contactos);
			 if (registrarPersonaSvc == null) {
			    	registrarPersonaSvc = GWT.create(RegistrarPersonaService.
			    			class);
			 }
			 AsyncCallback<Bool> callback = new AsyncCallback<Bool>(){
				public void onFailure(Throwable caught) {
					Window.alert("Hubo un error al registrar el Propietario. " +
							"Por favor intente nuevamente más tarde.");
				}
				public void onSuccess(Bool result) {
					if (result.isValue())
					{
						Window.alert("Se registró correctamente el " +
								"Propietario.");
					}
					else
					{
						Window.alert("Hubo un error al registrar el " +
								"Propietario. Por favor intente nuevamente " +
								"más tarde.");
					}
					submit.submit();
				}
			 };
			 registrarPersonaSvc.savePropietario(propietario, callback);
		}
		else if(listTipoPersona.getValue(listTipoPersona.getSelectedIndex()).
				trim().equals("2"))
		{
			//Empleado
			List<TituloBean> arrayTitulos = new ArrayList<TituloBean>();
			for(int i = 0; i < storeTitulos.getCount(); i++)
			{
				String nombreTitulo = storeTitulos.getAt(i).get("titulo");
				String idTitulo = storeTitulos.getAt(i).get("idTitulo");
				TituloBean titulo = new TituloBean(idTitulo, nombreTitulo, "");
				arrayTitulos.add(titulo);
			}
			TituloBean[] titulos = arrayTitulos.toArray(
					new TituloBean[arrayTitulos.size()]);
			String puesto = listTipoEmpleado.getValue(listTipoEmpleado.
					getSelectedIndex());
			TipoEmpleadoBean tipoEmppleado = new TipoEmpleadoBean(puesto, "", 
					"");
			EmpleadoBean empleado = new EmpleadoBean("", tipoEmppleado, "", "", 
					titulos, "", tipoDocumentoBean, apellidoString, 
					nombreString, numeroDocumentoString, sexo, direcciones,
					contactos);
			
			 if (registrarPersonaSvc == null) {
			    	registrarPersonaSvc = GWT.create(RegistrarPersonaService.
			    			class);
			 }
			 AsyncCallback<Bool> callback = new AsyncCallback<Bool>(){
					public void onFailure(Throwable caught) {
						Window.alert("Hubo un error al registrar el " +
								"Empleado. Por favor pongase en contacto " +
								"con el Administrador del Sistema.");
					}
					public void onSuccess(Bool result) {
						if (result.isValue())
						{
							Window.alert("Se registró correctamente el " +
									"Empleado.");
						}
						else
						{
							Window.alert("Hubo un error al registrar la " +
									"Empleado. Por favor pongase en " +
									"contacto con el Administrador del " +
									"Sistema.");
						}
						submit.submit();
					}
			 };
			 registrarPersonaSvc.saveEmpleado(empleado, callback);
		}
		else
		{
			//Cliente
			ClienteBean cliente = new ClienteBean("", "", tipoDocumentoBean, 
					apellidoString, nombreString, numeroDocumentoString, sexo,
					direcciones, contactos);
			 if (registrarPersonaSvc == null) {
			    	registrarPersonaSvc = GWT.create(RegistrarPersonaService.
			    			class);
			 }
			 AsyncCallback<Bool> callback = new AsyncCallback<Bool>(){
					public void onFailure(Throwable caught) {
						Window.alert("Hubo un error al registrar el Cliente. " +
								"Por favor pongase en contacto con el " +
								"Administrador del Sistema.");
					}
					public void onSuccess(Bool result) {
						if (result.isValue())
						{
							Window.alert("Se registró correctamente el " +
									"Cliente.");
						}
						else
						{
							Window.alert("Hubo un error al registrar la " +
									"Cliente. Por favor pongase en contacto " +
									"con el Administrador del Sistema.");
						}
						submit.submit();
					}
			 };
			 registrarPersonaSvc.saveCliente(cliente, callback);
		}
	}
}
