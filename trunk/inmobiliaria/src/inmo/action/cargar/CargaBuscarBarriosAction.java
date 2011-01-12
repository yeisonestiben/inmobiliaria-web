package inmo.action.cargar;

import inmo.Utilidades;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaBuscarBarriosAction extends Action{
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) 
    throws Exception
	{
		Utilidades.setNombreFormulario(request.getParameter("form"));
				
		BarriosDAO barriosDAO = new BarriosDAO();
		ArrayList<Barrios> arrayBarrios;
		arrayBarrios = (ArrayList<Barrios>) barriosDAO.findAll();
		request.setAttribute("arrayBarrios",arrayBarrios);
		return mapping.findForward("busquedaBarrio");
	}
}


