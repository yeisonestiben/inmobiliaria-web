package inmo.pagebeans;

import inmo.Utilidades;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrarCitaBean extends ActionForm 
{

	private static final long serialVersionUID = 1L;
	
	private String idPersona = "";
	private String nombre = "";
	private String fecha = "";
	private String hora = "";
	private String minutos = "";
	private String calle = "";
	private String numero = "";
	private String piso;
	private String departamento = "";
	private String idBarrio = "";
	private String barrio = "";
	private String cpp = "";
	private String descripcion = "";
	private String nombreBarrio = "";
	
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIdBarrio() {
		return idBarrio;
	}
	public void setIdBarrio(String idBarrio) {
		this.idBarrio = idBarrio;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getMinutos() {
		return minutos;
	}
	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getCpp() {
		return cpp;
	}
	public void setCpp(String cpp) {
		this.cpp = cpp;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (Utilidades.isMissing(getIdPersona()))
		{
			errors.add("persona", new ActionMessage("errors.required", "Persona"));
		}

		if (Utilidades.isMissing(getFecha())) {
			errors.add("fecha", new ActionMessage("errors.required", "Fecha"));
		}	

		if (Utilidades.isMissing(getHora())) {
			errors.add("hora", new ActionMessage("errors.required", "Hora"));
		}
		else 
		{
			if (!Utilidades.isInt(getHora()))
			{
				errors.add("hora", new ActionMessage("errors.integer", "Hora"));
			}
		}

		if (Utilidades.isMissing(getMinutos())) {
			errors.add("minutos", new ActionMessage("errors.required", "Minutos"));
		}
		else 
		{
			if (!Utilidades.isInt(getMinutos()))
			{
				errors.add("minutos", new ActionMessage("errors.integer", "Minutos"));
			}
		}

		if (Utilidades.isMissing(getCalle()))
		{
			errors.add("calle", new ActionMessage("errors.required", "Calle"));
		}

		if (Utilidades.isMissing(getNumero())) {
			errors.add("numero", new ActionMessage("errors.required", "Número de Dirección"));
		}
		else 
		{
			if (!Utilidades.isInt(getNumero()))
			{
				errors.add("numero", new ActionMessage("errors.integer", "Número de Dirección"));
			}
		}

		if (Utilidades.isMissing(getCpp())) {
			errors.add("cpp", new ActionMessage("errors.required", "Código Postal"));
		}

		return errors;
	}

}
