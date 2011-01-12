package inmo.action.cargar;

import java.util.ArrayList;

import inmo.Utilidades;
import inmo.db.Cliente;
import inmo.db.ClienteDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CargaBuscarClientesAction extends Action{
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) 
    throws Exception
	{
		Utilidades.setNombreFormulario(request.getParameter("form"));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> arrayClientes;
		arrayClientes = (ArrayList<Cliente>) clienteDAO.findAll();
		request.setAttribute("arrayClientes",arrayClientes);
		
		return mapping.findForward("busquedaCliente");
	}

}
