package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.OrganizacionBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Contacto;
import inmo.db.ContactoDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.Organizacion;
import inmo.db.OrganizacionDAO;
import inmo.db.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

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
		
		Persona persona = 
			new GestorPersona().getPersona(organizacionBean.getTitular());
		
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
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String nombre)
	{	    
		OrganizacionDAO organizacionDAO = new OrganizacionDAO();
		List<Organizacion> organizaciones = organizacionDAO.findAll();
		Collections.sort (organizaciones);

		List<BaseTreeModel> organizacionesModel = 
			new ArrayList<BaseTreeModel>();
		
		for (Organizacion organizacion : organizaciones)
		{			
			if (organizacion.getNombre().toUpperCase().startsWith(nombre.toUpperCase()))
			{
				BaseTreeModel organizacionModel = new BaseTreeModel();
				String direccion = organizacion.getDireccion().getCalle() +
				" N° " + organizacion.getDireccion().getNro().toString() + 
				" B° " + organizacion.getDireccion().getBarrios().getNombre() +
				" de la ciudad de " + organizacion.getDireccion().
				getBarrios().getLocalidades().getNombre() + ", Provincia de " +
				organizacion.getDireccion().getBarrios().getLocalidades().
				getProvincias().getNombre();
				
				organizacionModel.set("direccion", direccion);
				organizacionModel.set("nombre", organizacion.getNombre());
				organizacionModel.set("id", organizacion.getIdOrganizacion().toString());
				organizacionesModel.add(organizacionModel);
			}
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = organizacionesModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(organizacionesModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, 
				loadConfig.getOffset(), organizacionesModel.size());
	}
	
	public OrganizacionBean getOrganizacion(Organizacion organizacion)
	{
		DireccionBean direccion = 
			new GestorDireccion().getDireccion(organizacion. getDireccion());

		ContactoBean[] contactos = 
			new GestorContacto().getContactos(organizacion.getContactos());

		PersonaBean titular = 
			new GestorPersona().getPersona(organizacion.getTitular());

		OrganizacionBean organizacionBean = 
			new OrganizacionBean(organizacion.getIdOrganizacion().toString(), 
					organizacion.getNombre(), direccion, titular, contactos);

		return organizacionBean;
	}	
	
}
