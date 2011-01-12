package inmo.action;

import inmo.db.CobroAlquileres;
import inmo.db.CobroAlquileresDAO;
import inmo.db.Contratos;
import inmo.db.ContratosDAO;
import inmo.db.EstadoCobroDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarCobroAlquilerAction extends Action {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{	
		ArrayList<String[]> cobros = (ArrayList<String[]>) request.getSession().getAttribute("cobros");
		Iterator iterator = cobros.iterator();

		CobroAlquileresDAO cobroDAO = new CobroAlquileresDAO();

		//0="numeroContrato"
		//1="fechaVencimiento"
		while (iterator.hasNext())
		{
			String [] cobro = (String []) iterator.next();
			Date fechaVencimiento = new Date();
			fechaVencimiento.setDate(Integer.parseInt(cobro[1].substring(0, 2)));
			fechaVencimiento.setMonth(Integer.parseInt(cobro[1].substring(3, 5))-1);
			fechaVencimiento.setYear(Integer.parseInt(cobro[1].substring(6))-1900);
			System.out.println("ID de contrato que llega: "+cobro[0]);
			Contratos contrato = new ContratosDAO().findById(Integer.parseInt(cobro[0]));
			ArrayList<CobroAlquileres> cobroAlquileres = (ArrayList<CobroAlquileres>) cobroDAO.findByProperty("contratos", contrato);
			
			Iterator<CobroAlquileres> iteratorCobros = cobroAlquileres.iterator();
			while (iteratorCobros.hasNext())
			{
				CobroAlquileres cobroAlquiler = (CobroAlquileres) iteratorCobros.next();
				System.out.println("fecha del cobro de la DB: "+cobroAlquiler.getFechaVencimiento());
				System.out.println("fecha que llega: "+fechaVencimiento);
				if (cobroAlquiler.getFechaVencimiento().getYear() == fechaVencimiento.getYear() 
						&& cobroAlquiler.getFechaVencimiento().getMonth() == fechaVencimiento.getMonth()
						&& cobroAlquiler.getFechaVencimiento().getDate() == fechaVencimiento.getDate())
				{
					System.out.println("Entra a actualizar");
					cobroAlquiler.setFechaCobro(new Date());
					cobroAlquiler.setEstadoCobro(new EstadoCobroDAO().findById(2));
					cobroDAO.update(cobroAlquiler);
				}
			}
		}
		return mapping.findForward("success");
	}
}