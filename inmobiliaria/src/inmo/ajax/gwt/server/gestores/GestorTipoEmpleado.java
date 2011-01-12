package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoEmpleadoBean;
import inmo.db.TipoEmpleado;
import inmo.db.TipoEmpleadoDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GestorTipoEmpleado {
	
	@SuppressWarnings("unchecked")
	public TipoEmpleadoBean[] getTiposEmpleado()
	{
		TipoEmpleadoDAO tipoEmpleadoDAO = new TipoEmpleadoDAO();
		List<TipoEmpleado> listaEmpleados = tipoEmpleadoDAO.findAll();
		Collections.sort (listaEmpleados);
		Iterator<TipoEmpleado> iterator = listaEmpleados.iterator();
		
		List<TipoEmpleadoBean> listaEmpleadosBean = new ArrayList<TipoEmpleadoBean>();
		
		while(iterator.hasNext())
		{
			TipoEmpleado tipo = iterator.next();
			TipoEmpleadoBean tipoBean = 
				new TipoEmpleadoBean(tipo.getIdTipoEmpleado().toString(), tipo.getNombre(), tipo.getDescripcion());
			listaEmpleadosBean.add(tipoBean);
		}
		return listaEmpleadosBean.toArray(new TipoEmpleadoBean[listaEmpleadosBean.size()]);
	}

}
