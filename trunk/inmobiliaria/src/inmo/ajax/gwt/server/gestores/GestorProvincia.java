package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.db.Provincias;
import inmo.db.ProvinciasDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GestorProvincia {
	
	@SuppressWarnings("unchecked")
	public ProvinciaBean[] getProvincias()
	{
		ProvinciasDAO provinciaDAO = new ProvinciasDAO();
		List<Provincias> provincias = provinciaDAO.findAll();
		Collections.sort (provincias);
		Iterator<Provincias> iterator = provincias.iterator();
		
		List<ProvinciaBean> proviciasBean = new ArrayList<ProvinciaBean>();
		
		while (iterator.hasNext())
		{
			Provincias provincia = iterator.next();
			ProvinciaBean provinciaBean = 
				new ProvinciaBean(provincia.getIdProvincias().toString(), 
						provincia.getNombre());
			
			proviciasBean.add(provinciaBean);
		}
		return proviciasBean.toArray(new ProvinciaBean[proviciasBean.size()]);
	}
	
	public ProvinciaBean getProvincia (Provincias provincia)
	{
		ProvinciaBean provinciaBean = 
			new ProvinciaBean(provincia.getIdProvincias().toString(),
					provincia.getNombre());
		return provinciaBean;
	}

}
