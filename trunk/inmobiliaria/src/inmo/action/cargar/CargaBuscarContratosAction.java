package inmo.action.cargar;

import inmo.Utilidades;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaBuscarContratosAction extends Action{
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) 
    throws Exception
	{
		Utilidades.setNombreFormulario(request.getParameter("form"));
		
		return mapping.findForward("busquedaContrato");
	}

}