package inmo.ajax.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Prueba implements EntryPoint
{
	private PruebaServiceAsync service = GWT.create(PruebaService.class);
	HTML html = new HTML();
	VerticalPanel panel = new VerticalPanel();
	Button boton = new Button("GenerarGrafico");

	public void onModuleLoad()
	{
		boton.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent arg0)
			{
				mostrarGrafico();
			}
		});
		
		panel.add(html);
		panel.add(boton);
		RootPanel.get("datosPropiedad").add(panel);
	}

	public void mostrarGrafico()
	{
		AsyncCallback<String> callback = new AsyncCallback<String>()
		{
			public void onFailure(Throwable arg0)
			{
				
				Window.alert("Error al traer los Tipos de Disponibilidad");
			}
	
			public void onSuccess(String result)
			{				
				html.setHTML("resultado<br><img src=\"/inmobiliaria/" + result + "\"> ");
				Window.alert(html.getHTML());
			}
		};
		service.getFileName(callback);
	}
}
