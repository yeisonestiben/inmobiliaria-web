package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Cliente;
import inmo.db.ClienteDAO;
import inmo.db.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

public class GestorCliente extends GestorPersona 
{
	
	public Bool saveCliente(ClienteBean clienteBean)
	{
		Bool lReturn  = new Bool(true);	
		
		Persona persona = savePersona(clienteBean);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente (null, persona, null);
		clienteDAO.save(cliente);
		
		return lReturn;
	}
	
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedClientes(PagingLoadConfig loadConfig, String apellido, 
			String nombre)
	{
		ClienteDAO clientesDAO = new ClienteDAO();
		List<Cliente> clientes = clientesDAO.findAll();
		Collections.sort (clientes);

		List<BaseTreeModel> clientesModel = new ArrayList<BaseTreeModel>();
		
		for (Cliente cliente : clientes)
		{			
			if (cliente.getPersona().getApellido().toUpperCase().startsWith(apellido.toUpperCase()) 
					&& cliente.getPersona().getNombres().toUpperCase().startsWith(nombre.toUpperCase()))
			{
				BaseTreeModel clienteModel = new BaseTreeModel();
				clienteModel.set("apellido", cliente.getPersona().getApellido());
				clienteModel.set("nombres", cliente.getPersona().getNombres());
				clienteModel.set("id", cliente.getIdCliente().toString());
				clienteModel.set("tipoDocumento", cliente.getPersona().getTipoDocumento().getTipo());
				clienteModel.set("numeroDocumento", cliente.getPersona().getNumeroDocumento());
				clienteModel.set("persona", getCliente(cliente));
				clientesModel.add(clienteModel);
			}
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = clientesModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(clientesModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, loadConfig.getOffset(), clientesModel.size());
	}

	public ClienteBean getCliente(String idCliente)
	{
		Cliente cliente = new ClienteDAO().findById(Integer.valueOf(idCliente));
		return getCliente(cliente);
	}
	
	public ClienteBean getCliente(Cliente cliente)
	{
		TipoDocumentoBean tipoDocumentoBean = 
			new GestorTipoDocumento().getTipoDocumento(cliente.getPersona().
					getTipoDocumento());
		DireccionBean[] direcciones = 
			new GestorDireccion().getDirecciones(cliente.getPersona().
					getDireccionXPersonas());
		ContactoBean[] contactos = 
			new GestorContacto().getContactos(cliente.getPersona().
					getContactos());
			
		ClienteBean clienteBean = 
			new ClienteBean(cliente.getIdCliente().toString(), 
					cliente.getPersona().getIdPersona().toString(), 
					tipoDocumentoBean, cliente.getPersona().getApellido(), 
					cliente.getPersona().getNombres(), 
					cliente.getPersona().getNumeroDocumento(), 
					cliente.getPersona().getSexo(),
					direcciones, contactos);
		return clienteBean;
	}	
}
