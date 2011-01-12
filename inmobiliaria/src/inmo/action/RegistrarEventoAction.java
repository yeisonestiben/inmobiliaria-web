package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarEventoAction extends Action {
	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
//		
//		RegistrarEventoBean eventoBean = (RegistrarEventoBean) form;
//		
//		Barrios barrio = new BarriosDAO().findById(Integer.parseInt(eventoBean.getIdBarrio()));
//		Integer piso;
//		try
//		{
//			piso = Integer.parseInt(eventoBean.getPiso());
//		}
//		catch (Exception e)
//		{
//			piso = null;
//		}
//		//creo la fecha y seteo d�a, mes y a�o
//		Date fecha = new Date();
//		fecha.setDate(Integer.parseInt(eventoBean.getFecha().substring(0, 2)));
//		fecha.setMonth(Integer.parseInt(eventoBean.getFecha().substring(3, 5))-1);
//		fecha.setYear(Integer.parseInt(eventoBean.getFecha().substring(6))-1900);
//		//creo la hora y seteo hora y minutos
//		Date hora = new Date();
//		hora.setHours(Integer.parseInt(eventoBean.getHora()));
//		hora.setMinutes(Integer.parseInt(eventoBean.getMinutos()));
//		String descripcion = eventoBean.getDescripcion();
//		TipoEvento tipoEvento = new TipoEventoDAO().findById(Integer.parseInt(eventoBean.getTipoEvento()));
//		EventosDAO eventoDAO = new EventosDAO();	
//		Direccion direccion = new Direccion (null, barrio, eventoBean.getCalle(), Integer.parseInt(eventoBean.getNumero()), piso, eventoBean.getDepartamento(), eventoBean.getCpp());
//		DireccionDAO direccionDAO = new DireccionDAO();
//		
//		//Guardos los objetos en la DB
//		direccionDAO.save(direccion);
//		Eventos evento = new Eventos(tipoEvento, direccion, fecha, hora, descripcion);
//		eventoDAO.save(evento);
		
		return mapping.findForward("success");
	}
}