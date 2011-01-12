package inmo.pagebeans;

import inmo.Utilidades;
import inmo.db.TipoDocumento;
import inmo.db.TipoDocumentoDAO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrarPersonaBean extends ActionForm 
{
	private static final long serialVersionUID = 1L;
	
	private String tipoDocumento;
	private String apellido;
	private String nombres;
	private String numeroDocumento;
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	@SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {

        ActionErrors errors = new ActionErrors();

        if (Utilidades.isMissing(getApellido()))
        {
            errors.add("apellido", new ActionMessage("errors.required", "Apellido"));
        }

        if (Utilidades.isMissing(getNombres()))
        {
            errors.add("nombres", new ActionMessage("errors.required", "Nombres"));
        }

        if (Utilidades.isMissing(getNumeroDocumento()))
        {
            errors.add("numeroDocumento", new ActionMessage("errors.required", "Número de Documento"));
        }

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		ArrayList<TipoDocumento> arrayTipoDocumentos;
		arrayTipoDocumentos = (ArrayList<TipoDocumento>) tipoDocumentoDAO.findAll();
		request.setAttribute("arrayTipoDocumentos",arrayTipoDocumentos);
		
        return errors;
    }
}