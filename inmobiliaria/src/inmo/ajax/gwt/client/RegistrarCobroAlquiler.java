package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarPersona;
import inmo.ajax.gwt.client.db.CobroAlquilerBean;
import inmo.ajax.gwt.client.db.ContratoBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
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
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarCobroAlquiler extends Registro implements EntryPoint 
{
	private RegistrarCobroAlquilerServiceAsync service = 
		GWT.create(RegistrarCobroAlquilerService.class);
	
	//mensajes de error
	VerticalPanel panelErrores = new VerticalPanel();
	MensajeError errorCliente;
	MensajeError errorCobros;
	
	//Boton Submit	
	Submit submit = new Submit("Aceptar");
	
	//Conexiones
	private RpcProxy<PagingLoadResult<BaseTreeModel>> proxy;
	private PagingLoader<PagingLoadResult<ModelData>> loader;  
	private ListStore<BaseTreeModel> store;
	
	//Busqueda Cliente o Contratos
	private Button buttonBuscarCliente = new Button("Buscar");
	private Button buttonBuscarContrato = new Button("Buscar");
	private RadioButton radioCliente = new RadioButton("busqueda", "Cliente");
	private RadioButton radioContrato = new RadioButton("busqueda", "Contrato");
	private HorizontalPanel panelBuscar = new HorizontalPanel();
	final TextBox txtCliente = new TextBox();
	final TextBox txtContrato = new TextBox();
	final Hidden hiddenIdCliente = new Hidden();
	final BuscarPersona buscarCliente = new BuscarPersona(TipoPersona.CLIENTE, 
			hiddenIdCliente, new PersonaContainer(), txtCliente, service);	

	//Grilla Cobros
	final ContentPanel panelGrilla = new ContentPanel();
	private Grid<BaseTreeModel> gridCobros;
	private ColumnModel columnModel;
	private HTML lblTotal = new HTML(getTotalImprimible("0.00"));
	final List<CobroAlquilerBean> cobros = new ArrayList<CobroAlquilerBean>();
	final List<String> cobrosId = new ArrayList<String>();
	private boolean refreshGrid = false;
	float total = 0;
	
	public void onModuleLoad()
	{	
		proxy = new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedPersonas((PagingLoadConfig) loadConfig, 
						TipoPersona.CLIENTE, callback);
			}
		};
		loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
		
		store = new ListStore<BaseTreeModel>(loader);		
		GridCellRenderer<BaseTreeModel> checkBoxRenderer = 
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
							for (int i = 0; i < be.getGrid().getStore().
							getCount(); i++) 
							{  
								if (be.getGrid().getView().getWidget(i, 
										be.getColIndex()) != null && 
										be.getGrid().getView().getWidget(i, 
										be.getColIndex()) instanceof 
										BoxComponent) 
								{  
									((BoxComponent) be.getGrid().getView().
											getWidget(i, be.getColIndex())).
											setWidth(be.getWidth() - 10);  
								}  
							}  
						}  
					});
				}

				final CheckBox check = new CheckBox();
				check.addListener(Events.Change, new Listener<FieldEvent>()
				{
					public void handleEvent(FieldEvent be)
					{
						String monto = model.get("monto");
						String idContato = model.get("numeroContrato");
						String fecha = model.get("fechaVencimiento");
						ContratoBean contrato = new ContratoBean(idContato, 
								null, null, null, null, null);
						CobroAlquilerBean cobro = new CobroAlquilerBean(null, 
								null, contrato, null, fecha, monto, null);
						if (check.getValue())
						{
							total += Float.parseFloat(monto);
							insertarCobro(cobro);
						}
						else
						{
							total -= Float.parseFloat(monto);
							removerCobro(cobro);
						}
						monto = Utilidades.formatearNumero(""+total);
						lblTotal.setHTML(getTotalImprimible(monto));
						
					}
				});
				return check;  
			}
		};  
		
		GridCellRenderer<BaseTreeModel> montoRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{
			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{
				String monto = model.get("monto");
				monto = Utilidades.formatearNumero(monto);
				return monto;
			}
		};
		
		GridCellRenderer<BaseTreeModel> fechaRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{
			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{
				boolean isVencido = Utilidades.isVencido(
						(String)model.get("fechaVencimiento"));
				String color = isVencido ? "red" : "green";
				
				return "<span style='color:" + color + "'>" +
						(String)model.get("fechaVencimiento") + "</span>";
			}
		};
		
		GridCellRenderer<BaseTreeModel> clientesRenderer = 
			new GridCellRenderer<BaseTreeModel>()
		{
			public Object render(BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{				
				return "<span>" +(String)model.get("clientes") + "</span>";
			}
		};		
		
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();  
		
		ColumnConfig columnId = 
			new ColumnConfig("seleccionar", "Seleccionar", 80);
		columnId.setRenderer(checkBoxRenderer);
		columns.add(columnId);
		
		ColumnConfig columnContrato = 
			new ColumnConfig("numeroContrato", "Número Contrato", 100);
		columnContrato.setAlignment(HorizontalAlignment.RIGHT);
		columns.add(columnContrato);	

		ColumnConfig columnClientes = 
			new ColumnConfig("clientes","Clientes", 150); 
		columnClientes.setRenderer(clientesRenderer);
		columns.add(columnClientes);
		
		columns.add(new ColumnConfig("tipoPropiedad", "Tipo Propiedad", 100));
		
		ColumnConfig columnFecha = 
			new ColumnConfig("fechaVencimiento", "Fecha Vencimiento", 120);
		columnFecha.setRenderer(fechaRenderer);
		columnFecha.setAlignment(HorizontalAlignment.CENTER);
		columns.add(columnFecha);	
		
		ColumnConfig columnMonto = new ColumnConfig("monto", "Monto", 70);
		columnMonto.setRenderer(montoRenderer);
		columnMonto.setAlignment(HorizontalAlignment.RIGHT);
		columns.add(columnMonto);

		columnModel = new ColumnModel(columns);  
		
		AggregationRowConfig<BaseTreeModel> rowTotales = 
			new AggregationRowConfig<BaseTreeModel>();  
	    rowTotales.setHtml("fechaVencimiento", "TOTAL");  
	      
	    rowTotales.setWidget("monto", lblTotal);

	    columnModel.addAggregationRow(rowTotales);	    

		gridCobros = new Grid<BaseTreeModel>(store, columnModel);  		
		gridCobros.setLoadMask(true);  
		gridCobros.setBorders(true);   
		
		panelGrilla.setFrame(true);   
		panelGrilla.setHeading("Cobros encontrados");  
		panelGrilla.setLayout(new FitLayout());  
		panelGrilla.add(gridCobros);  
//		panelGrilla.setSize(700, 500);
		panelGrilla.setHeight(300);

		/**
		 * Inicializo los paneles a Agregar
		 */
		completarPanelBusqueda();
		completarPanelErrores();
		completarPanelSubmit();

		/**
		 * Acá agrego los paneles a las JSP
		 */
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("busqueda").add(panelBuscar);
		RootPanel.get("cobros").add(panelGrilla);
		RootPanel.get("submit").add(submit);
	}
	
	private void reconfigureGrid(final RegistrarCobroAlquilerServiceAsync 
			service, final ColumnModel columnModel, Grid<BaseTreeModel> grid,
			final String id, final String tipoId)
	{
		proxy = new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				if (tipoId.equals("cliente"))
				{
					service.getCobrosImpagosPorCliente((PagingLoadConfig) 
							loadConfig, id, callback);
				}
				else
				{
					service.getCobrosImpagosPorContrato((PagingLoadConfig) 
							loadConfig, id, callback);
				}
				
			}
		};
		loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);  
		store = new ListStore<BaseTreeModel>(loader);
		loader.load();
		grid.reconfigure(store, columnModel);
//		if (contadorFilasGrilla == 0)
//		{
//			Info.display("Atención", "No se encontraron cobros para el " +
//					"Cliente o Contrato seleccionado");
//		}
	}
	
	private String getTotalImprimible (String total)
	{
		return "<span style=\"color:green;font-family:sans-serif;font-weight:" +
				"bolder;\">"+total+"</span>";
	}
	
	private void insertarCobro(CobroAlquilerBean cobro) 
	{
		String idContrato = "idContrato"+cobro.getContrato().getIdContrato() +
				"fecha"+cobro.getFechaVencimiento();
		if (!cobrosId.contains(idContrato))
		{
			cobrosId.add(idContrato);
			cobros.add(cobro);
		}
	}
	
	private void removerCobro(CobroAlquilerBean cobro) 
	{
		String idContrato = "idContrato"+cobro.getContrato().getIdContrato() +
				"fecha"+cobro.getFechaVencimiento();
		int removedIndex = cobrosId.indexOf(idContrato);
		cobrosId.remove(removedIndex);
		cobros.remove(removedIndex);
	}
	
	@Override
	protected boolean validarCampos()
	{
		boolean error = false;
		if (txtCliente.getText().trim().equals("") &&
				txtContrato.getText().trim().equals(""))
		{
			errorCliente.setVisible(true);
			error = true;
		}
		else
		{
			errorCliente.setVisible(false);
			if (cobros.size() == 0)
			{
				errorCobros.setVisible(true);
				error = true;
			}
			else
			{
				errorCobros.setVisible(false);
			}
		}
		return error;
	}
	
	@Override
	protected void completarPanelErrores()
	{
		/**
		 * Acá inicializo los mensaje de Error
		 */
		errorCliente = new MensajeError("Cliente o Contrato", 
				TipoError.AL_MENOS_UNO);
		errorCobros = new MensajeError("Cobro", TipoError.AL_MENOS_UNO);
		
		panelErrores.add(errorCliente);
		panelErrores.add(errorCobros);
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
							"registrar el/los cobro/s de Alquiler?");
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
	
	private void completarPanelBusqueda()
	{
		txtCliente.setReadOnly(true);
		panelBuscar.add(radioCliente);
		panelBuscar.add(txtCliente);
		panelBuscar.add(buttonBuscarCliente);
		panelBuscar.add(new Label("    "));
		panelBuscar.add(radioContrato);
		panelBuscar.add(txtContrato);
		panelBuscar.add(buttonBuscarContrato);
		panelBuscar.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		radioCliente.setValue(true);
		txtContrato.setEnabled(false);
		buttonBuscarContrato.setEnabled(false);
		
		ClickHandler clickHandler = new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				cambiarTipoBusqueda();
			}
		};
		
		radioCliente.addClickHandler(clickHandler);
		radioContrato.addClickHandler(clickHandler);
		
		buttonBuscarCliente.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				buscarCliente.showDialog();
				refreshGrid = true;
			}
		});
		
		buttonBuscarContrato.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				String idContrato = txtContrato.getText().trim();
				if (Utilidades.isInt(idContrato))
				{
					refreshGrid("contrato", idContrato);
				}
				else
				{
					Window.alert("El número de Contrato no es un número " +
							"válido");
				}
			}
		});
		
		txtCliente.addFocusHandler(new FocusHandler()
		{
			public void onFocus(FocusEvent arg0)
			{
				if (refreshGrid)
				{
					String idCliente = hiddenIdCliente.getValue();
					refreshGrid("cliente", idCliente);
					refreshGrid = false;
				}
			}
		});
		
	}
	
	private void cambiarTipoBusqueda()
	{
		if (radioCliente.getValue())
		{
			txtCliente.setEnabled(true);
			txtContrato.setEnabled(false);
			buttonBuscarCliente.setEnabled(true);
			buttonBuscarContrato.setEnabled(false);
			
			if (!txtCliente.getText().trim().equals(""))
			{
				refreshGrid("cliente", hiddenIdCliente.getValue());
			}
		}
		else
		{
			txtCliente.setEnabled(false);
			txtContrato.setEnabled(true);
			buttonBuscarCliente.setEnabled(false);
			buttonBuscarContrato.setEnabled(true);
			
			String idContrato = txtContrato.getText().trim();
			if (!idContrato.equals("") && Utilidades.isInt(idContrato))
			{
				refreshGrid("contrato", idContrato);
			}	
		}
	}
	
	@Override
	protected void realizarRegistro(Submit submit)
	{
		AsyncCallback<Bool> callback = new AsyncCallback<Bool>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Hubo un error al registrar los Cobros. Por " +
						"favor intente nuevamente más tarde.");
			}

			public void onSuccess(Bool arg0)
			{
				if (arg0.isValue())
				{
					Window.alert("Se registró correctamente el Cobro de " +
							"Alquileres.");
				}
				else
				{
					Window.alert("Hubo un error al registrar los Cobros. Por " +
							"favor intente nuevamente más tarde.");
				}
				
			}
		};
		service.saveCobroAlquiler(cobros.toArray(new 
				CobroAlquilerBean[cobros.size()]), callback);
	}
	
	private void refreshGrid(String tipoId, String id)
	{
		cobros.clear();
		cobrosId.clear();
		total = 0;
		reconfigureGrid(service, columnModel, gridCobros, id, tipoId);
		lblTotal.setHTML(getTotalImprimible("0.00"));
	}
}
