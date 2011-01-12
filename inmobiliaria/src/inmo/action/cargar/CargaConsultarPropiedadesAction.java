package inmo.action.cargar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaConsultarPropiedadesAction extends Action {
	public ActionForward execute (ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response) 
		    throws Exception
			{
//				Utilidades.setNombreFormulario(request.getParameter("form"));
//		
//				TipoPropiedadDAO tipoPropiedadDAO = new TipoPropiedadDAO();
//				ArrayList<TipoPropiedad> arrayTipoPropiedad;
//				arrayTipoPropiedad = (ArrayList<TipoPropiedad>) tipoPropiedadDAO.findAll();
//				request.setAttribute("arrayTipoPropiedad",arrayTipoPropiedad);
//				
//				TipoDisponibilidadDAO tipoDisponibilidadDAO = new TipoDisponibilidadDAO();
//				ArrayList<TipoDisponibilidad> arrayTipoDisponibilidad;
//				arrayTipoDisponibilidad = (ArrayList<TipoDisponibilidad>) tipoDisponibilidadDAO.findAll();
//				request.setAttribute("arrayTipoDisponibilidad",arrayTipoDisponibilidad);
//				
//				MonedaDAO monedaDAO = new MonedaDAO();
//				ArrayList<Moneda> arrayMonedas;
//				arrayMonedas = (ArrayList<Moneda>) monedaDAO.findAll();
//				request.setAttribute("arrayMonedas",arrayMonedas);
				
				return mapping.findForward("consultarPropiedad");
			}

}
