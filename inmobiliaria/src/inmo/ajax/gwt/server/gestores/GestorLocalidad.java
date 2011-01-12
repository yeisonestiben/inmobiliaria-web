package inmo.ajax.gwt.server.gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import inmo.ajax.gwt.client.db.LocalidadBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.db.Localidades;
import inmo.db.LocalidadesDAO;

public class GestorLocalidad {

	@SuppressWarnings("unchecked")
	public LocalidadBean[] getLocalidades()
	{
		LocalidadesDAO localidadesDAO = new LocalidadesDAO();
		List<Localidades> localidades = localidadesDAO.findAll();
		Collections.sort (localidades);
		Iterator<Localidades> iterator = localidades.iterator();
		
		List<LocalidadBean> localidadesBean = new ArrayList<LocalidadBean>();
		
		while (iterator.hasNext())
		{
			Localidades localidad = iterator.next();
			ProvinciaBean provincia = new GestorProvincia().getProvincia(localidad.getProvincias());
			LocalidadBean localidadBean = new LocalidadBean(localidad.getIdLocalidades().toString(), provincia, localidad.getNombre());
			
			localidadesBean.add(localidadBean);
		}
		return localidadesBean.toArray(new LocalidadBean[localidadesBean.size()]);
	}
	
	public LocalidadBean getLocalidad (Localidades localidad)
	{
		ProvinciaBean provinciaBean = new GestorProvincia().getProvincia(localidad.getProvincias());
		LocalidadBean localidadBean = new LocalidadBean(localidad.getIdLocalidades().toString(), provinciaBean, localidad.getNombre());
		return localidadBean;
	}
	
	@SuppressWarnings("unchecked")
	public LocalidadBean[] getLocalidades(String idProvincia)
	{
		LocalidadesDAO localidadesDAO = new LocalidadesDAO();
		List<Localidades> localidades = localidadesDAO.findAll();
		Collections.sort (localidades);
		Iterator<Localidades> iterator = localidades.iterator();
		
		List<LocalidadBean> localidadesBean = new ArrayList<LocalidadBean>();
		
		while (iterator.hasNext())
		{
			Localidades localidad = iterator.next();
			if (localidad.getProvincias().getIdProvincias() == Integer.parseInt(idProvincia))
			{
				ProvinciaBean provincia = new GestorProvincia().getProvincia(localidad.getProvincias());
				LocalidadBean localidadBean = new LocalidadBean(localidad.getIdLocalidades().toString(), provincia, localidad.getNombre());
				localidadesBean.add(localidadBean);	
			}
		}
		return localidadesBean.toArray(new LocalidadBean[localidadesBean.size()]);
	}
}
