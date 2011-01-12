package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.busquedas.BuscarPersona;
import inmo.ajax.gwt.client.db.ContratoBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.ReclamoBean;
import inmo.ajax.gwt.client.db.TipoReclamoBean;
import inmo.ajax.gwt.client.db.container.PersonaContainer;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.TipoPersona;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarQueja extends Registro implements EntryPoint
{
	private RegistrarQuejaServiceAsync service = 
		GWT.create(RegistrarQuejaService.class);
	
	//mensajes de error
	private VerticalPanel panelErrores = new VerticalPanel();
	private MensajeError errorCliente;
	private MensajeError errorReclamo;
	private MensajeError errorContrato;
	
	//Numero de Contrato
	private Label lblContrato = new Label("Contrato: ");
	private TextBox txtContrato = new TextBox();
	private FlexTable panelContrato = new FlexTable();
	
	//Persona
	private Label lblPersona = new Label("Persona: ");
	private TextBox txtPersona = new TextBox();
	private Hidden hiddenPersona = new Hidden();
	private Button buttonBuscarPersona = new Button("Buscar"); 
	private BuscarPersona buscarPersona;
	private FlexTable panelPersona = new FlexTable();
	
	//Tipo Reclamo
	private Label lblTipoReclamo = new Label("Tipo de Reclamo: ");
	private ListBox listTipoReclamo = new ListBox();
	private FlexTable panelTipoReclamo = new FlexTable();	
	
	//Reclamo
	private TextArea txtReclamo = new TextArea();
	
	//Comentarios
	private TextArea txtComentarios = new TextArea();
	
	//Boton Submit	
	Submit submit = new Submit("Aceptar");
	
	public void onModuleLoad()
	{
		completarPanelTipoReclamo();
		completarPanelErrores();
		completarPanelSubmit();
		completarPanelContrato();
		completarPanelPersona();
		completarTextAreas();

		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("contrato").add(panelContrato);
		RootPanel.get("persona").add(panelPersona);
		RootPanel.get("tipoReclamo").add(panelTipoReclamo);
		RootPanel.get("reclamo").add(txtReclamo);
		RootPanel.get("comentarios").add(txtComentarios);
		RootPanel.get("submit").add(submit);
	}
	
	private void cargarComboTipoReclamo()
	{
		if (service == null) {
			service = GWT.create(RegistrarQuejaService.class);
		 }
		 AsyncCallback<TipoReclamoBean[]> callback = 
			 new AsyncCallback<TipoReclamoBean[]>() 
		 {
			 public void onFailure(Throwable caught) {
				 Window.alert("Error al traer los tipos de Documento");						
			 }
	
			public void onSuccess(TipoReclamoBean[] result) {
				for (int i = 0; i<result.length; i++)
				{
					listTipoReclamo.addItem(result[i].getNombre(), 
							result[i].getIdMotivo());
				}
			}
		};
		service.getTipoReclamos(callback);
	}
	
	private void completarTextAreas()
	{
//		txtReclamo.setWidth("50px");
//		txtReclamo.setHeight("10px");

		txtReclamo.setPixelSize(400, 100);
		txtComentarios.setPixelSize(400, 100);
	}
	
	private void completarPanelTipoReclamo()
	{
		cargarComboTipoReclamo();
		panelTipoReclamo.setWidget(0, 0, lblTipoReclamo);
		panelTipoReclamo.setWidget(0, 1, listTipoReclamo);
	}
	
	private void completarPanelContrato()
	{
		panelContrato.setWidget(0, 0, lblContrato);
		panelContrato.setWidget(0, 1, txtContrato);
	}
	
	private void completarPanelPersona()
	{
		buscarPersona = new BuscarPersona(TipoPersona.TODOS, hiddenPersona, 
				new PersonaContainer(), txtPersona, service);
		buttonBuscarPersona.addClickHandler(new ClickHandler()
		{
			
			public void onClick(ClickEvent arg0)
			{
				buscarPersona.showDialog();
			}
		});
		txtPersona.setReadOnly(true);
		panelPersona.setWidget(0, 0, lblPersona);
		panelPersona.setWidget(0, 1, txtPersona);
		panelPersona.setWidget(0, 2, buttonBuscarPersona);
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
							"registrar el nuevo Reclamo?");
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
		errorCliente = new MensajeError("Persona", TipoError.REQUERIDO);
		errorReclamo = new MensajeError("Descripción de reclamo", 
				TipoError.REQUERIDO);
		errorContrato = new MensajeError("Contrato", TipoError.REQUERIDO);
		
		panelErrores.add(errorContrato);
		panelErrores.add(errorCliente);
		panelErrores.add(errorReclamo);
	}

	@Override
	protected boolean validarCampos()
	{
		boolean error = false;
		if (txtPersona.getText().trim().equals(""))
		{
			error = true;
			errorCliente.setVisible(true);
		}
		else
		{
			errorCliente.setVisible(false);
		}
		if (txtContrato.getText().trim().equals(""))
		{
			error = true;
			errorContrato.setVisible(true);
		}
		else
		{
			errorContrato.setVisible(false);
		}
		if (txtReclamo.getText().trim().equals(""))
		{
			error = true;
			errorReclamo.setVisible(true);
		}
		else
		{
			errorReclamo.setVisible(false);
		}
		return error;
	}

	@Override
	protected void realizarRegistro(final Submit submit)
	{
		String idMotivo = 
			listTipoReclamo.getValue(listTipoReclamo.getSelectedIndex());
		TipoReclamoBean tipoReclamo = new TipoReclamoBean(idMotivo, "", "", "");
		
		String idContrato = txtContrato.getText().trim();
		ContratoBean contrato = new ContratoBean(idContrato, null, "", null, 
				null, null);
		
		String idPersona = hiddenPersona.getValue();
		PersonaBean persona = new PersonaBean(idPersona, null, "", "", "", "", 
				null, null);
		
		String textReclamo = txtReclamo.getText();
		String comentario = txtComentarios.getText();
		
		ReclamoBean reclamo = new ReclamoBean("", null, persona, tipoReclamo, 
				contrato, textReclamo, comentario);
		
		 AsyncCallback<Bool> callback = new AsyncCallback<Bool>(){
				public void onFailure(Throwable caught) {
					Window.alert("Hubo un error al registrar el " +
							"Reclamo. Por favor pongase en contacto " +
							"con el Administrador del Sistema.");
				}
				public void onSuccess(Bool result) {
					if (result.isValue())
					{
						Window.alert("Se registró correctamente el " +
								"Reclamo.");
					}
					else
					{
						Window.alert("Hubo un error al registrar la " +
								"Reclamo. Por favor pongase en " +
								"contacto con el Administrador del " +
								"Sistema.");
					}
					submit.submit();
				}
		 };
		 service.saveReclamo(reclamo, callback);
		
	}
}
