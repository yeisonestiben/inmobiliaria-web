package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.BarrioBean;
import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;

public class GestorBarrio {
	
	public BarrioBean[] getBarrios()
	{
		return getBarrios("");
	}
	
	@SuppressWarnings("unchecked")
	public BarrioBean[] getBarrios(String inicial)
	{
		BarriosDAO barriosDAO = new BarriosDAO();
		List<Barrios> barrios = barriosDAO.findAll();
		Collections.sort (barrios);
		Iterator<Barrios> iterator = barrios.iterator();
		
		List<BarrioBean> barriosBean = new ArrayList<BarrioBean>();
		
		while (iterator.hasNext())
		{
			Barrios barrio = (Barrios)iterator.next();
			insetarBarrio(inicial, barriosBean, barrio);
		}
		return barriosBean.toArray(new BarrioBean[barriosBean.size()]);
	}

	@SuppressWarnings("unchecked")
	public BarrioBean[] getBarrios(String idLocalidad, String idProvincia, String inicial)
	{
		BarriosDAO barriosDAO = new BarriosDAO();
		List<Barrios> barrios = barriosDAO.findAll();
		Collections.sort (barrios);
		Iterator<Barrios> iterator = barrios.iterator();
		
		List<BarrioBean> barriosBean = new ArrayList<BarrioBean>();
		
		while (iterator.hasNext())
		{
			Barrios barrio = (Barrios)iterator.next();
			
			if (idLocalidad != null && idLocalidad.compareTo("") != 0 && idLocalidad.compareTo("0") != 0)
			{
				if (barrio.getLocalidades().getIdLocalidades() == Integer.parseInt(idLocalidad))
				{
					insetarBarrio(inicial, barriosBean, barrio);
				}
			}
			else if (idProvincia != null && idProvincia.compareTo("") != 0 && idProvincia.compareTo("0") != 0)
			{
				if (barrio.getLocalidades().getProvincias().getIdProvincias() == Integer.parseInt(idProvincia))
				{
					insetarBarrio(inicial, barriosBean, barrio);
				}
			}
			else
			{
				insetarBarrio(inicial, barriosBean, barrio);
			}
		}
		return barriosBean.toArray(new BarrioBean[barriosBean.size()]);
	}

	public BarrioBean getBarrio (Barrios barrio) {
		LocalidadBean localidadBean = new GestorLocalidad().getLocalidad(barrio.getLocalidades());
		BarrioBean barrioBean = new BarrioBean(barrio.getIdBarrios().toString(), localidadBean, barrio.getNombre());
		return barrioBean;
	}
	
	private void insetarBarrio(String inicial, List<BarrioBean> barriosBean, Barrios barrio) 
	{
		if (inicial != null && inicial.compareTo("") != 0)
		{
			if (barrio.getNombre().toUpperCase().startsWith(inicial))
			{
				barriosBean.add(getBarrio(barrio));
			}
		}
		else
		{
			barriosBean.add(getBarrio(barrio));
		}
	}
	
	private void insetarBarrioModel(String inicial, List<BaseTreeModel> barriosModel, Barrios barrio) 
	{
		if (barrio.getNombre().toUpperCase().startsWith(inicial.toUpperCase()))
		{
			BaseTreeModel barrioModel = new BaseTreeModel();
			barrioModel.set("idBarrio", barrio.getIdBarrios().toString());
			barrioModel.set("nombre", barrio.getNombre());
			barrioModel.set("localidad", barrio.getLocalidades().getNombre());
			barrioModel.set("provincia", barrio.getLocalidades().getProvincias().getNombre());
			
			barriosModel.add(barrioModel);
		}
	}
	
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig)
	{
		BarriosDAO barriosDAO = new BarriosDAO();
		List<Barrios> barrios = barriosDAO.findAll();
		Collections.sort (barrios);
		
		List<BaseTreeModel> barriosModel = new ArrayList<BaseTreeModel>();
		
		for (Barrios barrio : barrios)
		{
			insetarBarrioModel("", barriosModel, barrio);
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = barriosModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(barriosModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, loadConfig.getOffset(), barriosModel.size());
	}
	
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<BaseTreeModel> getPagedBarrios(PagingLoadConfig loadConfig, String idLocalidad, 
			String idProvincia, String inicial)
	{	    
		BarriosDAO barriosDAO = new BarriosDAO();
		List<Barrios> barrios = barriosDAO.findAll();
		Collections.sort (barrios);

		List<BaseTreeModel> barriosModel = new ArrayList<BaseTreeModel>();
		
		for (Barrios barrio : barrios)
		{			
			if (idLocalidad != null && idLocalidad.compareTo("") != 0 && idLocalidad.compareTo("0") != 0)
			{
				if (barrio.getLocalidades().getIdLocalidades() == Integer.parseInt(idLocalidad))
				{
					insetarBarrioModel(inicial, barriosModel, barrio);
				}
			}
			else if (idProvincia != null && idProvincia.compareTo(inicial) != 0 && idProvincia.compareTo("0") != 0)
			{
				if (barrio.getLocalidades().getProvincias().getIdProvincias() == Integer.parseInt(idProvincia))
				{
					insetarBarrioModel(inicial, barriosModel, barrio);
				}
			}
			else
			{
				insetarBarrioModel(inicial, barriosModel, barrio);
			}
		}
		
	    ArrayList<BaseTreeModel> sublist = new ArrayList<BaseTreeModel>();
	    
	    int start = loadConfig.getOffset();
	    int limit = barriosModel.size();
	    if (loadConfig.getLimit() > 0) {
	      limit = Math.min(start + loadConfig.getLimit(), limit);
	    }
	    
	    for (int i = loadConfig.getOffset(); i < limit; i++) {
	      sublist.add(barriosModel.get(i));
	    }
	    
		return new BasePagingLoadResult<BaseTreeModel>(sublist, loadConfig.getOffset(), barriosModel.size());
	}

}
