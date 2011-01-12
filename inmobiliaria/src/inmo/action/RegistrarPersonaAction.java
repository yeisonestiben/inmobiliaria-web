package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarPersonaAction extends Action
{
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception
	{
//		RegistrarPersonaBean registrarPersonaBean =(RegistrarPersonaBean) form;		
//
//		PersonaDAO personaDAO = new PersonaDAO();
//
//		ArrayList <Direccion> direcciones = (ArrayList <Direccion>) request.getSession().getAttribute("direcciones");
//		ArrayList <Contacto> contactos = (ArrayList <Contacto>) request.getSession().getAttribute("contactos");
//
//		TipoDocumento tipoDocumento = new TipoDocumentoDAO().findById(Integer.parseInt(registrarPersonaBean.getTipoDocumento()));
//		String apellido = registrarPersonaBean.getApellido();
//		String nombres = registrarPersonaBean.getNombres();
//		String numeroDocumento = registrarPersonaBean.getNumeroDocumento();
//		
//		//Creo y guardo la persona
//		Persona persona = new Persona(null, tipoDocumento, apellido, nombres, numeroDocumento, null, null, null, null);
//		personaDAO.save(persona);		
//		
//		try
//		{
//			Iterator<Contacto> iteratorContactos = contactos.iterator();
//
//			while (iteratorContactos.hasNext())
//			{
//				ContactoDAO contactoDAO = new ContactoDAO();
//				Contacto contacto = (Contacto) iteratorContactos.next();
//				contacto.setPersona(persona);
//				contactoDAO.save(contacto);
//			}
//		}
//		catch (Exception e)
//		{
//			
//		}
//		
//		try 
//		{
//			Iterator <Direccion> iteratorDirecciones = direcciones.iterator();
//			
//			while (iteratorDirecciones.hasNext())
//			{
//				Direccion direccion = (Direccion) iteratorDirecciones.next();
//				DireccionDAO direccionDAO = new DireccionDAO();
//				direccionDAO.save(direccion);
//				
//				DireccionXPersonaId direccionXPersonaId = new DireccionXPersonaId (persona, direccion);
//				DireccionXPersona direccionXPersona = new DireccionXPersona (direccionXPersonaId, new Date(), null);
//				DireccionXPersonaDAO direccionXPersonaDAO = new DireccionXPersonaDAO();
//				direccionXPersonaDAO.save(direccionXPersona);
//			}	
//			
//		}
//		catch (Exception e)
//		{
//			
//		}
//
////		Compruebo el tipo de persona de la que se trata
////		0: Cliente
////		1: Propietario
////		2: Empleado
//
//		int tipoPersona = Integer.parseInt((String) request.getSession().getAttribute("tipoPersona"));
//		if (tipoPersona == 2)
//		{
//			//falta el tipo de empleado
//			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
//			ArrayList <Titulo> titulos = (ArrayList <Titulo>) request.getSession().getAttribute("titulos");
//			try
//			{
//				Iterator<Titulo> iteratorTitulo = titulos.iterator();
//				
//				TipoEmpleado tipoEmpleado = new TipoEmpleadoDAO().findById(Integer.parseInt((String)request.getSession().getAttribute("tipoEmpleado")));
//				Empleado empleado = new Empleado(null, tipoEmpleado, persona, null, null, null);
//				empleadoDAO.save(empleado);
//				
//				while (iteratorTitulo.hasNext())
//				{
//					Titulo titulo = (Titulo) iteratorTitulo.next();
//					TituloXEmpleadoId tituloXEmpleadoId = new TituloXEmpleadoId (titulo, empleado);
//					TituloXEmpleado tituloXEmpleado = new TituloXEmpleado (tituloXEmpleadoId, new Date());
//					TituloXEmpleadoDAO tituloXEmpleadoDAO = new TituloXEmpleadoDAO();
//					tituloXEmpleadoDAO.save(tituloXEmpleado);
//				}
//			}
//			catch (Exception e)
//			{
//				
//			}
//
//			request.getSession().removeAttribute("contactos");
//			request.getSession().removeAttribute("direcciones");
//			request.getSession().removeAttribute("titulos");
//			request.getSession().removeAttribute("tipoEmpleado");
//			
//			return mapping.findForward("success");
//		}
//		else if (tipoPersona == 1)
//		{
//			PropietarioDAO propietarioDAO = new PropietarioDAO();
//			Propietario propietario = new Propietario(persona, null);
//			propietarioDAO.save(propietario);
//			
//			request.getSession().removeAttribute("contactos");
//			request.getSession().removeAttribute("direcciones");
//			request.getSession().removeAttribute("titulos");
//			request.getSession().removeAttribute("tipoEmpleado");
//			
//			return mapping.findForward("success");
//		}
//		else
//		{
//			ClienteDAO clienteDAO = new ClienteDAO();
//			Cliente cliente = new Cliente (null, persona, null);
//			clienteDAO.save(cliente);
//			
//			request.getSession().removeAttribute("contactos");
//			request.getSession().removeAttribute("direcciones");
//			request.getSession().removeAttribute("titulos");
//			request.getSession().removeAttribute("tipoEmpleado");
//			
//			return mapping.findForward("success");
//		}
	return mapping.findForward("success");
	}

}
