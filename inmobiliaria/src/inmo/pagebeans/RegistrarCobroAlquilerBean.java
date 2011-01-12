package inmo.pagebeans;

import inmo.action.cargar.CargaRegistrarCobroAlquilerAction;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class RegistrarCobroAlquilerBean extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	String idCliente = "";

	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

    @SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {

        ActionErrors errors = new ActionErrors();

        String idCliente = (String) request.getSession().getAttribute("idCliente");
        System.out.println("eXISTE: " + idCliente);

        try
        {
            System.out.println("Entre1");
            Integer.parseInt(idCliente);
            System.out.println("Entre2");
            ArrayList<String[]> cobros = (ArrayList<String[]>) request.getSession().getAttribute("cobros");
            System.out.println("Entre3");
            if (cobros == null)
            {
                System.out.println("Entre4");
                errors.add("numeroCliente", new ActionMessage("errors.minimoRequerido", "un Cobro"));
                try
                {
                    System.out.println("Entre6");
                    new CargaRegistrarCobroAlquilerAction().execute(new ActionMapping(), null, request, null);
                }
                catch (Exception e)
                {
                    System.out.println("Entre7");
                    System.out.println("Entre al catch");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Entre5" + e.toString());
            errors.add("numeroCliente", new ActionMessage("errors.required", "Cliente"));
        }

        return errors;
    }
}
