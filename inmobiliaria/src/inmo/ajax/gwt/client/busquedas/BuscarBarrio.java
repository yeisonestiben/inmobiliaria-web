package inmo.ajax.gwt.client.busquedas;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BuscarBarrio {
	final DialogBox dialogBox = new DialogBox(); 
	private HorizontalPanel panelCombos = new HorizontalPanel();
	private FlexTable tablaCombos = new FlexTable();
	private VerticalPanel panelPrincipal = new VerticalPanel();
	private HorizontalPanel panelClose = new HorizontalPanel();
	private com.google.gwt.user.client.ui.Button closeButton =
		new com.google.gwt.user.client.ui.Button("Cerrar");
	private ListBox listLocalidad = new ListBox();
	private ListBox listProvincia = new ListBox();
	private TextBox txtNombre = new TextBox();
	final ContentPanel panelGrilla = new ContentPanel();  
	PagingToolBar toolBar;
	final Grid<BaseTreeModel> grid;
	final PagingLoader<PagingLoadResult<ModelData>> loader;  
	final ListStore<BaseTreeModel> store;
	final ColumnModel columnModel;

	final Hidden hiddenID;
	final TextBox textNombre;
	final TextBox textLocalidad;
	final TextBox textProvincia;

	public BuscarBarrio(final Hidden pId, final TextBox pNombre, 
			final TextBox pLocalidad, final TextBox pProvincia, 
			final BuscarBarrioService pService)
	{
		final BuscarBarrioService service = pService;

		listLocalidad.addItem("--TODAS--","0");
		completarComboProvincias(listProvincia, service);

		hiddenID = pId;
		textNombre = pNombre;
		textLocalidad = pLocalidad;
		textProvincia = pProvincia;

		dialogBox.setText("Buscar Barrio");
		dialogBox.setAnimationEnabled(true);
		dialogBox.setStyleName("gwt-DialogBox");

		RpcProxy<PagingLoadResult<BaseTreeModel>> proxy = 
			new RpcProxy<PagingLoadResult<BaseTreeModel>>(){
			@Override
			protected void load(Object loadConfig,
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedBarrios((PagingLoadConfig)loadConfig, callback);
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
						//Info.display((String) model.get("nombre"), "<ul><li>" + model.get("idBarrio") + "</li></ul>"); 
						setValues((String) model.get("idBarrio"), 
								(String) model.get("nombre"), 
								(String) model.get("localidad"), 
								(String) model.get("provincia"));
					}  
				});  
				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);  
				return b;  
			}
		};  

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();  
		columns.add(new ColumnConfig("idBarrio", "ID", 100));
		ColumnConfig columnConfigNombre = 
			new ColumnConfig("nombre", "Nombre", 150);
		columnConfigNombre.setRenderer(buttonRenderer);
		columns.add(columnConfigNombre);
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

		listLocalidad.addChangeHandler(new ChangeHandler()
		{
			public void onChange(ChangeEvent event)
			{
				final String idLocalidad = 
					listLocalidad.getValue(listLocalidad.getSelectedIndex());
				final String idProvincia = 
					listProvincia.getValue(listProvincia.getSelectedIndex());
				final String inicial = txtNombre.getText();
				reconfigureGrid(service, columnModel, grid, idLocalidad,
						idProvincia, inicial);
			}			
		});

		listProvincia.addChangeHandler(new ChangeHandler() {

			public void onChange(ChangeEvent event) {
				String idProvincia = 
					listProvincia.getValue(listProvincia.getSelectedIndex());
				listLocalidad.clear();
				completarComboLocalidades(listLocalidad, idProvincia, service);
				String idLocalidad = 
					listLocalidad.getValue(listLocalidad.getSelectedIndex());
				final String inicial = txtNombre.getText();
				reconfigureGrid(service, columnModel, grid, idLocalidad,
						idProvincia, inicial);
			}
		});
		
		txtNombre.addKeyUpHandler(new KeyUpHandler()
		{
			
			public void onKeyUp(KeyUpEvent arg0)
			{
				final String idLocalidad = 
					listLocalidad.getValue(listLocalidad.getSelectedIndex());
				final String idProvincia = 
					listProvincia.getValue(listProvincia.getSelectedIndex());
				final String inicial = txtNombre.getText();
				reconfigureGrid(service, columnModel, grid, idLocalidad,
						idProvincia, inicial);
			}
		});
		
		closeButton.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				dialogBox.hide();
			}
		});

		tablaCombos.setText(0, 0, "Nombre:");
		tablaCombos.setWidget(0, 1, txtNombre);
		tablaCombos.setText(0, 2, "Provincia:");
		tablaCombos.setWidget(0, 3, listProvincia);
		tablaCombos.setText(0, 4, "Localidad:");
		tablaCombos.setWidget(0, 5, listLocalidad);

		panelCombos.setWidth("100%");
		panelCombos.add(tablaCombos);
		panelCombos.setCellHorizontalAlignment(tablaCombos, 
				HasHorizontalAlignment.ALIGN_CENTER);
		
		panelGrilla.setFrame(true);   
		panelGrilla.setHeading("Seleccione Barrio"); 
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

	public void showDialog() {
		dialogBox.show();
		dialogBox.center();
		loader.load();
	}

	private void setValues (String id, String nombre, String localidad, 
			String provincia)
	{
		hiddenID.setValue(id);
		textNombre.setText(nombre);
		textLocalidad.setText(localidad);
		textProvincia.setText(provincia);
		dialogBox.hide();
	}

	private void completarComboLocalidades(final ListBox listaLocalidades, 
			String idProvincia, BuscarBarrioService service)
	{
		listaLocalidades.addItem("--TODAS--","0");
		AsyncCallback<LocalidadBean[]> callback = 
			new AsyncCallback<LocalidadBean[]>(){
			public void onFailure(Throwable caught) {
				Window.alert("Error al traer las Localidades");				
			}
			public void onSuccess(LocalidadBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listaLocalidades.addItem(result[i].getNombre(),
							result[i].getIdLocalidad());
				}
			}
		};
		service.getLocalidades(idProvincia, callback);
	}

	private void completarComboProvincias(final ListBox listaProvincias, 
			BuscarBarrioService service)
	{
		listaProvincias.addItem("--TODAS--","0");
		AsyncCallback<ProvinciaBean[]> callback =
			new AsyncCallback<ProvinciaBean[]>(){
			public void onFailure(Throwable caught) {
				Window.alert("Error al traer las Provincias");				
			}
			public void onSuccess(ProvinciaBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listaProvincias.addItem(result[i].getNombre(),
							result[i].getIdProvincia());
				}
			}
		};
		service.getProvincias(callback);
	}

	private void reconfigureGrid(final BuscarBarrioService service,
			final ColumnModel columnModel,
			Grid<BaseTreeModel> grid, final String idLocalidad,  
			final String idProvincia, final String inicial)
	{
		RpcProxy<PagingLoadResult<BaseTreeModel>> newProxy =
			new RpcProxy<PagingLoadResult<BaseTreeModel>>(){
			@Override
			protected void load(Object loadConfig, 
					AsyncCallback<PagingLoadResult<BaseTreeModel>> callback)
			{				
				service.getPagedBarrios((PagingLoadConfig) loadConfig,
						idLocalidad, idProvincia, inicial, callback);
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
