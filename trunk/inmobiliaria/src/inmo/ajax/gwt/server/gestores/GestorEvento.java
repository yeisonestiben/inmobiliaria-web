package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.EventoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.Eventos;
import inmo.db.EventosDAO;
import inmo.db.TipoEvento;
import inmo.db.TipoEventoDAO;

import java.util.Date;

public class GestorEvento
{
	public Bool saveEvento(EventoBean eventoBean)
	{
		Bool lReturn  = new Bool(true);	
		
		Barrios barrio = new BarriosDAO().findById(Integer.parseInt(
				eventoBean.getDireccion().getBarrios().getIdBarrio()));
		String calle = eventoBean.getDireccion().getCalle();
		
		String pisoStr = eventoBean.getDireccion().getPiso();
		Integer numero = Integer.parseInt(eventoBean.getDireccion().getNumero());
		Integer piso = !pisoStr.equals("") ? Integer.parseInt(pisoStr) : 0;
		String departamento = eventoBean.getDireccion().getDepartamento();
		String cpp = eventoBean.getDireccion().getCpp();
		
		Direccion direccion = new Direccion (null, barrio, calle, numero, piso, 
				departamento, cpp);
		
		Date fecha = Utilidades.getDate(eventoBean.getFecha());
		Date hora = Utilidades.getHora(eventoBean.getHora());
		
		TipoEvento tipoEvento = new TipoEventoDAO().findById(
				Integer.parseInt(eventoBean.getTipoEvento().getIdTipoEvento()));
		
		Eventos evento = new Eventos(tipoEvento, direccion, fecha, hora,
				eventoBean.getDescripcion());
		
		new DireccionDAO().save(direccion);
		new EventosDAO().save(evento);
		
		return lReturn;
	}
}
