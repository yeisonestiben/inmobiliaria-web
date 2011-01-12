package inmo.ajax.gwt.client.widgets;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DatePicker extends Composite
{   
	private final VerticalPanel panelVertical;
	private final HorizontalPanel panelHorizontal;

	private final TextBox texto;
	private com.extjs.gxt.ui.client.widget.DatePicker date;
	private final Button boton;

	private final DialogBox dialogo = new DialogBox();
	private final Button closeDialog = new Button("Cerrar");
	private final VerticalPanel panelVerticalDialog = new VerticalPanel();

	public DatePicker()
	{
		panelHorizontal = new HorizontalPanel();
		panelVertical = new VerticalPanel();

		dialogo.setText("Seleccionar Fecha");
		dialogo.setAnimationEnabled(true);
		dialogo.setStyleName("gwt-DialogBox");


		texto = new TextBox();
		texto.setWidth("75px");
		texto.setReadOnly(true);
		date = new com.extjs.gxt.ui.client.widget.DatePicker();
		date.getMessages().setCancelText("Cancelar");
		date.getMessages().setMaxText("Esta fecha es mayor a la fecha máxima");
		date.getMessages().setMinText("Esta fecha es anterior a la fecha mínima");
		date.getMessages().setMonthYearText("Seleccione mes (Control+Arriba/Abajo para cambiar el año)");
		date.getMessages().setNextText("Siguiente Mes (Control+Derecha)");
		date.getMessages().setOkText("Aceptar");
		date.getMessages().setPrevText("Mes Siguiente (Control+Izquierda)");
		date.getMessages().setTodayText("Hoy");
		boton = new Button("...");

		boton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				dialogo.setPopupPosition(boton.getAbsoluteLeft(), boton.getAbsoluteTop());
				dialogo.show();
			}
		});

		date.addListener(Events.Select, new Listener<ComponentEvent>() {

			@SuppressWarnings("deprecation")
			public void handleEvent(ComponentEvent be) {
				dialogo.hide();

				String dia = "";
				String mes = "";
				String anio = "";
				if (date.getValue().getDate() < 10)
				{
					dia = "0"+date.getValue().getDate();
				}
				else
				{
					dia = ""+date.getValue().getDate();
				}
				if (date.getValue().getMonth() < 9)
				{
					mes = "0"+(date.getValue().getMonth()+1);
				}
				else
				{
					mes = ""+(date.getValue().getMonth()+1);
				}
				anio = ""+(date.getValue().getYear()+1900);
				String fecha = dia+"/"+mes+"/"+anio;
				texto.setText(fecha);     
			}
		});

		closeDialog.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				dialogo.hide();
			}
		});

		panelVerticalDialog.add(date);
		panelVerticalDialog.add(closeDialog);
		dialogo.add(panelVerticalDialog);

		panelVertical.add(texto);

		panelHorizontal.add(panelVertical);
		panelHorizontal.add(boton);

		initWidget(panelHorizontal);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
	}
	
	public String getText()
	{
		return texto.getText();
	}
}