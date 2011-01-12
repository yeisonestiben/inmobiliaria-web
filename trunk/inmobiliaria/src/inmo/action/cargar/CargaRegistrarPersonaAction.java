package inmo.action.cargar;

import inmo.db.TipoDocumento;
import inmo.db.TipoDocumentoDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaRegistrarPersonaAction extends Action{

	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		request.getSession().removeAttribute("contactos");
		request.getSession().removeAttribute("direcciones");
		request.getSession().removeAttribute("titulos");

		TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		ArrayList<TipoDocumento> arrayTipoDocumentos;
		arrayTipoDocumentos = (ArrayList<TipoDocumento>) tipoDocumentoDAO.findAll();
		request.setAttribute("arrayTipoDocumentos",arrayTipoDocumentos);

		return mapping.findForward("registrarPersona");
	}
}
