package inmo.action.cargar;

import inmo.db.Moneda;
import inmo.db.MonedaDAO;
import inmo.db.TipoComprobante;
import inmo.db.TipoComprobanteDAO;
import inmo.db.TipoEgreso;
import inmo.db.TipoEgresoDAO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaRegistrarEgresosAction extends Action{
	
	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response) 
		    throws Exception
			{
				TipoEgresoDAO tipoEgresoDAO = new TipoEgresoDAO();
				ArrayList<TipoEgreso> arrayTipoEgresos;
				arrayTipoEgresos = (ArrayList<TipoEgreso>) tipoEgresoDAO.findAll();
				request.setAttribute("arrayTipoEgresos",arrayTipoEgresos);
				
				TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
				ArrayList<TipoComprobante> arrayTipoComprobantes;
				arrayTipoComprobantes = (ArrayList<TipoComprobante>) tipoComprobanteDAO.findAll();
				request.setAttribute("arrayTipoComprobantes",arrayTipoComprobantes);
				
				MonedaDAO monedaDAO = new MonedaDAO();
				ArrayList<Moneda> arrayMonedas;
				arrayMonedas = (ArrayList<Moneda>) monedaDAO.findAll();
				request.setAttribute("arrayMonedas",arrayMonedas);
		
				return mapping.findForward("registrarEgreso");
			}
}
