package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.CobroAlquilerBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.db.Cliente;
import inmo.db.ClienteDAO;
import inmo.db.CobroAlquileres;
import inmo.db.CobroAlquileresDAO;
import inmo.db.Contratos;
import inmo.db.ContratosDAO;
import inmo.db.EstadoCobro;
import inmo.db.EstadoCobroDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class GestorCobroAlquiler
{
	public BasePagingLoadResult<BaseTreeModel> getCobrosImpagosPorCliente(PagingLoadConfig loadConfig, String idCliente)
	{
		Cliente cliente = new ClienteDAO().findById(Integer.parseInt(idCliente));
		CobroAlquileresDAO cobroAlquileresDao = new CobroAlquileresDAO();

		ArrayList<CobroAlquileres> arrayCobroAlquileres = 
			(ArrayList<CobroAlquileres>) cobroAlquileresDao.findByProperty("estadoCobro", new EstadoCobroDAO().findById(1));
		Collections.sort(arrayCobroAlquileres);
		Iterator<CobroAlquileres> iterator = arrayCobroAlquileres.iterator();

		List<BaseTreeModel> cobrosModel = new ArrayList<BaseTreeModel>();

		while (iterator.hasNext())
		{
			CobroAlquileres cobro = (CobroAlquileres) iterator.next();
			Set clientes = cobro.getContratos().getClientes();
			Iterator iteratorClientes = clientes.iterator();

			boolean found = false;
			while (iteratorClientes.hasNext() && !found)
			{
				Cliente clienteContrato = (Cliente) iteratorClientes.next();
				if (clienteContrato.getIdCliente() == cliente.getIdCliente())
				{
					found = true;
					insertarCobros(cobrosModel, cobro);
				}
			}
		}
		
		ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();

		int start = loadConfig.getOffset();
		int limit = cobrosModel.size();
		if (loadConfig.getLimit() > 0) {
			limit = Math.min(start + loadConfig.getLimit(), limit);
		}

		for (int i = loadConfig.getOffset(); i < limit; i++) {
			sublist.add(cobrosModel.get(i));
		}
		return new BasePagingLoadResult<BaseTreeModel>(sublist, 
				loadConfig.getOffset(), cobrosModel.size());
	}
	
	public BasePagingLoadResult<BaseTreeModel> getCobrosImpagosPorContrato(
			PagingLoadConfig loadConfig, String numeroContrato)
	{
		Contratos contrato = 
			new ContratosDAO().findById(Integer.valueOf(numeroContrato));
		CobroAlquileresDAO cobroAlquileresDao = new CobroAlquileresDAO();
		
		ArrayList<CobroAlquileres> arrayCobroAlquileres = 
			(ArrayList<CobroAlquileres>) cobroAlquileresDao.findByProperty(
					"contratos", contrato);
		Collections.sort(arrayCobroAlquileres);
		Iterator<CobroAlquileres> iterator = arrayCobroAlquileres.iterator();

		List<BaseTreeModel> cobrosModel = new ArrayList<BaseTreeModel>();
		EstadoCobro estado = new EstadoCobroDAO().findById(1);

		while (iterator.hasNext())
		{
			CobroAlquileres cobro = (CobroAlquileres) iterator.next();
			if (cobro.getEstadoCobro().equals(estado))
			{
				insertarCobros(cobrosModel, cobro);
			}
		}

		
		ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();

		int start = loadConfig.getOffset();
		int limit = cobrosModel.size();
		if (loadConfig.getLimit() > 0) {
			limit = Math.min(start + loadConfig.getLimit(), limit);
		}

		for (int i = loadConfig.getOffset(); i < limit; i++) {
			sublist.add(cobrosModel.get(i));
		}
		return new BasePagingLoadResult<BaseTreeModel>(sublist, 
				loadConfig.getOffset(), cobrosModel.size());
	}
	
	private void insertarCobros(List<BaseTreeModel> cobrosModel,
			CobroAlquileres cobro)
	{
		String fecha = Utilidades.getDate(cobro.getFechaVencimiento());
		BaseTreeModel clienteModel = new BaseTreeModel();
		clienteModel.set("numeroContrato", cobro.getContratos().
				getIdContratos().toString());
		clienteModel.set("tipoPropiedad", cobro.getContratos().
				getPropiedades().getTipoPropiedad().getNombre());
		clienteModel.set("fechaVencimiento", fecha);
		clienteModel.set("monto", cobro.getMonto().toString());
		Set<Cliente> clientesCobro = cobro.getContratos().getClientes();
		StringBuffer nombres = new StringBuffer();
		boolean b = false;
		for (Cliente clienteCobro : clientesCobro)
		{
			if (b) nombres.append("<br>");
			nombres.append(clienteCobro.getPersona().getApellido() +
					", " + clienteCobro.getPersona().getNombres());
			b = true;
		}
		clienteModel.set("clientes",nombres.toString());
		cobrosModel.add(clienteModel);
	}
	
	@SuppressWarnings("deprecation")
	public Bool saveCobroAlquiler (CobroAlquilerBean[] cobrosBean)
	{
		Bool result = new Bool(true);
		CobroAlquileresDAO cobroDAO = new CobroAlquileresDAO();

		for (CobroAlquilerBean cobroBean : cobrosBean)
		{
			Date fechaVencimiento = Utilidades.getDate(cobroBean.getFechaVencimiento());
			Contratos contrato = new ContratosDAO().findById(
					Integer.parseInt(cobroBean.getContrato().getIdContrato()));
			
			ArrayList<CobroAlquileres> cobroAlquileres = (ArrayList<CobroAlquileres>) cobroDAO.findByProperty("contratos", contrato);

			for (CobroAlquileres cobroAlquiler : cobroAlquileres)
			{
				if (cobroAlquiler.getFechaVencimiento().getYear() == fechaVencimiento.getYear() 
						&& cobroAlquiler.getFechaVencimiento().getMonth() == fechaVencimiento.getMonth()
						&& cobroAlquiler.getFechaVencimiento().getDate() == fechaVencimiento.getDate())
				{
					cobroAlquiler.setFechaCobro(new Date());
					cobroAlquiler.setEstadoCobro(new EstadoCobroDAO().findById(2));
					cobroDAO.update(cobroAlquiler);
				}
			}
		}
		return result;
	}
}