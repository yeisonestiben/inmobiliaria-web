package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.MotivoCitaBean;
import inmo.db.MotivoCita;
import inmo.db.MotivoCitaDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestorMotivoCita
{
	@SuppressWarnings("unchecked")
	public MotivoCitaBean[] getMotivosCita()
	{
		MotivoCitaDAO motivoCitaDAO = new MotivoCitaDAO();
		List<MotivoCita> listaMotivoCita = motivoCitaDAO.findAll();
	//	Collections.sort (listaTipoEvento);
		Iterator<MotivoCita> iterator = listaMotivoCita.iterator();
		
		List<MotivoCitaBean> listaMotivoCitaBean = 
			new ArrayList<MotivoCitaBean>();
		
		while(iterator.hasNext())
		{
			MotivoCita motivo = iterator.next();
			MotivoCitaBean tipoBean = 
				new MotivoCitaBean(motivo.getIdMotivoCita().toString(), 
						motivo.getNombre(), motivo.getDescripcion());
			listaMotivoCitaBean.add(tipoBean);
		}
		return listaMotivoCitaBean.toArray(new 
				MotivoCitaBean[listaMotivoCitaBean.size()]);
	}
}
