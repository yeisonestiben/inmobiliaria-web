package inmo.ajax.gwt.client.busquedas;

import inmo.ajax.gwt.client.Interfaces.BuscarOrganizacionService;

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

public class BuscarOrganizacion
{
	final DialogBox dialogBox = new DialogBox(); 
	private HorizontalPanel panelTextos = new HorizontalPanel();
	private VerticalPanel panelPrincipal = new VerticalPanel();
	private Label lblNombre = new Label ("Nombre: ");
	private TextBox txtNombre = new TextBox();
	private Button btnBuscarOrganizacion = new Button("Buscar");
	final ContentPanel panelGrilla = new ContentPanel();  
	PagingToolBar toolBar;
	final Grid<BaseTreeModel> grid;
	final PagingLoader<PagingLoadResult<ModelData>> loader;  
	final ListStore<BaseTreeModel> store;
	final ColumnModel columnModel;
	final BuscarOrganizacionService service;
	
	final Hidden hiddenID;
	final Hidden direccion;
	final TextBox txtOrganizacion;
	
	public BuscarOrganizacion(Hidden hiddenOrganizacion, 
			TextBox pTxtOrganizacion, Hidden hiddenDireccion,
			BuscarOrganizacionService pService)
	{
		service = pService;
		hiddenID = hiddenOrganizacion;
		direccion = hiddenDireccion;
		txtOrganizacion = pTxtOrganizacion;
		
		dialogBox.setAnimationEnabled(true);
		dialogBox.setStyleName("gwt-DialogBox");
		dialogBox.setText("Buscar Organización");
		
		RpcProxy<PagingLoadResult<BaseTreeModel>> proxy = new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedOrganizaciones((PagingLoadConfig) loadConfig, 
						callback);
			}
		};
		
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
						setValues((String) model.get("id"), 
								(String) model.get("nombre"), 
								(String) model.get("direccion"));
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
		columns.add(new ColumnConfig("nombre", "Nombre", 150));
		
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
				final String nombre = txtNombre.getText();
				reconfigureGrid(service, columnModel, grid, nombre);		
			}
		};	
		txtNombre.addChangeHandler(txtHandler);
		
		panelTextos.add(lblNombre);
		panelTextos.add(txtNombre);
		panelTextos.add(btnBuscarOrganizacion);
		
		panelGrilla.setFrame(true);   
		panelGrilla.setHeading("Seleccione Organizacion");  
		panelGrilla.setLayout(new FitLayout());  
		panelGrilla.add(grid);  
		panelGrilla.setSize(700, 500);  
		panelGrilla.setBottomComponent(toolBar);
		
		panelPrincipal.add(panelTextos);
		panelPrincipal.add(panelGrilla);
		dialogBox.setWidget(panelPrincipal);
	}

	public void showDialog()
	{
		dialogBox.show();
		dialogBox.center();
		loader.load();
	}
	
	private void setValues (String id, String nombre, String pDireccion)
	{
		hiddenID.setValue(id);
		direccion.setValue(pDireccion);
		txtOrganizacion.setText(nombre);
		txtNombre.setFocus(true);
		dialogBox.hide();
	}
	
	private void reconfigureGrid(final BuscarOrganizacionService service,
			final ColumnModel columnModel, Grid<BaseTreeModel> grid, 
			final String nombre)
	{
		RpcProxy<PagingLoadResult<BaseTreeModel>> newProxy = 
			new RpcProxy<PagingLoadResult<BaseTreeModel>>()
		{
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedOrganizaciones((PagingLoadConfig) loadConfig, 
						nombre, callback);
			}
		};

		PagingLoader<PagingLoadResult<ModelData>> newLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(newProxy);  
		ListStore<BaseTreeModel> newStore = new ListStore<BaseTreeModel>(newLoader); 
		toolBar.bind(newLoader);  
		newLoader.load();
		grid.reconfigure(newStore, columnModel);
	}

}
