package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Consulta;
import inmo.ajax.gwt.client.busquedas.BuscarBarrio;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConsultarViviendas extends Consulta implements EntryPoint
{
	private ConsultarViviendasServiceAsync service = 
		GWT.create(ConsultarViviendasService.class);

	//panel Errores
	private VerticalPanel panelErrores;
	MensajeError errorMetrosCubiertos;
	MensajeError errorMetrosPatio;
	MensajeError errorMetrosParcela;
	MensajeError errorMontoDesde;
	MensajeError errorMontoHasta;
	MensajeError errorAntiguedad;
	
	//Panel Disponibilidad
	private FlexTable tablaDisponibilidad;
	private ListBox listTipoDisponibilidad;
	private ListBox moneda;
	private TextBox txtDesde;
	private TextBox txtHasta;
	
	
	//Panel Características
	private FlexTable tablaCaracteristicas;
	private BuscarBarrio buscarBarrio;
	private Button btnBuscarBarrio;
	private ListBox listTipoPropiedad;
	private ListBox listDormitorios;
	private ListBox listAmbientes;
	private TextBox txtAntiguedad;
	private TextBox txtTerreno;
	private TextBox txtPatio;
	private TextBox txtCubierto;
	private TextBox txtBarrio;
	private Hidden hiddenBarrio;
	
	//panel Submit
	private Submit submit;
	
	//panel Resultados
	private ContentPanel panelGrilla;
	private Grid<BaseTreeModel> gridResultados;
	private ColumnModel columnModel;
	private ListStore<BaseTreeModel> store;

	public void onModuleLoad()
	{
		completarPanelSubmit();
		completarPanelErrores();
		completarPanelDisponibilidad();
		completarPanelCaracteristicas();
		completarPanelResultados();
		
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("disponibilidad").add(tablaDisponibilidad);
		RootPanel.get("caracteristicas").add(tablaCaracteristicas);
		RootPanel.get("submit").add(submit);
		RootPanel.get("resultados").add(panelGrilla);
		
	}

	@Override
	protected void completarPanelSubmit()
	{
		/**
		 * Acá inicializo el boton Submit
		 */
		submit = new Submit("Consultar");
		submit.addClickHandler(new ClickHandler() 
		{		
			public void onClick(ClickEvent event) 
			{
				boolean error = validarCampos();
				
				if (!error)
				{
					realizarConsulta(submit);
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
		panelErrores = new VerticalPanel();
		
		errorMetrosCubiertos = new MensajeError("Metros Cubiertos", TipoError.FORMATO_INVALIDO);
		errorMetrosPatio = new MensajeError("Metros de Patio", TipoError.FORMATO_INVALIDO);
		errorMetrosParcela = new MensajeError("Mestros de Terreno", TipoError.FORMATO_INVALIDO);
		errorMontoDesde = new MensajeError("Monto Desde", TipoError.FORMATO_INVALIDO);
		errorMontoHasta = new MensajeError("Monto Hasta", TipoError.FORMATO_INVALIDO);
		errorAntiguedad = new MensajeError("Antigüedad", TipoError.FORMATO_INVALIDO);
		
		panelErrores.add(errorMetrosCubiertos);
		panelErrores.add(errorMetrosPatio);
		panelErrores.add(errorMetrosParcela);
		panelErrores.add(errorMontoDesde);
		panelErrores.add(errorMontoHasta);
		panelErrores.add(errorAntiguedad);
	}
	
	private void completarPanelDisponibilidad() 
	{
		completarListTipoDisponibilidad();
		completarListMoneda();
		
		tablaDisponibilidad = new FlexTable();
		
		txtDesde = new TextBox();
		txtHasta = new TextBox();
		
		tablaDisponibilidad.setText(0, 0, "Tipo");
		tablaDisponibilidad.setWidget(0, 1, listTipoDisponibilidad);
		tablaDisponibilidad.setText(1, 0, "Monto");
		tablaDisponibilidad.setWidget(1, 1, moneda);
		tablaDisponibilidad.setText(1, 2, "Desde");
		tablaDisponibilidad.setWidget(1, 3, txtDesde);
		tablaDisponibilidad.setText(1, 4, "Hasta");
		tablaDisponibilidad.setWidget(1, 5, txtHasta);
	}
	
	private void completarPanelCaracteristicas()
	{
		completarListTipoPropiedad();
		completarListDormitorios();
		completarListAmbientes();
	
		tablaCaracteristicas = new FlexTable();
		
		btnBuscarBarrio = new Button("...");
		
		txtAntiguedad = new TextBox();
		txtTerreno = new TextBox();
		txtPatio = new TextBox();
		txtCubierto = new TextBox();
		txtBarrio = new TextBox();
		txtBarrio.setReadOnly(true);
		
		txtAntiguedad.setWidth("45px");
		txtTerreno.setWidth("45px");
		txtPatio.setWidth("45px");
		txtCubierto.setWidth("45px");
		
		hiddenBarrio = new Hidden();
		
		buscarBarrio = new BuscarBarrio(hiddenBarrio, txtBarrio, new TextBox(), 
				new TextBox(), service);
		
		tablaCaracteristicas.setText(0, 0, "Barrio");
		tablaCaracteristicas.setWidget(0, 1, txtBarrio);
		tablaCaracteristicas.setWidget(0, 2, btnBuscarBarrio);
		tablaCaracteristicas.setText(0, 3, "Antigüedad (Años)");
		tablaCaracteristicas.setWidget(0, 4, txtAntiguedad);
		tablaCaracteristicas.setText(0, 5, "Tipo Propiedad");
		tablaCaracteristicas.setWidget(0, 6, listTipoPropiedad);
		HTML tituloTerreno = new HTML("Terreno (m<SUP>2</SUP>)");
		tablaCaracteristicas.setWidget(1, 0, tituloTerreno);
		tablaCaracteristicas.setWidget(1, 1, txtTerreno);
		HTML tituloPatio = new HTML("Patio (m<SUP>2</SUP>)");
		tablaCaracteristicas.setWidget(1, 3, tituloPatio);
		tablaCaracteristicas.setWidget(1, 4, txtPatio);
		HTML tituloCubierto = new HTML("m<SUP>2</SUP> Cubiertos");
		tablaCaracteristicas.setWidget(1, 5, tituloCubierto);
		tablaCaracteristicas.setWidget(1, 6, txtCubierto);
		tablaCaracteristicas.setText(4, 0, "Dormitorios");
		tablaCaracteristicas.setWidget(4, 1, listDormitorios);
		tablaCaracteristicas.setText(4, 3, "Ambientes");
		tablaCaracteristicas.setWidget(4, 4, listAmbientes);
		
		btnBuscarBarrio.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarBarrio.showDialog();
			}
		});
	}
	
	private void completarPanelResultados()
	{
		GridCellRenderer<BaseTreeModel> buttonRenderer = 
			new GridCellRenderer<BaseTreeModel>() 
		{     
			private boolean init;  

			public Object render(final BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{  
				if (!init) {  
					init = true;  
					grid.addListener(Events.ColumnResize, 
							new Listener<GridEvent<BaseTreeModel>>() {  

						public void handleEvent(GridEvent<BaseTreeModel> be)
						{
							for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {  
								if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null  
										&& be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {  
									((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);  
								}  
							}  
						}  
					});  
				}  

				com.extjs.gxt.ui.client.widget.button.Button b = new com.extjs.gxt.ui.client.widget.button.Button((String) model.get(property),
						new SelectionListener<ButtonEvent>() {  
					@Override  
					public void componentSelected(ButtonEvent ce) {  
//						setValues((String) model.get("idBarrio"), 
//								(String) model.get("nombre"), 
//								(String) model.get("localidad"), 
//								(String) model.get("provincia"));
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				b.setText("...");
				return b;  
			}
		};  	
		
		ColumnConfig tipoPropiedad = new ColumnConfig("tipoPropiedad", 
				"Tipo Propiedad", 120);
		ColumnConfig calle = new ColumnConfig("calle", "Calle", 130);
		ColumnConfig numero = new ColumnConfig("numero", "Número", 70);
		ColumnConfig barrio = new ColumnConfig("barrio", "Barrio", 120);
		ColumnConfig moneda = new ColumnConfig("moneda", "Moneda", 70);
		ColumnConfig monto = new ColumnConfig("monto", "Monto", 70);
		ColumnConfig mas = new ColumnConfig("verMas", "Ver Más", 70);
		mas.setRenderer(buttonRenderer);
		
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>(); 
		
		columns.add(tipoPropiedad);
		columns.add(calle);
		columns.add(numero);
		columns.add(barrio);
		columns.add(moneda);
		columns.add(monto);
		columns.add(mas);
		
		columnModel = new ColumnModel(columns);
		store = new ListStore<BaseTreeModel>();
		
		gridResultados = new Grid<BaseTreeModel>(store, columnModel);  		
		gridResultados.setLoadMask(true);  
		gridResultados.setBorders(true); 
		
		panelGrilla = new ContentPanel();
		panelGrilla.setFrame(true); 
		panelGrilla.setBorders(true);
		panelGrilla.setHeading("Propiedades Encontradas");  
		panelGrilla.setLayout(new FitLayout());  
		panelGrilla.add(gridResultados);
		panelGrilla.setSize(670, 300);
//		panelGrilla.setHeight(300);
	}
	
	private void completarListTipoDisponibilidad()
	{
		listTipoDisponibilidad = new ListBox();
		AsyncCallback<TipoDisponibilidadBean[]> callback = 
		new AsyncCallback<TipoDisponibilidadBean[]>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al traer los Tipos de Disponibilidad");
			}

			public void onSuccess(TipoDisponibilidadBean[] result)
			{
				for (int i = 0; i<result.length; i++)
				{
					listTipoDisponibilidad.addItem(result[i].getNombre(), 
							result[i].getIdTipoDisponibilidad());
				}

			}
		};
		service.getTiposDisponibilidad(callback);
	}
	
	private void completarListMoneda()
	{
		moneda = new ListBox();
		AsyncCallback<MonedaBean[]> callback = new AsyncCallback<MonedaBean[]>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al traer las Monedas");
			}

			public void onSuccess(MonedaBean[] result)
			{
				for (int i = 0; i<result.length; i++)
				{
					moneda.addItem(result[i].getNombre(), 
							result[i].getIdMoneda());
				}

			}
		};
		service.getMonedas(callback);
	}
	
	private void completarListTipoPropiedad()
	{
		listTipoPropiedad = new ListBox();
		AsyncCallback<TipoPropiedadBean[]> callback = 
			new AsyncCallback<TipoPropiedadBean[]>(){
				public void onFailure(Throwable arg0)
				{
					Window.alert("Error al traer los Tipos de Propiedad");
				}

				public void onSuccess(TipoPropiedadBean[] result)
				{
					for (int i = 0; i<result.length; i++)
					{
						listTipoPropiedad.addItem(result[i].getNombre(), 
								result[i].getIdTipoPropiedad());
					}
				}
			};
			service.getTipoPropiedades(callback);
	}
	
	private void completarListDormitorios()
	{
		listDormitorios = new ListBox();
		listDormitorios.addItem("","0");
		for (int i = 1 ; i <= 5; i++) {
			listDormitorios.addItem((i==5) ? i+" ó mas" : String.valueOf(i), 
					String.valueOf(i));
		}
	}
	
	private void completarListAmbientes()
	{
		listAmbientes = new ListBox();
		listAmbientes.addItem("","0");
		for (int i = 1 ; i <= 5; i++) {
			listAmbientes.addItem((i==5) ? i+" ó mas" : String.valueOf(i), 
					String.valueOf(i));
		}
	}

	@Override
	protected boolean validarCampos()
	{
		for (int i = 0; i < panelErrores.getWidgetCount(); i++)
		{
			MensajeError error = (MensajeError) panelErrores.getWidget(i);
			error.setVisible(false);
		}
		boolean error = false;
		if (!txtAntiguedad.getText().trim().equals("") && 
				!Utilidades.isInt(txtAntiguedad.getText().trim()))
		{
			errorAntiguedad.setVisible(true);
			error = true;
		}
		if (!txtCubierto.getText().trim().equals("") && 
				!Utilidades.isFloat(txtCubierto.getText().trim()))
		{
			errorMetrosCubiertos.setVisible(true);
			error = true;
		}
		if (!txtDesde.getText().trim().equals("") && 
				!Utilidades.isFloat(txtDesde.getText().trim()))
		{
			errorMontoDesde.setVisible(true);
			error = true;
		}
		if (!txtHasta.getText().trim().equals("") && 
				!Utilidades.isFloat(txtHasta.getText().trim()))
		{
			errorMontoHasta.setVisible(true);
			error = true;
		}
		if (!txtPatio.getText().trim().equals("") && 
				!Utilidades.isFloat(txtPatio.getText().trim()))
		{
			errorMetrosPatio.setVisible(true);
			error = true;
		}
		if (!txtTerreno.getText().trim().equals("") && 
				!Utilidades.isFloat(txtTerreno.getText().trim()))
		{
			errorMetrosParcela.setVisible(true);
			error = true;
		}
		return error;
	}

	@Override
	protected void realizarConsulta(Submit submit)
	{
		String idTipoDisponibilidad = 
			listTipoDisponibilidad.getValue(listTipoDisponibilidad.getSelectedIndex());
		TipoDisponibilidadBean tipoDisponibilidad = 
			new TipoDisponibilidadBean(idTipoDisponibilidad, "", "");
		String idMoneda = moneda.getValue(moneda.getSelectedIndex());
		MonedaBean moneda = new MonedaBean(idMoneda, "", "", "");
		DisponibilidadBean disponibilidad = 
			new DisponibilidadBean("", moneda, null, tipoDisponibilidad, null, null, null);
		
		BarrioBean barrio = new BarrioBean(hiddenBarrio.getValue(), null, null);
		DireccionBean direccionBean = 
			new DireccionBean("", null, barrio, "", "", "", "", "");
		String idTipoPropiedad = 
			listTipoPropiedad.getValue(listTipoPropiedad.getSelectedIndex());
		TipoPropiedadBean tipoPropiedad = 
			new TipoPropiedadBean(idTipoPropiedad, "", "");
		String terreno = txtTerreno.getText();
		String cubierto = txtCubierto.getText();
		String patio = txtPatio.getText();
		String dormitorios = listDormitorios.getValue(listDormitorios.getSelectedIndex());
		String ambientes = listAmbientes.getValue(listAmbientes.getSelectedIndex());
		PropiedadBean propiedad = new PropiedadBean("", tipoPropiedad, 
				direccionBean, null, "", ambientes, dormitorios, "", patio, 
				terreno, cubierto, null);
		
		String montoDesde = txtDesde.getText();
		String montoHasta = txtHasta.getText();
		String antiguedad = txtAntiguedad.getText();
		
		AsyncCallback<BasePagingLoadResult<BaseTreeModel>> callback = new AsyncCallback<BasePagingLoadResult<BaseTreeModel>>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Hubo un error al consultar las Propiedades. " +
						"Por favor intente nuevamente más tarde.");
			}

			public void onSuccess(BasePagingLoadResult<BaseTreeModel> arg0)
			{
				store = new ListStore<BaseTreeModel>();
				store.add(arg0.getData());
				gridResultados.reconfigure(store, columnModel);
			};
		};		
		PagingLoadConfig plc = new BasePagingLoadConfig();
		service.getPagedPropiedades(plc, propiedad, disponibilidad, montoDesde,
				montoHasta, antiguedad, callback);
	}
}
