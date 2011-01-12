package inmo.ajax.gwt.server.gestores;

import inmo.HibernateSessionFactory;
import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Persona;
import inmo.db.Propietario;
import inmo.db.PropietarioDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

public class GestorPropietario extends GestorPersona 
{	
	public Bool savePropietario (PropietarioBean propietarioBean)
	{	
		Bool lReturn = new Bool(true);	
		
		Persona persona = savePersona(propietarioBean);
		
		PropietarioDAO propietarioDAO = new PropietarioDAO();
		Propietario propietario = new Propietario(persona, null);
		propietarioDAO.save(propietario);
		
		HibernateSessionFactory.getSession().clear();
		
		return lReturn;
	}
	
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedPropietarios(
			PagingLoadConfig loadConfig, String apellido, String nombre)
	{	    
		PropietarioDAO propietariosDAO = new PropietarioDAO();
		List<Propietario> propietarios = propietariosDAO.findAll();
		Collections.sort (propietarios);

		List<BaseTreeModel> propietariosModel = new ArrayList<BaseTreeModel>();
		
		for (Propietario propietario : propietarios)
		{			
			if (propietario.getPersona().getApellido().toUpperCase().
					startsWith(apellido.toUpperCase()) 
					&& propietario.getPersona().getNombres().toUpperCase().
					startsWith(nombre.toUpperCase()))
			{
				BaseTreeModel propietarioModel = new BaseTreeModel();
				propietarioModel.set("apellido", 
						propietario.getPersona().getApellido());
				propietarioModel.set("nombres", 
						propietario.getPersona().getNombres());
				propietarioModel.set("id", 
						propietario.getIdPropietario().toString());
				propietarioModel.set("tipoDocumento", 
						propietario.getPersona().getTipoDocumento().getTipo());
				propietarioModel.set("numeroDocumento", 
						propietario.getPersona().getNumeroDocumento());
				propietarioModel.set("persona", getPropietario(propietario));
				propietariosModel.add(propietarioModel);
				
			}
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = propietariosModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(propietariosModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, 
				loadConfig.getOffset(), propietariosModel.size());
	}

	public PropietarioBean getPropietario(String idPropietario)
	{
		Propietario propietario =
			new PropietarioDAO().findById(Integer.valueOf(idPropietario));
		return getPropietario(propietario);
	}
	
	public PropietarioBean getPropietario(Propietario propietario)
	{
		TipoDocumentoBean tipoDocumentoBean = 
			new GestorTipoDocumento().getTipoDocumento(propietario.getPersona().
					getTipoDocumento());
		DireccionBean[] direcciones = 
			new GestorDireccion().getDirecciones(propietario.getPersona().
					getDireccionXPersonas());
		ContactoBean[] contactos = 
			new GestorContacto().getContactos(propietario.getPersona().
					getContactos());
			
		PropietarioBean propietarioBean = 
			new PropietarioBean(propietario.getIdPropietario().toString(), 
					propietario.getPersona().getIdPersona().toString(), 
					tipoDocumentoBean, propietario.getPersona().getApellido(), 
					propietario.getPersona().getNombres(), 
					propietario.getPersona().getNumeroDocumento(), 
					propietario.getPersona().getSexo(),
					direcciones, contactos);
		return propietarioBean;
	}
}
