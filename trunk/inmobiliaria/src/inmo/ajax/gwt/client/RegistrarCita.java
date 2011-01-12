package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarBarrio;
import inmo.ajax.gwt.client.busquedas.BuscarPersona;
import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.CitaBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.MotivoCitaBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.ajax.gwt.client.widgets.DatePicker;
import inmo.ajax.gwt.client.widgets.MensajeError;
import inmo.ajax.gwt.client.widgets.Submit;
import inmo.ajax.gwt.client.widgets.TipoError;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarCita extends Registro implements EntryPoint
{
	private RegistrarCitaServiceAsync service = 
		GWT.create(RegistrarCitaService.class);
	
	//mensajes de error
	VerticalPanel panelErrores;
	MensajeError errorPersona;
	MensajeError errorFecha;
	MensajeError errorHoraRequerido;
	MensajeError errorHoraNumerico;
	MensajeError errorHoraFormato;
	MensajeError errorMinutosRequerido;
	MensajeError errorMinutosNumerico;
	MensajeError errorMinutosFormato;
	MensajeError errorCalle;
	MensajeError errorNumeroDireccionRequerido;
	MensajeError errorNumeroDireccionNumerico;
	MensajeError errorPiso;
	MensajeError errorBarrio;
	MensajeError errorCpp;
	
	//panel Interesado
	private FlexTable tablaInteresado;
	private Hidden hiddenIdCliente;
	private TextBox txtPersona;
	private Button buttonBuscarPersona;
	private BuscarPersona buscarPersona;
	
	//panel Cita
	private FlexTable tablaCita;
	private DatePicker fecha;
	private TextBox txtHora;
	private TextBox txtMinutos;
	private ListBox listMotivos;
	
	//panel Direccion
	private FlexTable tablaDireccion;
	private TextBox txtCalle;
	private TextBox txtNumero;
	private TextBox txtPiso;
	private TextBox txtDepartamento;
	private Hidden hiddenBarrio;
	private TextBox txtBarrio;
	private Button buttonBuscarBarrio;
	private TextBox txtCodigoPostal;
	private BuscarBarrio buscarBarrio;
	
	//Panel Submit
	private Submit submit;
	
	public void onModuleLoad()
	{
		completarPanelErrores();
		completarPanelInteresado();
		completarPanelCita();
		completarPanelDireccion();
		completarPanelSubmit();
		
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("interesado").add(tablaInteresado);
		RootPanel.get("cita").add(tablaCita);
		RootPanel.get("direccion").add(tablaDireccion);
		RootPanel.get("submit").add(submit);
		
	}

	@Override
	protected void completarPanelSubmit()
	{
		/**
		 * Acá inicializo el boton Submit
		 */
		submit = new Submit("Aceptar");
		submit.addClickHandler(new ClickHandler() 
		{		
			public void onClick(ClickEvent event) 
			{
				boolean error = validarCampos();
				
				if (!error)
				{
					boolean confirm = Window.confirm("¿Está seguro que desea " +
							"registrar la Cita?");
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
		panelErrores = new VerticalPanel();
		errorPersona = new MensajeError("Persona", TipoError.REQUERIDO);
		errorFecha = new MensajeError("Fecha", TipoError.REQUERIDO);
		errorHoraRequerido = new MensajeError ("Hora", TipoError.REQUERIDO);
		errorHoraNumerico = new MensajeError("Hora", TipoError.NUMERICO);
		errorHoraFormato = new MensajeError("Hora", TipoError.FORMATO_INVALIDO);
		errorMinutosRequerido = new MensajeError("Minutos", 
				TipoError.REQUERIDO);
		errorMinutosNumerico = new MensajeError("Minutos", TipoError.NUMERICO);
		errorMinutosFormato = new MensajeError("Minutos", 
				TipoError.FORMATO_INVALIDO);
		errorCalle =  new MensajeError("Calle", TipoError.REQUERIDO);
		errorNumeroDireccionRequerido = new MensajeError("Número de Dirección", 
				TipoError.REQUERIDO);
		errorNumeroDireccionNumerico = new MensajeError("Número de Dirección", 
				TipoError.NUMERICO);
		errorPiso = new MensajeError("Piso", TipoError.NUMERICO);
		errorBarrio = new MensajeError("Barrio", TipoError.REQUERIDO);
		errorCpp = new MensajeError("Código Postal", TipoError.REQUERIDO);
		
		panelErrores.add(errorPersona);
		panelErrores.add(errorFecha);
		panelErrores.add(errorHoraRequerido);
		panelErrores.add(errorHoraNumerico);
		panelErrores.add(errorHoraFormato);
		panelErrores.add(errorMinutosRequerido);
		panelErrores.add(errorMinutosNumerico);
		panelErrores.add(errorMinutosFormato);
		panelErrores.add(errorCalle);
		panelErrores.add(errorNumeroDireccionRequerido);
		panelErrores.add(errorNumeroDireccionNumerico);
		panelErrores.add(errorPiso);
		panelErrores.add(errorBarrio);
		panelErrores.add(errorCpp);
	}
	
	private void completarPanelInteresado()
	{
		tablaInteresado = new FlexTable();
		hiddenIdCliente = new Hidden();
		txtPersona = new TextBox();
		txtPersona.setReadOnly(true);
		buttonBuscarPersona = new Button("Buscar");
		buscarPersona = new BuscarPersona(TipoPersona.TODOS, hiddenIdCliente, 
				new PersonaContainer(), txtPersona, service);
		
		tablaInteresado.setText(0, 0, "Persona");
		tablaInteresado.setWidget(0, 1, txtPersona);
		tablaInteresado.setWidget(0, 2, buttonBuscarPersona);
		
		buttonBuscarPersona.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarPersona.showDialog();
			}
		});
	}
	
	private void completarPanelCita()
	{
		tablaCita = new FlexTable();
		fecha = new DatePicker();
		txtHora = new TextBox();
		txtMinutos = new TextBox();
		txtHora.setWidth("20px");
		txtMinutos.setWidth("20px");
		listMotivos = new ListBox();
		completarListaMotivos();
		
		tablaCita.setText(0, 0, "Fecha");
		tablaCita.setWidget(0, 1, fecha);
		tablaCita.setText(0, 3, "Hora");
		tablaCita.setWidget(0, 4, txtHora);
		tablaCita.setText(0, 5, ":");
		tablaCita.setWidget(0, 6, txtMinutos);
		tablaCita.setText(1, 0, "Motivo");
		tablaCita.setWidget(1, 1, listMotivos);
	}
	
	private void completarListaMotivos()
	{
		if (service == null) 
		{
			service = GWT.create(RegistrarCitaService.class);
		 }
		AsyncCallback<MotivoCitaBean[]> callback = 
			new AsyncCallback<MotivoCitaBean[]>() {
			public void onFailure(Throwable caught) {
				Window.alert("Error al traer los Motivos de las Citas");						
			}

			public void onSuccess(MotivoCitaBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listMotivos.addItem(result[i].getNombre(),
							result[i].getIdMotivoCita());
				}
			}
		};
		service.getMotivosCita(callback);
		
	}

	private void completarPanelDireccion()
	{		
		tablaDireccion = new FlexTable();
		txtCalle = new TextBox();
		txtNumero = new TextBox();
		txtPiso = new TextBox();
		txtDepartamento = new TextBox();
		hiddenBarrio = new Hidden();
		txtBarrio = new TextBox();
		txtBarrio.setReadOnly(true);
		buttonBuscarBarrio = new Button("Buscar");
		txtCodigoPostal = new TextBox();
		buscarBarrio = new BuscarBarrio(hiddenBarrio, txtBarrio, new TextBox(), 
				new TextBox(), service);
		
		tablaDireccion.setText(0, 0, "Calle");
		tablaDireccion.setWidget(0, 1, txtCalle);
		tablaDireccion.setText(0, 2, "Número");
		tablaDireccion.setWidget(0, 3, txtNumero);
		tablaDireccion.setText(1, 0, "Piso");
		tablaDireccion.setWidget(1, 1, txtPiso);
		tablaDireccion.setText(1, 2, "Departamento");
		tablaDireccion.setWidget(1, 3, txtDepartamento);
		tablaDireccion.setText(2, 0, "Barrio");
		tablaDireccion.setWidget(2, 1, txtBarrio);
		tablaDireccion.setWidget(2, 2, buttonBuscarBarrio);
		tablaDireccion.setText(3, 0, "Código Postal");
		tablaDireccion.setWidget(3, 1, txtCodigoPostal);
		
		buttonBuscarBarrio.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent arg0)
			{
				buscarBarrio.showDialog();
			}
		});
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
		if (txtPersona.getText().trim().equals(""))
		{
			errorPersona.setVisible(true);
			error = true;
		}
		if (fecha.getText().trim().equals(""))
		{
			errorFecha.setVisible(true);
			error = true;
		}
		if (txtHora.getText().trim().equals(""))
		{
			errorHoraRequerido.setVisible(true);
			error = true;
		}
		else
		{
			if (!Utilidades.isInt(txtHora.getText().trim()))
			{
				errorHoraNumerico.setVisible(true);
				error = true;
			}
			else
			{
				int hora = Integer.parseInt(txtHora.getText().trim());
				if (hora < 0 || hora > 23)
				{
					errorHoraFormato.setVisible(true);
					error = true;
				}
			}
		}
		if (txtMinutos.getText().trim().equals(""))
		{
			errorMinutosRequerido.setVisible(true);
			error = true;
		}
		else
		{
			if (!Utilidades.isInt(txtMinutos.getText().trim()))
			{
				errorMinutosNumerico.setVisible(true);
				error = true;
			}
			else
			{
				int minutos = Integer.parseInt(txtMinutos.getText().trim());
				if (minutos < 0 || minutos > 59)
				{
					errorMinutosFormato.setVisible(true);
					error = true;
				}
			}
		}
		if (txtCalle.getText().trim().equals(""))
		{
			errorCalle.setVisible(true);
			error = true;
		}
		if (txtNumero.getText().trim().equals(""))
		{
			errorNumeroDireccionRequerido.setVisible(true);
			error = true;
		}
		else
		{
			if (!Utilidades.isInt(txtNumero.getText().trim()))
			{
				errorNumeroDireccionNumerico.setVisible(true);
				error = true;
			}
		}
		if (!txtPiso.getText().trim().equals(""))
		{
			try {
				Integer.parseInt(txtPiso.getText().trim());
				errorPiso.setVisible(false);
			}
			catch (Exception e) {
				error = true;
				errorPiso.setVisible(true);
			}
		}
		if (txtBarrio.getText().trim().equals(""))
		{
			errorBarrio.setVisible(true);
			error = true;
		}
		if (txtCodigoPostal.getText().trim().equals(""))
		{
			errorCpp.setVisible(true);
			error = true;
		}
		return error;
	}

	@Override
	protected void realizarRegistro(final Submit submit)
	{
		MotivoCitaBean motivo = new MotivoCitaBean(listMotivos.getValue(listMotivos.getSelectedIndex()), "", "");
		BarrioBean barrio = new BarrioBean(hiddenBarrio.getValue(), null, "");
		DireccionBean direccion = new DireccionBean("", null, barrio, 
				txtCalle.getText(), txtNumero.getText(), txtPiso.getText(), 
				txtDepartamento.getText(), txtCodigoPostal.getText());
		String hora = txtHora.getText() + ":" + txtMinutos.getText();
		CitaBean cita =
			new CitaBean("", motivo, direccion, fecha.getText(), hora);
		
		AsyncCallback<Bool> callback = new AsyncCallback<Bool>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Hubo un error al registrar la Cita. Por " +
						"favor intente nuevamente más tarde.");
			}

			public void onSuccess(Bool arg0)
			{
				if (arg0.isValue())
				{
					Window.alert("Se registró correctamente la Cita");
					submit.submit();
				}
				else
				{
					Window.alert("Hubo un error al registrar la Cita. Por " +
							"favor intente nuevamente más tarde.");
				}
			}
		};
		service.saveCita(cita, callback);
		
	}

}
