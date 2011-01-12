package inmo.ajax.gwt.client.busquedas;

import inmo.ajax.gwt.client.Interfaces.BuscarInmuebleService;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.db.container.PropiedadContainer;
import inmo.ajax.gwt.client.utils.Constantes;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.client.utils.Utilidades;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar.PagingToolBarMessages;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BuscarInmueble
{
	private final BuscarInmuebleService serviceInmueble;
	
	final DialogBox dialogBox = new DialogBox(); 
	private VerticalPanel panelCombos = new VerticalPanel();
	private FlexTable tablaCombosSuperior = new FlexTable();
	private FlexTable tablaCombosInferior = new FlexTable();
	private VerticalPanel panelPrincipal = new VerticalPanel();
	private HorizontalPanel panelClose = new HorizontalPanel();
	private com.google.gwt.user.client.ui.Button closeButton =
		new com.google.gwt.user.client.ui.Button("Cerrar");
	
	private TextBox txtCalle = new TextBox();
	private TextBox txtBarrio = new TextBox();
	private TextBox txtNumero = new TextBox();
	private ListBox listTipoPropiedad = new ListBox();
	private BuscarBarrio buscarBarrio;
	private com.google.gwt.user.client.ui.Button botonBuscarBarrio = 
		new com.google.gwt.user.client.ui.Button("Buscar");
	private Hidden hiddenBarrio = new Hidden();
	
	private TextBox txtPropietario = new TextBox();
	private com.google.gwt.user.client.ui.Button botonBuscarPropietario = 
		new com.google.gwt.user.client.ui.Button("Buscar"); 
	private BuscarPersona buscarPropietario;
	
	private ContentPanel panelGrilla = new ContentPanel();  
	private PagingToolBar toolBar;
	private Grid<BaseTreeModel> grid;
	private PagingLoader<PagingLoadResult<ModelData>> loader; 
	private ListStore<BaseTreeModel> store;
	private ColumnModel columnModel;

	final PropiedadContainer propiedadContainer;
	final TextArea txtInmueble;
	final Hidden hiddenIdPropietario = new Hidden();
	final PersonaContainer personaContainer = new PersonaContainer();
	
	final TipoDisponibilidadBean tipoDisponibilidad;

	public BuscarInmueble(final String idPropietario, 
			PropiedadContainer propiedadContainer, TextArea txtInmueble, 
			TipoDisponibilidadBean tipoDisponibilidadBean, 
			BuscarInmuebleService service)
	{
		this.tipoDisponibilidad = tipoDisponibilidadBean;
		this.serviceInmueble = service;
		this.propiedadContainer = propiedadContainer;
		this.txtInmueble = txtInmueble;
		this.txtPropietario.setReadOnly(true);
		this.txtBarrio.setReadOnly(true);
		
		dialogBox.setAnimationEnabled(true);
		dialogBox.setStyleName("gwt-DialogBox");
		dialogBox.setText("Buscar Propiedad");

		buscarBarrio = new BuscarBarrio(hiddenBarrio, txtBarrio, new TextBox(), 
				new TextBox(), service);
		
		botonBuscarBarrio.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				buscarBarrio.showDialog();
			}
		});
		
		if (idPropietario != null && !idPropietario.equals(""))
		{
			this.hiddenIdPropietario.setValue(idPropietario);
			botonBuscarPropietario.setEnabled(false);
			completarTxtPropietario();
		}
		else
		{
			buscarPropietario = new BuscarPersona(TipoPersona.PROPIETARIO, 
					this.hiddenIdPropietario, personaContainer, txtPropietario, 
					service);
			botonBuscarPropietario.addClickHandler(new ClickHandler()
			{
				
				public void onClick(ClickEvent arg0)
				{
					buscarPropietario.showDialog();
				}
			});
		}
		
		completarComboTipoPropiedad();
		
		tablaCombosSuperior.setText(0, 0, "Propietario");
		tablaCombosSuperior.setWidget(0, 1, txtPropietario);
		tablaCombosSuperior.setWidget(0, 2, botonBuscarPropietario);
		tablaCombosSuperior.setText(0, 3, "Tipo Popiedad");
		tablaCombosSuperior.setWidget(0, 4, listTipoPropiedad);
		
		tablaCombosInferior.setText(0, 0, "Calle");
		tablaCombosInferior.setWidget(0, 1, txtCalle);
		tablaCombosInferior.setText(0, 2, "Número");
		tablaCombosInferior.setWidget(0, 3, txtNumero);
		tablaCombosInferior.setText(0, 4, "Barrio");
		tablaCombosInferior.setWidget(0, 5, txtBarrio);
		tablaCombosInferior.setWidget(0, 6, botonBuscarBarrio);
		
		RpcProxy<PagingLoadResult<BaseTreeModel>> proxy = 
			new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{
				serviceInmueble.getPagedInmuebles((PagingLoadConfig) loadConfig, 
						hiddenIdPropietario.getValue(), hiddenBarrio.getValue(), 
						txtCalle.getText(), txtNumero.getText(), "1", 
						tipoDisponibilidad, callback);
			}
		};
		
		loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);  
		
		store = new ListStore<BaseTreeModel>(loader);
		toolBar = new PagingToolBar(20);
		toolBar.bind(loader); 
		
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

				Button b = new Button((String) model.get(property),
						new SelectionListener<ButtonEvent>() {  
					@Override  
					public void componentSelected(ButtonEvent ce) {
						setValues((String) model.get("idPropiedad"));
					}
				});
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;
			}
		}; 
		
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();  
		
		columns.add(new ColumnConfig("tipoPropiedad", "Tipo Propiedad", 100));
		ColumnConfig columnConfigId = 
			new ColumnConfig("idPropiedad", "ID", 100);
		columnConfigId.setRenderer(buttonRenderer);
		columns.add(columnConfigId);
		columns.add(new ColumnConfig("calle", "Calle", 100));
		columns.add(new ColumnConfig("numero", "Número", 150));
		columns.add(new ColumnConfig("barrio", "Barrio", 150));
		columns.add(new ColumnConfig("localidad", "Localidad", 150));
		columns.add(new ColumnConfig("provincia", "Provincia", 150));

		columnModel = new ColumnModel(columns);

		grid = new Grid<BaseTreeModel>(store, columnModel);
		grid.setLoadMask(true);
		grid.setBorders(true);   
		
		final PagingToolBarMessages messages = toolBar.getMessages();
		messages.setRefreshText("Recargar");
		messages.setDisplayMsg("Mostrando {0} - {1} de {2}");
		messages.setAfterPageText("de {0}");
		messages.setBeforePageText("Pagina");
		messages.setEmptyMsg("Sin datos para mostrar");
		messages.setFirstText("Principio");
		messages.setLastText("Último");
		messages.setNextText("Siguiente");
		messages.setPrevText("Anterior");
		toolBar.setMessages(messages);
		
		listTipoPropiedad.addChangeHandler(new ChangeHandler()
		{
			public void onChange(ChangeEvent event) 
			{
				reconfigureGrid();
			}		
		});
		
		txtCalle.addKeyUpHandler(new KeyUpHandler()
		{
			
			public void onKeyUp(KeyUpEvent arg0)
			{
				reconfigureGrid();
			}
		});
		
		txtNumero.addKeyUpHandler(new KeyUpHandler()
		{
			
			public void onKeyUp(KeyUpEvent arg0)
			{
				if (!txtNumero.getText().equals("") && 
						!Utilidades.isInt(txtNumero.getText())) 
				{
					reconfigureGrid();
				}
				else
				{
					Window.alert("El campo numero es un valor numérico.");
				}
			}
		});
		
		ChangeHandler changeHandler = new ChangeHandler()
		{
			
			public void onChange(ChangeEvent arg0)
			{
				reconfigureGrid();
			}
		};
		
		txtPropietario.addChangeHandler(changeHandler);
		txtBarrio.addChangeHandler(changeHandler);
		
		closeButton.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				dialogBox.hide();
			}
		});
		
		panelCombos.setWidth("100%");
		panelCombos.add(tablaCombosSuperior);
		panelCombos.add(tablaCombosInferior);
		panelCombos.setCellHorizontalAlignment(tablaCombosSuperior, 
				HasHorizontalAlignment.ALIGN_CENTER);
		
		panelGrilla.setFrame(true);   
		panelGrilla.setHeading("Seleccione Propiedad"); 
		panelGrilla.setLayout(new FitLayout());  
		panelGrilla.add(grid);  
		panelGrilla.setSize(700, 500);  
		panelGrilla.setBottomComponent(toolBar);  
		
		panelClose.setWidth("100%");
		panelClose.add(closeButton);
		panelClose.setCellHorizontalAlignment(closeButton, 
				HasHorizontalAlignment.ALIGN_RIGHT);
		
		panelPrincipal.add(panelCombos);
		panelPrincipal.add(panelGrilla);
		panelPrincipal.add(panelClose);
		dialogBox.setWidget(panelPrincipal);
	}

	private void completarComboTipoPropiedad()
	{		
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
			serviceInmueble.getTipoPropiedades(callback);
	}

	private void completarTxtPropietario()
	{
		AsyncCallback<PropietarioBean> callback = 
			new AsyncCallback<PropietarioBean>()
		{

			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al consultar la DB, intente más tarde " +
						"por favor");
			}

			public void onSuccess(PropietarioBean arg0)
			{
				txtPropietario.setText(arg0.getApellido() + ", " + 
						arg0.getNombres());
			}
		};	
		serviceInmueble.getPropietario(hiddenIdPropietario.getValue(), callback);
	}

	public void showDialog()
	{
		dialogBox.show();
		dialogBox.center();
		loader.load();
	}
	
	private void setValues (String id)
	{
		AsyncCallback<PropiedadBean> callback = new AsyncCallback<PropiedadBean>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al consultar los datos de la Propiedad");
			}

			public void onSuccess(PropiedadBean arg0)
			{
				String descripcion = Constantes.getDescripcionPropiedad(arg0);
				txtInmueble.setText(descripcion);
				propiedadContainer.setPropiedad(arg0);
			}
		};
		serviceInmueble.getPropiedad(id, callback);
		dialogBox.hide();
	}
	
	private void reconfigureGrid()
	{
		final String idTipoPropiedad =	listTipoPropiedad.
		getValue(listTipoPropiedad.getSelectedIndex());
		final String calle = txtCalle.getText();
		final String numero = txtNumero.getText();
		final String idPropietario = hiddenIdPropietario.getValue();
		final String idBarrio = hiddenBarrio.getValue();
		
		RpcProxy<PagingLoadResult<BaseTreeModel>> newProxy =
			new RpcProxy<PagingLoadResult<BaseTreeModel>>(){
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				serviceInmueble.getPagedInmuebles((PagingLoadConfig)loadConfig, 
						idPropietario, idBarrio, calle, numero, idTipoPropiedad, 
						tipoDisponibilidad, callback);
			}
		};

		PagingLoader<PagingLoadResult<ModelData>> newLoader = 
			new BasePagingLoader<PagingLoadResult<ModelData>>(newProxy);  
		ListStore<BaseTreeModel> newStore = 
			new ListStore<BaseTreeModel>(newLoader); 
		toolBar.bind(newLoader);  
		newLoader.load();
		grid.reconfigure(newStore, columnModel);
	}	
}
