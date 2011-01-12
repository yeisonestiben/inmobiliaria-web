package inmo.action.cargar;

import inmo.Utilidades;
import inmo.db.Propietario;
import inmo.db.PropietarioDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaBuscarPropietariosAction extends Action{
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) 
    throws Exception
	{
		Utilidades.setNombreFormulario(request.getParameter("form"));
		
		PropietarioDAO propietarioDAO = new PropietarioDAO();
		ArrayList<Propietario> arrayPropietarios;
		arrayPropietarios = (ArrayList<Propietario>) propietarioDAO.findAll();
		request.setAttribute("arrayPropietarios",arrayPropietarios);
		
		return mapping.findForward("busquedaPropietario");
	}
}