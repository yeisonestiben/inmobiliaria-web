package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.OrganizacionBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Contacto;
import inmo.db.ContactoDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.Organizacion;
import inmo.db.OrganizacionDAO;
import inmo.db.Persona;

public class GestorOrganizacion
{
	public Bool saveOrganizacion (OrganizacionBean organizacionBean)
	{
		OrganizacionDAO organizacionDao = new OrganizacionDAO();
		
		DireccionDAO direccionDAO = new DireccionDAO();
		GestorDireccion gestorDireccion = new GestorDireccion();
		
		Direccion direccion = 
			gestorDireccion.getDireccion(organizacionBean.getDireccion());
		direccionDAO.save(direccion);
		
		Persona persona = new GestorPersona().getPersona(organizacionBean.getTitular());
		
//		Creo y guardo la Organizacion
		String nombre = organizacionBean.getNombre();
		Organizacion organizacion = new Organizacion(null, nombre, direccion, 
			persona, null);		
		organizacionDao.save(organizacion);
		
		ContactoDAO contactoDAO = new ContactoDAO();
		GestorContacto gestorContacto = new GestorContacto();
		for (int i = 0; i < organizacionBean.getContactos().length; i++)
		{
			Contacto contacto = 
				gestorContacto.getContacto(organizacionBean.getContactos()[i]);
			contacto.setOrganizacion(organizacion);
			contactoDAO.save(contacto);
		}
		
		return new Bool(true);
	}
}
