package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarCitaAction extends Action {
	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
//		
////		RegistrarCitaBean citaBean = (RegistrarCitaBean) form;
//		
//		Barrios barrio = new BarriosDAO().findById(Integer.parseInt(citaBean.getIdBarrio()));
//		Integer piso;
//		try
//		{
//			piso = Integer.parseInt(citaBean.getPiso());
//		}
//		catch (Exception e)
//		{
//			piso = null;
//		}
//		Direccion direccion = new Direccion (null, barrio, citaBean.getCalle(), Integer.parseInt(citaBean.getNumero()), piso, citaBean.getDepartamento(), citaBean.getCpp());
//		DireccionDAO direccionDAO = new DireccionDAO();
//		Date fecha = new Date();
//		fecha.setDate(Integer.parseInt(citaBean.getFecha().substring(0, 2)));
//		fecha.setMonth(Integer.parseInt(citaBean.getFecha().substring(3, 5)));
//		fecha.setYear(Integer.parseInt(citaBean.getFecha().substring(6))-1900);
//		Date hora = new Date();
//		hora.setHours(Integer.parseInt(citaBean.getHora()));
//		hora.setMinutes(Integer.parseInt(citaBean.getMinutos()));
//		MotivoCita motivo = null;
//		Citas cita = new Citas(motivo, direccion, fecha, hora);
//		CitasDAO citasDAO = new CitasDAO();
//		
//		//Guardos los objetos en la DB
//		direccionDAO.save(direccion);
//		citasDAO.save(cita);

		return mapping.findForward("success");
	}
}
