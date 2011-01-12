package inmo.pagebeans;

import java.util.ArrayList;

import inmo.Utilidades;
import inmo.db.Motivo;
import inmo.db.MotivoDAO;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class RegistrarQuejaBean extends ActionForm {
	private String numeroContrato;
	private String nombre;
	private String motivo;
	private String descripcionReclamo;
	private String comentarios;
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getDescripcionReclamo() {
		return descripcionReclamo;
	}
	public void setDescripcionReclamo(String descripcionReclamo) {
		this.descripcionReclamo = descripcionReclamo;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}


	@SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (Utilidades.isMissing(getNumeroContrato())) {
			errors.add("numeroContrato", new ActionMessage("errors.required", "Número de Contrato"));
		}	

		String[] persona = (String[]) request.getSession().getAttribute("persona");
		if (persona == null)
		{
			errors.add("idPersona", new ActionMessage("errors.required", "Persona"));
		}

		if (Utilidades.isMissing(getDescripcionReclamo())) {
			errors.add("descripcionReclamo", new ActionMessage("errors.required", "Descripción del Reclamo"));
		}

		MotivoDAO motivoDAO = new MotivoDAO();
		ArrayList<Motivo> arrayMotivos;
		arrayMotivos = (ArrayList<Motivo>) motivoDAO.findAll();
		request.setAttribute("arrayMotivos",arrayMotivos);

		return errors;
	}
}
