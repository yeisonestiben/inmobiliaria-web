package inmo.action.cargar;

import inmo.db.EstadoPropiedad;
import inmo.db.EstadoPropiedadDAO;
import inmo.db.Moneda;
import inmo.db.MonedaDAO;
import inmo.db.TipoDisponibilidad;
import inmo.db.TipoDisponibilidadDAO;
import inmo.db.TipoPropiedad;
import inmo.db.TipoPropiedadDAO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaRegistrarPropiedadesAction extends Action{

	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
		request.getSession().removeAttribute("idBarrio");

		TipoPropiedadDAO tipoPropiedadDAO = new TipoPropiedadDAO();
		ArrayList<TipoPropiedad> arrayTipoPropiedad;
		arrayTipoPropiedad = (ArrayList<TipoPropiedad>) tipoPropiedadDAO.findAll();
		request.setAttribute("arrayTipoPropiedad",arrayTipoPropiedad);

		TipoDisponibilidadDAO tipoDisponibilidadDAO = new TipoDisponibilidadDAO();
		ArrayList<TipoDisponibilidad> arrayTipoDisponibilidad;
		arrayTipoDisponibilidad = (ArrayList<TipoDisponibilidad>) tipoDisponibilidadDAO.findAll();
		request.setAttribute("arrayTipoDisponibilidad",arrayTipoDisponibilidad);

		EstadoPropiedadDAO estadoPropiedadDAO = new EstadoPropiedadDAO();
		ArrayList<EstadoPropiedad> arrayEstadoPropiedad;
		arrayEstadoPropiedad = (ArrayList<EstadoPropiedad>) estadoPropiedadDAO.findAll();
		request.setAttribute("arrayEstadoPropiedad", arrayEstadoPropiedad);

		MonedaDAO monedaDAO = new MonedaDAO();
		ArrayList<Moneda> arrayMonedas;
		arrayMonedas = (ArrayList<Moneda>) monedaDAO.findAll();
		request.setAttribute("arrayMonedas",arrayMonedas);

		return mapping.findForward("registrarPropiedad");
	}
}