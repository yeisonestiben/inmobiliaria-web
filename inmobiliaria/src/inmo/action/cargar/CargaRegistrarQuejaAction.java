package inmo.action.cargar;

import inmo.db.Motivo;
import inmo.db.MotivoDAO;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaRegistrarQuejaAction extends Action{

	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		request.getSession().removeAttribute("persona");

		MotivoDAO motivoDAO = new MotivoDAO();
		ArrayList<Motivo> arrayMotivos;
		arrayMotivos = (ArrayList<Motivo>) motivoDAO.findAll();
		request.setAttribute("arrayMotivos",arrayMotivos);

		return mapping.findForward("registrarQueja");
	}
}
