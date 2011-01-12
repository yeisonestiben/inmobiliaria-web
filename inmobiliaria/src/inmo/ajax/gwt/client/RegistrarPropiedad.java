package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarBarrio;
import inmo.ajax.gwt.client.busquedas.BuscarPersona;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.EstadoPropiedadBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.ajax.gwt.client.widgets.DatePicker;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
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

public class RegistrarPropiedad extends Registro implements EntryPoint
{

	private RegistrarPropiedadServiceAsync registrarPropiedadSvc = 
		GWT.create(RegistrarPropiedadService.class);

	//Mensajes de Error
	VerticalPanel panelErrores = new VerticalPanel();
	MensajeError errorPropietario;
	MensajeError errorFecha;
	MensajeError errorMetrosCubiertosRequerido;
	MensajeError errorMetrosCubiertosNumerico;
	MensajeError errorMetrosPatioNumerico;
	MensajeError errorMetrosParcelaRequerido;
	MensajeError errorMetrosParcelaNumerico;
	MensajeError errorCalle;
	MensajeError errorNumeroRequrido;
	MensajeError errorNumeroNumerico;
	MensajeError errorPiso;
	MensajeError errorBarrio;
	MensajeError errorMonto;

	//Datos de la Propiedad
	private FlexTable tablaDatosPropiedad = new FlexTable();
	final ListBox listTipoPropiedad = new ListBox();
	final TextBox textPropietario = new TextBox();
	final ListBox listEstadoPropiedad = new ListBox();
	final DatePicker dateFechaConstruccion = new DatePicker();
	final ListBox listAmbientes = new ListBox();
	final ListBox listDormitorios = new ListBox();
	final ListBox listBanios = new ListBox();
	final TextBox textMetrosCubiertos = new TextBox();
	final TextBox textMetrosPatio = new TextBox();
	final TextBox textMetrosParcela = new TextBox();
	final Button botonBuscarPropietario = new Button("...");
	private Hidden hiddenIdPropietario = new Hidden();
	final BuscarPersona dialogBuscarPropietario = new BuscarPersona(
			TipoPersona.PROPIETARIO, hiddenIdPropietario, new PersonaContainer(), textPropietario, 
			registrarPropiedadSvc);


	//Dirección de la Propiedad
	final FlexTable tablaDireccion = new FlexTable();
	final TextBox textCalle = new TextBox();
	final TextBox textNumero = new TextBox();
	final TextBox textPiso = new TextBox();
	final TextBox textDepartamento = new TextBox();
	final TextBox textBarrio = new TextBox();
	final TextBox textLocalidad = new TextBox();
	final TextBox textProvincia = new TextBox();
	final TextBox textCodigoPostal = new TextBox();
	final Button botonBuscarBarrio = new Button("...");
	private Hidden hiddenIdBarrio = new Hidden();
	final BuscarBarrio dialogBuscarBarrio = new BuscarBarrio(hiddenIdBarrio, 
			textBarrio, textLocalidad, textProvincia, registrarPropiedadSvc);

	//Disponibilidad
	private FlexTable tablaDisponibilidad = new FlexTable();
	final ListBox listTipoDisponibilidad = new ListBox();
	final ListBox listMoneda = new ListBox();
	final TextBox textMonto = new TextBox();

	//Boton Submit
	Submit submit = new Submit("Aceptar");

	public void onModuleLoad() 
	{	
		/**
		 * Inicializo los paneles a Agregar
		 */
		completarPanelErrores();
		completarPanelDatosPropiedad();
		completarPanelDireccionPropiedad();
		completarPanelDisponibilidad();
		completarPanelSubmit();

		/**
		 * Acá agrego los paneles a las JSP
		 */
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("datosPropiedad").add(tablaDatosPropiedad);
		RootPanel.get("direccion").add(tablaDireccion);
		RootPanel.get("disponibilidad").add(tablaDisponibilidad);
		RootPanel.get("submit").add(submit);
	}

	@Override
	protected void completarPanelErrores() 
	{
		errorPropietario = new MensajeError("Propietario", TipoError.REQUERIDO);
		errorFecha = new MensajeError("Fecha de Construcción", TipoError.REQUERIDO);
		errorMetrosCubiertosRequerido = new MensajeError("Metros Cubiertos", TipoError.REQUERIDO);
		errorMetrosCubiertosNumerico = new MensajeError("Metros Cubiertos", TipoError.NUMERICO);
		errorMetrosPatioNumerico = new MensajeError("Metros Patio", TipoError.NUMERICO);
		errorMetrosParcelaNumerico = new MensajeError("Metros de Parcela", TipoError.NUMERICO);
		errorMetrosParcelaRequerido = new MensajeError("Metros de Parcela", TipoError.REQUERIDO);
		errorCalle = new MensajeError("Calle", TipoError.REQUERIDO);
		errorNumeroRequrido = new MensajeError("Número", TipoError.REQUERIDO);
		errorNumeroNumerico = new MensajeError("Número", TipoError.NUMERICO);
		errorPiso = new MensajeError("Piso", TipoError.NUMERICO);
		errorBarrio = new MensajeError("Barrio", TipoError.REQUERIDO);
		errorMonto = new MensajeError("Monto", TipoError.NUMERICO);

		panelErrores.add(errorPropietario);
		panelErrores.add(errorFecha);
		panelErrores.add(errorMetrosCubiertosRequerido);
		panelErrores.add(errorMetrosCubiertosNumerico);
		panelErrores.add(errorMetrosPatioNumerico);
		panelErrores.add(errorMetrosParcelaNumerico);
		panelErrores.add(errorMetrosParcelaRequerido);
		panelErrores.add(errorCalle);
		panelErrores.add(errorNumeroRequrido);
		panelErrores.add(errorNumeroNumerico);
		panelErrores.add(errorPiso);
		panelErrores.add(errorBarrio);	
		panelErrores.add(errorMonto);

	}

	private void completarPanelDatosPropiedad() {
		textPropietario.setReadOnly(true);
		completarComboTipoPropiedad();
		completarComboEstado();
		completarCombosAmbientes();
		completarComboDormitorios();
		completarComboBanios();

		botonBuscarPropietario.addClickHandler(new ClickHandler() 
		{
			public void onClick(ClickEvent event) 
			{
				dialogBuscarPropietario.showDialog();		
			}
		});

		tablaDatosPropiedad.setText(0, 0, "Tipo");
		tablaDatosPropiedad.setWidget(0, 1, listTipoPropiedad);
		tablaDatosPropiedad.setText(0, 2, "Propietario");
		HorizontalPanel panelPropietario = new HorizontalPanel();
		panelPropietario.add(textPropietario);
		panelPropietario.add(botonBuscarPropietario);
		tablaDatosPropiedad.setWidget(0, 3, panelPropietario);
		tablaDatosPropiedad.setText(1, 0, "Estado");
		tablaDatosPropiedad.setWidget(1, 1, listEstadoPropiedad);
		tablaDatosPropiedad.setText(1, 2, "Fecha Contrucción");
		tablaDatosPropiedad.setWidget(1, 3, dateFechaConstruccion);
		tablaDatosPropiedad.setText(2, 0, "Ambientes");
		tablaDatosPropiedad.setWidget(2, 1, listAmbientes);
		tablaDatosPropiedad.setText(2, 2, "Dormitorios");
		tablaDatosPropiedad.setWidget(2, 3, listDormitorios);
		tablaDatosPropiedad.setText(3, 0, "Baños");
		tablaDatosPropiedad.setWidget(3, 1, listBanios);
		tablaDatosPropiedad.setText(3, 2, "Metros Cubiertos");
		tablaDatosPropiedad.setWidget(3, 3, textMetrosCubiertos);
		tablaDatosPropiedad.setText(4, 0, "Metros Patio");
		tablaDatosPropiedad.setWidget(4, 1, textMetrosPatio);
		tablaDatosPropiedad.setText(4, 2, "Metros Parcela");
		tablaDatosPropiedad.setWidget(4, 3, textMetrosParcela);
	}

	private void completarPanelDireccionPropiedad() {
		botonBuscarBarrio.addClickHandler(new ClickHandler() 
		{
			public void onClick(ClickEvent event) 
			{
				dialogBuscarBarrio.showDialog();		
			}
		});
		textBarrio.setReadOnly(true);
		textLocalidad.setReadOnly(true);
		textProvincia.setReadOnly(true);

		tablaDireccion.setText(0, 0, "Calle");
		tablaDireccion.setText(0, 2, "Número");
		tablaDireccion.setText(1, 0, "Piso");
		tablaDireccion.setText(1, 2, "Departamento");
		tablaDireccion.setText(2, 0, "Código Postal");
		tablaDireccion.setText(2, 2, "Barrio");
		tablaDireccion.setText(3, 0, "Localidad");
		tablaDireccion.setText(3, 2, "Provincia");

		tablaDireccion.setWidget(0, 1, textCalle);
		tablaDireccion.setWidget(0, 3, textNumero);
		tablaDireccion.setWidget(1, 1, textPiso);
		tablaDireccion.setWidget(1, 3, textDepartamento);
		tablaDireccion.setWidget(2, 1, textCodigoPostal);
		tablaDireccion.setWidget(2, 3, textBarrio);
		tablaDireccion.setWidget(2, 4, botonBuscarBarrio);
		tablaDireccion.setWidget(3, 1, textLocalidad);
		tablaDireccion.setWidget(3, 3, textProvincia);
	}

	private void completarPanelDisponibilidad() {
		completarComboMoneda();
		completarComboTipoDisponibilidad();

		tablaDisponibilidad.setText(0, 0, "Tipo Disponibilidad");
		tablaDisponibilidad.setText(0, 2, "Moneda");
		tablaDisponibilidad.setText(1, 0, "Monto");
		tablaDisponibilidad.setWidget(0, 1, listTipoDisponibilidad);
		tablaDisponibilidad.setWidget(0, 3, listMoneda);
		tablaDisponibilidad.setWidget(1, 1, textMonto);
	}

	@Override
	protected void completarPanelSubmit() {
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
					boolean registrar  = true;
					boolean registrarDisponibilidad = true;

					if (textMonto.getText().trim().equals(""))
					{
						registrar = Window.confirm("El campo Disponibilidad está incompleto. ¿Desea Continuar?");
						registrarDisponibilidad = false;
					}

					if (registrar)
					{
						boolean confirm = Window.confirm("¿Está seguro que desea registrar la nueva Propiedad?");
						if (confirm)
						{
							realizarRegistroPropiedad(submit, registrarDisponibilidad);
						}
					}
				}	
				else
				{
					Window.scrollTo(0, 0);
				}
			}
		});
	}

	private void completarComboTipoPropiedad() 
	{
		if (registrarPropiedadSvc == null) {
			registrarPropiedadSvc = GWT.create(RegistrarPropiedadService.class);
		}
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
			registrarPropiedadSvc.getTipoPropiedades(callback);
	}

	private void completarComboEstado() {
		if (registrarPropiedadSvc == null) {
			registrarPropiedadSvc = GWT.create(RegistrarPropiedadService.class);
		}
		AsyncCallback<EstadoPropiedadBean[]> callback = 
			new AsyncCallback<EstadoPropiedadBean[]>()
			{
				public void onFailure(Throwable arg0)
				{
					Window.alert("Error al traer los Estados");
				}

				public void onSuccess(EstadoPropiedadBean[] result)
				{
					for (int i = 0; i<result.length; i++)
					{
						listEstadoPropiedad.addItem(result[i].getNombre(), 
								result[i].getIdEstadoPropiedad());
					}

				}
			};
			registrarPropiedadSvc.getEstadoPropiedad(callback);
	}

	private void completarCombosAmbientes() {
		for (int i = 0 ; i <= 5; i++) {
			listAmbientes.addItem((i==5) ? i+" ó mas" : String.valueOf(i), 
					String.valueOf(i));
		}
	}

	private void completarComboBanios() {
		for (int i = 0 ; i <= 5; i++) {
			listBanios.addItem((i==5) ? i+" ó mas" : String.valueOf(i), 
					String.valueOf(i));
		}
	}

	private void completarComboDormitorios() {
		for (int i = 0 ; i <= 5; i++) {
			listDormitorios.addItem((i==5) ? i+" ó mas" : String.valueOf(i), 
					String.valueOf(i));
		}
	}

	private void completarComboMoneda() {
		if (registrarPropiedadSvc == null) {
			registrarPropiedadSvc = GWT.create(RegistrarPropiedadService.class);
		}
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
				}

			}
		};
		registrarPropiedadSvc.getMonedas(callback);
	}

	private void completarComboTipoDisponibilidad() {
		if (registrarPropiedadSvc == null) {
			registrarPropiedadSvc = GWT.create(RegistrarPropiedadService.class);
		}
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
			registrarPropiedadSvc.getTiposDisponibilidad(callback);
	}

	protected boolean validarCampos() 
	{
		boolean error = false;
		if (textPropietario.getText().trim().equals(""))
		{
			error = true;
			errorPropietario.setVisible(true);
		}
		else
		{
			errorPropietario.setVisible(false);
		}
		if (dateFechaConstruccion.getText().trim().equals(""))
		{
			error = true;
			errorFecha.setVisible(true);
		}
		else
		{
			errorFecha.setVisible(false);
		}
		if (textMetrosCubiertos.getText().trim().equals(""))
		{
			error = true;
			errorMetrosCubiertosRequerido.setVisible(true);
		}
		else
		{
			try {
				Integer.parseInt(textMetrosCubiertos.getText().trim());
				errorMetrosCubiertosNumerico.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorMetrosCubiertosNumerico.setVisible(true);
			}
			errorMetrosCubiertosRequerido.setVisible(false);
		}
		if (!textMetrosPatio.getText().trim().equals(""))
		{
			try {
				Integer.parseInt(textMetrosPatio.getText().trim());
				errorMetrosPatioNumerico.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorMetrosPatioNumerico.setVisible(true);
			}
		}

		if (textMetrosParcela.getText().trim().equals(""))
		{
			error = true;
			errorMetrosParcelaRequerido.setVisible(true);
		}
		else
		{
			try {
				Integer.parseInt(textMetrosParcela.getText().trim());
				errorMetrosParcelaNumerico.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorMetrosParcelaNumerico.setVisible(true);
			}
			errorMetrosParcelaRequerido.setVisible(false);
		}
		if (textCalle.getText().trim().equals(""))
		{
			error = true;
			errorCalle.setVisible(true);
		}
		else
		{
			errorCalle.setVisible(false);
		}
		if (textNumero.getText().trim().equals(""))
		{
			error = true;
			errorNumeroRequrido.setVisible(true);
		}
		else
		{
			try {
				Integer.parseInt(textNumero.getText().trim());
				errorNumeroNumerico.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorNumeroNumerico.setVisible(true);
			}
			errorNumeroRequrido.setVisible(false);
		}
		if (!textPiso.getText().trim().equals(""))
		{
			try {
				Integer.parseInt(textPiso.getText().trim());
				errorPiso.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorPiso.setVisible(true);
			}
		}
		if (textBarrio.getText().trim().equals(""))
		{
			error = true;
			errorBarrio.setVisible(true);
		}
		else
		{
			errorBarrio.setVisible(false);
		}
		if (!textMonto.getText().trim().equals(""))
		{
			try {
				Float.parseFloat(textMonto.getText().trim());
				errorMonto.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorMonto.setVisible(true);
			}
		}
		return error;
	}

	private void realizarRegistroPropiedad(final Submit submit, 
			boolean hasDisponibilidad) 
	{
		TipoPropiedadBean tipoPropiedad = new TipoPropiedadBean(listTipoPropiedad.getValue(listTipoPropiedad.getSelectedIndex()), "", "");

		PropietarioBean propietario = new PropietarioBean(hiddenIdPropietario.getValue().toString(), null, null, null, null, null, null, null, null);

		EstadoPropiedadBean estadoPropiedad = new EstadoPropiedadBean(listEstadoPropiedad.getValue(listEstadoPropiedad.getSelectedIndex()).toString(), null, null);

		BarrioBean barrio = new BarrioBean(hiddenIdBarrio.getValue().toString(), null, null);
		DireccionBean direccion = new DireccionBean(null, null, barrio, textCalle.getText(), textNumero.getText(), textPiso.getText(), textDepartamento.getText(), textCodigoPostal.getText());

		String metrosCubiertos = textMetrosCubiertos.getText();
		String metrosParcela = textMetrosParcela.getText();
		String metrosPatio = textMetrosPatio.getText();
		String ambientes = listAmbientes.getValue(listAmbientes.getSelectedIndex()).toString();
		String dormitorios = listDormitorios.getValue(listDormitorios.getSelectedIndex()).toString();
		String banios = listBanios.getValue(listBanios.getSelectedIndex()).toString();
		String fechaConstruccion = dateFechaConstruccion.getText();

		PropiedadBean propiedad = new PropiedadBean("", tipoPropiedad, 
				direccion, estadoPropiedad, fechaConstruccion, ambientes, 
				dormitorios, banios, metrosPatio, metrosParcela, 
				metrosCubiertos, propietario);
		if (registrarPropiedadSvc == null) {
			registrarPropiedadSvc = GWT.create(RegistrarPropiedadService.class);
		}

		DisponibilidadBean disponibilidad = null;
		if (hasDisponibilidad)
		{
			String monto = textMonto.getText();
			String fecha = Utilidades.getDate(new Date());
			TipoDisponibilidadBean tipoDisponibilidad = 
				new TipoDisponibilidadBean(listTipoDisponibilidad.getValue(listTipoDisponibilidad.getSelectedIndex()).toString(),  null, null);
			MonedaBean moneda = new MonedaBean(listMoneda.getValue(listMoneda.getSelectedIndex()).toString(), null, null, null);
			disponibilidad = new DisponibilidadBean("", moneda, propiedad, tipoDisponibilidad, fecha, "", monto);
		}

		AsyncCallback<Bool> callback = new AsyncCallback<Bool>(){
			public void onFailure(Throwable caught) {
				Window.alert("Hubo un error al registrar la Propiedad. Por " +
						"favor pongase en contacto con el Administrador del " +
						"Sistema.");
				Window.alert(caught.toString());
			}
			public void onSuccess(Bool result) {
				if (result.isValue())
				{
					Window.alert("Se registró correctamente la Propiedad.");
				}
				else
				{
					Window.alert("Hubo un error al registrar la Propiedad. Por " +
							"favor pongase en contacto con el Administrador " +
							"del Sistema.");
				}
				submit.submit();
			}
		};
		registrarPropiedadSvc.savePropiedad(propiedad, disponibilidad, callback);
	}

	@Override
	protected void realizarRegistro(Submit submit)
	{
	}
}
