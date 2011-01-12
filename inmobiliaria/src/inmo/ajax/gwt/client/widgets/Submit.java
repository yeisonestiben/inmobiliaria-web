package inmo.ajax.gwt.client.widgets;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SubmitButton;

public class Submit extends Composite
{
	HorizontalPanel panel;
	Button submit;
	SubmitButton dummySubmit;
	
	public Submit()
	{
		submit = new Button();
		init();
	}
	
	public Submit(String texto)
	{
		submit = new Button(texto);
		init();
	}

	private void init() {
		panel = new HorizontalPanel();
		dummySubmit = new SubmitButton();
		dummySubmit.setVisible(false);
		
		panel.add(submit);
		panel.add(dummySubmit);
		
		initWidget(panel);
	}
	
	@Override
	protected void onLoad() 
	{
	    super.onLoad();
	}
	
	public void addClickHandler(ClickHandler handler)
	{
		submit.addClickHandler(handler);
	}
	
	public void submit()
	{
		dummySubmit.click();
	}
	
	public void setText(String texto)
	{
		submit.setText(texto);
	}
}
