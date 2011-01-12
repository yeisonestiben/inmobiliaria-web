package inmo.action.cargar;

import inmo.Utilidades;
import inmo.db.Persona;
import inmo.db.PersonaDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaBuscarPersonasAction extends Action{
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) 
    throws Exception
	{
		Utilidades.setNombreFormulario(request.getParameter("form"));
		
		PersonaDAO personasDAO = new PersonaDAO();
		ArrayList<Persona> arrayPersonas;
		arrayPersonas = (ArrayList<Persona>) personasDAO.findAll();
		request.setAttribute("arrayPersonas",arrayPersonas);
		
		return mapping.findForward("busquedaPersona");
	}
}