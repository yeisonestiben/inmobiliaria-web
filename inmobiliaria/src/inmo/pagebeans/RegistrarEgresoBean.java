package inmo.pagebeans;

import inmo.Utilidades;
import inmo.action.cargar.CargaRegistrarEgresosAction;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrarEgresoBean extends ActionForm{

	private static final long serialVersionUID = 1L;

	private String tipoEgreso;
	private String fecha;
	private String numeroComprobante;
	private String tipoComprobante;
	private String moneda;
	private String monto;
	
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoEgreso() {
		return tipoEgreso;
	}
	public void setTipoEgreso(String tipoEgreso) {
		this.tipoEgreso = tipoEgreso;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		
		if (Utilidades.isMissing(getFecha())) {
			errors.add("fecha", new ActionMessage("errors.required", "Fecha"));
		}	

		if (Utilidades.isMissing(getNumeroComprobante()))
		{
			errors.add("numeroComprobante", new ActionMessage("errors.required", "Número de Comprobante"));
		}

		if (Utilidades.isMissing(getMonto())) {
			errors.add("monto", new ActionMessage("errors.required", "Monto"));
		}
		else 
		{
			if (!Utilidades.isFloat(getMonto()))
			{
				errors.add("monto", new ActionMessage("errors.float", "Monto"));
			}
		}
		
		try
		{
			new CargaRegistrarEgresosAction().execute(new ActionMapping(), null, request, null);	
		}
		catch (Exception e)
		{
			System.out.println("Entre al catch");
		}
		return errors;
	}
}
