package inmo.ajax.gwt.client.busquedas;

import inmo.ajax.gwt.client.Interfaces.BuscarPersonaService;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.utils.TipoPersona;

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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BuscarPersona 
{
	final DialogBox dialogBox = new DialogBox(); 
	private HorizontalPanel panelTextos = new HorizontalPanel();
	private VerticalPanel panelPrincipal = new VerticalPanel();
	private Label lblApellido = new Label ("Apellido: ");
	private Label lblNombre = new Label ("Nombre: ");
	private TextBox txtApellido = new TextBox();
	private TextBox txtNombre = new TextBox();
	private Button txtBuscarPersona = new Button("Buscar");
	final ContentPanel panelGrilla = new ContentPanel();  
	PagingToolBar toolBar;
	final Grid<BaseTreeModel> grid;
	final PagingLoader<PagingLoadResult<ModelData>> loader;  
	final ListStore<BaseTreeModel> store;
	final ColumnModel columnModel;
	TipoPersona tipo;

	final Hidden hiddenID;
	final PersonaContainer personaContainer;
	final TextBox textNombreApellido;

	public BuscarPersona(TipoPersona tipoPersona, final Hidden pId, 
			final PersonaContainer container, final TextBox pNombre, 
			final BuscarPersonaService pService)
	{
		final BuscarPersonaService service = pService;
		tipo = tipoPersona;
		
		hiddenID = pId;
		personaContainer = container;
		textNombreApellido = pNombre;

		dialogBox.setAnimationEnabled(true);
		dialogBox.setStyleName("gwt-DialogBox");
		
		RpcProxy<PagingLoadResult<BaseTreeModel>> proxy = new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedPersonas((PagingLoadConfig) loadConfig, tipo, callback);
			}
		};

		if (tipo == TipoPersona.CLIENTE)
		{
			dialogBox.setText("Buscar Cliente");
		}
		else if (tipo == TipoPersona.EMPLEADO)
		{
			dialogBox.setText("Buscar Empleado");
		}
		else if (tipo == TipoPersona.PROPIETARIO)
		{
			dialogBox.setText("Buscar Propietario");
		}
		else
		{
			dialogBox.setText("Buscar Persona");
		}

		loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);  
		
		store = new ListStore<BaseTreeModel>(loader);
		toolBar = new PagingToolBar(20);
		toolBar.bind(loader); 
		
		GridCellRenderer<BaseTreeModel> buttonRenderer = new GridCellRenderer<BaseTreeModel>() 
		{     
			private boolean init;  

			public Object render(final BaseTreeModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseTreeModel> store, Grid<BaseTreeModel> grid)
			{  
				if (!init) 
				{  
					init = true;  
					grid.addListener(Events.ColumnResize, new Listener<GridEvent<BaseTreeModel>>() {  

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
						PersonaBean persona = model.get("persona");
						setValues((String) model.get("id"), 
								(String) model.get("apellido") + ", " + 
								model.get("nombres"), persona);
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;  
			}
		};  

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();  
		
		ColumnConfig columnId = new ColumnConfig("id", "ID", 100);
		columnId.setRenderer(buttonRenderer);
		columns.add(columnId);
		columns.add(new ColumnConfig("apellido", "Apellido", 150));		
		columns.add(new ColumnConfig("nombres", "Nombres", 150));
		columns.add(new ColumnConfig("tipoDocumento", "Tipo Documento", 150));		
		columns.add(new ColumnConfig("numeroDocumento", "Número Documento", 150));
		
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
		
		ChangeHandler txtHandler = new ChangeHandler()
		{
			public void onChange(ChangeEvent arg0)
			{
//				Info.display(txtNombre.getText(), "<ul><li>" + txtApellido.getText() + "</li></ul>"); 
				final String nombre = txtNombre.getText();
				final String apellido = txtApellido.getText();
				reconfigureGrid(service, columnModel, grid, apellido, nombre);		
			}
		};	
		txtApellido.addChangeHandler(txtHandler);
		txtNombre.addChangeHandler(txtHandler);

		panelTextos.add(lblApellido);
		panelTextos.add(txtApellido);
		panelTextos.add(lblNombre);
		panelTextos.add(txtNombre);
		panelTextos.add(txtBuscarPersona);
		
		panelGrilla.setFrame(true);   
		panelGrilla.setHeading("Seleccione Propietario");  
		panelGrilla.setLayout(new FitLayout());  
		panelGrilla.add(grid);  
		panelGrilla.setSize(700, 500);  
		panelGrilla.setBottomComponent(toolBar);  

		panelPrincipal.add(panelTextos);
		panelPrincipal.add(panelGrilla);
		dialogBox.setWidget(panelPrincipal);
	}

	public void showDialog() {
		dialogBox.show();
		dialogBox.center();
		loader.load();
	}

	private void setValues (String id, String nombreCompleto, 
			PersonaBean persona)
	{
		hiddenID.setValue(id);
		personaContainer.setPersona(persona);
		textNombreApellido.setText(nombreCompleto);
		textNombreApellido.setFocus(true);
		dialogBox.hide();
	}

	private void reconfigureGrid(final BuscarPersonaService service,
			final ColumnModel columnModel,
			Grid<BaseTreeModel> grid, final String apellido,  
			final String nombres)
	{
		RpcProxy<PagingLoadResult<BaseTreeModel>> newProxy = new RpcProxy<PagingLoadResult<BaseTreeModel>>(){
			@Override
			protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedPersonas((PagingLoadConfig) loadConfig, apellido, nombres, tipo, callback);
			}
		};

		PagingLoader<PagingLoadResult<ModelData>> newLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(newProxy);  
		ListStore<BaseTreeModel> newStore = new ListStore<BaseTreeModel>(newLoader); 
		toolBar.bind(newLoader);  
		newLoader.load();
		grid.reconfigure(newStore, columnModel);
	}
}
