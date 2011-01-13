package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.db.Cliente;
import inmo.db.ClienteDAO;
import inmo.db.Contacto;
import inmo.db.ContactoDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.DireccionXPersona;
import inmo.db.DireccionXPersonaDAO;
import inmo.db.DireccionXPersonaId;
import inmo.db.Persona;
import inmo.db.PersonaDAO;
import inmo.db.Propietario;
import inmo.db.PropietarioDAO;
import inmo.db.TipoDocumento;
import inmo.db.TipoDocumentoDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

public class GestorPersona {
	
	public Persona savePersona(PersonaBean personaBean)
	{
		PersonaDAO personaDAO = new PersonaDAO();
		
		TipoDocumento tipoDocumento = new TipoDocumentoDAO().findById(Integer.
				parseInt(personaBean.getTipoDocumento().getIdTipo()));
		String apellido = personaBean.getApellido();
		String nombres = personaBean.getNombres();
		String numeroDocumento = personaBean.getNumeroDocumento();
		String sexo = personaBean.getSexo();
		
		//Creo y guardo la persona
		Persona persona = new Persona(null, tipoDocumento, apellido, nombres, 
				numeroDocumento, sexo, null, null, null, null);
		personaDAO.save(persona);
		
		ContactoDAO contactoDAO = new ContactoDAO();
		GestorContacto gestorContacto = new GestorContacto();
		for (int i = 0; i < personaBean.getContactos().length; i++)
		{
			Contacto contacto = 
				gestorContacto.getContacto(personaBean.getContactos()[i]);
			contacto.setPersona(persona);
			contactoDAO.save(contacto);
		}
		
		DireccionDAO direccionDAO = new DireccionDAO();
		DireccionXPersonaDAO direccionXPersonaDAO = new DireccionXPersonaDAO();
		GestorDireccion gestorDireccion = new GestorDireccion();
		
		for (int i = 0; i < personaBean.getDirecciones().length; i++)
		{
			Direccion direccion = 
				gestorDireccion.getDireccion(personaBean.getDirecciones()[i]);
			direccionDAO.save(direccion);
			
			DireccionXPersonaId direccionXPersonaId = 
				new DireccionXPersonaId (persona, direccion);
			DireccionXPersona direccionXPersona = 
				new DireccionXPersona (direccionXPersonaId, new Date(), null);
			direccionXPersonaDAO.save(direccionXPersona);
		}
		
		return persona;
	}
	
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedPersonas(PagingLoadConfig 
			loadConfig, String apellido, String nombre)
	{	    
		PersonaDAO personasDAO = new PersonaDAO();
		List<Persona> personas = personasDAO.findAll();
		Collections.sort (personas);

		List<BaseTreeModel> personasModel = new ArrayList<BaseTreeModel>();
		
		for (Persona persona : personas)
		{			
			if (persona.getApellido().toUpperCase().startsWith(apellido.toUpperCase()) 
					&& persona.getNombres().toUpperCase().startsWith(nombre.toUpperCase()))
			{
				BaseTreeModel personaModel = new BaseTreeModel();
				List<Cliente> clientes = new ClienteDAO().findByProperty("persona", persona);
				if (clientes.size() > 0) {
					ClienteBean clienteBean = new GestorCliente().getCliente((Cliente)clientes.get(0));
					personaModel.set("persona", clienteBean);
					personaModel.set("apellido", persona.getApellido());
					personaModel.set("nombres", persona.getNombres());
					personaModel.set("id", persona.getIdPersona().toString());
					personaModel.set("tipoDocumento", persona.getTipoDocumento().getTipo());
					personaModel.set("numeroDocumento",	persona.getNumeroDocumento());
					personasModel.add(personaModel);
				}
				else
				{
					List<Propietario> propietarios = new PropietarioDAO().findByProperty("persona", persona);
					if (propietarios.size() > 0)
					{
						PropietarioBean propietarioBean = new GestorPropietario().getPropietario((Propietario)propietarios.get(0));
						personaModel.set("persona", propietarioBean);
						personaModel.set("apellido", persona.getApellido());
						personaModel.set("nombres", persona.getNombres());
						personaModel.set("id", persona.getIdPersona().toString());
						personaModel.set("tipoDocumento", persona.getTipoDocumento().getTipo());
						personaModel.set("numeroDocumento",	persona.getNumeroDocumento());
						personasModel.add(personaModel);
					}
				}
			}
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = personasModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(personasModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, 
				loadConfig.getOffset(), personasModel.size());
	}

	public Persona getPersona(PersonaBean personaBean)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public PersonaBean getPersona(Persona persona)
	{
		TipoDocumentoBean tipoDocumentoBean = 
			new GestorTipoDocumento().getTipoDocumento(persona.
					getTipoDocumento());
		DireccionBean[] direcciones = 
			new GestorDireccion().getDirecciones(persona.
					getDireccionXPersonas());
		ContactoBean[] contactos = 
			new GestorContacto().getContactos(persona.getContactos());
		
		PersonaBean personaBean = new PersonaBean(
				persona.getIdPersona().toString(), tipoDocumentoBean, 
				persona.getApellido(), persona.getNombres(), 
				persona.getNumeroDocumento(), persona.getSexo(), direcciones, 
				contactos);
		return personaBean;
	}
}
