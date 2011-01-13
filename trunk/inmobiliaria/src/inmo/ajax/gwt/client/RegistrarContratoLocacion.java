package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarInmueble;
import inmo.ajax.gwt.client.busquedas.BuscarOrganizacion;
import inmo.ajax.gwt.client.busquedas.BuscarPersona;
import inmo.ajax.gwt.client.db.ClausulaBean;
import inmo.ajax.gwt.client.db.ContratoBean;
import inmo.ajax.gwt.client.db.GarantiaBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.db.container.PropiedadContainer;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.ConstantesContrato;
import inmo.ajax.gwt.client.utils.TipoGarantia;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.client.widgets.DatePicker;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarContratoLocacion extends Registro implements EntryPoint
{
	private RegistrarContratoLocacionServiceAsync service = 
		GWT.create(RegistrarContratoLocacionService.class);

	//Panel Errores
	private VerticalPanel panelErrores;
	private MensajeError errorLocadora;
	private MensajeError errorLocataria;
	private MensajeError errorFechaDesde;
	private MensajeError errorFechaHasta;
	private MensajeError errorInteresEntregaNumerico;
	private MensajeError errorInteresPagoNumerico;
	private MensajeError errorMontoNumerico;

	//Panel Submit
	private HorizontalPanel panelSubmit;
	private Submit submit;
	private Button botonVistaPreliminar;

	//Panel Locatario
	private HorizontalPanel panelTipoLocatario;
	private VerticalPanel panelLocatario;
	private FlexTable tablaLocatario;
	private Hidden hiddenLocatario;
	private PersonaContainer contenedorLocatario;
	private TextBox txtLocatario;
	private RadioButton radioLocatarioPersona;
	private RadioButton radioLocatarioOrganizacion;
	private Button botonBuscarLocatario;
	private BuscarPersona buscarLocatarioPersona;
	private BuscarOrganizacion buscarLocatarioOrganizacion;
	private String selectedLocatario;

	//Panel Locador
	private HorizontalPanel panelTipoLocador;
	private VerticalPanel panelLocador;
	private FlexTable tablaLocador;
	private Hidden hiddenLocador;
	private PersonaContainer contenedorLocador;
	private TextBox txtLocador;
	private RadioButton radioLacadorPersona;
	private RadioButton radioLacadorOrganizacion;
	private Button botonBuscarLocador;
	private BuscarPersona buscarLocadorPersona;
	private BuscarOrganizacion buscarLocadorOrganizacion;
	private String selectedLocador;

	//Panel Inmueble
	private VerticalPanel panelInmueble;
	private FlexTable tablaInmbueble;
	private CheckBox checkModificaciones;
	private Button botonBuscarInmueble;
	private TextArea txtDescripcionPropiedad;
	private BuscarInmueble buscarInmueble;
	private PropiedadContainer propiedadContainer;

	//Panel Periodo
	private VerticalPanel panelPeriodo;
	private FlexTable tablaPeriodo;
	private FlexTable tablaInteresEntrega;
	private DatePicker fechaDesde;
	private TextBox txtPeriodo;
	private TextBox txtInteresPorEntrega;
	private ListBox listInteresPorEntrega;
	private CheckBox checkPermitirUtilizar;

	//Panel Precio
	private FlexTable tablaPrecio;
	private VerticalPanel panelPrecio;
	private TextBox txtMonto;
	private TextBox txtDescripcionMonto;
	private ListBox listMoneda;
	private CheckBox checkRenegociarAnualmente;
	private CheckBox checkContemplaIVA;
	private Map<String, MonedaBean> mapMonedas;

	//Panel Pago
	private VerticalPanel panelPago;
//	private FlexTable tablaLugar;
	private FlexTable tablaFechaPago;
	private FlexTable tablaInteresPago;
//	private ListBox listLugar;
	private TextBox txtInteresPorPago;
	private ListBox listInteresPorPago;
	private CheckBox checkPagoPorAdelantado;
	private TextBox txtPagoDesde;
	private TextBox txtPagoHasta;
	
	//Panel Condiciones del Inmuble
	private VerticalPanel panelCondicionInmbueble;
	private FlexTable tablaCondicionesInmbueble;
	private TextBox txtColorInmueble;
	private ListBox listTipoPinturaInmueble;
	private TextArea txtCondicionesExtras;
	
	//Panel GrupoFamiliar
	private CheckBox checkUsoFamiliar;
	
	//Panel Garantes
	private VerticalPanel panelGarantes;
	private VerticalPanel panelEmpleo1;
	private VerticalPanel panelEmpleo2;
	private VerticalPanel panelEmpleo3;
	private FlexTable tablaGarante1;
	private FlexTable tablaBuscarGarante1;
	private FlexTable tablaGarante2;
	private FlexTable tablaBuscarGarante2;
	private FlexTable tablaGarante3;
	private FlexTable tablaBuscarGarante3;
	private FlexTable tablaLugarEmpleo1;
	private FlexTable tablaLugarEmpleo2;
	private FlexTable tablaLugarEmpleo3;
	private FlexTable tablaMontoEmpleo1;
	private FlexTable tablaMontoEmpleo2;
	private FlexTable tablaMontoEmpleo3;
	private FlexTable tablaPropiedad1;
	private FlexTable tablaPropiedad2;
	private FlexTable tablaPropiedad3;	
	private FlexTable tablaCantidadGarantes;
	private TextBox txtGarante1;
	private TextBox txtGarante2;
	private TextBox txtGarante3;
	private TextBox txtPropiedad1;
	private TextBox txtPropiedad2;
	private TextBox txtPropiedad3;
	private TextBox txtOrganizacion1;
	private TextBox txtOrganizacion2;
	private TextBox txtOrganizacion3;
	private TextBox txtPuesto1;
	private TextBox txtPuesto2;
	private TextBox txtPuesto3;
	private TextBox txtSueldo1;
	private TextBox txtSueldo2;
	private TextBox txtSueldo3;
	private TextBox txtSueldoLetras1;
	private TextBox txtSueldoLetras2;
	private TextBox txtSueldoLetras3;
	private TextArea txtDescripcionPropiedad1;
	private TextArea txtDescripcionPropiedad2;
	private TextArea txtDescripcionPropiedad3;
	private ListBox listMoneda1;
	private ListBox listMoneda2;
	private ListBox listMoneda3;
	private ListBox listCantidadGarantes;
	private BuscarPersona buscarGarante1;
	private BuscarPersona buscarGarante2;
	private BuscarPersona buscarGarante3;
	private BuscarPersona buscarGarantePropierario1;
	private BuscarPersona buscarGarantePropierario2;
	private BuscarPersona buscarGarantePropierario3;
	private BuscarInmueble buscarGarantiaInmueble1;
	private BuscarInmueble buscarGarantiaInmueble2;
	private BuscarInmueble buscarGarantiaInmueble3;
	private BuscarOrganizacion buscarOrganizacion1;
	private BuscarOrganizacion buscarOrganizacion2;
	private BuscarOrganizacion buscarOrganizacion3;
	private Button botonBuscarGarante1;
	private Button botonBuscarGarante2;
	private Button botonBuscarGarante3;
	private Button botonBuscarPropiedad1;
	private Button botonBuscarPropiedad2;
	private Button botonBuscarPropiedad3;
	private Button botonBuscarOrganizacion1;
	private Button botonBuscarOrganizacion2;
	private Button botonBuscarOrganizacion3;
	private PersonaContainer containerGarante1;
	private PersonaContainer containerGarante2;
	private PersonaContainer containerGarante3;
	private RadioButton radioGarantia1Propiedad;
	private RadioButton radioGarantia1Recibo;
	private RadioButton radioGarantia2Propiedad;
	private RadioButton radioGarantia2Recibo;
	private RadioButton radioGarantia3Propiedad;
	private RadioButton radioGarantia3Recibo;	
	private PropiedadContainer containerGarantiaPropiedad1;
	private PropiedadContainer containerGarantiaPropiedad2;
	private PropiedadContainer containerGarantiaPropiedad3;
	private DatePicker fechaIngreso1;
	private DatePicker fechaIngreso2;
	private DatePicker fechaIngreso3;
	private HTML separador1;
	private HTML separador2;
	private HTML separador3;
	private Hidden hiddenDireccionOrganizacion1;
	private Hidden hiddenDireccionOrganizacion2;
	private Hidden hiddenDireccionOrganizacion3;

	public void onModuleLoad()
	{
		completarPanelLocatario();
		completarPanelLocador();
		completarPanelInmueble();
		completarPanelPeriodo();
		completarPanelPrecio();
		completarPanelPago();
		completarPanelCondicioneInmueble();
		completarPanelUsoFamiliar();
		completarPanelGarantes();
		completarPanelSubmit();
		completarPanelErrores();

		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("locadora").add(panelLocador);
		RootPanel.get("locataria").add(panelLocatario);
		RootPanel.get("inmueble").add(panelInmueble);
		RootPanel.get("periodo").add(panelPeriodo);
		RootPanel.get("precio").add(panelPrecio);
		RootPanel.get("pago").add(panelPago);
		RootPanel.get("condicionInmueble").add(panelCondicionInmbueble);
		RootPanel.get("usoFamiliar").add(checkUsoFamiliar);
		RootPanel.get("garantes").add(panelGarantes);
		RootPanel.get("submit").add(panelSubmit);
	}

	@Override
	protected void realizarRegistro(Submit submit)
	{
		// TODO Auto-generated method stub		
	}

	private void completarPanelLocador()
	{
		panelLocador = new VerticalPanel();
		tablaLocador = new FlexTable();
		hiddenLocador = new Hidden();
		contenedorLocador = new PersonaContainer();
		txtLocador = new TextBox();
		botonBuscarLocador = new Button("Buscar");
		buscarLocadorPersona = new BuscarPersona(TipoPersona.PROPIETARIO, 
				hiddenLocador, contenedorLocador, txtLocador, service);
		buscarLocadorOrganizacion = new BuscarOrganizacion(hiddenLocador, 
				txtLocador, new Hidden(), service);
		radioLacadorPersona = new RadioButton("locador", "Persona");
		radioLacadorOrganizacion = new RadioButton("locador", "Organización");
		radioLacadorPersona.setValue(true);
		selectedLocador = "persona";

		txtLocador.setReadOnly(true);

		ClickHandler clickHandler = new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				limpiarLocador();
			}
		};

		radioLacadorPersona.addClickHandler(clickHandler);
		radioLacadorOrganizacion.addClickHandler(clickHandler);

		botonBuscarLocador.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent arg0)
			{
				if (radioLacadorPersona.getValue())
				{
					buscarLocadorPersona.showDialog();
				}
				else
				{
					buscarLocadorOrganizacion.showDialog();
				}
			}
		});

		panelTipoLocador = new HorizontalPanel();
		panelTipoLocador.add(radioLacadorPersona);
		panelTipoLocador.add(radioLacadorOrganizacion);

		tablaLocador.setText(0, 0, "Nombre");
		tablaLocador.setWidget(0, 1, txtLocador);
		tablaLocador.setWidget(0, 2, botonBuscarLocador);

		panelLocador.add(panelTipoLocador);
		panelLocador.add(tablaLocador);
	}

	private void completarPanelLocatario() 
	{
		panelLocatario = new VerticalPanel();
		tablaLocatario = new FlexTable();
		hiddenLocatario = new Hidden();
		contenedorLocatario = new PersonaContainer();
		txtLocatario = new TextBox();
		botonBuscarLocatario = new Button("Buscar");
		buscarLocatarioPersona = new BuscarPersona(TipoPersona.CLIENTE, 
				hiddenLocatario, contenedorLocatario, txtLocatario, service);
		buscarLocatarioOrganizacion = new BuscarOrganizacion(hiddenLocatario, 
				txtLocatario, new Hidden(), service);
		radioLocatarioPersona = new RadioButton("locatario", "Persona");
		radioLocatarioOrganizacion = 
			new RadioButton("locatario", "Organización");
		radioLocatarioPersona.setValue(true);
		selectedLocatario = "persona";

		txtLocatario.setReadOnly(true);

		ClickHandler clickHandler = new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				limpiarLocatario();
				if (radioLocatarioPersona.getValue())
				{
					checkUsoFamiliar.setEnabled(true);
				}
				else
				{
					checkUsoFamiliar.setEnabled(false);
				}
			}
		};

		radioLocatarioPersona.addClickHandler(clickHandler);
		radioLocatarioOrganizacion.addClickHandler(clickHandler);

		botonBuscarLocatario.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent arg0)
			{
				if (radioLocatarioPersona.getValue())
				{
					buscarLocatarioPersona.showDialog();
				}
				else
				{
					buscarLocatarioOrganizacion.showDialog();
				}
			}
		});

		panelTipoLocatario = new HorizontalPanel();
		panelTipoLocatario.add(radioLocatarioPersona);
		panelTipoLocatario.add(radioLocatarioOrganizacion);

		tablaLocatario.setText(0, 0, "Nombre");
		tablaLocatario.setWidget(0, 1, txtLocatario);
		tablaLocatario.setWidget(0, 2, botonBuscarLocatario);

		panelLocatario.add(panelTipoLocatario);
		panelLocatario.add(tablaLocatario);


	}

	private void completarPanelInmueble()
	{
		panelInmueble = new VerticalPanel();
		tablaInmbueble = new FlexTable();
		checkModificaciones = new CheckBox("Permitir realizar Modificaciones " +
			"en la Propiedad");
		botonBuscarInmueble = new Button("Buscar");
		txtDescripcionPropiedad = new TextArea();
		txtDescripcionPropiedad.setPixelSize(400, 150);
		propiedadContainer = new PropiedadContainer();

		tablaInmbueble.setText(0, 0, "Seleccione un Inmueble");
		tablaInmbueble.setWidget(0, 1, botonBuscarInmueble);
		tablaInmbueble.setText(1, 0, "Descripcion de la Propiedad");
		tablaInmbueble.setWidget(1, 1, txtDescripcionPropiedad);

		panelInmueble.add(tablaInmbueble);
		panelInmueble.add(checkModificaciones);

		botonBuscarInmueble.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				if (hiddenLocador.getValue() == "")
				{
					Window.alert("Seleccione Primero el Propietario (Locador)");
				}
				else
				{
					buscarInmueble = new BuscarInmueble(hiddenLocador.getValue(), 
							propiedadContainer, txtDescripcionPropiedad, 
							new TipoDisponibilidadBean("1", "", ""), service);
					buscarInmueble.showDialog();
				}
			}
		});
	}

	private void completarPanelPeriodo()
	{
		panelPeriodo = new VerticalPanel();
		tablaPeriodo = new FlexTable();
		tablaInteresEntrega = new FlexTable();
		fechaDesde = new DatePicker();
		txtPeriodo = new TextBox();
		txtInteresPorEntrega = new TextBox();
		listInteresPorEntrega = new ListBox();
		checkPermitirUtilizar = new CheckBox("Permitir Utilizar después de " +
			"vencido el plazo");

		txtInteresPorEntrega.setWidth("45px");
		txtPeriodo.setWidth("45px");

		completarComboTipoInteres(listInteresPorEntrega);

		tablaPeriodo.setText(0, 0, "Desde");
		tablaPeriodo.setWidget(0, 1, fechaDesde);
		tablaPeriodo.setWidget(0, 2, txtPeriodo);
		tablaPeriodo.setText(0, 3, "Años");

		tablaInteresEntrega.setText(0, 0, "Interes en Caso de no devolver " +
				"la Propiedad en Término:");
		tablaInteresEntrega.setWidget(0, 1, txtInteresPorEntrega);
		tablaInteresEntrega.setText(0, 2, "%");
		tablaInteresEntrega.setWidget(0, 3, listInteresPorEntrega);

		panelPeriodo.add(tablaPeriodo);
		panelPeriodo.add(tablaInteresEntrega);
		panelPeriodo.add(checkPermitirUtilizar);
	}

	private void completarPanelPrecio()
	{
		tablaPrecio = new FlexTable();
		panelPrecio = new VerticalPanel();
		txtMonto = new TextBox();
		txtDescripcionMonto = new TextBox();
		listMoneda = new ListBox();
		checkRenegociarAnualmente = new CheckBox("Renegociar Anualmente");
		checkContemplaIVA = new CheckBox("Completa IVA");
		mapMonedas = new HashMap<String, MonedaBean>();
		
		txtMonto.setWidth("45px");
		checkRenegociarAnualmente.setValue(true);

		completarComboMoneda();

		tablaPrecio.setText(0, 0, "Moneda");
		tablaPrecio.setWidget(0, 1, listMoneda);
		tablaPrecio.setText(0, 2, "Monto");
		tablaPrecio.setWidget(0, 3, txtMonto);
		tablaPrecio.setText(0, 4, "Aclaración (Letras)");
		tablaPrecio.setWidget(0, 5, txtDescripcionMonto);

		panelPrecio.add(tablaPrecio);
		panelPrecio.add(checkRenegociarAnualmente);
		panelPrecio.add(checkContemplaIVA);
	}

	private void completarPanelPago()
	{
		panelPago = new VerticalPanel();
//		tablaLugar = new FlexTable();
		tablaFechaPago = new FlexTable();
		tablaInteresPago = new FlexTable();
//		listLugar = new ListBox();
		txtInteresPorPago = new TextBox();
		listInteresPorPago = new ListBox();
		checkPagoPorAdelantado = new CheckBox("Pago por Adelantado");
		txtPagoDesde = new TextBox();
		txtPagoHasta = new TextBox();
		
		checkPagoPorAdelantado.setValue(true);
		txtPagoDesde.setWidth("30px");
		txtPagoHasta.setWidth("30px");
		txtPagoDesde.setText("1");
		txtPagoHasta.setText("10");

//		completarComboLugar();

		tablaInteresPago.setText(0, 0, "Interés por pago fuera de término");
		tablaInteresPago.setWidget(0, 1, txtInteresPorPago);
		tablaInteresPago.setText(0, 2, "%");
		tablaInteresPago.setWidget(0, 3, listInteresPorPago);
		
		tablaFechaPago.setText(0, 0, "Del");
		tablaFechaPago.setWidget(0, 1, txtPagoDesde);
		tablaFechaPago.setText(0, 2, "al");
		tablaFechaPago.setWidget(0, 3, txtPagoHasta);
		tablaFechaPago.setText(0, 5, "de cada mes.-");

//		tablaLugar.setText(0, 0, "Lugar");
//		tablaLugar.setWidget(0, 1, listLugar);

		txtInteresPorPago.setWidth("45px");

		completarComboTipoInteres(listInteresPorPago);

		panelPago.add(checkPagoPorAdelantado);
//		panelPago.add(tablaLugar);
		panelPago.add(tablaFechaPago);
		panelPago.add(tablaInteresPago);
	}
	
	private void completarPanelCondicioneInmueble()
	{
		panelCondicionInmbueble = new VerticalPanel();
		tablaCondicionesInmbueble = new FlexTable();
		completarComboTipoPintura();
		txtColorInmueble = new TextBox();
		txtCondicionesExtras = new TextArea();
		txtCondicionesExtras.setPixelSize(400, 150);
		
		tablaCondicionesInmbueble.setText(0, 0, "Color del inmueble");
		tablaCondicionesInmbueble.setWidget(0, 1, txtColorInmueble);
		tablaCondicionesInmbueble.setText(0, 2, "Tipo de Pintura");
		tablaCondicionesInmbueble.setWidget(0, 3, listTipoPinturaInmueble);
		tablaCondicionesInmbueble.setText(1, 0, "Extras");
		
		panelCondicionInmbueble.add(tablaCondicionesInmbueble);
		panelCondicionInmbueble.add(txtCondicionesExtras);
	}

	private void completarPanelGarantes()
	{		
		panelGarantes = new VerticalPanel();
		
		listCantidadGarantes = new ListBox();
		
		hiddenDireccionOrganizacion1 = new Hidden();
		hiddenDireccionOrganizacion2 = new Hidden();
		hiddenDireccionOrganizacion3 = new Hidden();
		
		panelEmpleo1 = new VerticalPanel();
		panelEmpleo2 = new VerticalPanel();
		panelEmpleo3 = new VerticalPanel();

		tablaBuscarGarante1 = new FlexTable();
		tablaBuscarGarante2 = new FlexTable();
		tablaBuscarGarante3 = new FlexTable();
		
		tablaGarante1 = new FlexTable();
		tablaGarante2 = new FlexTable();
		tablaGarante3 = new FlexTable();
		
		tablaLugarEmpleo1 = new FlexTable();
		tablaLugarEmpleo2 = new FlexTable();
		tablaLugarEmpleo3 = new FlexTable();
		
		tablaMontoEmpleo1 = new FlexTable();
		tablaMontoEmpleo2 = new FlexTable();
		tablaMontoEmpleo3 = new FlexTable();
		
		tablaPropiedad1 = new FlexTable();
		tablaPropiedad2 = new FlexTable();
		tablaPropiedad3 = new FlexTable();
		
		tablaCantidadGarantes = new FlexTable();
		
		txtGarante1 = new TextBox();
		txtGarante2 = new TextBox();
		txtGarante3 = new TextBox();
		
		txtPropiedad1 = new TextBox();
		txtPropiedad2 = new TextBox();
		txtPropiedad3 = new TextBox();
		
		txtOrganizacion1 = new TextBox();
		txtOrganizacion2 = new TextBox();
		txtOrganizacion3 = new TextBox();
		
		txtPuesto1 = new TextBox();
		txtPuesto2 = new TextBox();
		txtPuesto3 = new TextBox();
		
		txtSueldo1 = new TextBox();
		txtSueldo2 = new TextBox();
		txtSueldo3 = new TextBox();
		
		txtSueldoLetras1 = new TextBox();
		txtSueldoLetras2 = new TextBox();
		txtSueldoLetras3 = new TextBox();
		
		separador1 = new HTML("<BR><HR><BR>");
		separador2 = new HTML("<BR><HR><BR>");
		separador3 = new HTML("<BR><HR><BR>");
		
		txtDescripcionPropiedad1 = new TextArea();
		txtDescripcionPropiedad2 = new TextArea();
		txtDescripcionPropiedad3 = new TextArea();
		
		containerGarante1 = new PersonaContainer();
		containerGarante2 = new PersonaContainer();
		containerGarante3 = new PersonaContainer();
		
		containerGarantiaPropiedad1 = new PropiedadContainer();
		containerGarantiaPropiedad2 = new PropiedadContainer();
		containerGarantiaPropiedad3 = new PropiedadContainer();
		
		listCantidadGarantes.addItem("0", "0");
		listCantidadGarantes.addItem("1", "1");
		listCantidadGarantes.addItem("2", "2");
		listCantidadGarantes.addItem("3", "3");
		
		buscarGarante1 = new BuscarPersona(TipoPersona.TODOS, new Hidden(), 
				containerGarante1, txtGarante1, service);
		buscarGarante2 = new BuscarPersona(TipoPersona.TODOS, new Hidden(), 
				containerGarante2, txtGarante2, service);
		buscarGarante3 = new BuscarPersona(TipoPersona.TODOS, new Hidden(), 
				containerGarante3, txtGarante3, service);
		
		buscarGarantePropierario1 = new BuscarPersona(TipoPersona.PROPIETARIO, 
				new Hidden(), containerGarante1, txtGarante1, service);
		buscarGarantePropierario2 = new BuscarPersona(TipoPersona.PROPIETARIO, 
				new Hidden(), containerGarante2, txtGarante2, service);
		buscarGarantePropierario3 = new BuscarPersona(TipoPersona.PROPIETARIO, 
				new Hidden(), containerGarante3, txtGarante3, service);
		
		buscarOrganizacion1 = new BuscarOrganizacion(new Hidden(), 
				txtOrganizacion1, hiddenDireccionOrganizacion1, service);
		buscarOrganizacion2 = new BuscarOrganizacion(new Hidden(), 
				txtOrganizacion2, hiddenDireccionOrganizacion2, service);
		buscarOrganizacion3 = new BuscarOrganizacion(new Hidden(), 
				txtOrganizacion3, hiddenDireccionOrganizacion3, service);
		
		botonBuscarGarante1 = new Button("Buscar");
		botonBuscarGarante2 = new Button("Buscar");
		botonBuscarGarante3 = new Button("Buscar");
		
		botonBuscarOrganizacion1 = new Button("Buscar");
		botonBuscarOrganizacion2 = new Button("Buscar");
		botonBuscarOrganizacion3 = new Button("Buscar");
		
		botonBuscarPropiedad1 = new Button("Buscar");
		botonBuscarPropiedad2 = new Button("Buscar");
		botonBuscarPropiedad3 = new Button("Buscar");
		
		radioGarantia1Propiedad = new RadioButton("garantia1", "Propiedad");
		radioGarantia2Propiedad = new RadioButton("garantia2", "Propiedad");
		radioGarantia3Propiedad = new RadioButton("garantia3", "Propiedad");
		
		radioGarantia1Recibo = new RadioButton("garantia1", "Recibo");
		radioGarantia2Recibo = new RadioButton("garantia2", "Recibo");
		radioGarantia3Recibo = new RadioButton("garantia3", "Recibo");
		
		fechaIngreso1 = new DatePicker();
		fechaIngreso2 = new DatePicker();
		fechaIngreso3 = new DatePicker();
		
		txtGarante1.setReadOnly(true);
		txtGarante2.setReadOnly(true);
		txtGarante3.setReadOnly(true);
		
		txtPropiedad1.setReadOnly(true);
		txtPropiedad2.setReadOnly(true);
		txtPropiedad3.setReadOnly(true);
		
		txtOrganizacion1.setReadOnly(true);
		txtOrganizacion2.setReadOnly(true);
		txtOrganizacion3.setReadOnly(true);
		
		radioGarantia1Recibo.setValue(true);
		radioGarantia2Recibo.setValue(true);
		radioGarantia3Recibo.setValue(true);
		
		tablaPropiedad1.setVisible(false);
		tablaPropiedad2.setVisible(false);
		tablaPropiedad3.setVisible(false);
		
		ocultarPanelGarantes(separador1, tablaGarante1, tablaBuscarGarante1, 
				tablaPropiedad1, panelEmpleo1);
		ocultarPanelGarantes(separador2, tablaGarante2, tablaBuscarGarante2, 
				tablaPropiedad2, panelEmpleo2);
		ocultarPanelGarantes(separador3, tablaGarante3, tablaBuscarGarante3, 
				tablaPropiedad3, panelEmpleo3);
		
		txtSueldo1.setWidth("45px");
		txtSueldo2.setWidth("45px");
		txtSueldo3.setWidth("45px");
		
		txtDescripcionPropiedad1.setPixelSize(400, 150);
		txtDescripcionPropiedad2.setPixelSize(400, 150);
		txtDescripcionPropiedad3.setPixelSize(400, 150);
		
		tablaCantidadGarantes.setText(0, 0, "Cantidad de Garantes");
		tablaCantidadGarantes.setWidget(0, 1, listCantidadGarantes);
		
		tablaGarante1.setWidget(0, 0, new HTML("<b>Garante 1</b>"));
		tablaGarante1.setWidget(0, 1, radioGarantia1Recibo);
		tablaGarante1.setWidget(0, 2, radioGarantia1Propiedad);
		
		tablaGarante2.setWidget(0, 0, new HTML("<b>Garante 2</b>"));
		tablaGarante2.setWidget(0, 1, radioGarantia2Recibo);
		tablaGarante2.setWidget(0, 2, radioGarantia2Propiedad);

		tablaGarante3.setWidget(0, 0, new HTML("<b>Garante 3</b>"));
		tablaGarante3.setWidget(0, 1, radioGarantia3Recibo);
		tablaGarante3.setWidget(0, 2, radioGarantia3Propiedad);
		
		tablaBuscarGarante1.setWidget(0, 0, txtGarante1);
		tablaBuscarGarante1.setWidget(0, 1, botonBuscarGarante1);

		tablaBuscarGarante2.setWidget(0, 0, txtGarante2);
		tablaBuscarGarante2.setWidget(0, 1, botonBuscarGarante2);

		tablaBuscarGarante3.setWidget(0, 0, txtGarante3);
		tablaBuscarGarante3.setWidget(0, 1, botonBuscarGarante3);
		
		tablaPropiedad1.setText(0, 0, "Seleccione un Inmueble");
		tablaPropiedad1.setWidget(0, 1, botonBuscarPropiedad1);
		tablaPropiedad1.setText(1, 0, "Descripcion de la Propiedad");
		tablaPropiedad1.setWidget(1, 1, txtDescripcionPropiedad1);
		
		tablaPropiedad2.setText(0, 0, "Seleccione un Inmueble");
		tablaPropiedad2.setWidget(0, 1, botonBuscarPropiedad2);
		tablaPropiedad2.setText(1, 0, "Descripcion de la Propiedad");
		tablaPropiedad2.setWidget(1, 1, txtDescripcionPropiedad2);
		
		tablaPropiedad3.setText(0, 0, "Seleccione un Inmueble");
		tablaPropiedad3.setWidget(0, 1, botonBuscarPropiedad3);
		tablaPropiedad3.setText(1, 0, "Descripcion de la Propiedad");
		tablaPropiedad3.setWidget(1, 1, txtDescripcionPropiedad3);

		tablaLugarEmpleo1.setText(0, 0, "Empresa donde trabaja");
		tablaLugarEmpleo1.setWidget(0, 1, txtOrganizacion1);
		tablaLugarEmpleo1.setWidget(0, 2, botonBuscarOrganizacion1);
		tablaLugarEmpleo1.setText(0, 3, "Puesto");
		tablaLugarEmpleo1.setWidget(0, 4, txtPuesto1);
		tablaLugarEmpleo1.setText(1, 0, "Fecha de Ingreso");
		tablaLugarEmpleo1.setWidget(1, 1, fechaIngreso1);
		
		tablaLugarEmpleo2.setText(0, 0, "Empresa donde trabaja");
		tablaLugarEmpleo2.setWidget(0, 1, txtOrganizacion2);
		tablaLugarEmpleo2.setWidget(0, 2, botonBuscarOrganizacion2);
		tablaLugarEmpleo2.setText(0, 3, "Puesto");
		tablaLugarEmpleo2.setWidget(0, 4, txtPuesto2);
		tablaLugarEmpleo2.setText(1, 0, "Fecha de Ingreso");
		tablaLugarEmpleo2.setWidget(1, 1, fechaIngreso2);
		
		tablaLugarEmpleo3.setText(0, 0, "Empresa donde trabaja");
		tablaLugarEmpleo3.setWidget(0, 1, txtOrganizacion3);
		tablaLugarEmpleo3.setWidget(0, 2, botonBuscarOrganizacion3);
		tablaLugarEmpleo3.setText(0, 3, "Puesto");
		tablaLugarEmpleo3.setWidget(0, 4, txtPuesto3);
		tablaLugarEmpleo3.setText(1, 0, "Fecha de Ingreso");
		tablaLugarEmpleo3.setWidget(1, 1, fechaIngreso3);
		
		tablaMontoEmpleo1.setText(0, 0, "Moneda");
		tablaMontoEmpleo1.setWidget(0, 1, listMoneda1);
		tablaMontoEmpleo1.setText(0, 2, "Monto");
		tablaMontoEmpleo1.setWidget(0, 3, txtSueldo1);
		tablaMontoEmpleo1.setText(0, 4, "Aclaración (Letras)");
		tablaMontoEmpleo1.setWidget(0, 5, txtSueldoLetras1);
		
		tablaMontoEmpleo2.setText(0, 0, "Moneda");
		tablaMontoEmpleo2.setWidget(0, 1, listMoneda2);
		tablaMontoEmpleo2.setText(0, 2, "Monto");
		tablaMontoEmpleo2.setWidget(0, 3, txtSueldo2);
		tablaMontoEmpleo2.setText(0, 4, "Aclaración (Letras)");
		tablaMontoEmpleo2.setWidget(0, 5, txtSueldoLetras2);
		
		tablaMontoEmpleo3.setText(0, 0, "Moneda");
		tablaMontoEmpleo3.setWidget(0, 1, listMoneda3);
		tablaMontoEmpleo3.setText(0, 2, "Monto");
		tablaMontoEmpleo3.setWidget(0, 3, txtSueldo3);
		tablaMontoEmpleo3.setText(0, 4, "Aclaración (Letras)");
		tablaMontoEmpleo3.setWidget(0, 5, txtSueldoLetras3);
		
		panelEmpleo1.add(tablaLugarEmpleo1);
		panelEmpleo1.add(tablaMontoEmpleo1);
		
		panelEmpleo2.add(tablaLugarEmpleo2);
		panelEmpleo2.add(tablaMontoEmpleo2);
		
		panelEmpleo3.add(tablaLugarEmpleo3);
		panelEmpleo3.add(tablaMontoEmpleo3);
		
		panelGarantes.add(tablaCantidadGarantes);
		panelGarantes.add(separador1);
		panelGarantes.add(tablaGarante1);
		panelGarantes.add(tablaBuscarGarante1);
		panelGarantes.add(tablaPropiedad1);
		panelGarantes.add(panelEmpleo1);
		panelGarantes.add(separador2);
		panelGarantes.add(tablaGarante2);
		panelGarantes.add(tablaBuscarGarante2);
		panelGarantes.add(tablaPropiedad2);
		panelGarantes.add(panelEmpleo2);
		panelGarantes.add(separador3);
		panelGarantes.add(tablaGarante3);
		panelGarantes.add(tablaBuscarGarante3);
		panelGarantes.add(tablaPropiedad3);
		panelGarantes.add(panelEmpleo3);
		
		listCantidadGarantes.addChangeHandler(new ChangeHandler()
		{
			
			public void onChange(ChangeEvent arg0)
			{
				if (listCantidadGarantes.getSelectedIndex() == 0)
				{
					ocultarPanelGarantes(separador1, tablaGarante1, 
							tablaBuscarGarante1, tablaPropiedad1, panelEmpleo1);
					ocultarPanelGarantes(separador2, tablaGarante2, 
							tablaBuscarGarante2, tablaPropiedad2, panelEmpleo2);
					ocultarPanelGarantes(separador3, tablaGarante3, 
							tablaBuscarGarante3, tablaPropiedad3, panelEmpleo3);
				}
				else if (listCantidadGarantes.getSelectedIndex() == 1)
				{
					mostrarPanelGarantes(separador1, tablaGarante1, 
							tablaBuscarGarante1, tablaPropiedad1, panelEmpleo1);
					ocultarPanelGarantes(separador2, tablaGarante2,
							tablaBuscarGarante2, tablaPropiedad2, panelEmpleo2);
					ocultarPanelGarantes(separador3, tablaGarante3,
							tablaBuscarGarante3, tablaPropiedad3, panelEmpleo3);
				}
				else if (listCantidadGarantes.getSelectedIndex() == 2)
				{
					mostrarPanelGarantes(separador1, tablaGarante1, 
							tablaBuscarGarante1, tablaPropiedad1, panelEmpleo1);
					mostrarPanelGarantes(separador2, tablaGarante2, 
							tablaBuscarGarante2, tablaPropiedad2, panelEmpleo2);
					ocultarPanelGarantes(separador3, tablaGarante3, 
							tablaBuscarGarante3, tablaPropiedad3, panelEmpleo3);
				}
				else
				{
					mostrarPanelGarantes(separador1, tablaGarante1, 
							tablaBuscarGarante1, tablaPropiedad1, panelEmpleo1);
					mostrarPanelGarantes(separador2, tablaGarante2, 
							tablaBuscarGarante2, tablaPropiedad2, panelEmpleo2);
					mostrarPanelGarantes(separador3, tablaGarante3, 
							tablaBuscarGarante3, tablaPropiedad3, panelEmpleo3);
				}
			}
		});
		
		botonBuscarGarante1.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				if (radioGarantia1Propiedad.getValue())
				{
					buscarGarantePropierario1.showDialog();
				}
				else
				{
					buscarGarante1.showDialog();
				}
				
			}
		});
		
		botonBuscarGarante2.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				if (radioGarantia2Propiedad.getValue())
				{
					buscarGarantePropierario2.showDialog();
				}
				else
				{
					buscarGarante2.showDialog();
				}
			}
		});
		
		botonBuscarGarante3.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				if (radioGarantia3Propiedad.getValue())
				{
					buscarGarantePropierario3.showDialog();
				}
				else
				{
					buscarGarante3.showDialog();
				}
			}
		});
		
		botonBuscarPropiedad1.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				PropietarioBean garante1 =
					(PropietarioBean) containerGarante1.getPersona();
				buscarGarantiaInmueble1 = new BuscarInmueble(
						garante1.getIdPropietario(), 
						containerGarantiaPropiedad1 , txtDescripcionPropiedad1, 
						null, service);
				buscarGarantiaInmueble1.showDialog();
			}
		});
		
		botonBuscarPropiedad2.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				PropietarioBean garante2 = 
					(PropietarioBean) containerGarante2.getPersona();
				buscarGarantiaInmueble2 = new BuscarInmueble(
						garante2.getIdPropietario(), 
						containerGarantiaPropiedad2 , txtDescripcionPropiedad1, 
						null, service);
				buscarGarantiaInmueble2.showDialog();
			}
		});
		
		botonBuscarPropiedad3.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				PropietarioBean garante3 =
					(PropietarioBean) containerGarante3.getPersona();
				buscarGarantiaInmueble3 = new BuscarInmueble(
						garante3.getIdPropietario(), 
						containerGarantiaPropiedad3, txtDescripcionPropiedad3, 
						null, service);
				buscarGarantiaInmueble3.showDialog();
				
				buscarInmueble = new BuscarInmueble(hiddenLocador.getValue(), 
						propiedadContainer, txtDescripcionPropiedad, 
						new TipoDisponibilidadBean("1", "", ""), service);
				buscarInmueble.showDialog();
			}
		});
		
		botonBuscarOrganizacion1.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarOrganizacion1.showDialog();
			}
		});
		
		botonBuscarOrganizacion2.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarOrganizacion2.showDialog();
			}
		});
		
		botonBuscarOrganizacion3.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarOrganizacion3.showDialog();
			}
		});
		
		radioGarantia1Propiedad.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{
			
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia1Propiedad.getValue())
				{
					tablaPropiedad1.setVisible(true);
					panelEmpleo1.setVisible(false);
					if (containerGarante1.getPersona() != null && 
							containerGarante1.getPersona().getTipoPersona() != 
								TipoPersona.PROPIETARIO)
					{
						txtGarante1.setText("");
					}
				}
			}
		});
		
		radioGarantia1Recibo.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{
			
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia1Recibo.getValue())
				{
					tablaPropiedad1.setVisible(false);
					panelEmpleo1.setVisible(true);
					txtDescripcionPropiedad1.setText("");
				}
			}
		});

		radioGarantia2Propiedad.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia2Propiedad.getValue())
				{
					tablaPropiedad2.setVisible(true);
					panelEmpleo2.setVisible(false);
					if (containerGarante2.getPersona() != null && 
							containerGarante2.getPersona().getTipoPersona() != 
								TipoPersona.PROPIETARIO)
					{
						txtGarante2.setText("");
					}
				}
			}
		});

		radioGarantia2Recibo.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia2Recibo.getValue())
				{
					tablaPropiedad2.setVisible(false);
					panelEmpleo2.setVisible(true);
					txtDescripcionPropiedad2.setText("");
				}
			}
		});
		
		radioGarantia3Propiedad.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{					
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia3Propiedad.getValue())
				{
					tablaPropiedad3.setVisible(true);
					panelEmpleo3.setVisible(false);
					if (containerGarante3.getPersona() != null && 
							containerGarante3.getPersona().getTipoPersona() != 
								TipoPersona.PROPIETARIO)
					{
						txtGarante3.setText("");
					}
				}
			}
		});
				
		radioGarantia3Recibo.addValueChangeHandler(new 
				ValueChangeHandler<Boolean>()
		{				
			public void onValueChange(ValueChangeEvent<Boolean> arg0)
			{
				if (radioGarantia3Recibo.getValue())
				{
					tablaPropiedad3.setVisible(false);
					panelEmpleo3.setVisible(true);
					txtDescripcionPropiedad3.setText("");
				}
			}
		});
	}
	
	private void mostrarPanelGarantes(HTML separador, FlexTable tablaGarantes, 
			FlexTable tablaBuscarGarante, FlexTable tablaPropiedad, 
			VerticalPanel panelEmpleo)
	{
		separador.setVisible(true);
		tablaGarantes.setVisible(true);
		tablaBuscarGarante.setVisible(true);
		RadioButton radio = (RadioButton) tablaGarantes.getWidget(0, 1);
		if (radio.getValue())
		{
			panelEmpleo.setVisible(true);
		}
		else
		{
			tablaPropiedad.setVisible(true);
		}
	}
	
	private void ocultarPanelGarantes(HTML separador, FlexTable tablaGarantes, 
			FlexTable tablaBuscarGarante, FlexTable tablaPropiedad, 
			VerticalPanel panelEmpleo)
	{
		separador.setVisible(false);
		tablaGarantes.setVisible(false);
		tablaBuscarGarante.setVisible(false);
		panelEmpleo.setVisible(false);
		tablaPropiedad.setVisible(false);
	}
	
	private void completarPanelUsoFamiliar()
	{
		checkUsoFamiliar = new CheckBox("Destino a vivienda familiar");
		checkUsoFamiliar.setValue(true);
	}

	@Override
	protected void completarPanelSubmit()
	{
		panelSubmit = new HorizontalPanel();
		submit = new Submit("Registrar");
		botonVistaPreliminar = new Button("Vista Preliminar");

		botonVistaPreliminar.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				String html = "entra";
				Window.alert(html);
				List<GarantiaBean> garantes = getGarantes();
				if (garantes != null)
				{
					html = ConstantesContrato.getGarantes(garantes);
				}
				else
				{
					html = "llega vacio!!!";
				}
				Window.alert(html);
				AsyncCallback<Bool> callback = new AsyncCallback<Bool>()
				{

					public void onFailure(Throwable arg0)
					{
						Window.alert(arg0.getMessage());
					}

					public void onSuccess(Bool arg0)
					{
						if(!arg0.isValue())
						{
							Window.alert("Error al Generar la Vista Preliminar");
						}
						else
						{
							Window.open("/inmobiliaria/pages/altas/vistaPreliminarContrato.jsp", "_blank", "");
						}
					}
				};
				service.sendContrato(html, callback);
			}
		});

		panelSubmit.add(botonVistaPreliminar);
		panelSubmit.add(submit);
	}

	@Override
	protected void completarPanelErrores()
	{
		panelErrores = new VerticalPanel();
		errorLocadora = new MensajeError("Locadora", TipoError.REQUERIDO);
		errorLocataria = new MensajeError("Locataria", TipoError.REQUERIDO);
		errorFechaDesde = new MensajeError("Fecha Desde", TipoError.REQUERIDO);
		errorFechaHasta = new MensajeError("Fecha Hasta", TipoError.REQUERIDO);
		errorInteresEntregaNumerico = new MensajeError("Interes en Caso de " +
				"no devolver la Propiedad en Término", TipoError.NUMERICO);
		errorInteresPagoNumerico = new MensajeError("Interés por pago fuera " +
				"de término", TipoError.NUMERICO);
		errorMontoNumerico = new MensajeError("Monto", TipoError.NUMERICO);

		panelErrores.add(errorLocadora);
		panelErrores.add(errorLocataria);
		panelErrores.add(errorFechaDesde);
		panelErrores.add(errorFechaHasta);
		panelErrores.add(errorMontoNumerico);
		panelErrores.add(errorInteresEntregaNumerico);
		panelErrores.add(errorInteresPagoNumerico);
	}

	private void completarComboTipoInteres(ListBox listInteres) 
	{
		listInteres.addItem("Diario", "diario");
		listInteres.addItem("Mensual", "mensual");
		listInteres.addItem("Anual", "anual");
	}

//	private void completarComboLugar()
//	{
//		listLugar.addItem("Inmueble", "inmueble");
//		listLugar.addItem("Inmobialiaria", "inmobiliaria");
//	}

	private void completarComboMoneda()
	{
		listMoneda1 = new ListBox();
		listMoneda2 = new ListBox();
		listMoneda3 = new ListBox();
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
					listMoneda.addItem(result[i].getNombre(), 
							result[i].getIdMoneda());
					listMoneda1.addItem(result[i].getNombre(), 
							result[i].getIdMoneda());
					listMoneda2.addItem(result[i].getNombre(), 
							result[i].getIdMoneda());
					listMoneda3.addItem(result[i].getNombre(), 
							result[i].getIdMoneda());
					mapMonedas.put(result[i].getIdMoneda(), result[i]);
				}

			}
		};
		service.getMonedas(callback);
	}
	
	private void completarComboTipoPintura()
	{
		listTipoPinturaInmueble = new ListBox();
		listTipoPinturaInmueble.addItem("Pintura al Látex");
		listTipoPinturaInmueble.addItem("Pintura al Agua");
		listTipoPinturaInmueble.addItem("Pintura al Aceite");
	}

	@Override
	protected boolean validarCampos()
	{
		// TODO Auto-generated method stub
		return true;
	}

	private void limpiarLocatario()
	{
		if ((radioLocatarioPersona.getValue() && selectedLocatario.equals("organizacion"))
				|| (radioLocatarioOrganizacion.getValue() && selectedLocatario.equals("persona")))
		{
			if (selectedLocatario.equals("persona"))
			{
				selectedLocatario = "organizacion";
			}
			else
			{
				selectedLocatario = "persona";
			}
			hiddenLocador.setValue("");
			txtLocador.setText("");
		}		
	}	

	private void limpiarLocador()
	{
		if ((radioLacadorPersona.getValue() 
				&& selectedLocador.equals("organizacion"))
				|| (radioLacadorOrganizacion.getValue() 
						&& selectedLocador.equals("persona")))
		{
			if (selectedLocador.equals("persona"))
			{
				selectedLocador = "organizacion";
			}
			else
			{
				selectedLocador = "persona";
			}
			hiddenLocador.setValue("");
			txtLocador.setText("");
		}		
	}

	private void generarContrato()
	{
		if (validarCampos())
		{
			ContratoBean contrato = new ContratoBean();
			List<ClausulaBean> clausulas = new ArrayList<ClausulaBean>();
			clausulas.add(new ClausulaBean("", "", 
					ConstantesContrato.getPartes(contenedorLocador.getPersona(), 
							contenedorLocatario.getPersona()), "0"));
			clausulas.add(new ClausulaBean("", ConstantesContrato._01_INMUEBLE, 
					ConstantesContrato.getInmueble(propiedadContainer.
							getPropiedad(), txtDescripcionPropiedad.getText(), 
							checkModificaciones.getValue()), "1"));
			clausulas.add(new ClausulaBean("", ConstantesContrato._02_TERMINO, 
					ConstantesContrato.getTermino(fechaDesde.getText(), 
							txtPeriodo.getText(), 
							txtInteresPorEntrega.getText(), 
							listInteresPorEntrega.getItemText(
									listInteresPorEntrega.getSelectedIndex()), 
							checkPermitirUtilizar.getValue()), "2"));
			clausulas.add(new ClausulaBean("", ConstantesContrato._03_PRECIO, 
					ConstantesContrato.getPrecio(txtMonto.getText(), 
							txtDescripcionMonto.getText(), 
							mapMonedas.get(listMoneda.getValue(listMoneda.
									getSelectedIndex())), 
							checkRenegociarAnualmente.getValue(), 
							checkContemplaIVA.getValue()), "3"));
			clausulas.add(new ClausulaBean("", ConstantesContrato._04_PAGO, 
					ConstantesContrato.getPago(
							propiedadContainer.getPropiedad(), 
							listInteresPorPago.getItemText(listInteresPorPago.
									getSelectedIndex()),  
							txtInteresPorPago.getText(), txtPagoDesde.getText(), 
							txtPagoHasta.getText()), "4"));
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._05_CONDICIONES_DEL_INMUEBLE, 
					ConstantesContrato.getCondicionesInmueble(
							txtColorInmueble.getText(), 
							listTipoPinturaInmueble.getItemText(
									listTipoPinturaInmueble.getSelectedIndex()), 
							txtCondicionesExtras.getText()), "5"));
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._06_INTRANSFERIBILIDAD, 
					ConstantesContrato.getIntransferibilidad(), "6"));
			int numeroOrden = 7;
			if (checkUsoFamiliar.isEnabled() && checkUsoFamiliar.getValue())
			{
				clausulas.add(new ClausulaBean("", 
						ConstantesContrato._07_GRUPO_FAMILIAR, 
						ConstantesContrato.getGrupoFamiliar(
								contenedorLocatario.getPersona()), 
								String.valueOf(numeroOrden)));
				numeroOrden++;
			}
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._08_PROHIBICIONES, 
					ConstantesContrato.getProhibiciones(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._09_IMPUESTOS_TASAS_SERVICIOS, 
					ConstantesContrato.getProhibiciones(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._10_RESPONSABILIDADES_LOCATARIA, 
					ConstantesContrato.getResponsabilidadesLocataria(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._11_RESPONSABILIDADES_LOCADORA, 
					ConstantesContrato.getResponsabilidadesLocadora(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._12_CONSIGNACION_DE_LLAVES, 
					ConstantesContrato.getConsignacionLlaves(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._13_INCUMPLIMIENTO_DESALOJO, 
					ConstantesContrato.getIncumplimientoDesalojo(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._14_RESCISION, 
					ConstantesContrato.getRescision(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._15_SELLADOS, 
					ConstantesContrato.getSellados(),
					String.valueOf(numeroOrden)));
			numeroOrden++;
			clausulas.add(new ClausulaBean("", 
					ConstantesContrato._16_COSTOS_HONORARIOS, 
					ConstantesContrato.getCostosYHonorarios(),
					String.valueOf(numeroOrden)));
			List<GarantiaBean> garantes = getGarantes();
			if (garantes != null)
			{
				numeroOrden++;
				clausulas.add(new ClausulaBean("", 
						ConstantesContrato._17_GARANTES, 
						ConstantesContrato.getGarantes(garantes),
						String.valueOf(numeroOrden)));
				
			}
			numeroOrden++;
			
		}
	}
	
	private List<GarantiaBean> getGarantes ()
	{
		List<GarantiaBean> garantes = null;
		int cantidadGarantes = Integer.valueOf(listCantidadGarantes.
				getValue(listCantidadGarantes.getSelectedIndex()));
		if (cantidadGarantes > 0)
		{
			garantes = new ArrayList<GarantiaBean>();
			if (cantidadGarantes == 1)
			{
				if (radioGarantia1Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante1, txtDescripcionPropiedad1));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante1, 
							hiddenDireccionOrganizacion1, txtPuesto1, listMoneda1, 
							txtSueldo1, txtSueldoLetras1, fechaIngreso1));
				}
			}
			else if (cantidadGarantes == 2)
			{
				if (radioGarantia1Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante1, txtDescripcionPropiedad1));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante1, 
							hiddenDireccionOrganizacion1, txtPuesto1, listMoneda1, 
							txtSueldo1, txtSueldoLetras1, fechaIngreso1));
				}
				if (radioGarantia2Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante2, txtDescripcionPropiedad2));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante2, 
							hiddenDireccionOrganizacion2, txtPuesto2, listMoneda2, 
							txtSueldo2, txtSueldoLetras2, fechaIngreso2));
				}
			}
			else if (cantidadGarantes == 3)
			{
				if (radioGarantia1Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante1, txtDescripcionPropiedad1));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante1, 
							hiddenDireccionOrganizacion1, txtPuesto1, listMoneda1, 
							txtSueldo1, txtSueldoLetras1, fechaIngreso1));
				}
				if (radioGarantia2Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante2, txtDescripcionPropiedad2));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante2, 
							hiddenDireccionOrganizacion2, txtPuesto2, listMoneda2, 
							txtSueldo2, txtSueldoLetras2, fechaIngreso2));
				}
				if (radioGarantia3Propiedad.getValue())
				{
					garantes.add(generarGarantePropietario(
							containerGarante3, txtDescripcionPropiedad3));
				}
				else
				{
					garantes.add(generarGaranteRecibo(containerGarante3, 
							hiddenDireccionOrganizacion3, txtPuesto3, listMoneda3, 
							txtSueldo3, txtSueldoLetras3, fechaIngreso3));
				}
			}
		}
		return garantes;
	}
	
	private GarantiaBean generarGarantePropietario(PersonaContainer 
			containerGarante, TextArea descripcionPropiedad)
	{
		GarantiaBean garantia = new GarantiaBean();
		garantia.setTipoGarantia(TipoGarantia.PROPIETARIA);
		garantia.setGarante(containerGarante.getPersona());
		garantia.setDescripcionGarantia(descripcionPropiedad.getText());
		return garantia;
	}
	
	private GarantiaBean generarGaranteRecibo(PersonaContainer containerGarante, 
			Hidden direccion, TextBox txtPuesto, ListBox listMoneda, 
			TextBox txtMonto, TextBox txtMontoLetras, DatePicker fechaIngreso)
	{
		GarantiaBean garantia = new GarantiaBean();
		garantia.setTipoGarantia(TipoGarantia.SUELDO);
		garantia.setGarante(containerGarante.getPersona());
		StringBuilder descripcion = new StringBuilder();
		descripcion.append(txtOrganizacion1.getValue());
		descripcion.append(" sito en ");
		descripcion.append(direccion.getValue());
		descripcion.append(" con categoría de ");
		descripcion.append(txtPuesto.getText().trim());
		descripcion.append(", y fecha de ingreso el ");
		descripcion.append(fechaIngreso.getText());
		descripcion.append(", con un sueldo mensual de ");
		descripcion.append(
				listMoneda.getItemText(listMoneda.getSelectedIndex()));
		descripcion.append(" ");
		descripcion.append(txtMontoLetras.getText().trim());
		descripcion.append(" (");
		descripcion.append(
				listMoneda.getItemText(listMoneda.getSelectedIndex()));
		descripcion.append(txtMonto.getText().trim());
		descripcion.append(")");
		garantia.setDescripcionGarantia(descripcion.toString());
		return garantia;
	}
}
