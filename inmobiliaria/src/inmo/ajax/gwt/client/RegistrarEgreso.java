package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.abstracts.Registro;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.TipoComprobanteBean;
import inmo.ajax.gwt.client.db.TipoEgresoBean;
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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RegistrarEgreso extends Registro implements EntryPoint
{
	private RegistrarEgresoServiceAsync service = 
		GWT.create(RegistrarEgresoService.class);
	
	//mensajes de error
	private VerticalPanel panelErrores;
	private MensajeError errorFecha;
	private MensajeError errorNumero;
	private MensajeError errorMontoRequerido;
	private MensajeError errorMontoNumerico;
	
	//panel egreso
	private FlexTable tablaEgreso;
	private ListBox listTipoEgreso;
	private ListBox listTipoComprobante;
	private ListBox listMoneda;
	private DatePicker date;
	private TextBox txtNumeroComprobante;
	private TextBox txtMonto;
	
	//Submit
	private Submit submit;

	public void onModuleLoad()
	{
		completarPanelErrores();
		completarPanelEgreso();
		completarPanelSubmit();
		
		RootPanel.get("errores").add(panelErrores);
		RootPanel.get("egreso").add(tablaEgreso);
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
							"registrar el Egreso?");
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
		
		errorFecha = new MensajeError("Fecha", TipoError.REQUERIDO);
		errorNumero = new MensajeError("Número de Comprobante", 
				TipoError.REQUERIDO);
		errorMontoRequerido = new MensajeError("Monto", TipoError.REQUERIDO);
		errorMontoNumerico = new MensajeError("Monto", TipoError.NUMERICO);
		
		panelErrores.add(errorFecha);
		panelErrores.add(errorNumero);
		panelErrores.add(errorMontoNumerico);
		panelErrores.add(errorMontoRequerido);
		
	}
	
	private void completarPanelEgreso()
	{
		tablaEgreso = new FlexTable();
		listTipoEgreso = new ListBox();
		listTipoComprobante = new ListBox();
		listMoneda = new ListBox();
		date = new DatePicker();
		txtNumeroComprobante = new TextBox();
		txtMonto = new TextBox();
		
		completarListaTipoEgreso();
		completarListaTipoComprobante();
		completarListaMoneda();
		
		tablaEgreso.setText(0, 0, "Tipo Egreso");
		tablaEgreso.setWidget(0, 1, listTipoEgreso);
		tablaEgreso.setText(0, 2, "Fecha del Pago");
		tablaEgreso.setWidget(0, 3, date);
		tablaEgreso.setText(1, 0, "Nro Comprobante");
		tablaEgreso.setWidget(1, 1, txtNumeroComprobante);
		tablaEgreso.setText(1, 2, "Tipo Comprobante");
		tablaEgreso.setWidget(1, 3, listTipoComprobante);
		tablaEgreso.setText(2, 0, "Moneda");
		tablaEgreso.setWidget(2, 1, listMoneda);
		tablaEgreso.setText(2, 2, "Monto");
		tablaEgreso.setWidget(2, 3, txtMonto);
	}

	private void completarListaMoneda()
	{
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
		service.getMonedas(callback);	
	}

	private void completarListaTipoComprobante()
	{
		AsyncCallback<TipoComprobanteBean[]> callback = new AsyncCallback<TipoComprobanteBean[]>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al traer los Tipos de Comprobante");
			}

			public void onSuccess(TipoComprobanteBean[] result)
			{
				for (int i = 0; i<result.length; i++)
				{
					listTipoComprobante.addItem(result[i].getNombre(), 
							result[i].getIdTipoComprobante());
				}
			}
		};
		service.getTiposComprobante(callback);
	}

	private void completarListaTipoEgreso()
	{
		AsyncCallback<TipoEgresoBean[]> callback = new AsyncCallback<TipoEgresoBean[]>()
		{
			public void onFailure(Throwable arg0)
			{
				Window.alert("Error al traer los Tipos de Egreso");
			}

			public void onSuccess(TipoEgresoBean[] result)
			{
				for (int i = 0; i<result.length; i++)
				{
					listTipoEgreso.addItem(result[i].getNombre(), 
							result[i].getIdTipoEgreso());
				}
			}
		};
		service.getTiposEgreso(callback);
	}

	@Override
	protected boolean validarCampos()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void realizarRegistro(Submit submit)
	{
		// TODO Auto-generated method stub
		
	}

}
