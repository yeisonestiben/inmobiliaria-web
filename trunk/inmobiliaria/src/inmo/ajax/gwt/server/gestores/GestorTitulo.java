package inmo.ajax.gwt.server.gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import inmo.ajax.gwt.client.db.TituloBean;
import inmo.db.Titulo;
import inmo.db.TituloDAO;

public class GestorTitulo {
	
	@SuppressWarnings("unchecked")
	public TituloBean[] getTitulos()
	{
		TituloDAO tituloDAO = new TituloDAO();
		List<Titulo> listaTitulos = tituloDAO.findAll();
		Collections.sort (listaTitulos);
		Iterator<Titulo> iterator = listaTitulos.iterator();
		
		List<TituloBean> listaTitulosBean = new ArrayList<TituloBean>();
		
		while(iterator.hasNext())
		{
			Titulo titulo= iterator.next();
			TituloBean tituloBean = 
				new TituloBean(titulo.getIdTitulo().toString(), titulo.getNombre(), titulo.getDescripcion());
			listaTitulosBean.add(tituloBean);
		}
		return listaTitulosBean.toArray(new TituloBean[listaTitulosBean.size()]);
	}
	
	public Titulo getTitulo(TituloBean tituloBean)
	{
		Titulo titulo = new TituloDAO().findById(Integer.parseInt(tituloBean.getIdTitulo()));
		System.out.println(titulo.getNombre());
		return titulo;
	}
}
