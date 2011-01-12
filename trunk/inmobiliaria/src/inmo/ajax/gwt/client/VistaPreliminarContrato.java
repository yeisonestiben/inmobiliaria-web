package inmo.ajax.gwt.client;

import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class VistaPreliminarContrato implements EntryPoint
{
	private VistaPreliminarContratoServiceAsync service = 
		GWT.create(VistaPreliminarContratoService.class);
	
	private VerticalPanel panelPrincipal;
	private HTML contrato;
	
	public void onModuleLoad()
	{
		completarPanelPrincipal();
		
		RootPanel.get("contrato").add(panelPrincipal);
	}

	private void completarPanelPrincipal()
	{
		panelPrincipal = new VerticalPanel();
		contrato = new HTML();
		
		AsyncCallback<String> callback = new AsyncCallback<String>()
		{

			public void onFailure(Throwable arg0)
			{
				Window.alert(arg0.getMessage());
				
			}

			public void onSuccess(String arg0)
			{
				contrato.setHTML(arg0);
			}
		};
		service.getContrato(callback);
		
		panelPrincipal.add(contrato);
	}

}
