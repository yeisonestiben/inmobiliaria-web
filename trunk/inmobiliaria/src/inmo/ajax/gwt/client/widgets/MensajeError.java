package inmo.ajax.gwt.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class MensajeError extends Composite {
	private HorizontalPanel panel;
	private HTML mensaje;
	
	public MensajeError (String campo, TipoError tipoError)
	{
		panel = new HorizontalPanel();
		String msj = "";
		if (tipoError.equals(TipoError.REQUERIDO))
		{
			msj = "<LI>El campo '"+campo+"' es Requerido</LI>";
		}
		else if (tipoError.equals(TipoError.NUMERICO))
		{
			msj = "<LI>El campo '"+campo+"' es Numérico</LI>";
		}
		else if (tipoError.equals(TipoError.AL_MENOS_UNO))
		{
			msj = "<LI>Debe seleccionar al menos un/a '"+campo+"'</LI>";
		}
		else if (tipoError.equals(TipoError.FORMATO_INVALIDO))
		{
			msj = "<LI>El campo '"+campo+"' tiene formato inválido</LI>";
		}
		mensaje = new HTML(msj);
		panel.setVisible(false);
		panel.add(mensaje);
		initWidget(panel);
	}
	
	public void setVisible(boolean visible)
	{
		panel.setVisible(visible);
	}
	
	@Override
	protected void onLoad() 
	{
	    super.onLoad();
	}
}
