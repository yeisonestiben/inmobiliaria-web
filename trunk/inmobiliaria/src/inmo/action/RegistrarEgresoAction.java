package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarEgresoAction extends Action {
	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
//		RegistrarEgresoBean egresoBean =(RegistrarEgresoBean) form;
//		
//		TipoEgreso tipoEgreso = new TipoEgresoDAO().findById(Integer.parseInt(egresoBean.getTipoEgreso()));
//		TipoComprobante tipoComprobante = new TipoComprobanteDAO().findById(Integer.parseInt(egresoBean.getTipoComprobante()));
//		Moneda moneda = new MonedaDAO().findById(Integer.parseInt(egresoBean.getMoneda()));
//		Date fecha = new Date();
//		fecha.setDate(Integer.parseInt(egresoBean.getFecha().substring(0, 2)));
//		fecha.setMonth(Integer.parseInt(egresoBean.getFecha().substring(3, 5))-1);
//		fecha.setYear(Integer.parseInt(egresoBean.getFecha().substring(6))-1900);
//		Float monto = Float.valueOf(egresoBean.getMonto());
//		String numeroComprobante = egresoBean.getNumeroComprobante();
//		
//		Egreso egreso = new Egreso(null, tipoEgreso, tipoComprobante, moneda, fecha, monto, numeroComprobante);
//		
//		//lo guardo en la DB
//		EgresoDAO egresoDAO = new EgresoDAO();
//		egresoDAO.save(egreso);
//		
		return mapping.findForward("success");
	}
}
