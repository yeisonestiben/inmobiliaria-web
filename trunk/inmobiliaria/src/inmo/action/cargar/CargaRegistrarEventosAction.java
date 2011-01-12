package inmo.action.cargar;


import inmo.db.TipoEvento;
import inmo.db.TipoEventoDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaRegistrarEventosAction extends Action{

	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		TipoEventoDAO tipoEvento = new TipoEventoDAO();
		ArrayList<TipoEvento> arrayTipoEvento;
		arrayTipoEvento = (ArrayList<TipoEvento>) tipoEvento.findAll();
		request.setAttribute("arrayTipoEvento",arrayTipoEvento);

		return mapping.findForward("registrarEvento");
	}
}
